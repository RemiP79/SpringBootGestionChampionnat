package com.example.tpgestionchampionnat.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "le champ name ne peut pas être vide")
    @NotNull(message =  "le champ name ne peut pas être null")
    private String name;

    @NotBlank(message = "le champ logo ne peut pas être vide")
    @NotNull(message =  "le champ logo ne peut pas être null")
    private String logo;


    public Country(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }


    public Country() {

    }

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;



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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}