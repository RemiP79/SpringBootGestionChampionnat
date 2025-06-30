package com.example.tpgestionchampionnat.repositories;

import com.example.tpgestionchampionnat.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}