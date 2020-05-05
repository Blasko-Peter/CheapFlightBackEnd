package com.blasko.cheapflight.cheapflight.model;

public class FlightsRequest {

    private String startTown;
    private String arriveTown;

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

}
