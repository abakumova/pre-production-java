package com.viktoriia_abakumova.task11.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "specialization")
@XmlEnum
public enum Specialization {

    @XmlEnumValue("Neurosurgeons")
    NEUROSURGEONS("Neurosurgeons"),
    @XmlEnumValue("Pediatrician")
    PEDIATRICIAN("Pediatrician"),
    @XmlEnumValue("Surgeon")
    SURGEON("Surgeon"),
    @XmlEnumValue("Dentist")
    DENTIST("Dentist");
    private final String value;

    Specialization(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Specialization fromValue(String v) {
        for (Specialization c : Specialization.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}