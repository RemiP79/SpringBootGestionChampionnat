package com.example.tpgestionchampionnat.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Le score de l'équipe 1 ne peut pas être null")
    private int team1Point;

    @NotNull(message = "Le score de l'équipe 2 ne peut pas être null")
    private int team2Point;

    @ManyToOne
    @JoinColumn(name = "id_team1", nullable = false)
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "id_team2", nullable = false)
    private Team team2;

    @ManyToOne
    @JoinColumn(name = "id_day", nullable = false)
    private Day day;

    // Constructeurs
    public Game() {}

    public Game(int team1Point, int team2Point, Team team1, Team team2, Day day) {
        this.team1Point = team1Point;
        this.team2Point = team2Point;
        this.team1 = team1;
        this.team2 = team2;
        this.day = day;
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public int getTeam1Point() {
        return team1Point;
    }

    public void setTeam1Point(int team1Point) {
        this.team1Point = team1Point;
    }

    public int getTeam2Point() {
        return team2Point;
    }

    public void setTeam2Point(int team2Point) {
        this.team2Point = team2Point;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Game(int team1Point, int team2Point) {
        this.team1Point = team1Point;
        this.team2Point = team2Point;
    }

    public Game() {

    }

    public Day getDay() {
        return day;
    }
}
