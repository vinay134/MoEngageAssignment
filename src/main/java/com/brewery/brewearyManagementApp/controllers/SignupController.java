package com.brewery.brewearyManagementApp.controllers;

import com.brewery.brewearyManagementApp.model.Users;
import com.brewery.brewearyManagementApp.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {
    @Autowired
    private UsersService usersService;
    @PostMapping("/signup")
    public String signUpNewUser(@ModelAttribute Users users){
        usersService.saveDetails(users);
        return "redirect:/login";
    }
}
