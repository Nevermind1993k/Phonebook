package com.nevermind.bu.controller;

import com.nevermind.bu.service.interfaces.ContactService;
import com.nevermind.bu.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@RequestMapping("contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String getAll(Model model, Principal principal) {
        model.addAttribute("contactList", contactService.getAllByUserName(principal.getName()));
        return "contacts";
    }


}
