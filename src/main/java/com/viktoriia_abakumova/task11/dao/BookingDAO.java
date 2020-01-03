package com.viktoriia_abakumova.task11.dao;

import com.viktoriia_abakumova.task11.xml.Booking;
import com.viktoriia_abakumova.task11.enums.Status;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookingDAO {

    private List<Booking> bookings = new ArrayList<>();

    public Booking addBookingRequest(String doctorName, BigInteger timeSlot) {
        Booking booking1 = new Booking();
        booking1.setDoctorName(doctorName);
        booking1.setTimeSlot(timeSlot);
        booking1.setBookingStatus(Status.ACTIVE);
        bookings.add(booking1);
        return booking1;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Booking addBooking(Booking booking, String doctorName, BigInteger timeSlot) {
        booking.setBookingStatus(Status.ACTIVE);
        booking.setTimeSlot(timeSlot);
        booking.setDoctorName(doctorName);
        bookings.add(booking);
        return booking;
    }

    public boolean deleteBooking(String doctorName, BigInteger timeSlot) {
        return bookings.removeIf(x -> x.getDoctorName().equals(doctorName) && x.getTimeSlot().equals(timeSlot));
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