/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.repository;

import com.grupo10.app.rents.entities.Score;
import com.grupo10.app.rents.interfaces.IScoreRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ScroreRepository {
    
    @Autowired
    IScoreRepository repository;

    public Iterable<Score> getAll(){
        return repository.findAll();
    }
    
    public Optional<Score> findById(Integer id){
        Optional<Score> response= repository.findById(id);
        return response;
    }
    
    public Boolean existsById(Integer id){
        return repository.existsById(id);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    
    public Score save(Score score){
        return repository.save(score);
    }
    
}
