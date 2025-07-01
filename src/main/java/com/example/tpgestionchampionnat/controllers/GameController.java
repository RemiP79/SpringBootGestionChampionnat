package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.Game;
import com.example.tpgestionchampionnat.models.Team;
import com.example.tpgestionchampionnat.models.Day;
import com.example.tpgestionchampionnat.services.GameService;
import com.example.tpgestionchampionnat.services.TeamService;
import com.example.tpgestionchampionnat.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private DayService dayService;

    // Liste des matchs (backoffice)
    @GetMapping("/admin")
    public String adminList(Model model) {
        List<Game> gameList = gameService.recupererGames();
        model.addAttribute("gameList", gameList);
        return "admin/gameList";
    }

    // Formulaire d'ajout
    @GetMapping("/admin/add")
    public String addForm(Model model) {
        model.addAttribute("game", new Game());
        model.addAttribute("teams", teamService.recupererTeams());
        model.addAttribute("days", dayService.recupererDays());
        return "admin/gameForm";
    }

    @PostMapping("/admin/add")
    public String addSubmit(@ModelAttribute Game game, @RequestParam Integer team1Id, @RequestParam Integer team2Id, @RequestParam Integer dayId) {
        Team team1 = teamService.recupererTeam(team1Id);
        Team team2 = teamService.recupererTeam(team2Id);
        Day day = dayService.recupererDay(dayId);
        game.setTeam1(team1);
        game.setTeam2(team2);
        game.setDay(day);
        gameService.ajouterGame(game);
        return "redirect:/game/admin";
    }

    // Formulaire de modification
    @GetMapping("/admin/edit")
    public String editForm(@RequestParam Integer id, Model model) {
        Game game = gameService.recupererGame(id);
        model.addAttribute("game", game);
        model.addAttribute("teams", teamService.recupererTeams());
        model.addAttribute("days", dayService.recupererDays());
        return "admin/gameForm";
    }

    @PostMapping("/admin/edit")
    public String editSubmit(@ModelAttribute Game game, @RequestParam Integer team1Id, @RequestParam Integer team2Id, @RequestParam Integer dayId) {
        Team team1 = teamService.recupererTeam(team1Id);
        Team team2 = teamService.recupererTeam(team2Id);
        Day day = dayService.recupererDay(dayId);
        game.setTeam1(team1);
        game.setTeam2(team2);
        game.setDay(day);
        gameService.ajouterGame(game);
        return "redirect:/game/admin";
    }

    // Suppression
    @PostMapping("/admin/delete")
    public String delete(@RequestParam Integer id) {
        gameService.supprimerGame(id);
        return "redirect:/game/admin";
    }
}