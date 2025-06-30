package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Game;
import com.example.tpgestionchampionnat.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game ajouterGame(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game recupererGame(Integer idGame) {
        return gameRepository.findById(idGame).orElse(null);
    }

    @Override
    public List<Game> recupererGames() {
        return gameRepository.findAll();
    }

    @Override
    public void supprimerGame(Integer idGame) {
        gameRepository.deleteById(idGame);
    }
}