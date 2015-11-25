package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Ad;
import project.persistence.entities.User;
import project.persistence.repositories.AdRepository;
import project.service.AdService;
import project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.util.Arrays;
import java.util.Date;

@Controller
public class AdController {

    // Instance Variables
    AdService adService;
    UserService userService;

    // Dependency Injection
    @Autowired
    public AdController(AdService adService, UserService userService) {
        this.adService = adService;
        this.userService = userService;
    }

    // GET view for creating a new ad
    @RequestMapping(value = "/new/ad", method = RequestMethod.GET)
    public String adViewGet(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);

        if(session.getAttribute("user") == null) {
            return "redirect:/login";
        }

        model.addAttribute("ad",new Ad());

        // Return the view
        return "ads/new_ad";
    }

    // POST a new ad and return the ad-list view
    @RequestMapping(value = "/new/ad", method = RequestMethod.POST)
    public String adViewGet(@ModelAttribute("ad") Ad ad, HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        ad.setCreationTime((new Date()).getTime());
        ad.setAuthor((User) session.getAttribute("user"));
        adService.save(ad);

        model.addAttribute("ads", adService.findAllReverseOrder());

        // Return the view
        return "ads/adlist";
    }

    // GET view for all ads
    @RequestMapping(value = "/ads", method = RequestMethod.GET)
    public String adsViewGet(Model model) {

        model.addAttribute("ads", adService.findAllReverseOrder());

        return "ads/adlist";
    }

    // GET view for a single ad
    @RequestMapping(value = "/ads/{id}", method = RequestMethod.GET)
    public String adGetAdsFromName(@PathVariable long id, Model model){

        // Get all Postit Notes with this name and add them to the model
        model.addAttribute("ad", adService.findOne(id));

        // Return the view
        return "ads/ad";
    }

    @RequestMapping(value = "/ads/user/{author_id}", method = RequestMethod.GET)
    public String adGetAdsFromUsername(@PathVariable Long author_id, Model model) {

        model.addAttribute("ads", adService.findByAuthor_id(author_id));
        model.addAttribute("user", userService.findOne(author_id));

        return "users/userpage";
    }

    @RequestMapping(value = "/ads/my_ads", method = RequestMethod.GET)
    public String currentUserAdsGet(HttpServletRequest request, Model model) {

        if(request.getSession().getAttribute("user") == null) {
            return "redirect:/";
        }

        User author = (User) request.getSession().getAttribute("user");
        model.addAttribute("ads", adService.findByAuthor_id(author.getId()));

        return "users/userpage";
    }

    @RequestMapping(value = "/ad/delete", method = RequestMethod.POST)
    public String removeAdViewGet(@RequestParam("id") String id, Model model) {

        Ad adToDelete = adService.findOne((long) Integer.parseInt(id));

        adService.delete(adToDelete);

        return "redirect:/ads";
    }

    @RequestMapping(value="/ad/edit/{ad_id}", method = RequestMethod.GET)
    public String editAdViewGet(@PathVariable Long ad_id, Model model) {

        model.addAttribute("ad", adService.findOne(ad_id));
        model.addAttribute("users", userService.findAll());

        return "ads/edit";
    }

    @RequestMapping(value = "/ad/edit/{ad_id}", method = RequestMethod.POST)
    public String editAdViewPost(HttpServletRequest request, @PathVariable Long ad_id, Model model) {

        Ad ad = adService.findOne(ad_id);
        ad.setName(request.getParameter("name"));
        ad.setContent(request.getParameter("content"));
        ad.setUpdatedTime((new Date()).getTime());
        try{
            User buyer = userService.findOne(Long.parseLong(request.getParameter("buyer")));
            ad.setBuyer(buyer);
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        adService.save(ad);

        return "redirect:/ads/my_ads";
    }
}
