package com.cineslate.CineSlate.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cineslate.CineSlate.entities.ListMovies;
import com.cineslate.CineSlate.services.ListMoviesService;
@RestController
public class ListMoviesController {
    @Autowired
    private ListMoviesService listMoviesService;

     @GetMapping("/listmovie/{id}")
    public ListMovies getListMovies(@PathVariable Long id){
        Optional<ListMovies> optionalmovieList= listMoviesService.getById(id);
        if(optionalmovieList.isPresent()){
            return optionalmovieList.get();
        }
        return null;
    }

    @GetMapping("/listmovies")
    public List<ListMovies> getAllListMovies(){
        return listMoviesService.findAll();
    }
    @PostMapping("/listmovie/add")
    public ListMovies addLists(@RequestBody  ListMovies listMovie){
        return listMoviesService.save(listMovie);
    }

    @GetMapping("/listmovie/delete/{id}")
    public String deleteList(@PathVariable Long id){
        Optional<ListMovies> optionalListMovie= listMoviesService.getById(id);
        if(optionalListMovie.isPresent()){
            ListMovies list= optionalListMovie.get();
            listMoviesService.delete(list);
            return "Deletion Successful";
        }
        return "ListMovie not Found";
    }
}
