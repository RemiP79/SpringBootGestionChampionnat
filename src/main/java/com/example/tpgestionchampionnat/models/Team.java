package com.example.tpgestionchampionnat.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @NotNull(message = "le champ name ne peut pas être null")
    private String name;

    @Temporal(value = TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat()
    private LocalDate creationDate;

    @NotBlank
    @NotNull(message = "le champ logo ne peut pas être null")
    private String logo;

    @NotBlank
    @NotNull(message = "le champ coach ne peut pas être null")
    private String coach;

    @NotBlank
    @NotNull(message = "le champ president ne peut pas être null")
    private String president;

    @NotBlank
    @NotNull(message = "le champ status ne peut pas être null")
    private String status;

    @NotBlank
    @NotNull(message = "le champ siege ne peut pas être null")
    private String siege;

    @NotBlank
    @NotNull(message = "le champ phone ne peut pas être null")
    private String phone;

    @NotBlank
    @NotNull(message = "le champ webSite ne peut pas être null")
    private String webSite;


//     @OneToMany(mappedBy = "team")
//     private List<Stadium> stadium;


    @ManyToOne
    @JoinColumn(name = "stadium_id")
    private Stadium stadium;


    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "team")
    private List<TeamChampionship> teamChampionships;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Stadium getStadium() {return stadium;}  // création de liste basé sur @OneToMany

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<TeamChampionship> getTeamChampionships() {
        return teamChampionships;
    }

    public void setTeamChampionships(List<TeamChampionship> teamChampionships) {
        this.teamChampionships = teamChampionships;
    }

    @PrePersist
    protected void onCreate() {
        creationDate = LocalDate.now();
    }

    @OneToMany(mappedBy = "team1")
    private List<Game> gamesAsTeam1;

    @OneToMany(mappedBy = "team2")
    private List<Game> gamesAsTeam2;

    public Team(String name, LocalDate creationDate, String logo, String coach, String president, String status, String siege, String phone, String webSite/*, Stadium stadium, Country country, List<TeamChampionship> teamChampionships*/) {
        this.name = name;
        this.creationDate = creationDate;
        this.logo = logo;
        this.coach = coach;
        this.president = president;
        this.status = status;
        this.siege = siege;
        this.phone = phone;
        this.webSite = webSite;
//        this.stadium = stadium;
//        this.country = country;
//        this.teamChampionships = teamChampionships;
    }

    public Team() {
    }

    public List<Game> getGamesAsTeam1() {
        return gamesAsTeam1;
    }

    public List<Game> getGamesAsTeam2() {
        return gamesAsTeam2;
    }
}

