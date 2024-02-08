package com.hexaware.payxpert.exception;
/**
 * The {@code DatabaseConnectionException} class is a custom exception that
 * indicates an issue with establishing or maintaining a database connection.
 * This exception can be thrown when there are problems related to database
 * connectivity.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public class DatabaseConnectionException extends Exception {

    /**
     * Constructs a new DatabaseConnectionException with the specified detail
     * message.
     * 
     * @param message The detail message that describes the reason for the exception.
     */
    public DatabaseConnectionException(String message) {
        super(message);
    }
}