package com.hexaware.payxpert.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.util.DatabaseContext;


/**
 * The TaxDaoTest class contains JUnit tests for the TaxDao class.
 */
public class TaxDaoTest {
	 private TaxDao taxDao;
	 Connection con;

	    /**
	     * Sets up the necessary resources before running the tests.
	     *
	     * @throws DatabaseConnectionException If an error occurs while establishing a database connection.
	     */
	    @Before
	    public void setUp() throws DatabaseConnectionException {
	    	//establishing connection with DB before testing
	    	taxDao = new TaxDao();
	    	con = DatabaseContext.getDBConn();
	    }

	    /**
	     * Tests the retrieval of tax amount by tax ID.
	     *
	     * @throws DatabaseConnectionException If an error occurs while connecting to the database.
	     */
	    @Test
	    public void testForTaxAmount() throws DatabaseConnectionException {
	    	
	    	//creating test variables to compare with actual values
	        int testTaxlId = 1; 
	        double expectedTaxAmount = 1584.40; 

	        // Call the method to get the actual balance.
	        double actualTaxAmount = taxDao.getTaxById(testTaxlId).getTaxAmount();

	        // Assert that the actual balance matches the expected balance.
	        assertEquals(expectedTaxAmount, actualTaxAmount, 0.001); // 0.001 is the delta for double comparison.
	    }
}
