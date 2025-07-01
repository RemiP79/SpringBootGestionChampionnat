package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.TeamChampionship;
import com.example.tpgestionchampionnat.models.TeamChampionshipId;
import com.example.tpgestionchampionnat.models.Championship;
import com.example.tpgestionchampionnat.models.Team;
import com.example.tpgestionchampionnat.services.TeamChampionshipService;
import com.example.tpgestionchampionnat.services.ChampionshipService;
import com.example.tpgestionchampionnat.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/teamchampionship")
public class TeamChampionshipController {
    @Autowired
    private TeamChampionshipService teamChampionshipService;
    
    @Autowired
    private ChampionshipService championshipService;
    
    @Autowired
    private TeamService teamService;

    // Liste des participations (admin)
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<TeamChampionship> teamChampionshipList = teamChampionshipService.recupererTeamChampionships();
        model.addAttribute("teamChampionshipList", teamChampionshipList);
        return "admin/teamChampionshipList";
    }

    // Formulaire d'ajout
    @GetMapping("/admin/add")
    public String addForm(Model model) {
        model.addAttribute("teamChampionship", new TeamChampionship());
        model.addAttribute("championships", championshipService.recupererChampionships());
        model.addAttribute("teams", teamService.recupererTeams());
        return "admin/teamChampionshipForm";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute TeamChampionship teamChampionship, 
                           @RequestParam(required = false) Integer championshipId,
                           @RequestParam(required = false) Integer teamId) {
        if (championshipId != null && teamId != null) {
            Championship championship = championshipService.recupererChampionship(championshipId);
            Team team = teamService.recupererTeam(teamId);
            teamChampionship.setChampionship(championship);
            teamChampionship.setTeam(team);
        }
        teamChampionshipService.ajouterTeamChampionship(teamChampionship);
        return "redirect:/teamchampionship/admin";
    }

    // Formulaire de modification
    @GetMapping("/admin/edit")
    public String editForm(@RequestParam Integer idChampionship, @RequestParam Integer idTeam, Model model) {
        TeamChampionshipId id = new TeamChampionshipId(idChampionship, idTeam);
        TeamChampionship teamChampionship = teamChampionshipService.recupererTeamChampionship(id);
        model.addAttribute("teamChampionship", teamChampionship);
        model.addAttribute("championships", championshipService.recupererChampionships());
        model.addAttribute("teams", teamService.recupererTeams());
        return "admin/teamChampionshipForm";
    }

    @PostMapping("/admin/edit")
    public String editSubmit(@ModelAttribute TeamChampionship teamChampionship,
                            @RequestParam(required = false) Integer championshipId,
                            @RequestParam(required = false) Integer teamId) {
        if (championshipId != null && teamId != null) {
            Championship championship = championshipService.recupererChampionship(championshipId);
            Team team = teamService.recupererTeam(teamId);
            teamChampionship.setChampionship(championship);
            teamChampionship.setTeam(team);
        }
        teamChampionshipService.ajouterTeamChampionship(teamChampionship);
        return "redirect:/teamchampionship/admin";
    }

    // Suppression
    @PostMapping("/admin/delete")
    public String delete(@RequestParam Integer idChampionship, @RequestParam Integer idTeam) {
        TeamChampionshipId id = new TeamChampionshipId(idChampionship, idTeam);
        teamChampionshipService.supprimerTeamChampionship(id);
        return "redirect:/teamchampionship/admin";
    }
} 