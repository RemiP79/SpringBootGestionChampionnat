package com.example.tpgestionchampionnat.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
public class Championship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotNull(message = "le champ name ne peut pas être null")
    private String name;

    @NotBlank
    @NotNull(message = "le champ logo ne peut pas être null")
    private String logo;

    @Temporal(value = TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat()
    @NotNull(message = "le champ start date ne peut pas être null")
    private LocalDate startDate;

    @Temporal(value = TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat()
    @NotNull(message = "le champ end date ne peut pas être null")
    private LocalDate endDate;

    @NotNull(message = "le champ wonPoint ne peut pas être null")
    private int wonPoint;

    @NotNull(message = "le champ lostPoint ne peut pas être null")
    private int lostPoint;

    @NotNull(message = "le champ lostPoint ne peut pas être null")
    private int drawPoint;

    @NotBlank
    @NotNull(message = "le champ typeRanking ne peut pas être null")
    private String typeRanking;

    @OneToMany(mappedBy = "championship")
    private List<Day> days;

    @OneToMany(mappedBy = "championship")
    private List<TeamChampionship> teamChampionships;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getWonPoint() {
        return wonPoint;
    }

    public void setWonPoint(int wonPoint) {
        this.wonPoint = wonPoint;
    }

    public int getLostPoint() {
        return lostPoint;
    }

    public void setLostPoint(int lostPoint) {
        this.lostPoint = lostPoint;
    }

    public int getDrawPoint() {
        return drawPoint;
    }

    public void setDrawPoint(int drawPoint) {
        this.drawPoint = drawPoint;
    }

    public String getTypeRanking() {
        return typeRanking;
    }

    public void setTypeRanking(String typeRanking) {
        this.typeRanking = typeRanking;
    }

    public void addDay(Day day)
    {
        this.days.add(day);
    }

    public Championship(String name, LocalDate startDate, LocalDate endDate, int wonPoint, int lostPoint, int drawPoint, String typeRanking) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.wonPoint = wonPoint;
        this.lostPoint = lostPoint;
        this.drawPoint = drawPoint;
        this.typeRanking = typeRanking;
    }

    public Championship() {
    }

    public List<TeamChampionship> getTeamChampionships() {
        return teamChampionships;
    }

    public List<Day> getDays() {
        return days;
    }
}
