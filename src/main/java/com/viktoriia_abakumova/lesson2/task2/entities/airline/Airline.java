package com.viktoriia_abakumova.lesson2.task2.entities.airline;

import com.viktoriia_abakumova.lesson2.task2.entities.aircrafts.Aircraft;
import com.viktoriia_abakumova.lesson2.task2.comparators.AircraftCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Airline {

    private String airlineName;
    private List<Aircraft> aircraft = new ArrayList<>();

    public Airline(String airlineName) {
        this.airlineName = airlineName;
    }

    private String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void addAircraft(Aircraft aircraft) {
        this.aircraft.add(aircraft);
    }

    public void calculateTotalCargoAndPassengerCapacity() {
        int totalPassengerCapacity = 0;
        int totalCargoCapacity = 0;
        for (Aircraft aircraft : aircraft) {
            totalPassengerCapacity += aircraft.getSeatingCapacity();
            totalCargoCapacity += aircraft.getCargoCapacity();
        }

        System.out.println("Total passenger capacity " + totalPassengerCapacity);
        System.out.println("Total cargo capacity " + totalCargoCapacity);
    }

    public void sortPlanesByFlightRange() {
        Collections.sort(this.aircraft, new AircraftCompare());
    }

    public List<Aircraft> filterAircraftsByFuelConsumption(int min, int max, boolean showResult) {
        List<Aircraft> resultList = new ArrayList<>();
        for (Aircraft aircraft : this.aircraft) {
            int planeConsumption = aircraft.getFuelConsumption();
            if (planeConsumption >= min && planeConsumption <= max) {
                resultList.add(aircraft);
            }
        }

        if (showResult) {
            showAircraftList(resultList);
        }

        return resultList;
    }

    public void showAirlineAircrafts() {
        showAircraftList(this.aircraft);
    }

    private void showAircraftList(List<Aircraft> al) {
        System.out.println("======= " + this.getAirlineName() + " ======");
        for (Aircraft aircraft : al) {
            System.out.println(aircraft);
        }
    }
}
