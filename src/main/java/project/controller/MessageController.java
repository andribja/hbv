package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.persistence.entities.Ad;
import project.persistence.entities.User;
import project.persistence.repositories.AdRepository;
import project.service.MessageService;
import project.service.UserService;

import java.util.Arrays;
import java.util.Date;

@Controller
public class MessageController {

    // Instance Variables
    MessageService messageService;

    // Dependency Injection
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


}
