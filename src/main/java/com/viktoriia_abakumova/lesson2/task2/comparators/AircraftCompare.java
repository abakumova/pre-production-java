package com.viktoriia_abakumova.lesson2.task2.comparators;

import com.viktoriia_abakumova.lesson2.task2.entities.aircrafts.Aircraft;

import java.util.Comparator;

public class AircraftCompare implements Comparator<Aircraft> {

    public int compare(Aircraft a1, Aircraft a2) {
        return Integer.compare(a1.getFlightRange(), a2.getFlightRange());
    }
}
