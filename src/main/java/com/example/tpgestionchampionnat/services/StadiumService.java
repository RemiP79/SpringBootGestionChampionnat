package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Stadium;
import java.util.List;

public interface StadiumService {
    Stadium ajouterStadium(Stadium stadium);
    Stadium recupererStadium(Integer idStadium);
    List<Stadium> recupererStadiums();
    void supprimerStadium(Integer idStadium);
}