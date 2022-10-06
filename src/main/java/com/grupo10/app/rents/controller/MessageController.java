/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.entities.Message;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.service.MessageService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/Message")
public class MessageController {
    
    @Autowired
    MessageService service;
    
    @GetMapping("/all")
    public Iterable<Message> get(){
        return service.get();
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    
    public void create(@RequestBody Message request){
        
        service.create(request);
    }


    
    
}