package com.blasko.cheapflight.cheapflight.controller;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class DataController {

    String cities[] = new String[] {"Budapest", "Paris", "Madrid", "London", "Berlin"};

    @GetMapping(value = "/getData")
    public List<String> getAllCities() {
        List<String> allCities = Arrays.asList(cities);
        return allCities;
    }

    @GetMapping(value = "/")
    public String checkFirefoxBySelenium(){
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        WebDriver x = new FirefoxDriver();
        x.get("https://group.accor.com/en");
        return "good";
    }

}
