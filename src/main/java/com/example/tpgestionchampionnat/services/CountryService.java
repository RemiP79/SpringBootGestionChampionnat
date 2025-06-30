package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Country;
import java.util.List;

public interface CountryService {
    Country ajouterCountry(Country country);
    Country recupererCountry(Integer idCountry);
    List<Country> recupererCountries();
    void supprimerCountry(Integer idCountry);
}