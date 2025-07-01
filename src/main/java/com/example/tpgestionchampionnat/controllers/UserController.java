package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.User;
import com.example.tpgestionchampionnat.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Affiche le formulaire d'inscription
    @GetMapping("/inscription")
    public String afficherFormulaireInscription(Model model) {
        model.addAttribute("user", new User());
        return "inscription"; // View: templates/inscription.html
    }

    // Traite le formulaire soumis
    @PostMapping("/inscription")
    public String traiterInscription(@Valid @ModelAttribute("user") User user,
                                     BindingResult result,
                                     Model model) {

        if (result.hasErrors()) {
            return "inscription"; // Renvoie vers le formulaire avec les erreurs
        }

        if (userService.recupererTousLesMembres()
                .stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(user.getEmail()))) {
            model.addAttribute("erreurEmail", "Cet email est déjà utilisé.");
            return "inscription";
        }

        userService.ajouterMembre(user);
        model.addAttribute("message", "Inscription réussie !");
        return "redirect:/users/confirmation"; // Redirige vers une page de confirmation
    }

//    @GetMapping("/login")
//    public String afficherPageLogin() {
//        return "login"; // correspond à login.html dans templates/
//    }

//    @GetMapping("/confirmation")
//    public String confirmationInscription() {
//        return "confirmation"; // View: templates/confirmation.html
//    }
}
