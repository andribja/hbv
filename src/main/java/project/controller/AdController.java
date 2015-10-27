package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.persistence.entities.Ad;
import project.persistence.entities.User;
import project.persistence.repositories.AdRepository;
import project.service.AdService;
import project.service.UserService;

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

        //userService.save(new User("test2", "test2@test.com"));
    }


    // GET view for creating a new ad
    @RequestMapping(value = "/new/ad", method = RequestMethod.GET)
    public String adViewGet(Model model){

        model.addAttribute("ad",new Ad());

        // Return the view
        return "ads/new_ad";
    }


    // POST a new ad and return the ad-list view
    @RequestMapping(value = "/new/ad", method = RequestMethod.POST)
    public String adViewGet(@ModelAttribute("ad") Ad ad, Model model){
        ad.setCreationTime((new Date()).getTime());
        adService.save(ad);

        model.addAttribute("ads", adService.findAllReverseOrder());

        // Return the view
        return "ads/adlist";
    }

    // GET view for a single user
    @RequestMapping(value = "/userpage", method=RequestMethod.GET)
    public String userViewGet(Model model) {

        model.addAttribute("user", userService.findOne("test"));

        return "users/user";
    }

    // GET view for user-list
    @RequestMapping(value = "/users", method=RequestMethod.GET)
    public String userlistViewGet(Model model) {

        model.addAttribute("users", userService.findAll());

        return "users/userlist";
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


    @RequestMapping(value = "/new/user", method = RequestMethod.GET)
    public String newUserViewGet(Model model) {

        model.addAttribute("user",new User());

        return "users/new_user";
    }

    //@RequestMapping(value = "/new/user", method = RequestMethod.POST)
    //public String userViewGet()
}
