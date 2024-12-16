package com.cineslate.CineSlate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.cineslate.CineSlate.services.ApiService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ApiController {
    
    @Autowired
    private ApiService apiService;

    @PostMapping("/search")
    public String search(@RequestParam(name = "prom", required = true) String prom,Model model) throws JsonProcessingException {
        if(prom.isEmpty()) return "/";
        model.addAttribute("movies", apiService.getSearch(prom));
         return "popular";
    }
    @GetMapping("/movie/{id}")
    public String getmovie(Model model, @PathVariable Long id) throws JsonProcessingException {
        model.addAttribute("movie", apiService.getMovie(id));
        return "avtarmodal";
    }
    
}
