package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.Stadium;
import com.example.tpgestionchampionnat.services.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/stadium")
public class StadiumController {
    @Autowired
    private StadiumService stadiumService;

    // Liste des stades (admin)
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<Stadium> stadiumList = stadiumService.recupererStadiums();
        model.addAttribute("stadiumList", stadiumList);
        return "admin/stadiumList";
    }

    // Formulaire d'ajout
    @GetMapping("/admin/add")
    public String addForm(Model model) {
        model.addAttribute("stadium", new Stadium());
        return "admin/stadiumForm";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute Stadium stadium) {
        stadiumService.ajouterStadium(stadium);
        return "redirect:/stadium/admin";
    }

    // Formulaire de modification
    @GetMapping("/admin/edit")
    public String editForm(@RequestParam Integer id, Model model) {
        Stadium stadium = stadiumService.recupererStadium(id);
        model.addAttribute("stadium", stadium);
        return "admin/stadiumForm";
    }

    @PostMapping("/admin/edit")
    public String editSubmit(@ModelAttribute Stadium stadium) {
        stadiumService.ajouterStadium(stadium);
        return "redirect:/stadium/admin";
    }

    // Suppression
    @PostMapping("/admin/delete")
    public String delete(@RequestParam Integer id) {
        stadiumService.supprimerStadium(id);
        return "redirect:/stadium/admin";
    }
} 