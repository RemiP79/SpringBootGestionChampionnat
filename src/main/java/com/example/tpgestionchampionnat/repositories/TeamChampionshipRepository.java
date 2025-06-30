package com.example.tpgestionchampionnat.repositories;

import com.example.tpgestionchampionnat.models.TeamChampionship;
import com.example.tpgestionchampionnat.models.TeamChampionshipId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamChampionshipRepository extends JpaRepository<TeamChampionship, TeamChampionshipId> {
}