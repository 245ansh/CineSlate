package com.cineslate.CineSlate.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cineslate.CineSlate.entities.User;
import com.cineslate.CineSlate.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile/{id}")
    public Optional<User> getProfile(@PathVariable Long id) {
        return userService.findById(id);
    }
    
    @PostMapping("/register")
    public User register(@RequestBody User user) {
       return userService.register(user);
    }

    @PostMapping("/profile/update/{id}")
    public User updateProfile(@PathVariable Long id) {
            User user = userService.findById(id).get();
            user.setName(user.getName());
            user.setDOB(user.getDOB());
            user.setGender(user.getGender());
            user.setPassword(user.getPassword());
            userService.register(user);
            return user;          
    }
    
    @DeleteMapping("/user/delete/{id}")
    public void removeUser(@PathVariable Long id){
        userService.removeUser(id);
    }
    
}
