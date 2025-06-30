package com.example.tpgestionchampionnat.models;

import java.io.Serializable;
import java.util.Objects;

public class TeamChampionshipId implements Serializable {
    private int idChampionship;
    private int idTeam;

    public TeamChampionshipId() {}

    public TeamChampionshipId(int idChampionship, int idTeam) {
        this.idChampionship = idChampionship;
        this.idTeam = idTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeamChampionshipId that = (TeamChampionshipId) o;
        return idChampionship == that.idChampionship && idTeam == that.idTeam;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idChampionship, idTeam);
    }
}
