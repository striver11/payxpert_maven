/**
 * The ITaxService interface defines the contract for services related to tax management.
 * It declares methods for retrieving and printing tax details based on various criteria.
 * Implementing classes should provide concrete implementations for these methods.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
package com.hexaware.payxpert.controller;

import com.hexaware.payxpert.exception.DatabaseConnectionException;

public interface ITaxService {
    /**
     * Prints the details of a tax based on the provided tax ID.
     *
     * @param taxId The ID of the tax to print.
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */
	  public void printTaxesById(int taxId) throws DatabaseConnectionException;
	    /**
	     * Prints the details of taxes associated with a specific employee.
	     *
	     * @param customerId The ID of the employee for whom taxes should be printed.
	     */
	  public void printTaxesByEmployeeId(int customerId);
	    /**
	     * Prints the details of taxes for a specific tax year.
	     *
	     * @param taxYear The tax year for which taxes should be printed.
	     */
	  public void printTaxesByTaxYear(int taxYear);
}
