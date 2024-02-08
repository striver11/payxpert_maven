package com.hexaware.payxpert.exception;
/**
 * The {@code TaxCalculationException} class is a runtime exception that
 * indicates an exceptional situation related to tax calculation.
 * This exception is thrown when there is an issue or error during the
 * calculation of taxes for employees.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public class TaxCalculationException extends RuntimeException {

    /**
     * A version number for this class, to manage object serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new TaxCalculationException with the specified detail message.
     * 
     * @param message The detail message that describes the reason for the exception.
     */
    public TaxCalculationException(String message) {
        super(message);
    }
}