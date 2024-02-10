package com.github.j143;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseOperations {
    private static final String CREATE_TABLE_QUERY = "CREATE TABLE users (id INT PRIMARY KEY, name VARCHAR(255))";
    private static final String INSERT_DATA_QUERY = "INSERT INTO users VALUES (?, ?)";
    private static final String RETRIEVE_DATA_QUERY = "SELECT * FROM users";

    public static void createTable(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_QUERY)) {
            statement.executeUpdate();
            System.out.println("Table created successfully.");
        }
    }

    public static void insertData(Connection connection, int id, String name) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_DATA_QUERY)) {
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.executeUpdate();
            System.out.println("Data inserted successfully.");
        }
    }

    public static void retrieveData(Connection connection) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(RETRIEVE_DATA_QUERY);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }
        }
    }
}
