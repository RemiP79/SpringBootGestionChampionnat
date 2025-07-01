package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.User;
import com.example.tpgestionchampionnat.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

    // Liste des utilisateurs (admin)
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<User> userList = userService.recupererTousLesMembres();
        model.addAttribute("userList", userList);
        return "admin/userList";
    }

    // Formulaire d'ajout
    @GetMapping("/admin/add")
    public String addForm(Model model) {
        model.addAttribute("user", new User());
        return "admin/userForm";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute User user) {
        userService.ajouterMembre(user);
        return "redirect:/users/admin";
    }

    // Formulaire de modification
    @GetMapping("/admin/edit")
    public String editForm(@RequestParam Integer id, Model model) {
        User user = userService.recupererMembre(id.longValue());
        model.addAttribute("user", user);
        return "admin/userForm";
    }

    @PostMapping("/admin/edit")
    public String editSubmit(@ModelAttribute User user) {
        userService.ajouterMembre(user);
        return "redirect:/users/admin";
    }

    // Suppression
    @PostMapping("/admin/delete")
    public String delete(@RequestParam Integer id) {
        userService.supprimerMembre(id.longValue());
        return "redirect:/users/admin";
    }
}
