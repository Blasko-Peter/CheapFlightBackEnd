package com.blasko.cheapflight.cheapflight.service;

import com.blasko.cheapflight.cheapflight.model.Flight;
import com.blasko.cheapflight.cheapflight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findByAllFlight(){
        return flightRepository.findAll();
    }

}
