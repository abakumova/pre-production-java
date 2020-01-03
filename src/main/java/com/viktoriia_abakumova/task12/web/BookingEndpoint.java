package com.viktoriia_abakumova.task12.web;

import com.viktoriia_abakumova.task12.service.BookingService;
import com.epam.viktoriia_abakumova.java.lesson12.task12.xml.*;
import com.viktoriia_abakumova.task12.xml.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BookingEndpoint {
    private static final String NAMESPACE_URI = "http://preprod/qa/soap";

    private BookingService bookingService;

    @Autowired
    public BookingEndpoint(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addBookingRequest")
    @ResponsePayload
    public AddBookingResponse addBookingRequest(@RequestPayload AddBookingRequest request) {
        AddBookingResponse response = new AddBookingResponse();
        response.setBooking(bookingService.addBooking(request.getDoctorName(), request.getTimeSlot()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteBookingRequest")
    @ResponsePayload
    public DeleteBookingResponse deleteBooking(@RequestPayload DeleteBookingRequest request) {
        DeleteBookingResponse response = new DeleteBookingResponse();
        response.setDeleteBooking(bookingService.deleteBooking(request.getDoctorName(), request.getTimeSlot()));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "searchFreeTimeSlotRequest")
    @ResponsePayload
    public SearchFreeTimeSlotResponse searchBooking(@RequestPayload SearchFreeTimeSlotRequest request) {
        SearchFreeTimeSlotResponse response = new SearchFreeTimeSlotResponse();
        response.setTimeSlot(bookingService.searchFreeTimeSlot(request.getDoctorName(), request.getTimeSlotFrom(), request.getTimeSlotTo()));
        return response;
    }
}