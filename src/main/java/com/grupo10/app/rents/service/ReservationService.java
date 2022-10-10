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
    
    
    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= repository.findById(reservation.getIdReservation());
            if(!e.isEmpty()){
                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                if(reservation.getQuadbike()!=null){
                    e.get().setQuadbike(reservation.getQuadbike());
                }
                if(reservation.getClient()!=null){
                    e.get().setClient(reservation.getClient());
                }
                repository.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
        
    }
    
     public Boolean delete(Integer id){
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }
    
    
    
}
