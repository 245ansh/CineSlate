package com.cineslate.CineSlate.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cineslate.CineSlate.entities.Lists;
import com.cineslate.CineSlate.services.ListsService;
@RestController
public class ListsController {
    @Autowired
    private ListsService listsService;

    @GetMapping("/lists/{id}")
    public Lists getList(@PathVariable Long id){
        Optional<Lists> optionalList= listsService.getById(id);
        if(optionalList.isPresent()){
            return optionalList.get();
        }
        return null;
    }

    @PostMapping("/list/add")
    public Lists addLists(@RequestBody  Lists list){
        return listsService.save(list);
    }
        @PostMapping("/list/edit/{id}")
        public Lists updateLists(@RequestBody Lists list,@PathVariable Long id){

        Optional<Lists> optionalList = listsService.getById(id);
        if(optionalList.isPresent()){
            Lists lis = optionalList.get();
            lis.setListName(list.getListName());
            lis.setUpdatedAt(list.getUpdatedAt());
            return listsService.save(lis);
        }
        return null;
    }

    @GetMapping("/list/delete/{id}")
    public String deleteList(@PathVariable Long id){
        Optional<Lists> optionalList= listsService.getById(id);
        if(optionalList.isPresent()){
            Lists list= optionalList.get();
            listsService.delete(list);
            return "Deletion Successful";
        }
        return "List not Found";
    }
}
