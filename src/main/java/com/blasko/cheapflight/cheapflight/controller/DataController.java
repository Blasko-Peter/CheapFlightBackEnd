package com.blasko.cheapflight.cheapflight.controller;

import com.blasko.cheapflight.cheapflight.model.Flight;
import com.blasko.cheapflight.cheapflight.model.FlightsRequest;
import com.blasko.cheapflight.cheapflight.service.FlightService;
import com.blasko.cheapflight.cheapflight.service.SeleniumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class DataController {

    String cities[] = new String[] {"Budapest", "Paris", "Madrid", "London", "Berlin"};

    @Autowired
    private FlightService flightService;

    @Autowired
    private SeleniumService seleniumService;

    @GetMapping(value = "/getData")
    public List<String> getAllCities() {
        //List<Flight> checkedDatabase = flightService.findByAllFlight();
        //if(checkedDatabase.size() == 0) {
        //    flightService.databaseInitializer(cities, 2000);
        //}
        List<String> allCities = Arrays.asList(cities);
        return allCities;
    }

    @PostMapping(value = "/getData")
    public List<Flight> getActualFlights(@RequestBody FlightsRequest flightsRequest){
        return flightService.getActualFlights(flightsRequest);
    }


    @PostMapping(value = "/selenium")
    public List<Flight> checkChromeBySelenium(@RequestBody FlightsRequest flightsRequest) {
        return seleniumService.getActualFlights(flightsRequest);
    }

}
