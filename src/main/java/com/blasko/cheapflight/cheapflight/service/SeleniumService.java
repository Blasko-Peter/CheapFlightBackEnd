package com.blasko.cheapflight.cheapflight.service;

import com.blasko.cheapflight.cheapflight.model.Flight;
import com.blasko.cheapflight.cheapflight.model.FlightsRequest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        try {
            checkedWebsiteBySelenium(flightsRequest.getStartTown(), flightsRequest.getArriveTown(), flightsRequest.getStartTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return flights;
    }

    private void checkedWebsiteBySelenium(String startTown, String arriveTown, LocalDate date) throws InterruptedException {
        //Open the website
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cheapoair.com/");
        //Print startTown
        driver.findElement(By.id("from0")).sendKeys(startTown);
        Thread.sleep(1000);
        driver.findElement(By.id("from0")).sendKeys(Keys.ENTER);
        //Print arriveTown
        driver.findElement(By.id("to0")).sendKeys(arriveTown);
        Thread.sleep(1000);
        driver.findElement(By.id("to0")).sendKeys(Keys.ENTER);
        //Choose the date
        String day = String.valueOf(date.getDayOfMonth());
        int calendarDayIndex = 0;
        String calendarDay = "";
        int index = 0;
        for( index = 1; index < 39; index++){
            String calendarDayGetText = driver.findElement(By.xpath("//div[@class='calendar__wrapper clearfix']//div[1]//div[3]//div["+index+"]")).getText();
            if(!calendarDayGetText.equals("")){
                calendarDayIndex++;
                calendarDay = calendarDayGetText.substring(0, String.valueOf(calendarDayIndex).length());
                if(calendarDay.equals(day)){
                    System.out.println("a nap: " + calendarDay);
                    break;
                }
            }
        }
        driver.findElement(By.xpath("//div[@class='calendar__single-month active']//div["+index+"]//a[1]")).sendKeys(Keys.ENTER);



        //Close the website
        //driver.close();
    }

}
