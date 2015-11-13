package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.persistence.entities.User;
import project.service.UserService;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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

    @RequestMapping(value = "/new/user", method = RequestMethod.GET)
    public String newUserViewGet(Model model) {

        model.addAttribute("user",new User());

        return "users/new_user";
    }

    @RequestMapping(value = "/new/user", method = RequestMethod.POST)
    public String newUuserViewGet(@ModelAttribute("user") User user, Model model) {

        //if(!userService.exists(user.getUsername()))
            userService.save(user);
        //else
        //    System.out.println("User exists");

        return "users/user";
    }


    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public String removeUserViewGet(@RequestParam("username") String username, Model model) {

        User userToDelete = userService.findOne(username);
        userService.delete(userToDelete);

        return "redirect:/users";
    }
}
