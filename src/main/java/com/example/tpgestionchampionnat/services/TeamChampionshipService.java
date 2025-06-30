package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.TeamChampionship;
import com.example.tpgestionchampionnat.models.TeamChampionshipId;
import java.util.List;

public interface TeamChampionshipService {
    TeamChampionship ajouterTeamChampionship(TeamChampionship teamChampionship);
    TeamChampionship recupererTeamChampionship(TeamChampionshipId id);
    List<TeamChampionship> recupererTeamChampionships();
    void supprimerTeamChampionship(TeamChampionshipId id);
}