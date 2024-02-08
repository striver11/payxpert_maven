package com.hexaware.payxpert.controller;
/**
 * The {@code IFinancialRecordService} interface provides methods for handling financial records.
 * Implementing classes should provide concrete implementations for these methods.
 */
public interface IFinancialRecordService {
    /**
     * Retrieves and prints financial records for a specific employee ID.
     *
     * @param employeeId The unique identifier of the employee.
     */
	 public void printFinancialRecordsByEmployeeId(int employeeId);
    /**
     * Retrieves and prints financial records for a specific date.
     *
     * @param recordDate The date for which financial records should be retrieved.
     */	
	public void printFinancialRecordsForDate(String recordDate);
    /**
     * Retrieves and prints details for a specific financial record based on its record ID.
     *
     * @param recordID The unique identifier of the financial record.
     */
	void printFinancialRecordById(int recordID);
	
}
