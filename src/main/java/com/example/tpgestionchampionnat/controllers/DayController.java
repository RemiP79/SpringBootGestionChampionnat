package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.Day;
import com.example.tpgestionchampionnat.models.Championship;
import com.example.tpgestionchampionnat.services.DayService;
import com.example.tpgestionchampionnat.services.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/day")
public class DayController {
    @Autowired
    private DayService dayService;

    @Autowired
    private ChampionshipService championshipService;

    // Liste des journées (admin)
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<Day> dayList = dayService.recupererDays();
        model.addAttribute("dayList", dayList);
        return "admin/dayList";
    }

    // Formulaire d'ajout
    @GetMapping("/admin/add")
    public String addForm(Model model) {
        model.addAttribute("day", new Day());
        model.addAttribute("championships", championshipService.recupererChampionships());
        return "admin/dayForm";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute Day day, @RequestParam Integer championshipId) {
        Championship championship = championshipService.recupererChampionship(championshipId);
        day.setChampionship(championship);
        dayService.ajouterDay(day);
        return "redirect:/day/admin";
    }

    // Formulaire de modification
    @GetMapping("/admin/edit")
    public String editForm(@RequestParam Integer id, Model model) {
        Day day = dayService.recupererDay(id);
        model.addAttribute("day", day);
        model.addAttribute("championships", championshipService.recupererChampionships());
        return "admin/dayForm";
    }

    @PostMapping("/admin/edit")
    public String editSubmit(@ModelAttribute Day day, @RequestParam Integer championshipId) {
        Championship championship = championshipService.recupererChampionship(championshipId);
        day.setChampionship(championship);
        dayService.ajouterDay(day);
        return "redirect:/day/admin";
    }

    // Suppression
    @PostMapping("/admin/delete")
    public String delete(@RequestParam Integer id) {
        dayService.supprimerDay(id);
        return "redirect:/day/admin";
    }
} 