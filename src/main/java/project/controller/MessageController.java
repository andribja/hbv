package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Ad;
import project.persistence.entities.Message;
import project.persistence.entities.User;
import project.persistence.repositories.AdRepository;
import project.service.AdService;
import project.service.MessageService;
import project.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

@Controller
public class MessageController {

    // Instance Variables
    MessageService messageService;
    UserService userService;
    AdService adService;

    // Dependency Injection
    @Autowired
    public MessageController(MessageService messageService, UserService userService, AdService adService) {
        this.messageService = messageService;
        this.userService = userService;
        this.adService = adService;
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String messageViewGet(HttpServletRequest request, Model model) {

        User receiver = userService.findOne(Long.parseLong(request.getParameter("user_id")));
//        Ad relevantAd = new Ad();

        /*
        try {
            relevantAd = adService.findOne(Long.parseLong(request.getParameter("ad_id")));
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        if(relevantAd.getId() != null) {
            model.addAttribute("ad", relevantAd);
        }
        */

        model.addAttribute("receiver", receiver);
        model.addAttribute("message", new Message());

        return "messages/message";
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String messageViewPost(HttpServletRequest request,
                                  @ModelAttribute("message") Message message,
                                  Model model) {

        User sender = (User) request.getSession().getAttribute("user");
        User receiver = userService.findOne(Long.parseLong(request.getParameter("receiver_id")));

        message.setSender(sender);
        message.setReceiver(receiver);
        message.setSendTime((new Date()).getTime());

        messageService.save(message);

        model.addAttribute("receiver", receiver);

        return "messages/success";
    }
}
