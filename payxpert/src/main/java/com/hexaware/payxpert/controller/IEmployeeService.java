
/**
 * The IEmployeeService interface defines the contract for services related to employee management.
 * It declares methods for retrieving, adding, updating, and removing employees.
 * Implementing classes should provide concrete implementations for these methods.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
package com.hexaware.payxpert.controller;

import com.hexaware.payxpert.exception.DatabaseConnectionException;

public interface IEmployeeService {
    /**
     * Retrieves and displays the details of an employee based on the provided employee ID.
     *
     * @param employeeId The ID of the employee to retrieve.
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */
	void getEmployeeById(int employeeId) throws DatabaseConnectionException;
    /**
     * Retrieves and displays details of all employees in the system.
     *
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */
	void getAllEmployees() throws DatabaseConnectionException;
    /**
     * Adds a new employee to the system.
     */
	void addEmployee();	
    /**
     * Removes an employee from the system based on the provided employee ID.
     *
     * @param employeeId The ID of the employee to remove.
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */	 
	void removeEmployee(int employeeId) throws DatabaseConnectionException;
    /**
     * Updates the details of an existing employee based on the provided employee ID.
     *
     * @param employeeId The ID of the employee to update.
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */
	void updateEmployee(int employeeId) throws DatabaseConnectionException;
}
