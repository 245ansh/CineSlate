package com.cineslate.CineSlate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cineslate.CineSlate.apiThings.homemovies.Top7;
import com.cineslate.CineSlate.apiThings.movie.MovieResponse;
import com.cineslate.CineSlate.apiThings.search.searchResponse;
import com.cineslate.CineSlate.services.ApiService;
import com.fasterxml.jackson.core.JsonProcessingException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ApiController {
    
    @Autowired
    private ApiService apiService;

    @GetMapping("/search/{name}")
    public searchResponse search(@PathVariable  String name) throws JsonProcessingException {
         return apiService.search(name);
    }
    @GetMapping("/movie/{id}")
    public MovieResponse movieDetails(@PathVariable Long id) throws JsonProcessingException {
        return apiService.movieDetails(id);
    }
    @GetMapping("/homemovies")
    public String getHomeMovies() throws JsonProcessingException {
        return apiService.homeMovieDetails();
    }
    
}
