package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Ad;
import project.persistence.entities.User;
import project.persistence.repositories.AdRepository;
import project.persistence.repositories.AdSearch;
import project.service.AdService;
import project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class AdController {

    // Instance Variables
    AdService adService;

    // Inject the UserSearch object
    @Autowired
    private AdSearch adSearch;

    // Dependency Injection
    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
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

        return "users/userpage";
    }

    @RequestMapping(value = "/ad/delete", method = RequestMethod.POST)
    public String removeAdViewGet(@RequestParam("id") String id, Model model) {

        Ad adToDelete = adService.findOne((long) Integer.parseInt(id));

        adService.delete(adToDelete);

        return "redirect:/ads";
    }

    @RequestMapping("/ads/search")
    public String adSearch(String q, Model model) {
        List searchResults = null;
        try {
            searchResults = adSearch.search(q);
        }
        catch (Exception ex) {
            System.out.println("Search failure");
        }
        model.addAttribute("searchResults", searchResults);
        return "search";
    }
}
