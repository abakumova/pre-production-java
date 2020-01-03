package com.viktoriia_abakumova.task11.xml;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigInteger;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "doctorName",
        "timeSlotFrom",
        "timeSlotTo"
})
@XmlRootElement(name = "searchFreeTimeSlotRequest")
public class SearchFreeTimeSlotRequest {

    @XmlElement(required = true)
    protected String doctorName;
    @XmlElement(required = true)
    protected BigInteger timeSlotFrom;
    @XmlElement(required = true)
    protected BigInteger timeSlotTo;
}