package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.Country;
import com.example.tpgestionchampionnat.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private CountryService countryService;

    // Liste des pays (admin)
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<Country> countryList = countryService.recupererCountries();
        model.addAttribute("countryList", countryList);
        return "admin/countryList";
    }

    // Formulaire d'ajout
    @GetMapping("/admin/add")
    public String addForm(Model model) {
        model.addAttribute("country", new Country());
        return "admin/countryForm";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute Country country) {
        countryService.ajouterCountry(country);
        return "redirect:/country/admin";
    }

    // Formulaire de modification
    @GetMapping("/admin/edit")
    public String editForm(@RequestParam Integer id, Model model) {
        Country country = countryService.recupererCountry(id);
        model.addAttribute("country", country);
        return "admin/countryForm";
    }

    @PostMapping("/admin/edit")
    public String editSubmit(@ModelAttribute Country country) {
        countryService.ajouterCountry(country);
        return "redirect:/country/admin";
    }

    // Suppression
    @PostMapping("/admin/delete")
    public String delete(@RequestParam Integer id) {
        countryService.supprimerCountry(id);
        return "redirect:/country/admin";
    }
} 