package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Country;
import com.example.tpgestionchampionnat.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country ajouterCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country recupererCountry(Integer idCountry) {
        return countryRepository.findById(idCountry).orElse(null);
    }

    @Override
    public List<Country> recupererCountries() {
        return countryRepository.findAll();
    }

    @Override
    public void supprimerCountry(Integer idCountry) {
        countryRepository.deleteById(idCountry);
    }
}