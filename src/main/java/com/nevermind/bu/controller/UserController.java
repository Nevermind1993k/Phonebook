package com.nevermind.bu.controller;

import com.nevermind.bu.entity.User;
import com.nevermind.bu.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import utilities.UserExistException;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registerUser";
    }

    @PostMapping("/register")
    public String registerUserAccount(@Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "registerUser";
        }
        try {
            User registered = userService.registerNewUserAccount(user);
            model.addAttribute("user", registered);
            return "hello";
        } catch (UserExistException e) {
            model.addAttribute("duplicate", true);
            model.addAttribute("errorMsq", e.getMessage());
            return "registerUser";
        }

    }
}
