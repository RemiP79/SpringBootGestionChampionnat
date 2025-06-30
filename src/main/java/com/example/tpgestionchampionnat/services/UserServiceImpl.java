package com.example.tpgestionchampionnat.services;

import com.example.tpgestionchampionnat.models.User;
import com.example.tpgestionchampionnat.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User ajouterUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User recupererUser(Integer idUser) {
        return userRepository.findById(idUser).orElse(null);
    }

    @Override
    public List<User> recupererUsers() {
        return userRepository.findAll();
    }

    @Override
    public void supprimerUser(Integer idUser) {
        userRepository.deleteById(idUser);
    }
}