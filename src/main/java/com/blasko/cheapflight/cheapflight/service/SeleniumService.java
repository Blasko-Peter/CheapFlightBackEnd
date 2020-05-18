package com.blasko.cheapflight.cheapflight.service;

import com.blasko.cheapflight.cheapflight.model.Flight;
import com.blasko.cheapflight.cheapflight.model.FlightsRequest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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
        for(index = 1; index < 39; index++){
            String calendarDayGetText = driver.findElement(By.xpath("//div[@class='calendar__wrapper clearfix']//div[1]//div[3]//div["+index+"]")).getText();
            if(!calendarDayGetText.equals("")){
                calendarDayIndex++;
                calendarDay = calendarDayGetText.substring(0, String.valueOf(calendarDayIndex).length());
                if(calendarDay.equals(day)){
                    break;
                }
            }
        }
        driver.findElement(By.xpath("//div[@class='calendar__single-month active']//div["+index+"]//a[1]")).sendKeys(Keys.ENTER);
        //Click the search button
        driver.findElement(By.id("searchNow")).click();
        Thread.sleep(10000);
        //Find the web elements - the flights
        List<WebElement> flightsFromTheWebsite = driver.findElements(By.className("contract-block"));
        //Iterate on flights and find all data for my flight
        for(WebElement flight : flightsFromTheWebsite){
            String company = flight.findElement(By.className("airline__name")).getText();
            List<WebElement> flightTimes = flight.findElements(By.className("is--flight-time"));
            LocalTime startTime = LocalTime.parse(flightTimes.get(0).getText().substring(0, 5));
            LocalTime arriveTime = LocalTime.parse(flightTimes.get(1).getText().substring(0, 5));
            String price = flight.findElement(By.className("fare__amount--block")).getText();
            String[] pricePieces = price.split(",|\\ ");
            String realPrice = "";
            for(String pp : pricePieces){
                realPrice += pp;
            }
            double actualPrice = Double.parseDouble(realPrice.substring(1, realPrice.length()));
            Flight newFlight = new Flight();
            newFlight.setCompany(company);
            newFlight.setStartTown(startTown);
            newFlight.setArriveTown(arriveTown);
            newFlight.setDate(date);
            newFlight.setStartTime(startTime);
            newFlight.setArriveTime(arriveTime);
            newFlight.setPrice(actualPrice);
            flights.add(newFlight);
        }
        //Close the website
        driver.close();
    }

}
