package com.cineslate.CineSlate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cineslate.CineSlate.services.ApiService;
import com.fasterxml.jackson.core.JsonProcessingException;



@Controller
public class HomeController {
    @Autowired
    ApiService apiService;

    @GetMapping("/")
    @PreAuthorize("isAuthenticated()")
    public String home(Model model) throws JsonProcessingException {
        model
        .addAttribute("top81", apiService.homeMovie1());

        model.addAttribute("top82", apiService.homeMovie2());

        return "index";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }
     @GetMapping("/popular")
    public String popular(Model model) {
        return "Popular";
    }
    @GetMapping("/movie")
    public String movie(Model model) {
        return "avtarmodal";
    }
     @GetMapping("/mylist")
    public String lists(Model model) {
        return "Mylist";
    }
     @GetMapping("/latest")
    public String latest(Model model) throws JsonProcessingException {
        model.addAttribute("movies", apiService.homeMovie3());
        return "Latest";
    }

    @GetMapping("/writereview")
    public String writereview(Model model) {
        return "writereview";
    }
    
}
