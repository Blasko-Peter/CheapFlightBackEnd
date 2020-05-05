package com.blasko.cheapflight.cheapflight.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String company;
    private String startTown;
    private String arriveTown;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime arriveTime;
    private double price;

    public int getId() {
        return this.id;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String newCompany) {
        this.company = newCompany;
    }

    public String getStartTown() {
        return this.startTown;
    }

    public void setStartTown(String newStartTown) {
        this.startTown = newStartTown;
    }

    public String getArriveTown() {
        return this.arriveTown;
    }

    public void setArriveTown(String newArriveTown) {
        this.arriveTown = newArriveTown;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate newDate) {
        this.date = newDate;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalTime newStartTime) {
        this.startTime = newStartTime;
    }

    public LocalTime getArriveTime() {
        return this.arriveTime;
    }

    public void setArriveTime(LocalTime newArriveTime) {
        this.arriveTime = newArriveTime;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

}
