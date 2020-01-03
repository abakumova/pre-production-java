package com.viktoriia_abakumova.task11.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "deleteBooking"
})
@XmlRootElement(name = "deleteBookingResponse")
public class DeleteBookingResponse {

    protected boolean deleteBooking;
}
