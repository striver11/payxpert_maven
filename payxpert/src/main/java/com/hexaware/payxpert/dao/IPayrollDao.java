package com.hexaware.payxpert.dao;

import java.util.List;

import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.model.Payroll;
/**
 * The {@code IPayrollDao} interface defines methods for Payroll-related database
 * operations such as creating payrolls, retrieving payrolls by ID, employee ID,
 * and for a specific period. Implementing classes must provide concrete
 * implementations for these methods.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public interface IPayrollDao {
    /**
     * Creates a new payroll record in the database.
     * 
     * @param payroll The Payroll object containing payroll details to be stored.
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */
	void createPayroll(Payroll payroll) throws DatabaseConnectionException;
    /**
     * Retrieves a payroll record by its ID from the database.
     * 
     * @param payrollId The ID of the payroll to retrieve.
     * @return The Payroll object if found, otherwise null.
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */
	Payroll getPayrollById(int payrollId) throws DatabaseConnectionException;
    /**
     * Retrieves all payrolls associated with a specific employee from the
     * database.
     * 
     * @param employeeId The ID of the employee for whom payrolls should be
     *                   retrieved.
     * @return A list of Payroll objects.
     */
	 List<Payroll> getPayrollsForEmployee(int employeeId);
    /**
     * Retrieves all payrolls for a specific period from the database.
     * 
     * @param startPeriod The start date of the period for which payrolls should be
     *                    retrieved.
     * @param endPeriod   The end date of the period for which payrolls should be
     *                    retrieved.
     * @return A list of Payroll objects.
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */
	 List<Payroll> getPayrollsForPeriod(String startPeriod, String endPeriod) throws DatabaseConnectionException;
}
