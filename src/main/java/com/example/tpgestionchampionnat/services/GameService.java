package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Game;
import java.util.List;

public interface GameService {
    Game ajouterGame(Game game);
    Game recupererGame(Integer idGame);
    List<Game> recupererGames();
    void supprimerGame(Integer idGame);
}