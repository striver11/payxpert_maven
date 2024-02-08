/**
 * The TaxService class provides functionality to retrieve and print tax details
 * based on various criteria such as tax ID, employee ID, and tax year. It interacts
 * with the TaxDao to perform database operations related to taxes.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
package com.hexaware.payxpert.controller;

import java.util.List;

import com.hexaware.payxpert.dao.ITaxDao;
import com.hexaware.payxpert.dao.TaxDao;
import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.model.Tax;

public class TaxService implements  ITaxService{
    private TaxDao taxDao;
    /**
     * Constructs a TaxService object with the default TaxDao.
     * 
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */
    public TaxService() throws DatabaseConnectionException {
       
        taxDao = new TaxDao();
    }
    
    /**
     * Constructs a TaxService object with the specified ITaxDao implementation.
     * 
     * @param taxDao2 The ITaxDao implementation to be used by the service.
     */
    public TaxService(ITaxDao taxDao2) {
        this.taxDao = (TaxDao) taxDao2;
    }
    
    /**
     * Prints the details of a tax based on the provided tax ID.
     * 
     * @param taxId The ID of the tax to print.
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */
    public void printTaxesById(int taxId) throws DatabaseConnectionException {
        // Retrieve tax record by ID using TaxDao
        Tax tax = taxDao.getTaxById(taxId);

        if (tax != null) {
            // Print or display the tax details
            System.out.println("Tax Details for Tax ID " + taxId + ":");
            System.out.println("Employee ID: " + tax.getEmployeeID());
            System.out.println("Tax Year: " + tax.getTaxYear());
            System.out.println("Taxable Income: " + tax.getTaxableIncome());
            System.out.println("Tax Amount: " + tax.getTaxAmount());
            System.out.println();
        } else {
            System.out.println("Tax with ID " + taxId + " not found.");
        }
    }

  
    
    
    /**
     * Prints the details of taxes associated with a specific employee.
     * 
     * @param customerId The ID of the employee for whom taxes should be printed.
     */
    @Override    
    public void printTaxesByEmployeeId(int customerId) {
        List<Tax> taxes = getTaxesByEmployeeId(customerId);

        if (!taxes.isEmpty()) {
            System.out.println("Taxes for Tax ID " + customerId + ":");
            for (Tax tax : taxes) {
                System.out.println("Tax ID: " + tax.getTaxID());
                System.out.println("Employee ID: " + tax.getEmployeeID());
                System.out.println("Tax Year: " + tax.getTaxYear());
                System.out.println("Taxable Income: " + tax.getTaxableIncome());
                System.out.println("Tax Amount: " + tax.getTaxAmount());
           System.out.println();
            }
        } else {
            System.out.println("No taxes found for Tax ID " + customerId);
        }
    }
    // Private method to get a list of taxes associated with an employee
    private List<Tax> getTaxesByEmployeeId(int customerId) {
        return taxDao.getTaxesByEmployeeId(customerId);
    }
    
    
    /**
     * Prints the details of taxes for a specific tax year.
     * 
     * @param taxYear The tax year for which taxes should be printed.
     */
    @Override    
    public void printTaxesByTaxYear(int taxYear) {
        List<Tax> taxes = getTaxesByTaxYear(taxYear);

        if (!taxes.isEmpty()) {
            System.out.println("Taxes for Tax ID " + taxYear + ":");
            for (Tax tax : taxes) {
                System.out.println("Tax ID: " + tax.getTaxID());
                System.out.println("Employee ID: " + tax.getEmployeeID());
                System.out.println("Tax Year: " + tax.getTaxYear());
                System.out.println("Taxable Income: " + tax.getTaxableIncome());
                System.out.println("Tax Amount: " + tax.getTaxAmount());
                System.out.println();
            }
        } else {
            System.out.println("No taxes found for Tax ID " + taxYear);
        }
    }
    // Private method to get a list of taxes for a specific tax year
    private List<Tax> getTaxesByTaxYear(int taxYear) {
        return taxDao.getTaxesByTaxYear(taxYear);
    }

	
    
    
}
