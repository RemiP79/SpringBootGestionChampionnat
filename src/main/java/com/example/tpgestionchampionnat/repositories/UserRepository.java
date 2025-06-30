package com.example.tpgestionchampionnat.repositories;


import com.example.tpgestionchampionnat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
