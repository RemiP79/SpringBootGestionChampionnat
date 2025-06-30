package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Championship;
import java.util.List;

public interface ChampionshipService {
    Championship ajouterChampionship(Championship championship);
    Championship recupererChampionship(Integer idChampionship);
    List<Championship> recupererChampionships();
    void supprimerChampionship(Integer idChampionship);
}