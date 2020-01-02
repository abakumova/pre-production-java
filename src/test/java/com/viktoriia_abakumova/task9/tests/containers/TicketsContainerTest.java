package com.viktoriia_abakumova.task9.tests.containers;

import com.viktoriia_abakumova.task9.containers.TicketsContainer;
import com.viktoriia_abakumova.task9.entity.Ticket;
import com.viktoriia_abakumova.task9.parsers.TicketParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TicketsContainerTest {

    @Test
    public void getStandardTicketsTest() {
        TicketParser ticketParser = new TicketParser();
        TicketsContainer ticketsContainer;
        ticketsContainer = ticketParser.parseXMLFile("src/main/resources/example.xml");
        List<Ticket> actualStandartTickets = ticketsContainer.getStandardTickets();

        List<Ticket> expectedStandartTickets = new ArrayList<>();

        expectedStandartTickets.add(new Ticket(12, "Ten Thing I Hate About You", "STANDART", "2010-12-01T16:45:00+02:00", 40));
        expectedStandartTickets.add(new Ticket(13, "Ten Thing I Hate About You", "STANDART", "2010-12-01T16:45:00+02:00", 56));
        expectedStandartTickets.add(new Ticket(14, "Harry Potter and the Sorcerer's Stone", "STANDART", "2009-03-15T17:20:00+02:00", 25));
        expectedStandartTickets.add(new Ticket(15, "Harry Potter and the Sorcerer's Stone", "STANDART", "2009-03-15T17:20:00+02:00", 56));
        expectedStandartTickets.add(new Ticket(16, "Harry Potter and the Sorcerer's Stone", "STANDART", "2009-03-15T12:20:00+02:00", 56));
        expectedStandartTickets.add(new Ticket(9, "Pirates of the Carribbean", "STANDART", "2011-05-12T15:45:00+03:00", 69));
        TicketsContainer expectedTicketsContainer = new TicketsContainer();
        expectedTicketsContainer.setTicketList(expectedStandartTickets);

        Assert.assertEquals("getStandardTicketsTest", actualStandartTickets, expectedStandartTickets);
    }
}
