package com.viktoriia_abakumova.task12.web;

import com.viktoriia_abakumova.task12.xml.Booking;
import com.viktoriia_abakumova.task12.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
public class BookingREST {

    @Autowired
    private BookingService bookingService;

    public BookingREST(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @RequestMapping(value = "/bookings", method = RequestMethod.GET)
    public List<Booking> get() {
        return bookingService.get();
    }

    @RequestMapping(value = "/{doctorName}/{timeSlot}", method = RequestMethod.PUT)
    public Booking create(@PathVariable String doctorName, @PathVariable BigInteger timeSlot) {
        return bookingService.create(doctorName, timeSlot);
    }

    @RequestMapping(value = "/{doctorName}/{timeSlotFrom}/{timeSlotTo}", method = RequestMethod.GET)
    public String searchFreeTimeSlot(@PathVariable String doctorName, @PathVariable String timeSlotFrom, @PathVariable String timeSlotTo) {
        return bookingService.searchFreeTimeSlot(doctorName, new BigInteger(timeSlotFrom), new BigInteger(timeSlotTo));
    }

    @RequestMapping(value = "/{doctorName}/{timeSlot}", method = RequestMethod.DELETE)
    public boolean deleteBooking(@PathVariable String doctorName, @PathVariable String timeSlot) {
        return bookingService.deleteBooking(doctorName, new BigInteger(timeSlot));
    }
}