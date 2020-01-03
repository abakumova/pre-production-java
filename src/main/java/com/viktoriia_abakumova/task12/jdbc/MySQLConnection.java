package com.viktoriia_abakumova.task12.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    public static Connection sqlConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/hospital";
        String username = "root";
        String password = "password";

        Connection connection = DriverManager.getConnection(url, username, password);
        if(connection != null) {
            System.out.println("We're connected");
        }
        return connection;
    }
}