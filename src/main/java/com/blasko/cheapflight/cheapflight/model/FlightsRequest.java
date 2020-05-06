package com.blasko.cheapflight.cheapflight.model;

import java.time.LocalDate;

public class FlightsRequest {

    private String startTown;
    private String arriveTown;
    private LocalDate startTime;

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

    public LocalDate getStartTime() {
        return this.startTime;
    }

    public void setStartTime(LocalDate newStartTime) {
        this.startTime = newStartTime;
    }

}
