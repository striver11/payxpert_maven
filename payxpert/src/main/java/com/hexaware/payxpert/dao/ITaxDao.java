package com.hexaware.payxpert.dao;

import java.util.List;

import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.model.Tax;
/**
 * The {@code ITaxDao} interface defines methods for Tax-related database
 * operations such as retrieving tax details by ID, employee ID, and tax year.
 * Implementing classes must provide concrete implementations for these methods.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public interface ITaxDao {
    /**
     * Retrieves a tax record by its ID from the database.
     * 
     * @param taxId The ID of the tax to retrieve.
     * @return The Tax object if found, otherwise null.
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */
	Tax getTaxById(int taxId) throws DatabaseConnectionException;
    /**
     * Retrieves all taxes associated with a specific employee from the database.
     * 
     * @param employeeId The ID of the employee for whom taxes should be retrieved.
     * @return A list of Tax objects.
     */
	List<Tax> getTaxesByEmployeeId(int employeeId);
    /**
     * Retrieves all taxes for a specific tax year from the database.
     * 
     * @param taxYear The tax year for which taxes should be retrieved.
     * @return A list of Tax objects.
     */
	List<Tax> getTaxesByTaxYear(int taxYear);
}
