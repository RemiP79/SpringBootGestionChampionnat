package com.example.tpgestionchampionnat.repositories;

import com.example.tpgestionchampionnat.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}