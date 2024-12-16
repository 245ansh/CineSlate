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
    public User findByUsername(String name) {
        return userRepo.findByUsername(name);
    }
    public User findById(long id) {
        Optional<User> optional= userRepo.findById(id);
        if(optional.isPresent()){
            User user=optional.get();
            user.setReviews(null);
            user.setLists(null);
            return user;
        }
        else return null;
    }

    public void removeUser(Long id) {
        userRepo.deleteById(id);
    }

}
