package com.blasko.cheapflight.cheapflight.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class DataController {

    String cities[] = new String[] {"Budapest", "Paris", "Madrid", "London", "Berlin"};

    @GetMapping(value = "/getAllCities")
    public List<String> getAllCities() {
        List<String> allCities = Arrays.asList(cities);
        return allCities;
    }

}
