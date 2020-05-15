package com.blasko.cheapflight.cheapflight.service;

import com.blasko.cheapflight.cheapflight.model.Flight;
import com.blasko.cheapflight.cheapflight.model.FlightsRequest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeleniumService {

    List<Flight> flights;

    public List<Flight> getActualFlights(FlightsRequest flightsRequest) {
        flights = new ArrayList<>();
        checkedWebsiteBySelenium(flightsRequest.getStartTown(), flightsRequest.getArriveTown(), flightsRequest.getStartTime());
        return flights;
    }

    private void checkedWebsiteBySelenium(String startTown, String arriveTown, LocalDate date){
        //Open the website
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cheapoair.com/");
        //Close the website
        driver.close();
    }

}
