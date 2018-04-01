package com.nevermind.bu.controller;

import com.nevermind.bu.entity.Contact;
import com.nevermind.bu.entity.User;
import com.nevermind.bu.service.interfaces.ContactService;
import com.nevermind.bu.service.interfaces.UserService;
import exception.UserExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

    @GetMapping("/{id}")
    public String showContact(@PathVariable("id") int id, Model model) {
        model.addAttribute("contact", contactService.getById(id));
        return "showContact";
    }

    @GetMapping("/create")
    public String showCreateContactForm(Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "createContact";
    }

    @PostMapping("/create")
    public String createNewContact(@Valid Contact contact, Errors errors, Model model, Principal principal) {
        User user = userService.getByUsername(principal.getName());
        if (errors.hasErrors()) {
            return "createContact";
        }

        contact.setUser(user);
        Contact newContact = contactService.createNewContact(contact);
        model.addAttribute("contact", newContact);
        return "redirect:/contact/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") int id) {
        Contact contact = contactService.getById(id);
        contact.setUser(null);
        contactService.delete(contact);
        return "redirect:/contact/all";
    }


}
