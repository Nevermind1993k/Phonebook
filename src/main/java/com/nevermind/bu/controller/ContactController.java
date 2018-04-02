package com.nevermind.bu.controller;

import com.nevermind.bu.entity.Contact;
import com.nevermind.bu.entity.User;
import com.nevermind.bu.service.interfaces.ContactService;
import com.nevermind.bu.service.interfaces.UserService;
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
    public String showContact(@PathVariable("id") int id, Model model, Principal principal) {
        String pUsername = principal.getName();
        Contact contactById = contactService.getById(id);

        if (!pUsername.equals(contactById.getUser().getUsername())) {
            return "redirect:/error";
        }
        model.addAttribute("contact", contactById);
        return "showContact";
    }

    @PostMapping("/update")
    public String editMovie(@Valid Contact contact, Errors errors, Model model, Principal principal) {
        String pUsername = principal.getName();
        Contact updated = contactService.getById(contact.getId());
        User user = userService.getByUsername(principal.getName());


        if (!pUsername.equals(updated.getUser().getUsername())) {
            return "redirect:/error";
        }

        if (errors.hasErrors()) {
            model.addAttribute("contact", contact);
            return "showContact";
        }
        updated.setId(contact.getId());
        updated.setFirstName(contact.getFirstName());
        updated.setLastName(contact.getLastName());
        updated.setMiddleName(contact.getMiddleName());
        updated.setMobilePhoneNumber(contact.getMobilePhoneNumber());
        updated.setHomePhoneNumber(contact.getHomePhoneNumber());
        updated.setAddress(contact.getAddress());
        updated.setEmail(contact.getEmail());
        updated.setUser(user);
        contactService.update(updated);

        model.addAttribute("contact", contact);
        model.addAttribute("message", "Successfully edited!");

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
        model.addAttribute("message", "Successfully created!");
        return "createContact";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") int id, Principal principal) {
        String pUsername = principal.getName();
        Contact contactById = contactService.getById(id);

        if (!pUsername.equals(contactById.getUser().getUsername())) {
            return "redirect:/error";
        }
        contactById.setUser(null);
        contactService.delete(contactById);
        return "redirect:/contact/all";
    }

}
