package com.example.tpgestionchampionnat.repositories;

import com.example.tpgestionchampionnat.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
