package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.User;
import com.example.tpgestionchampionnat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void inscrireMembreAvecRole(User user, String role) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public User ajouterMembre(User membre) {
        membre.setPassword(passwordEncoder.encode(membre.getPassword()));
        return userRepository.save(membre);
    }

    @Override
    public User recupererMembre(Long id) {
        return userRepository.findById(Math.toIntExact(id)).orElse(null); // ou changer l'id en `Long` dans l'entité
    }

    @Override
    public List<User> recupererTousLesMembres() {
        return userRepository.findAll();
    }

    @Override
    public void supprimerMembre(Long id) {
        userRepository.deleteById(Math.toIntExact(id));
    }

}
