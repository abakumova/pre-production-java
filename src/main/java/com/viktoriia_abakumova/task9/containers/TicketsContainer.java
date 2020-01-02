package com.viktoriia_abakumova.task9.containers;

import com.viktoriia_abakumova.task9.entity.Ticket;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Data
@XmlRootElement(name = "tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketsContainer {

    @XmlElement(name = "ticket")
    private List<Ticket> ticketList;

    public List<Ticket> getStandardTickets() {
        return ticketList.stream()
                .filter(ticket -> ticket.getCategory().equals("STANDART"))
                .collect(Collectors.toList());
    }
}