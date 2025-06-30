package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.Day;
import java.util.List;

public interface DayService {
    Day ajouterDay(Day day);
    Day recupererDay(Integer idDay);
    List<Day> recupererDays();
    void supprimerDay(Integer idDay);
}