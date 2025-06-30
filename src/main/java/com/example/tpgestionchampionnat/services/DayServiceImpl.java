package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Day;
import com.example.tpgestionchampionnat.repositories.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DayServiceImpl implements DayService {
    @Autowired
    private DayRepository dayRepository;

    @Override
    public Day ajouterDay(Day day) {
        return dayRepository.save(day);
    }

    @Override
    public Day recupererDay(Integer idDay) {
        return dayRepository.findById(idDay).orElse(null);
    }

    @Override
    public List<Day> recupererDays() {
        return dayRepository.findAll();
    }

    @Override
    public void supprimerDay(Integer idDay) {
        dayRepository.deleteById(idDay);
    }
}