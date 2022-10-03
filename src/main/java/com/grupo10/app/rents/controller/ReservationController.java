/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.controller;

import com.grupo10.app.rents.interfaces.IReservationRepository;
import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Andres
 */
@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

  @Autowired
  ReservationService service;

  @GetMapping("/all")
  public Iterable<Reservation> get() {
    return service.get();

  }

  @PostMapping("/save")
  public String create(@RequestBody Reservation request) {
    return service.create(request);
    
  }
}
