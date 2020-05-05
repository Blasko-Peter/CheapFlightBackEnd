package com.blasko.cheapflight.cheapflight.controller;

import com.blasko.cheapflight.cheapflight.model.Flight;
import com.blasko.cheapflight.cheapflight.model.FlightsRequest;
import com.blasko.cheapflight.cheapflight.service.FlightService;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class DataController {

    String cities[] = new String[] {"Budapest", "Paris", "Madrid", "London", "Berlin"};

    @Autowired
    private FlightService flightService;

    @GetMapping(value = "/getData")
    public List<String> getAllCities() {
        List<Flight> checkedDatabase = flightService.findByAllFlight();
        if(checkedDatabase.size() == 0) {
            flightService.databaseInitializer(cities, 2000);
        }
        List<String> allCities = Arrays.asList(cities);
        return allCities;
    }

    @PostMapping(value = "/getData")
    public String getActualFlights(@RequestBody FlightsRequest flightsRequest){
        System.out.println(flightsRequest.getStartTown());
        System.out.println(flightsRequest.getArriveTown());
        return "success";
    }

    @GetMapping(value = "/")
    public String checkFirefoxBySelenium(){
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        WebDriver x = new FirefoxDriver();
        x.get("https://group.accor.com/en");
        return "good";
    }

}
