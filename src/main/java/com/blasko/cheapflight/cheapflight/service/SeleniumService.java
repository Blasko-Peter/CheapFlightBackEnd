package com.blasko.cheapflight.cheapflight.service;

import com.blasko.cheapflight.cheapflight.model.Flight;
import com.blasko.cheapflight.cheapflight.model.FlightsRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeleniumService {

    List<Flight> flights;

    public List<Flight> getActualFlights(FlightsRequest flightsRequest) {
        flights = new ArrayList<>();
        return flights;
    }

}
