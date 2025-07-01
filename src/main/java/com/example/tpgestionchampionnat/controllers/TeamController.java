package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.Team;
import com.example.tpgestionchampionnat.models.Country;
import com.example.tpgestionchampionnat.models.Stadium;
import com.example.tpgestionchampionnat.services.TeamService;
import com.example.tpgestionchampionnat.services.CountryService;
import com.example.tpgestionchampionnat.services.StadiumService;
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
    
    @Autowired
    private CountryService countryService;

    @Autowired
    private StadiumService stadiumService;

    @GetMapping("/list")
    public String listTeams(Model model) {
        List<Team> teamList = teamService.recupererTeams();
        model.addAttribute("teamList", teamList);
        return "teamList";
    }
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
        model.addAttribute("countries", countryService.recupererCountries());
        model.addAttribute("stadiums", stadiumService.recupererStadiums());
        return "admin/teamForm";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute Team team, @RequestParam(required = false) Integer countryId, @RequestParam(required = false) Integer stadiumId) {
        if (countryId != null) {
            Country country = countryService.recupererCountry(countryId);
            team.setCountry(country);
        }
        if (stadiumId != null) {
            Stadium stadium = stadiumService.recupererStadium(stadiumId);
            team.setStadium(stadium);
        }
        teamService.ajouterTeam(team);
        return "redirect:/team/admin";
    }

    // Formulaire de modification
    @GetMapping("/admin/edit")
    public String editForm(@RequestParam Integer id, Model model) {
        Team team = teamService.recupererTeam(id);
        model.addAttribute("team", team);
        model.addAttribute("countries", countryService.recupererCountries());
        model.addAttribute("stadiums", stadiumService.recupererStadiums());
        return "admin/teamForm";
    }

    @PostMapping("/admin/edit")
    public String editSubmit(@ModelAttribute Team team, @RequestParam(required = false) Integer countryId, @RequestParam(required = false) Integer stadiumId) {
        if (countryId != null) {
            Country country = countryService.recupererCountry(countryId);
            team.setCountry(country);
        }
        if (stadiumId != null) {
            Stadium stadium = stadiumService.recupererStadium(stadiumId);
            team.setStadium(stadium);
        }
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