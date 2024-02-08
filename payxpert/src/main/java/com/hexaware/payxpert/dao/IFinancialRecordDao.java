package com.hexaware.payxpert.dao;

import java.util.List;

import com.hexaware.payxpert.model.FinancialRecord;
/**
 * The {@code IFinancialRecordDao} interface defines methods for
 * FinancialRecord-related database operations such as retrieving financial
 * records by ID, employee ID, and date. Implementing classes must provide
 * concrete implementations for these methods.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public interface IFinancialRecordDao {
    /**
     * Retrieves a financial record by its ID from the database.
     * 
     * @param recordID The ID of the financial record to retrieve.
     * @return The FinancialRecord object if found, otherwise null.
     */
	public FinancialRecord getFinancialRecordById(int recordID);
    /**
     * Retrieves all financial records associated with a specific employee from the
     * database.
     * 
     * @param employeeId The ID of the employee for whom financial records should be
     *                   retrieved.
     * @return A list of FinancialRecord objects.
     */	
	List<FinancialRecord> getFinancialRecordByEmployeeId(int employeeId);
    /**
     * Retrieves all financial records for a specific date from the database.
     * 
     * @param recordDate The date for which financial records should be retrieved.
     * @return A list of FinancialRecord objects.
     */
	 List<FinancialRecord> getFinancialRecordsForDate(String recordDate);
}
