package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.TeamChampionship;
import com.example.tpgestionchampionnat.models.TeamChampionshipId;
import com.example.tpgestionchampionnat.repositories.TeamChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamChampionshipServiceImpl implements TeamChampionshipService {
    @Autowired
    private TeamChampionshipRepository teamChampionshipRepository;

    @Override
    public TeamChampionship ajouterTeamChampionship(TeamChampionship teamChampionship) {
        return teamChampionshipRepository.save(teamChampionship);
    }

    @Override
    public TeamChampionship recupererTeamChampionship(TeamChampionshipId id) {
        return teamChampionshipRepository.findById(id).orElse(null);
    }

    @Override
    public List<TeamChampionship> recupererTeamChampionships() {
        return teamChampionshipRepository.findAll();
    }

    @Override
    public void supprimerTeamChampionship(TeamChampionshipId id) {
        teamChampionshipRepository.deleteById(id);
    }
}