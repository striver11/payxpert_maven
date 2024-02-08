package com.hexaware.payxpert.dao;



import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.util.DatabaseContext;

/**
 * The PayrollDaoTest class contains JUnit tests for the PayrollDao class.
 */
public class PayrollDaoTest {

	
	 private PayrollDao payrollDAO;
	 Connection con;

	    /**
	     * Sets up the necessary resources before running the tests.
	     *
	     * @throws DatabaseConnectionException If an error occurs while establishing a database connection.
	     */
	    @Before
	    public void setUp() throws DatabaseConnectionException {
	    	//establishing connection with DB before testing
	    	payrollDAO = new PayrollDao();
	    	con = DatabaseContext.getDBConn();
	    }

	    /**
	     * Tests the retrieval of gross salary by payroll ID.
	     *
	     * @throws DatabaseConnectionException If an error occurs while connecting to the database.
	     */	    
	    @Test
	    public void testForGrossSalary() throws DatabaseConnectionException {
	    	
	    	//creating test variables to compare with actual values
	        int testPayrollId = 1; 
	        double expectedGrossSalary = 47091.00; 

	        // Call the method to get the actual balance.
	        double actualGrossSalary = payrollDAO.getPayrollById(testPayrollId).getGrossSalary();

	        // Assert that the actual balance matches the expected balance.
	        assertEquals(expectedGrossSalary, actualGrossSalary, 0.001); // 0.001 is the delta for double comparison.
	    }

	    /**
	     * Tests the retrieval of net salary by payroll ID.
	     *
	     * @throws DatabaseConnectionException If an error occurs while connecting to the database.
	     */	    
	    @Test
	    public void testForNetSalary() throws DatabaseConnectionException {
	    	
	    	//creating test variables to compare with actual values
	        int testPayrollId = 1; 
	        double expectedNetSalary = 45506.60; 

	        // Call the method to get the actual balance.
	        double actualGrossSalary = payrollDAO.getPayrollById(testPayrollId).getNetSalary();

	        // Assert that the actual balance matches the expected balance.
	        assertEquals(expectedNetSalary, actualGrossSalary, 0.001); // 0.001 is the delta for double comparison.
	    }
}
