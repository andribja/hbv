package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import project.persistence.entities.User;
import project.service.AdService;
import project.service.ReviewService;
import project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    UserService userService;
    AdService adService;
    ReviewService reviewService;
    
    //Facebook facebook;

    @Autowired
    public UserController(UserService userService, AdService adService, ReviewService reviewService) {
        this.userService = userService;
        this.adService = adService;
        this.reviewService = reviewService;
        
        //this.facebook = facebook;
    }

    // GET view for a single user
    @RequestMapping(value = "/userpage", method=RequestMethod.GET)
    public String userViewGet(HttpServletRequest request, Model model) {
       //model.addAttribute("user", userService.findOne("test"));

        User user = (User) request.getSession().getAttribute("user");
        model.addAttribute("ads", adService.findAllUnreviewedBy(user.getId()));

        return "users/user";
    }

    // GET view for user-list
    @RequestMapping(value = "/users", method=RequestMethod.GET)
    public String userlistViewGet(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();

        if(session.getAttribute("user") == null) {
            System.out.println("denied");
            return "redirect:/login";
        }

        model.addAttribute("users", userService.findAll());

        return "users/userlist";
    }

    @RequestMapping(value= "/users/{user_id}", method = RequestMethod.GET)
    public String userViewGet(HttpServletRequest request, @PathVariable Long user_id, Model model) {
        HttpSession session = request.getSession();

        if(session.getAttribute("user") == null) {
            System.out.println("denied");

            return "redirect:/login?redirect=true";
        }

        model.addAttribute("user", userService.findOne(user_id));
        model.addAttribute("reviews", reviewService.findByReceiverId(user_id));

        return "users/profile";
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public String removeUserViewGet(@RequestParam("username") String username, Model model) {

        //User userToDelete = userService.findOne(username);
        //userService.delete(userToDelete);

        return "redirect:/users";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signupViewGet(HttpServletRequest request, Model model) {
        if(request.getSession(false).getAttribute("user_id") != null) {
            return "redirect:/";
        }

        model.addAttribute("user",new User());

        return "users/new_user";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupViewPost(HttpServletRequest request, @ModelAttribute("user") User user, Model model) {
        HttpSession session = request.getSession();

        String pass = request.getParameter("password");
        String confirm = request.getParameter("confirm");

        if(!pass.equals(confirm)) {
            System.out.println("Password mismatch " + pass + ", " + confirm);

            model.addAttribute("user", user);
            return "new/user";
        }

        String hash = new BCryptPasswordEncoder().encode(pass);

        user.setHash(hash);
        //if(!userService.exists(user.getUsername()))
        userService.save(user);
        //else
        //    System.out.println("User exists");

        session.setAttribute("user", user);

        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(HttpServletRequest request, Model model) {
        try {
            if (request.getParameter("redirect").equals("true")) {
                String referrer = request.getHeader("Referer");
                request.getSession().setAttribute("return_url", referrer);
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        }

        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String loginPost(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String return_url = (String) request.getSession().getAttribute("return_url");
        if(return_url == null) {
            return_url = "/";
        }

        if(userService.findByUsername(username) == null) {
            model.addAttribute("message", "Notandi finnst ekki");

            return "login";
        }

        User user = userService.findByUsername(username);

        if(new BCryptPasswordEncoder().matches(pass, user.getHash())) {
            System.out.println("Match");

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            return "redirect:" + return_url;
        }

        model.addAttribute("message", "Villa kom upp, reyndu aftur");
        return "login";
    }

    @RequestMapping(value="/logout", method =  RequestMethod.GET)
    public String logout(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);

        session.invalidate();

        return("redirect:/");
    }
}
