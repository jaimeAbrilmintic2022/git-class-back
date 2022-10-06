/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/*@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    
    @Autowired
    CategoryService service;
    
    @GetMapping("/all")
    public Iterable<Category> get(){
        Iterable<Category> response = service.get();
        return response;
    }
    
       
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    
    public void create(@RequestBody Category request){
        
        service.create(request);
                
    }
}*/

@RestController
@RequestMapping("/api/Category")
public class CategoryController {
    
    @Autowired
    ICategoryRepository repository;
    
    @GetMapping("/all")
    public Iterable<Category> get(){
        Iterable<Category> response = repository.findAll();
        
        return response;
    }
    
    @PostMapping("/save")
    public void create(@RequestBody Category request){
        
        repository.save(request);
        
        //return "created....";
    }


    
    
}
