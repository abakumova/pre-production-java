package com.viktoriia_abakumova.task12.xml;

import com.viktoriia_abakumova.task12.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Getter
@Setter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "booking", propOrder = {
        "doctorName",
        "timeSlot",
        "bookingStatus"
})
public class Booking {

    @XmlElement(required = true)
    protected String doctorName;
    @XmlElement(required = true)
    protected BigInteger timeSlot;
    @XmlElement(required = true)
    protected Status bookingStatus;
}