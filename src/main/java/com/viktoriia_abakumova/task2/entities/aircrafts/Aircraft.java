package com.viktoriia_abakumova.task2.entities.aircrafts;

public abstract class Aircraft {

    private final String aircraftManufacturer;
    private final String aircraftModel;
    private final int flightRange;
    private final int fuelConsumption;

    Aircraft(int flightRange, int fuelConsumption, String aircraftManufacturer, String aircraftModel) {
        this.flightRange = flightRange;
        this.fuelConsumption = fuelConsumption;
        this.aircraftManufacturer = aircraftManufacturer;
        this.aircraftModel = aircraftModel;
    }

    public abstract int getSeatingCapacity();

    public abstract int getCargoCapacity();

    public int getFlightRange() {
        return flightRange;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    protected String getAircraftManufacturer() {
        return aircraftManufacturer;
    }

    protected String getAircraftModel() {
        return aircraftModel;
    }

    @Override
    public String toString() {
        return "Aircraft [aircraftManufacturer=" + aircraftManufacturer
                + ", aircraftModel=" + aircraftModel + ", seatingCapacity="
                + getSeatingCapacity() + ", cargoCapacity=" + getCargoCapacity()
                + ", flightRange=" + flightRange + ", fuelConsumption="
                + fuelConsumption + "]";
    }
}
