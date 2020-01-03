package com.viktoriia_abakumova.task11.xml;

import com.viktoriia_abakumova.task11.enums.Specialization;
import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@Setter
@Getter
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "doctor", propOrder = {
        "name",
        "specialization"
})
public class Doctor {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected Specialization specialization;
}
