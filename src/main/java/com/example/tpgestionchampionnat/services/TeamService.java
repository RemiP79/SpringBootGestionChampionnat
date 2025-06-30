package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Team;
import java.util.List;

public interface TeamService {
    Team ajouterTeam(Team team);
    Team recupererTeam(Integer idTeam);
    List<Team> recupererTeams();
    void supprimerTeam(Integer idTeam);
}