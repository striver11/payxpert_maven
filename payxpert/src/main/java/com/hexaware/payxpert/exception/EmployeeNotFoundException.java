package com.hexaware.payxpert.exception;
/**
 * The {@code EmployeeNotFoundException} class is a runtime exception that
 * indicates that an employee with the specified criteria is not found.
 * This exception is thrown when an operation expects to find an employee but
 * fails to do so.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public class EmployeeNotFoundException extends RuntimeException {
    /**
     * A version number for this class, to manage object serialization.
     */
	private static final long serialVersionUID = 1L;

    /**
     * Constructs a new EmployeeNotFoundException with the specified detail message.
     * 
     * @param message The detail message that describes the reason for the exception.
     */
	public EmployeeNotFoundException(String message) {
        super(message);
    }

	
}