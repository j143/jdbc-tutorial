package com.github.j143;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseOperationsTest {
    private static final String DB_URL = "jdbc:derby:mydatabase;create=true";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            DatabaseOperations.createTable(connection);
            DatabaseOperations.insertData(connection, 1, "John Doe");
            DatabaseOperations.retrieveData(connection);
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    
}
