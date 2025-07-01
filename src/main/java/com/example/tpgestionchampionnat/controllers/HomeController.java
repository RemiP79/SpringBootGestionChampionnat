package com.example.tpgestionchampionnat.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bienvenue sur le site de gestion de championnat !");
        return "home"; // correspond à accueil.html dans src/main/resources/templates
    }

    @GetMapping("/home")
        public String home(Model model, Authentication authentication) {
            model.addAttribute("email", authentication.getName());
            return "home"; // correspond à home.html dans src/main/resources/templates/
    }
}


