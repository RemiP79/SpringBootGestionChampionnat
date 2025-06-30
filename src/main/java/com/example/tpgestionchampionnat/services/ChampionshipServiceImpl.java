package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Championship;
import com.example.tpgestionchampionnat.repositories.ChampionshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChampionshipServiceImpl implements ChampionshipService {
    @Autowired
    private ChampionshipRepository championshipRepository;

    @Override
    public Championship ajouterChampionship(Championship championship) {
        return championshipRepository.save(championship);
    }

    @Override
    public Championship recupererChampionship(Integer idChampionship) {
        return championshipRepository.findById(idChampionship).orElse(null);
    }

    @Override
    public List<Championship> recupererChampionships() {
        return championshipRepository.findAll();
    }

    @Override
    public void supprimerChampionship(Integer idChampionship) {
        championshipRepository.deleteById(idChampionship);
    }
}