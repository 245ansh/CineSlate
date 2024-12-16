package com.cineslate.CineSlate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.cineslate.CineSlate.entities.User;
import com.cineslate.CineSlate.services.ApiService;
import com.cineslate.CineSlate.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApiService apiService;
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @GetMapping("/profile/{id}")
    @PreAuthorize("isAuthenticated()")
    public User getProfile(@PathVariable Long id) {
        return userService.findById(id);
    }
    @GetMapping("/logindex")
    public String logindex(Model model) throws JsonProcessingException{
        model
        .addAttribute("top81", apiService.homeMovie1());

        model.addAttribute("top82", apiService.homeMovie2());

        return "logindex";
    }
    @GetMapping("/action")
    public String action(){
        return "action";
    }
    @GetMapping("/drama")
    public String drama(){
        return "drama";
    }
    @GetMapping("/signin")
    public String register(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "Signin";
    }
    @PostMapping("/register")
    public String registeruser(@ModelAttribute User user) {
        userService.register(user);
        return "/logindex";
    }

    @PostMapping("/profile/update/{id}")
    public User updateProfile(@PathVariable Long id) {
            User user = userService.findById(id);
            user.setName(user.getName());
            user.setAge(user.getAge());
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
