package com.example.tpgestionchampionnat.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "le champ name ne peut pas être vide")
    @NotNull(message =  "le champ name ne peut pas être null")
    private String name;

    @NotBlank(message = "le champ address ne peut pas être vide")
    @NotNull(message =  "le champ address ne peut pas être null")
    private String address;


    @NotNull(message =  "le champ capacity ne peut pas être null")
    private int capacity;

    @NotBlank(message = "le champ phone ne peut pas être vide")
    @NotNull(message =  "le champ phone ne peut pas être null")
    private String phone;

    @OneToMany(mappedBy ="stadium")
    private List<Team> team;


//    @ManyToOne
//    @JoinColumn(name = "team_id")
//    private Team team;

    public Stadium() {

    }

    public Stadium( String name, String address, int capacity, String phone) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.phone = phone;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


// Getters et setters
}
