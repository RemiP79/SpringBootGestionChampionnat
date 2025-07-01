package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.Championship;
import com.example.tpgestionchampionnat.models.TeamChampionship;
import com.example.tpgestionchampionnat.models.Team;
import com.example.tpgestionchampionnat.models.Game;
import com.example.tpgestionchampionnat.models.Day;
import com.example.tpgestionchampionnat.services.ChampionshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

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
        // Calcul du classement
        List<TeamChampionship> participations = championship.getTeamChampionships();
        List<ClassementStat> classement = new ArrayList<>();
        if (participations != null) {
            for (TeamChampionship tc : participations) {
                Team team = tc.getTeam();
                int points = 0, victoires = 0, nuls = 0, defaites = 0;
                for (TeamChampionship tc2 : participations) {
                    for (Game game : tc2.getTeam().getGamesAsTeam1()) {
                        if (game.getDay() != null && game.getDay().getChampionship().getId() == idChampionship) {
                            if ((game.getTeam1() != null && game.getTeam1().getId() == team.getId()) || (game.getTeam2() != null && game.getTeam2().getId() == team.getId())) {
                                if (game.getTeam1() != null && game.getTeam2() != null) {
                                    if (game.getTeam1().getId() == team.getId()) {
                                        if (game.getTeam1Point() > game.getTeam2Point()) { victoires++; points += championship.getWonPoint(); }
                                        else if (game.getTeam1Point() < game.getTeam2Point()) { defaites++; points += championship.getLostPoint(); }
                                        else { nuls++; points += championship.getDrawPoint(); }
                                    } else if (game.getTeam2().getId() == team.getId()) {
                                        if (game.getTeam2Point() > game.getTeam1Point()) { victoires++; points += championship.getWonPoint(); }
                                        else if (game.getTeam2Point() < game.getTeam1Point()) { defaites++; points += championship.getLostPoint(); }
                                        else { nuls++; points += championship.getDrawPoint(); }
                                    }
                                }
                            }
                        }
                    }
                }
                classement.add(new ClassementStat(team, points, victoires, nuls, defaites));
            }
            classement.sort((a, b) -> Integer.compare(b.points, a.points));
        }
        model.addAttribute("classement", classement);
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

    // Classe interne pour le classement
    public static class ClassementStat {
        public Team team;
        public int points;
        public int victoires;
        public int nuls;
        public int defaites;
        public ClassementStat(Team team, int points, int victoires, int nuls, int defaites) {
            this.team = team;
            this.points = points;
            this.victoires = victoires;
            this.nuls = nuls;
            this.defaites = defaites;
        }
        public Team getTeam() { return team; }
        public int getPoints() { return points; }
        public int getVictoires() { return victoires; }
        public int getNuls() { return nuls; }
        public int getDefaites() { return defaites; }
    }

    @GetMapping("/results")
    public String resultsDay(@RequestParam Integer idChampionship, @RequestParam Integer idDay, Model model) {
        Championship championship = championshipService.recupererChampionship(idChampionship);
        Day day = null;
        for (Day d : championship.getDays()) {
            if (d.getId() == idDay) { day = d; break; }
        }
        List<Game> games = (day != null) ? day.getGames() : new ArrayList<>();
        model.addAttribute("championship", championship);
        model.addAttribute("day", day);
        model.addAttribute("games", games);
        return "resultsDay";
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Championship> championships = championshipService.recupererChampionships();
        if (!championships.isEmpty()) {
            Championship championship = championships.get(0);
            model.addAttribute("championship", championship);
            // Calcul du classement (même logique que /classement)
            List<TeamChampionship> participations = championship.getTeamChampionships();
            List<ClassementStat> classement = new ArrayList<>();
            if (participations != null) {
                for (TeamChampionship tc : participations) {
                    Team team = tc.getTeam();
                    int points = 0, victoires = 0, nuls = 0, defaites = 0;
                    for (TeamChampionship tc2 : participations) {
                        for (Game game : tc2.getTeam().getGamesAsTeam1()) {
                            if (game.getDay() != null && game.getDay().getChampionship().getId() == championship.getId()) {
                                if ((game.getTeam1() != null && game.getTeam1().getId() == team.getId()) || (game.getTeam2() != null && game.getTeam2().getId() == team.getId())) {
                                    if (game.getTeam1() != null && game.getTeam2() != null) {
                                        if (game.getTeam1().getId() == team.getId()) {
                                            if (game.getTeam1Point() > game.getTeam2Point()) { victoires++; points += championship.getWonPoint(); }
                                            else if (game.getTeam1Point() < game.getTeam2Point()) { defaites++; points += championship.getLostPoint(); }
                                            else { nuls++; points += championship.getDrawPoint(); }
                                        } else if (game.getTeam2().getId() == team.getId()) {
                                            if (game.getTeam2Point() > game.getTeam1Point()) { victoires++; points += championship.getWonPoint(); }
                                            else if (game.getTeam2Point() < game.getTeam1Point()) { defaites++; points += championship.getLostPoint(); }
                                            else { nuls++; points += championship.getDrawPoint(); }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    classement.add(new ClassementStat(team, points, victoires, nuls, defaites));
                }
                classement.sort((a, b) -> Integer.compare(b.points, a.points));
            }
            model.addAttribute("classement", classement);
        } else {
            model.addAttribute("classement", null);
            model.addAttribute("championship", null);
        }
        return "index";
    }

    @GetMapping("/jours")
    public String joursChampionnat(@RequestParam Integer idChampionship, Model model) {
        Championship championship = championshipService.recupererChampionship(idChampionship);
        model.addAttribute("championship", championship);
        model.addAttribute("days", championship.getDays());
        return "joursChampionnat";
    }
}