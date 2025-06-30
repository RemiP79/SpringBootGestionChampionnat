package com.example.tpgestionchampionnat.repositories;

import com.example.tpgestionchampionnat.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day, Integer> {
}