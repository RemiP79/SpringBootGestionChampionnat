package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Stadium;
import com.example.tpgestionchampionnat.repositories.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StadiumServiceImpl implements StadiumService {
    @Autowired
    private StadiumRepository stadiumRepository;

    @Override
    public Stadium ajouterStadium(Stadium stadium) {
        return stadiumRepository.save(stadium);
    }

    @Override
    public Stadium recupererStadium(Integer idStadium) {
        return stadiumRepository.findById(idStadium).orElse(null);
    }

    @Override
    public List<Stadium> recupererStadiums() {
        return stadiumRepository.findAll();
    }

    @Override
    public void supprimerStadium(Integer idStadium) {
        stadiumRepository.deleteById(idStadium);
    }
}