package com.cineslate.CineSlate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cineslate.CineSlate.entities.ListMovies;

public interface ListMoviesRepository extends JpaRepository<ListMovies,Long>{
    
}
