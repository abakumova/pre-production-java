package com.viktoriia_abakumova.task9.tests.parsers;

import com.viktoriia_abakumova.task9.containers.TicketsContainer;
import com.viktoriia_abakumova.task9.entity.Ticket;
import com.viktoriia_abakumova.task9.parsers.TicketParser;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketParserTest {

    @Test
    public void writeIntoJsonFileTest() throws IOException {
        List<Ticket> expectedStandartTickets = new ArrayList<>();
        expectedStandartTickets.add(new Ticket(12, "Ten Thing I Hate About You", "STANDART", "Dec 1, 2010, 4:45:00 PM", 40));
        expectedStandartTickets.add(new Ticket(13, "Ten Thing I Hate About You", "STANDART", "Dec 1, 2010, 4:45:00 PM", 56));
        expectedStandartTickets.add(new Ticket(14, "Harry Potter and the Sorcerer's Stone", "STANDART", "Mar 15, 2009, 5:20:00 PM", 25));
        expectedStandartTickets.add(new Ticket(15, "Harry Potter and the Sorcerer's Stone", "STANDART", "Mar 15, 2009, 5:20:00 PM", 56));
        expectedStandartTickets.add(new Ticket(16, "Harry Potter and the Sorcerer's Stone", "STANDART", "Mar 15, 2009, 12:20:00 PM", 56));
        expectedStandartTickets.add(new Ticket(9, "Pirates of the Carribbean", "STANDART", "May 12, 2011, 3:45:00 PM", 69));
        TicketsContainer expectedTicketsContainer = new TicketsContainer();
        expectedTicketsContainer.setTicketList(expectedStandartTickets);

        TicketParser ticketParser = new TicketParser();
        ticketParser.writeIntoJsonFile(expectedStandartTickets, "ticketsTest.txt");

        File fileExpected = new File("ticketsTest.txt");
        File fileActual = new File("tickets.txt");

        Assert.assertEquals(FileUtils.readLines(fileExpected), FileUtils.readLines(fileActual));
    }

    @Test
    public void parseJsonFileTest() throws IOException {
        TicketParser ticketParser = new TicketParser();
        File fileExpected = new File("ticketsTest1.txt");
        File fileActual = new File("tickets.txt");
        List<Ticket> jsonTickets = ticketParser.parseJsonFile("tickets.txt");
        ticketParser.writeIntoJsonFile(jsonTickets, "ticketsTest1.txt");

        Assert.assertEquals(FileUtils.readLines(fileExpected), FileUtils.readLines(fileActual));
    }
}
