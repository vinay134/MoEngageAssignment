package com.brewery.brewearyManagementApp.controllers;

import com.brewery.brewearyManagementApp.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("users",new Users());
        return "login";
    }
}
