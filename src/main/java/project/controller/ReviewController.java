package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Ad;
import project.persistence.entities.User;
import project.persistence.repositories.AdRepository;
import project.service.ReviewService;
import project.service.UserService;

import java.util.Arrays;
import java.util.Date;

@Controller
public class ReviewController {

    // Instance Variables
    ReviewService reviewService;

    // Dependency Injection
    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


}
