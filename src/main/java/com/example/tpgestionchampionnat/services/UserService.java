package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.User;

import java.util.List;

public interface UserService {
    void inscrireMembreAvecRole(User membre, String role);

    User ajouterMembre(User membre);

    User recupererMembre(Long id);

    List<User> recupererTousLesMembres();
    
    void supprimerMembre(Long id);
}
