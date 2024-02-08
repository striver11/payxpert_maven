package com.hexaware.payxpert.dao;



import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.util.DatabaseContext;

/**
 * The FinancialRecordDaoTest class contains JUnit tests for the FinancialRecordDao class.
 */
public class FinancialRecordDaoTest {

	
	 private FinancialRecordDao financialRecordDao;
	 Connection con;
	 
	    /**
	     * Sets up the necessary resources before running the tests.
	     *
	     * @throws DatabaseConnectionException If an error occurs while establishing a database connection.
	     */
	    @Before
	    public void setUp() throws DatabaseConnectionException {
	    	//establishing connection with DB before testing
	    	financialRecordDao = new FinancialRecordDao();
	    	con = DatabaseContext.getDBConn();
	    }

	    /**
	     * Tests the retrieval of financial record amount by ID.
	     *
	     * @throws DatabaseConnectionException If an error occurs while connecting to the database.
	     */	    
	    @Test
	    public void testForGrossSalary() throws DatabaseConnectionException {
	    	
	    	//creating test variables to compare with actual values
	        int financialRecordId = 1; 
	        double expectedfinancialRecordIdAmount = 45000.00; 

	        double actualfinancialRecordIdAmount = financialRecordDao.getFinancialRecordById(financialRecordId).getAmount();

	   
	        assertEquals(expectedfinancialRecordIdAmount, actualfinancialRecordIdAmount, 0.001); // 0.001 is the delta for double comparison.
	    }
	    
}
