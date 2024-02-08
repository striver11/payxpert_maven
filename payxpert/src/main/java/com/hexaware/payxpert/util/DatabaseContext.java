package com.hexaware.payxpert.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.hexaware.payxpert.exception.DatabaseConnectionException;

/**
 * The DatabaseContext class provides methods for establishing a connection to the database.
 * It uses JDBC to connect to a MySQL database and handles potential database connection exceptions.
 */
public class DatabaseContext {

    static Connection con;
    /**
     * Retrieves a connection to the database.
     *
     * @return A Connection object representing the connection to the database.
     * @throws DatabaseConnectionException If an error occurs while connecting to the database.
     */
    public static Connection getDBConn() throws DatabaseConnectionException {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PAYXPERT2", "root", "root");
        } catch (SQLException e) {
            throw new DatabaseConnectionException("Error connecting to the database: " + e.getMessage());
        }
        return con;
    }

    /**
     * The main method to test the database connection.
     *
     * @param args Command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        try {
            System.out.println(getDBConn());
        } catch (DatabaseConnectionException e) {
            System.err.println("Database Connection Error: " + e.getMessage());
        }
    }
}

