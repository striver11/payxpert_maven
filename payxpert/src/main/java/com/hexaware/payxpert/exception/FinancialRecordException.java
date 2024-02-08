package com.hexaware.payxpert.exception;
/**
 * The {@code FinancialRecordException} class is a runtime exception that
 * indicates an exceptional situation related to financial records.
 * This exception is thrown when there is an issue or error while working with
 * financial records, such as retrieval, creation, or validation.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public class FinancialRecordException extends RuntimeException {

    /**
     * A version number for this class, to manage object serialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new FinancialRecordException with the specified detail message.
     * 
     * @param message The detail message that describes the reason for the exception.
     */
    public FinancialRecordException(String message) {
        super(message);
    }
}