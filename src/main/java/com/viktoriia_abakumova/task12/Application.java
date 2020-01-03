package com.viktoriia_abakumova.task12;

import com.viktoriia_abakumova.task12.dao.SQLOperations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigInteger;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        SQLOperations sqlOperations = new SQLOperations();
        sqlOperations.deleteBooking("Kelli", BigInteger.valueOf(14));
    }
}