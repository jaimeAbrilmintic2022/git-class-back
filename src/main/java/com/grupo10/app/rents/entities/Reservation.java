/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Andres
 */
@Entity
@Table(name="tb_reservation")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")    
    private Integer idReservation;
    @Column
    private java.sql.Timestamp startDate;
    @Column
    private java.sql.Timestamp devolutionDate;    
    @Column
    private String status ="created";
    
    @ManyToOne
    @JoinColumn(name="quadbike")
    @JsonIgnoreProperties({"reservations"})
    private Quadbike quadbike;
    
    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;
    
   
        
     
    /*@ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("reservation")
    @JoinColumn(name="quadbike_id")
    private Quadbike quadbike;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("reservation")
    @JoinColumn(name="client_id")
    private Client client;*/
    
    @Column
    private String score;
      
    
    
}
