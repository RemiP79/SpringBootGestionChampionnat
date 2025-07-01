package com.example.tpgestionchampionnat.repositories;

import com.example.tpgestionchampionnat.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Pour authentification ou vérifications
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}
