package com.viktoriia_abakumova.task12.dao;

import com.viktoriia_abakumova.task12.xml.Booking;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookingDAO {

    private List<Booking> bookings = new ArrayList<>();

    public Booking addBookingRequest(String doctorName, BigInteger timeSlot) {
        return SQLOperations.addBooking(doctorName, timeSlot);
    }

    public List<Booking> get() {
        return SQLOperations.getBooking();
    }

    public boolean deleteBooking(String doctorName, BigInteger timeSlot) {
        return SQLOperations.deleteBooking(doctorName, timeSlot);
    }

    public String searchFreeTimeSlot(String doctorName, BigInteger timeSlotFrom, BigInteger timeSlotTo) {
        String freeTimeSlot = "Doctor name: " + doctorName + ", Free time slot : ";

        ArrayList<Integer> timeSlots = new ArrayList<>();
        for (int i = timeSlotFrom.intValue(); i <= timeSlotTo.intValue(); i++) {
            timeSlots.add(i);
        }

        for (Booking booking : bookings) {
            if (booking.getDoctorName().equals(doctorName)) {
                timeSlots.removeIf(x -> x == booking.getTimeSlot().intValue());
            }
        }
        return freeTimeSlot + timeSlots.toString();
    }
}