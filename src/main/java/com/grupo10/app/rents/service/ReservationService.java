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
import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.interfaces.IClientRepository;
import com.grupo10.app.rents.interfaces.IReservationRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Andres
 */
@Service
public class ReservationService {

    @Autowired
    IReservationRepository repository;

   @Autowired
    IQuadbikeRepository quadbikeRepository; 
    
    @Autowired
    IClientRepository clientRepository; 

    public Iterable<Reservation> get() {
        Iterable<Reservation> response = repository.findAll();
        return response;
    }

    public String create(Reservation request) {

        Optional<Quadbike> qua = quadbikeRepository.findById(request.getQuadbike().getId());
        if (!qua.isEmpty()) {
            request.setQuadbike(qua.get());
        }
        
        Optional<Client> cli = clientRepository.findById(request.getClient().getIdClient());
        if (!cli.isEmpty()) {
            request.setClient(cli.get());
        }
        if (request.getStartDate() != null) {
            repository.save(request);
            return "created....";
        } else {
            return "falta fecha";
        }

    }
}
