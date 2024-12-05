package com.cineslate.CineSlate.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cineslate.CineSlate.entities.Lists;
import com.cineslate.CineSlate.repository.ListsRepository;

@Service
public class ListsService {
    @Autowired
    private ListsRepository listsRepository;

    public Optional<Lists> getById(Long id){
        return listsRepository.findById(id);
    }
    public List<Lists> findAll(){
        return listsRepository.findAll();
    }

    
    public Page<Lists> findAll(int offset, int pageSize, String field){
        return listsRepository.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field));
    }
    
    public void delete(Lists list){
        listsRepository.delete(list);
    }
    public Lists save(Lists list){
        return listsRepository.save(list);
    }
}
