package com.viktoriia_abakumova.lesson2.task2;

import com.viktoriia_abakumova.lesson2.task2.entities.aircrafts.inheritors.AirbusA320;
import com.viktoriia_abakumova.lesson2.task2.entities.aircrafts.inheritors.Boeing737;
import com.viktoriia_abakumova.lesson2.task2.entities.aircrafts.inheritors.Cessna182;
import com.viktoriia_abakumova.lesson2.task2.entities.aircrafts.inheritors.DouglasMD80;
import com.viktoriia_abakumova.lesson2.task2.entities.aircrafts.Aircraft;
import com.viktoriia_abakumova.lesson2.task2.entities.airline.Airline;

public class Demo {

    public static void main(String[] args) {
            Aircraft aircraftAirbusA320a = new AirbusA320();
            Aircraft aircraftAirbusA320b = new AirbusA320();
            Aircraft aircraftDouglas = new DouglasMD80();
            Aircraft aircraftCessna = new Cessna182();
            Aircraft aircraftBoeing = new Boeing737();

            Airline ukraineInternationalAirline = new Airline("Ukraine International Airlines");
            ukraineInternationalAirline.addAircraft(aircraftAirbusA320a);
            ukraineInternationalAirline.addAircraft(aircraftAirbusA320b);
            ukraineInternationalAirline.addAircraft(aircraftDouglas);
            ukraineInternationalAirline.addAircraft(aircraftCessna);
            ukraineInternationalAirline.addAircraft(aircraftBoeing);

            ukraineInternationalAirline.showAirlineAircrafts();

            System.out.println();
            System.out.println("Aircrafts sorted by flight range:");
            ukraineInternationalAirline.sortPlanesByFlightRange();
            ukraineInternationalAirline.showAirlineAircrafts();
            System.out.println();

            ukraineInternationalAirline.filterAircraftsByFuelConsumption(2000, 3000, true);
            System.out.println();

            ukraineInternationalAirline.calculateTotalCargoAndPassengerCapacity();
    }
}
