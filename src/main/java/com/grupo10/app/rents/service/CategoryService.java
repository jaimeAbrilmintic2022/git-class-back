/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.entities.Quadbike;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    IQuadbikeRepository repository;
    @Autowired
    ICategoryRepository categoryRepository;
    
    public Iterable<Quadbike> get(){

        Iterable<Quadbike> response = repository.findAll();

        return response;
    }

    public String create(Quadbike request){
        Optional<Category> cat = categoryRepository.findById(request.getCategory().getId());
        if(!cat.isEmpty()){
            request.setCategory(cat.get());
        }
        if(request.getName()!=null){
            repository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
        }
       /*repository.save(request);
      
       return "Created ...";*/
        
    }

}




/*@Service
public class CategoryService {

    @Autowired
    IQuadbikeRepository repository;

    @Autowired
    ICategoryRepository categoryRepository; 

    public Iterable<Category> get() {
        Iterable<Category> response = categoryRepository.findAll();
        return response;
    }
    
    
    public String create(Category request) {

        if (request.getName() != null) {
            categoryRepository.save(request);
            return "created....";
        } else {
            return "falta el nombre";
        }

    }
}*/
    
    
    
    
    
    
    
    /*public String create(Quadbike request) {

        Optional<Category> cat = categoryRepository.findById(request.getCategory().getId());
        if (!cat.isEmpty()) {
            request.setCategory(cat.get());
        }
        if (request.getName() != null) {
            categoryRepository.save(request);
            return "created....";
        } else {
            return "falta el nombre";
        }

    }
}*/
