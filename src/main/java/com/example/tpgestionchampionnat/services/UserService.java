package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.User;
import java.util.List;

public interface UserService {
    User ajouterUser(User user);
    User recupererUser(Integer idUser);
    List<User> recupererUsers();
    void supprimerUser(Integer idUser);
}