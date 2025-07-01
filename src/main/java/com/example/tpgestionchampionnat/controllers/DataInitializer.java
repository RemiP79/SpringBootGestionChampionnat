package com.example.tpgestionchampionnat.controllers;

import com.example.tpgestionchampionnat.models.User;

import com.example.tpgestionchampionnat.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByEmail("admin").isEmpty()) {
                User admin = new User();
                admin.setFirstName("admin");
                admin.setLastName("admin");
                admin.setEmail("admin");
                admin.setPassword(passwordEncoder.encode("admin"));
                admin.setCreationDate((LocalDate.now()));
               // admin.setRole("ADMIN");
                userRepository.save(admin);

                System.out.println("🟢 Membre 'admin' créé.");
            }
        };
    }
}

