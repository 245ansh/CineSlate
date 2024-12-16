package com.cineslate.CineSlate.services;

import java.util.List;

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

   public ListMovies getById(Long id){
        ListMovies movie= listMoviesRepository.findById(id).get();
        movie.setList(null);
        return movie;
    }

    public List<ListMovies> findAll(){
        List<ListMovies> allmovies= listMoviesRepository.findAll();
        for(ListMovies moc:allmovies) moc.setList(null);
        return allmovies;
    }

    
    public Page<ListMovies> findAll(int offset, int pageSize, String field){
        Page<ListMovies> pagemovies= listMoviesRepository.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field));
        for(ListMovies moc:pagemovies) moc.setList(null);
        return pagemovies;
    }
    
    public void delete(ListMovies listMovies){
        listMoviesRepository.delete(listMovies);
    }
    public ListMovies save(ListMovies listMovies){
        return listMoviesRepository.save(listMovies);
    }

}