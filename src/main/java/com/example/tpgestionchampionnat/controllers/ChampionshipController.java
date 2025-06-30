package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.Championship;
import com.example.tpgestionchampionnat.services.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/championship")
public class ChampionshipController {
    @Autowired
    private ChampionshipService championshipService;

    // Affichage public de la liste des championnats
    @GetMapping("/list")
    public String listChampionships(Model model) {
        List<Championship> championshipList = championshipService.recupererChampionships();
        model.addAttribute("championshipList", championshipList);
        return "championshipList";
    }

    // Affichage du classement d'un championnat
    @GetMapping("/classement")
    public String classement(@RequestParam Integer idChampionship, Model model) {
        Championship championship = championshipService.recupererChampionship(idChampionship);
        model.addAttribute("championship", championship);
        // TODO: ajouter la logique de classement
        return "classement";
    }

    // Backoffice : liste des championnats
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<Championship> championshipList = championshipService.recupererChampionships();
        model.addAttribute("championshipList", championshipList);
        return "admin/championshipList";
    }

    // Formulaire d'ajout
    @GetMapping("/admin/add")
    public String addForm(Model model) {
        model.addAttribute("championship", new Championship());
        return "admin/championshipForm";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute Championship championship) {
        championshipService.ajouterChampionship(championship);
        return "redirect:/championship/admin";
    }

    // Formulaire de modification
    @GetMapping("/admin/edit")
    public String editForm(@RequestParam Integer id, Model model) {
        Championship championship = championshipService.recupererChampionship(id);
        model.addAttribute("championship", championship);
        return "admin/championshipForm";
    }

    @PostMapping("/admin/edit")
    public String editSubmit(@ModelAttribute Championship championship) {
        championshipService.ajouterChampionship(championship);
        return "redirect:/championship/admin";
    }

    // Suppression
    @PostMapping("/admin/delete")
    public String delete(@RequestParam Integer id) {
        championshipService.supprimerChampionship(id);
        return "redirect:/championship/admin";
    }
}