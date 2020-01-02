package com.viktoriia_abakumova.task2.entities.aircrafts;

public abstract class LightPassengerAircraft extends Aircraft {

    private final Integer seatingCapacity;

    public LightPassengerAircraft(int seatingCapacity, int flightRange,
                                  int fuelConsumption, String aircraftManufacturer,
                                  String aircraftModel) {
        super(flightRange, fuelConsumption, aircraftManufacturer, aircraftModel);
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    @Override
    public int getCargoCapacity() {
        return 0;
    }

}
