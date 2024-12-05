package com.cineslate.CineSlate.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineslate.CineSlate.entities.User;
import com.cineslate.CineSlate.repository.UserRepository;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;
    public User register(User user) {
        return userRepo.save(user);
    }

    public Optional<User> findOneByEmail(String email) {
        return userRepo.findOneByEmailIgnoreCase(email);
    }

    public Optional<User> findById(long id) {
        return userRepo.findById(id);
    }

    public void removeUser(Long id) {
        userRepo.deleteById(id);
    }

}
