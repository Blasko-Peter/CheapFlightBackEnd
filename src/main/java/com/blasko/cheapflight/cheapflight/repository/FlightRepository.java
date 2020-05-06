package com.blasko.cheapflight.cheapflight.repository;

import com.blasko.cheapflight.cheapflight.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findAll();

    @Query(value = "SELECT * FROM Flights WHERE START_TOWN = :startTown and ARRIVE_TOWN = :arriveTown and DATE = :date ORDER BY price", nativeQuery = true)
    List<Flight> findFlightByStartTownAndArriveTownAndStartTime(@Param("startTown") String startTown, @Param("arriveTown") String arriveTown, @Param("date") LocalDate startTime);

}
