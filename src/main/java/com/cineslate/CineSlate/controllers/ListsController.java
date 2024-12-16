package com.cineslate.CineSlate.controllers;

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
        return listsService.getById(id);
    }

    @PostMapping("/list/add")
    public Lists addLists(@RequestBody  Lists list){
        return listsService.save(list);
    }
        @PostMapping("/list/edit/{id}")
        public Lists updateLists(@RequestBody Lists list,@PathVariable Long id){
            Lists lis = listsService.getById(id);
            lis.setListName(list.getListName());
            return listsService.save(lis);
    }

    @GetMapping("/list/delete/{id}")
    public String deleteList(@PathVariable Long id){
            Lists list= listsService.getById(id);
            listsService.delete(list);
            return "Deletion Successful";
    }
}
