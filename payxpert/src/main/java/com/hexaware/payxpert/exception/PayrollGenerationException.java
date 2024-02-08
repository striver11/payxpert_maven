package com.hexaware.payxpert.exception;
/**
 * The {@code PayrollGenerationException} class is a runtime exception that
 * indicates an exceptional situation related to payroll generation.
 * This exception is thrown when there is an issue or error during the
 * generation of payroll records for employees.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public class PayrollGenerationException extends RuntimeException {

    /**
     * A version number for this class, to manage object serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new PayrollGenerationException with the specified detail message.
     * 
     * @param message The detail message that describes the reason for the exception.
     */
    public PayrollGenerationException(String message) {
        super(message);
    }
}
