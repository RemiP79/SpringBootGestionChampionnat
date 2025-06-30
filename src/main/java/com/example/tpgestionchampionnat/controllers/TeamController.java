package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.Team;
import com.example.tpgestionchampionnat.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    // Affichage public de la fiche d'une équipe
    @GetMapping("/fiche")
    public String fiche(@RequestParam Integer id, Model model) {
        Team team = teamService.recupererTeam(id);
        model.addAttribute("team", team);
        return "teamFiche";
    }

    // Backoffice : liste des équipes
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<Team> teamList = teamService.recupererTeams();
        model.addAttribute("teamList", teamList);
        return "admin/teamList";
    }

    // Formulaire d'ajout
    @GetMapping("/admin/add")
    public String addForm(Model model) {
        model.addAttribute("team", new Team());
        return "admin/teamForm";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute Team team) {
        teamService.ajouterTeam(team);
        return "redirect:/team/admin";
    }

    // Formulaire de modification
    @GetMapping("/admin/edit")
    public String editForm(@RequestParam Integer id, Model model) {
        Team team = teamService.recupererTeam(id);
        model.addAttribute("team", team);
        return "admin/teamForm";
    }

    @PostMapping("/admin/edit")
    public String editSubmit(@ModelAttribute Team team) {
        teamService.ajouterTeam(team);
        return "redirect:/team/admin";
    }

    // Suppression
    @PostMapping("/admin/delete")
    public String delete(@RequestParam Integer id) {
        teamService.supprimerTeam(id);
        return "redirect:/team/admin";
    }
}