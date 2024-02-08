package com.hexaware.payxpert.dao;

import java.util.List;

import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.model.Employee;
/**
 * The {@code IEmployeeDao} interface defines methods for Employee-related
 * database operations such as creating, retrieving, and removing employees.
 * Implementing classes must provide concrete implementations for these
 * methods.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public interface IEmployeeDao {
    /**
     * Inserts a new employee record into the database.
     * 
     * @param newEmployee The Employee object representing the new employee.
     */
	void createEmployee(Employee newEmployee);
    /**
     * Retrieves an employee by their ID from the database.
     * 
     * @param employeeId The ID of the employee to retrieve.
     * @return The Employee object if found, otherwise null.
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */
	Employee getEmployeeById(int employeeId) throws DatabaseConnectionException;
    /**
     * Retrieves all employees from the database.
     * 
     * @return A list of Employee objects.
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */	
	List<Employee> getAllEmployees() throws DatabaseConnectionException;
    /**
     * Removes an existing employee record from the database.
     * 
     * @param existingEmployee The Employee object representing the employee to be
     *                         removed.
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */
	void removeEmployee(Employee existingEmployee) throws DatabaseConnectionException;

}
