package com.hexaware.payxpert.controller;
import com.hexaware.payxpert.exception.InvalidInputException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The {@code ValidationService} class provides methods for validating different types of input.
 * It includes validation for alphabets, phone numbers, dates, and email addresses.
 */
public class ValidationService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /**
     * Validates that the input contains only alphabets.
     *
     * @param input The input string to be validated.
     * @throws InvalidInputException If the input contains characters other than alphabets.
     */
    public static void validateAlphabets(String input) {
        if (!input.matches("[a-zA-Z]+")) {
            throw new InvalidInputException("This should contain only alphabets");
        }
    }
    /**
     * Validates the format of a phone number.
     *
     * @param phoneNumber The phone number string to be validated.
     * @throws InvalidInputException If the phone number has an invalid format.
     */
    public static void validatePhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}")) {
        	throw new InvalidInputException("Invalid phone number format. Please use xxx-xxx-xxxx.");
           
        }
    }
    /**
     * Parses a date string into a {@code Date} object.
     *
     * @param dateStr The date string to be parsed.
     * @return The parsed {@code Date} object.
     * @throws InvalidInputException If the date has an invalid format.
     */
    public static Date parseDate(String dateStr) {
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
        	throw new InvalidInputException("Invalid date format. Please use yyyy-mm-dd.");
            
        }   
       
    }
    /**
     * Validates the format of an email address.
     *
     * @param email The email address string to be validated.
     * @throws InvalidInputException If the email address has an invalid format.
     */
	public static void validateEmail(String email) {
		// TODO Auto-generated method stub
		 String emailRegex = "^[a-zA-Z][a-zA-Z0-9]*@[a-zA-Z0-9]+\\.[a-zA-Z]{2,}$";
         if (!email.matches(emailRegex)) {
             throw new InvalidInputException("Invalid email address format");
         }
	}
}
