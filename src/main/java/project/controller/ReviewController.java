package project.controller;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Ad;
import project.persistence.entities.Review;
import project.persistence.entities.User;
import project.persistence.repositories.AdRepository;
import project.service.AdService;
import project.service.ReviewService;
import project.service.UserService;
import sun.net.httpserver.HttpsServerImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;

@Controller
public class ReviewController {

    // Instance Variables
    ReviewService reviewService;
    UserService userService;
    AdService adService;

    // Dependency Injection
    @Autowired
    public ReviewController(ReviewService reviewService, UserService userService, AdService adService) {
        this.reviewService = reviewService;
        this.userService = userService;
        this.adService = adService;
    }

    // GET á    foo.bar/review?ad_id=foo
    @RequestMapping(value = "/review", method = RequestMethod.GET)
    public String reviewGet(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        User sender = (User) session.getAttribute("user");
        User receiver = new User();
        Ad relevantAd = adService.findOne(Long.parseLong(request.getParameter("ad_id")));

        if(relevantAd.getBuyer() == null) {
            return "redirect:/";
        } else if (sender.getId() == relevantAd.getBuyer().getId()) {
            // Buyer reviews seller
            receiver = relevantAd.getAuthor();
        } else if(sender.getId() == relevantAd.getAuthor().getId()) {
            //Seller reviews buyer
            receiver = relevantAd.getBuyer();
        }

        model.addAttribute("receiver", receiver);
        model.addAttribute("ad", relevantAd);
        model.addAttribute("review", new Review());
        return "reviews/review";
    }

    // Póstað á:    foo.bar/review?user_id=foo&ad_id=bar
    @RequestMapping(value="/review", method = RequestMethod.POST)
    public String reviewPost(HttpServletRequest request, @ModelAttribute("review") Review review, Model model) {
        HttpSession session = request.getSession(false);

        User sender = (User) session.getAttribute("user");
        User receiver = userService.findOne(Long.parseLong(request.getParameter("receiver_id")));
        Ad relevantAd = adService.findOne(Long.parseLong(request.getParameter("ad_id")));
        double rating = Double.parseDouble(request.getParameter("rating"));

        receiver.giveRating(rating);

        System.out.println(receiver);

        if(relevantAd.getBuyer() == null) {
            return "redirect:/";
        }

        review.setSender(sender);
        review.setReceiver(receiver);
        review.setRelevantAd(relevantAd);
        review.setRating(rating);
        review.setReviewTime((new Date()).getTime());

        try {
            reviewService.save(review);
        } catch (Exception e) {

            return "redirect:/";
        }

        return "reviews/success";
    }


}
