package com.blasko.cheapflight.cheapflight.repository;

import com.blasko.cheapflight.cheapflight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    

}
