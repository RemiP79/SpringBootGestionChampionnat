package com.example.tpgestionchampionnat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String afficherPageLogin() {
        return "login"; // Cela correspond à templates/login.html
    }
}

