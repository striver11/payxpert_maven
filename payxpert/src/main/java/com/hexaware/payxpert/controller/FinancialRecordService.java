
/**
 * The FinancialRecordService class provides functionality to interact with the FinancialRecordDao
 * and perform operations related to financial record management, such as retrieving and printing
 * financial records based on various criteria.
 *
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
package com.hexaware.payxpert.controller;

import java.util.List;


import com.hexaware.payxpert.dao.FinancialRecordDao;
import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.exception.FinancialRecordException;
import com.hexaware.payxpert.model.FinancialRecord;

public class FinancialRecordService implements IFinancialRecordService {
    private FinancialRecordDao financialRecordDao;
    /**
     * Constructs a FinancialRecordService object with a default FinancialRecordDao.
     *
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */
    public FinancialRecordService() throws DatabaseConnectionException {
        
        financialRecordDao = new FinancialRecordDao();
    }
    /**
     * Constructs a FinancialRecordService object with a provided FinancialRecordDao.
     *
     * @param financialRecordDao The FinancialRecordDao to be used by the service.
     */
    public FinancialRecordService(FinancialRecordDao financialRecordDao) {
        this.financialRecordDao = financialRecordDao;
    }
    /**
     * Prints the details of a financial record based on the provided record ID.
     *
     * @param recordID The ID of the financial record to print.
     * @throws FinancialRecordException If the financial record with the given ID is not found.
     */
    public void printFinancialRecordById(int recordID) {
        FinancialRecord financialRecord = financialRecordDao.getFinancialRecordById(recordID);

        if (financialRecord != null) {
            System.out.println("Financial Record Details for Record ID " + recordID + ":");
            System.out.println("Record ID: " + financialRecord.getRecordID());
            System.out.println("Employee ID: " + financialRecord.getEmployeeID());
            System.out.println("Record Date: " + financialRecord.getRecordDate());
            System.out.println("Description: " + financialRecord.getDescription());
            System.out.println("Amount: " + financialRecord.getAmount());
            System.out.println("Record Type: " + financialRecord.getRecordType());
            System.out.println();
        } else {
           
            throw new FinancialRecordException("No financial record found for Record ID " + recordID);
        }
    }



    
    /**
     * Prints the details of financial records associated with a specific employee based on the provided employee ID.
     *
     * @param employeeId The ID of the employee for whom financial records should be printed.
     * @throws FinancialRecordException If no financial records are found for the given employee ID.
     */    
    public void printFinancialRecordsByEmployeeId(int employeeId) {
        List<FinancialRecord> financialRecords = getFinancialRecordByEmployeeId(employeeId);

        if (!financialRecords.isEmpty()) {
            System.out.println("Financial Records for Record ID " + employeeId + ":");
            for (FinancialRecord financialRecord : financialRecords) {
                System.out.println("Record ID: " + financialRecord.getRecordID());
                System.out.println("Employee ID: " + financialRecord.getEmployeeID());
                System.out.println("Record Date: " + financialRecord.getRecordDate());
                System.out.println("Description: " + financialRecord.getDescription());
                System.out.println("Amount: " + financialRecord.getAmount());
                System.out.println("Record Type: " + financialRecord.getRecordType());
                System.out.println();
            }
        } else {
            
            throw new FinancialRecordException("No financial record found for Employee ID " + employeeId);
        }
    }
    // Private method to get financial records by employee ID
    private List<FinancialRecord> getFinancialRecordByEmployeeId(int employeeId) {
        return financialRecordDao.getFinancialRecordByEmployeeId(employeeId);
    }
    
    /**
     * Prints the details of financial records for a specific date.
     *
     * @param recordDate The date for which financial records should be printed.
     * @throws FinancialRecordException If no financial records are found for the given date.
     */
    public void printFinancialRecordsForDate(String recordDate) {
        List<FinancialRecord> financialRecords = getFinancialRecordsForDate(recordDate);

        if (!financialRecords.isEmpty()) {
            System.out.println("Financial Records for Date " + recordDate + ":");
            for (FinancialRecord financialRecord : financialRecords) {
                System.out.println("Record ID: " + financialRecord.getRecordID());
                System.out.println("Employee ID: " + financialRecord.getEmployeeID());
                System.out.println("Record Date: " + financialRecord.getRecordDate());
                System.out.println("Description: " + financialRecord.getDescription());
                System.out.println("Amount: " + financialRecord.getAmount());
                System.out.println("Record Type: " + financialRecord.getRecordType());
                // Add additional attributes here
                
                System.out.println();
            }
        } else {
           
            throw new FinancialRecordException("No financial records found for Date " + recordDate);
        }
    }
    // Private method to get financial records for a specific date
    private List<FinancialRecord> getFinancialRecordsForDate(String recordDate) {
        return financialRecordDao.getFinancialRecordsForDate(recordDate);
    }


}