package com.cineslate.CineSlate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cineslate.CineSlate.entities.ListMovies;
import com.cineslate.CineSlate.repository.ListMoviesRepository;

@Service
public class ListMoviesService{
   @Autowired
   private ListMoviesRepository listMoviesRepository;

   public Optional<ListMovies> getById(Long id){
        return listMoviesRepository.findById(id);
    }

    public List<ListMovies> findAll(){
        return listMoviesRepository.findAll();
    }

    
    public Page<ListMovies> findAll(int offset, int pageSize, String field){
        return listMoviesRepository.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field));
    }
    
    public void delete(ListMovies listMovies){
        listMoviesRepository.delete(listMovies);
    }
    public ListMovies save(ListMovies listMovies){
        return listMoviesRepository.save(listMovies);
    }

}