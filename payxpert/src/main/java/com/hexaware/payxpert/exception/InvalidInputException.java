package com.hexaware.payxpert.exception;
/**
 * The {@code InvalidInputException} class is a runtime exception that
 * indicates an exceptional situation related to invalid input.
 * This exception is thrown when there is an issue or error due to invalid
 * input provided to a method or operation.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public class InvalidInputException extends RuntimeException {

    /**
     * A version number for this class, to manage object serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new InvalidInputException with the specified detail message.
     * 
     * @param message The detail message that describes the reason for the exception.
     */
	public InvalidInputException(String message) {
		super(message);
	}
}
