package com.blasko.cheapflight.cheapflight.repository;

import com.blasko.cheapflight.cheapflight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findAll();

}
