/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo10.app.rents.service;

import com.grupo10.app.rents.dto.ReportClientDto;
import com.grupo10.app.rents.dto.ReportStatusDto;
//import com.grupo10.app.rents.interfaces.IQuadbikeRepository;
import com.grupo10.app.rents.entities.Category;
import com.grupo10.app.rents.entities.Client;
import com.grupo10.app.rents.interfaces.ICategoryRepository;
import com.grupo10.app.rents.entities.Quadbike;
import com.grupo10.app.rents.entities.Reservation;
import com.grupo10.app.rents.interfaces.IClientRepository;
import com.grupo10.app.rents.interfaces.IReservationRepository;
import com.grupo10.app.rents.repository.ClientRepository;
import com.grupo10.app.rents.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    ReservationRepository repository;

  // @Autowired
  //  IQuadbikeRepository quadbikeRepository; 
    
    @Autowired
    ClientRepository clientRepository; 

    public Iterable<Reservation> get() {
        Iterable<Reservation> response = repository.getAll();
        return response;
    }

    /*public String create(Reservation request) {

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

    }*/
    
    public String create(Reservation request) {

        repository.save(request);
        return "";
    }
    
    
    public List<ReportClientDto> getClientReport() {

        List<ReportClientDto> report = new ArrayList<ReportClientDto>();
        List<Object[]> reportData = repository.getReport();

        for (int i = 0; i < reportData.size(); i++) {
            ReportClientDto reportClientDto = new ReportClientDto();
            reportClientDto.client = (Client) reportData.get(i)[0];
            reportClientDto.total = (Long) reportData.get(i)[1];
            report.add(reportClientDto);
        }
        return report;

    }

    public List<Reservation> getReportDates(String dateOne, String dateTwo) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateOne);
            b = parser.parse(dateTwo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (a.before(b)) {
            return repository.getReservationsPeriod(a, b);
        } else {
            return new ArrayList<>();
        }

    }

    public ReportStatusDto getReservationsStatusReport() {
        ReportStatusDto reportStatusDto = new ReportStatusDto();
        reportStatusDto.completed=repository.getReservationsByStatus("completed").size();
        reportStatusDto.cancelled=repository.getReservationsByStatus("cancelled").size();        
        return reportStatusDto;

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
