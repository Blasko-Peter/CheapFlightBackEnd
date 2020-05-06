package com.blasko.cheapflight.cheapflight.service;

import com.blasko.cheapflight.cheapflight.model.Flight;
import com.blasko.cheapflight.cheapflight.model.FlightsRequest;
import com.blasko.cheapflight.cheapflight.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class FlightService {

    private Random random = new Random();
    private static DecimalFormat df = new DecimalFormat("0.00");
    private String companies[] = new String[] {"WizzAir", "EasyJet", "RyanAir", "Air France", "Lufthansa"};

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findByAllFlight(){
        return flightRepository.findAll();
    }

    public void databaseInitializer(String cities[], int numberOfFlights){
        for(int i = 0; i < numberOfFlights; i++){
            Flight newFlight = new Flight();
            newFlight.setCompany(companies[random.nextInt(companies.length)]);
            newFlight.setStartTown(cities[random.nextInt(cities.length)]);
            newFlight.setArriveTown(cities[random.nextInt(cities.length)]);
            newFlight.setDate(dateRandomizer());
            newFlight.setStartTime(LocalTime.MIN.plusSeconds(random.nextLong()));
            newFlight.setArriveTime(newFlight.getStartTime().plusHours(3));
            newFlight.setPrice(doubleRandomizer());
            while(newFlight.getStartTown().equals(newFlight.getArriveTown())){
                newFlight.setArriveTown(cities[random.nextInt(cities.length)]);
            }
            flightRepository.save(newFlight);
        }
    }

    private LocalDate dateRandomizer(){
        long minDay = LocalDate.now().toEpochDay();
        long maxDay = LocalDate.of(2020, 6, 30).toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(minDay, maxDay);
        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);
        return randomDate;
    }

    private double doubleRandomizer(){
        double min = 50;
        double max = 200;
        double randomDouble = min + ((max - min) * random.nextDouble());
        double roundedDouble = Math.round(randomDouble * 100.0) / 100.0;
        return roundedDouble;
    }

    public List<Flight> getActualFlights(FlightsRequest flightsRequest){
        return flightRepository.findFlightByStartTownAndArriveTownAndStartTime(flightsRequest.getStartTown(), flightsRequest.getArriveTown(), flightsRequest.getStartTime());
    }

}
