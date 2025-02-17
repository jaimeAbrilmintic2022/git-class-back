/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo10.app.rents.interfaces;

import com.grupo10.app.rents.entities.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Andres
 */
public interface IReservationRepository extends CrudRepository<Reservation, Integer> {
    
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalclientReservation();
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo );
    
    public List<Reservation>findAllByStatus(String status);
    
}

    /*@Query("SELECT c.ortopedic, COUNT(c.ortopedic) from Reservation AS c group by c.ortopedic order by COUNT(c.ortopedic) DESC")
    public List<Object[]> countTotalReservationsByRoom();


    //select clientId, count(*) as "total" from reservation group by clientId order by total desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo );

    public List<Reservation>findAllByStatus(String status);*/

