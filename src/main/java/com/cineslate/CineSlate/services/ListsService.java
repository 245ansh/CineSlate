package com.cineslate.CineSlate.services;

import java.util.List;

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

    public Lists getById(Long id){
        Lists list= listsRepository.findById(id).get();
        list.setUser(null);
        return list;
    }
    public List<Lists> findAll(){
        List<Lists> lists= listsRepository.findAll();
        for(Lists lis:lists) lis.setUser(null);
        return lists;
    }

    
    public Page<Lists> findAll(int offset, int pageSize, String field){
        Page<Lists> lists= listsRepository.findAll(PageRequest.of(offset, pageSize).withSort(Direction.ASC, field));
        for(Lists lis:lists) lis.setUser(null);
        return lists;
    }
    
    public void delete(Lists list){
        listsRepository.delete(list);
    }
    public Lists save(Lists list){
        return listsRepository.save(list);
    }
}
