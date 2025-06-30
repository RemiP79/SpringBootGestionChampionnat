package com.example.tpgestionchampionnat.models;

import jakarta.persistence.*;

@Entity
@IdClass(TeamChampionshipId.class)
public class TeamChampionship {
    @Id
    private int idChampionship;
    @Id
    private int idTeam;

    @ManyToOne
    @JoinColumn(name = "idChampionship", insertable = false, updatable = false)
    private Championship championship;

    @ManyToOne
    @JoinColumn(name = "idTeam", insertable = false, updatable = false)
    private Team team;

    // Getters et setters
}