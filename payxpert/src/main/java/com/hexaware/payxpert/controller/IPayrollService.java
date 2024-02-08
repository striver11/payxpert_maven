
/**
 * The IPayrollService interface defines the contract for services related to payroll management.
 * It declares methods for generating payroll, retrieving payroll details by ID, and fetching payrolls for employees
 * and specific periods. Implementing classes should provide concrete implementations for these methods.
 * 
 * @author Your Name
 * @version 1.0
 * @since 2024-02-08
 */
package com.hexaware.payxpert.controller;

import java.util.List;

import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.model.Payroll;

public interface IPayrollService {
    /**
     * Generates payroll for an employee based on the provided details.
     *
     * @param employeeId  The ID of the employee for whom payroll is generated.
     * @param startDate   The start date of the payroll period.
     * @param endDate     The end date of the payroll period.
     * @param basicSalary The basic salary of the employee.
     * @param overTime    The overtime pay for the employee.
     * @param otherPay    Any other additional pay for the employee.
     * @param deductions  Deductions from the employee's salary.
     */
	void generatePayroll(int employeeId, String startDate, String endDate, double basicSalary, double overTime,
			double otherPay, double deductions);
    /**
     * Retrieves and displays the details of a payroll based on the provided payroll ID.
     *
     * @param payrollId The ID of the payroll to retrieve.
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */
	public void getPayrollById(int payrollId) throws DatabaseConnectionException;
    /**
     * Retrieves a list of payrolls associated with a specific employee.
     *
     * @param employeeId The ID of the employee for whom payrolls should be retrieved.
     * @return A list of Payroll objects representing the employee's payrolls.
     */
	List<Payroll> getPayrollsForEmployee(int employeeId);
    /**
     * Retrieves a list of payrolls for a specific period.
     *
     * @param startPeriod The start date of the period for which payrolls should be retrieved.
     * @param endPeriod   The end date of the period for which payrolls should be retrieved.
     * @return A list of Payroll objects representing payrolls for the specified period.
     */
	 List<Payroll> getPayrollsForPeriod(String startPeriod, String endPeriod);
}
