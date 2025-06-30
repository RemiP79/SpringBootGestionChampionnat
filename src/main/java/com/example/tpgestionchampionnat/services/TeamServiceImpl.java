package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Team;
import com.example.tpgestionchampionnat.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team ajouterTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team recupererTeam(Integer idTeam) {
        return teamRepository.findById(idTeam).orElse(null);
    }

    @Override
    public List<Team> recupererTeams() {
        return teamRepository.findAll();
    }

    @Override
    public void supprimerTeam(Integer idTeam) {
        teamRepository.deleteById(idTeam);
    }
}