package com.example.tpgestionchampionnat.repositories;

import com.example.tpgestionchampionnat.models.Championship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChampionshipRepository extends JpaRepository<Championship, Integer> {
}
