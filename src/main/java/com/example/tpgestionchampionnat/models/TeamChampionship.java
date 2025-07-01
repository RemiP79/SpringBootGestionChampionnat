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
    public int getIdChampionship() {
        return idChampionship;
    }

    public void setIdChampionship(int idChampionship) {
        this.idChampionship = idChampionship;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public Championship getChampionship() {
        return championship;
    }

    public void setChampionship(Championship championship) {
        this.championship = championship;
        if (championship != null) {
            this.idChampionship = championship.getId();
        }
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
        if (team != null) {
            this.idTeam = team.getId();
        }
    }
}