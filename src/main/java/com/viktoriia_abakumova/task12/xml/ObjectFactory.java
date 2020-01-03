package com.viktoriia_abakumova.task12.xml;

import com.epam.viktoriia_abakumova.java.lesson12.task12.xml.*;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public DeleteBookingResponse createDeleteBookingResponse() {
        return new DeleteBookingResponse();
    }

    public SearchFreeTimeSlotRequest createSearchFreeTimeSlotRequest() {
        return new SearchFreeTimeSlotRequest();
    }

    public AddBookingResponse createAddBookingResponse() {
        return new AddBookingResponse();
    }

    public Booking createBooking() {
        return new Booking();
    }

    public SearchFreeTimeSlotResponse createSearchFreeTimeSlotResponse() {
        return new SearchFreeTimeSlotResponse();
    }

    public AddBookingRequest createAddBookingRequest() {
        return new AddBookingRequest();
    }

    public DeleteBookingRequest createDeleteBookingRequest() {
        return new DeleteBookingRequest();
    }

    public Doctor createDoctor() {
        return new Doctor();
    }
}