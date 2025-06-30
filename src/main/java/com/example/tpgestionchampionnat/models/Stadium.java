package com.example.tpgestionchampionnat.models;

import jakarta.persistence.*;

@Entity
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private int capacity;
    private String phone;

    // Getters et setters
}
