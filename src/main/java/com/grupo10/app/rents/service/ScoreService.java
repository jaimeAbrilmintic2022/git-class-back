/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.entities.Score;
import com.grupo10.app.rents.interfaces.IReservationRepository;
import com.grupo10.app.rents.interfaces.IScoreRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    
    @Autowired
    IScoreRepository repository;
    @Autowired
    IReservationRepository reservationRepository;
    
    public Iterable<Score> get(){
        Iterable<Score> response = repository.findAll();

        return response;
    }

    public String create(Score request){
        if(request.getMessageText()!=null){
            repository.save(request);
            return "Created ...";
            
        }else{
            return "Falta el nombre";
        }
        
    }
    
    public Score update(Score score){
        if(score.getIdScore()!=null){
            Optional<Score> e= repository.findById(score.getIdScore());
            if(!e.isEmpty()){
                if(score.getMessageText()!=null){
                    e.get().setMessageText(score.getMessageText());
                }
                if(score.getStars()!=null){
                    e.get().setStars(score.getStars());
                }
                if(score.getReservation()!=null){
                    e.get().setReservation(score.getReservation());
                }
                repository.save(e.get());
                return e.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }

    public Boolean delete(Integer id){
        repository.deleteById(id);
        Boolean delete = true;
        return delete;
    }

    
    

    
}
