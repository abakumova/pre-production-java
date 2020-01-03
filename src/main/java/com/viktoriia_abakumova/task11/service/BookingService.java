package com.viktoriia_abakumova.task11.service;

import com.viktoriia_abakumova.task11.xml.Booking;
import com.viktoriia_abakumova.task11.dao.BookingDAO;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Component
public class BookingService {

    private BookingDAO bookingDAO = new BookingDAO();

    public Booking addBooking(String doctorName, BigInteger timeSlot) {
        if (doctorName == null || timeSlot == null) {
            throw new IllegalArgumentException("Booking is null");
        }
        checkTimeSlot(timeSlot);
        if (isBookingExist(doctorName, timeSlot)) {
            throw new IllegalArgumentException("Such booking already exist");
        }
        return bookingDAO.addBookingRequest(doctorName, timeSlot);
    }

    public List<Booking> getBookingDAO() {
        return bookingDAO.getBookings();
    }

    public Booking create(String doctorName, BigInteger timeSlot) {
        return bookingDAO.addBookingRequest(doctorName, timeSlot);
    }

    public boolean deleteBooking(String doctorName, BigInteger timeSlot) {
        if (doctorName == null || timeSlot == null) {
            throw new IllegalArgumentException("DoctorName or timeSlot is null.");
        }
        checkTimeSlot(timeSlot);
        return bookingDAO.deleteBooking(doctorName, timeSlot);
    }

    public String searchFreeTimeSlot(String doctorName, BigInteger timeSlotFrom, BigInteger timeSlotTo) {
        if (doctorName == null || timeSlotFrom == null || timeSlotTo == null) {
            throw new IllegalArgumentException("DoctorName or timeSlotFrom or timeSlotTo is null.");
        }
        checkTimeSlot(timeSlotFrom);
        checkTimeSlot(timeSlotTo);
        return bookingDAO.searchFreeTimeSlot(doctorName, timeSlotFrom, timeSlotTo);
    }

    public boolean isBookingExist(String doctorName, BigInteger timeSlot) {
        Optional<Booking> tvShowOptional = bookingDAO.getBookings().stream().filter(x -> x.getDoctorName().equals(doctorName) && x.getTimeSlot().equals(timeSlot)).findAny();
        return tvShowOptional.isPresent();
    }

    private void checkTimeSlot(BigInteger timeSlot) {
        if (timeSlot.intValue() < 0 || timeSlot.intValue() > 24) {
            throw new IllegalArgumentException("Time slot should be from 0 to 24");
        }
    }
}