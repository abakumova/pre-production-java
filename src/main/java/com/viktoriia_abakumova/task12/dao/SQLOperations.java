package com.viktoriia_abakumova.task12.dao;

import com.viktoriia_abakumova.task12.xml.Booking;
import com.viktoriia_abakumova.task12.enums.Status;
import com.viktoriia_abakumova.task12.jdbc.MySQLConnection;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLOperations {

    private static final String SHOW_ALL_BOOKINGS = "Select * From doctor";
    private static final String ADD_BOOKINGS = "INSERT into doctor (name_doctor, time_slot, status) values (?, ?, ?)";
    private static final String DELETE_BOOKINGS = "DELETE FROM doctor where doctor.name_doctor = ? and doctor.time_slot = ?";

    public static List<Booking> getBooking() {
        List<Booking> bookingList = null;

        try (Connection connection = MySQLConnection.sqlConnection();
             PreparedStatement statement = connection.prepareStatement(SHOW_ALL_BOOKINGS);
             ResultSet resultSet = statement.executeQuery()) {

            bookingList = new ArrayList<>();
            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setDoctorName(resultSet.getString(2));
                booking.setTimeSlot(new BigInteger(String.valueOf(resultSet.getInt(3))));
                booking.setBookingStatus(Status.fromValue(resultSet.getString(4)));
                bookingList.add(booking);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookingList;
    }

    public static Booking addBooking(String doctorName, BigInteger timeSlot) {
        try {
            Connection connection = MySQLConnection.sqlConnection();
            PreparedStatement statement = connection.prepareStatement(ADD_BOOKINGS);

            statement.setString(1, doctorName);
            statement.setInt(2, Integer.parseInt(String.valueOf(timeSlot)));
            statement.setString(3, "ACTIVE");

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("The new good was inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Boolean deleteBooking(String doctorName, BigInteger timeSlot) {
        int result = 0;

        try {
            Connection connection = MySQLConnection.sqlConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_BOOKINGS);

            statement.setString(1, doctorName);
            statement.setInt(2, Integer.parseInt(String.valueOf(timeSlot)));

            result = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result > 0;
    }
}