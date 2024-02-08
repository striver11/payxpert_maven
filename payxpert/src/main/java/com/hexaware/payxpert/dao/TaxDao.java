package com.hexaware.payxpert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.model.Tax;
import com.hexaware.payxpert.util.DatabaseContext;
/**
 * The {@code TaxDao} class provides methods for performing database operations
 * related to tax records. It includes methods for retrieving tax records by ID,
 * employee ID, and tax year.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public class TaxDao implements ITaxDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * Constructs a TaxDao object with the default database connection.
     * 
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */
    public TaxDao() throws DatabaseConnectionException {
        con = DatabaseContext.getDBConn();
    }

    /**
     * Retrieves a tax record by its ID from the database.
     * 
     * @param taxId The ID of the tax record to retrieve.
     * @return The Tax object if found, otherwise null.
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */
        public Tax getTaxById(int taxId) throws DatabaseConnectionException {
            Tax tax = null;

            try {
                con = DatabaseContext.getDBConn();
                ps = con.prepareStatement("SELECT * FROM tax WHERE taxId = ?");
                ps.setInt(1, taxId);
                rs = ps.executeQuery();

                if (rs.next()) {
                    // Populate the Tax object
                    tax = new Tax();
                    tax.setTaxID(rs.getInt("taxId"));
                    tax.setEmployeeID(rs.getInt("employeeID"));
                    tax.setTaxYear(rs.getInt("taxYear"));
                    tax.setTaxableIncome(rs.getDouble("taxableIncome"));
                    tax.setTaxAmount(rs.getDouble("taxAmount"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeResources();
            }

            return tax;
        }

      

    

    
        /**
         * Retrieves all tax records associated with a specific employee from the
         * database.
         * 
         * @param employeeId The ID of the employee for whom tax records should be
         *                   retrieved.
         * @return A list of Tax objects.
         */    
    public List<Tax> getTaxesByEmployeeId(int employeeId) {
        List<Tax> taxes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM tax WHERE employeeID = ?");
            preparedStatement.setInt(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Tax tax = new Tax();
               
                tax.setTaxID(rs.getInt("taxId"));
                tax.setEmployeeID(rs.getInt("employeeID"));
                tax.setTaxYear(rs.getInt("taxYear"));
                tax.setTaxableIncome(rs.getDouble("taxableIncome"));
                tax.setTaxAmount(rs.getDouble("taxAmount"));

                // Add tax to the list
                taxes.add(tax);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(taxes);
        return taxes;
    }
    
    /**
     * Retrieves all tax records for a specific tax year from the database.
     * 
     * @param taxYear The tax year for which tax records should be retrieved.
     * @return A list of Tax objects.
     */
    public List<Tax> getTaxesByTaxYear(int taxYear) {
        List<Tax> taxes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM tax WHERE TaxYear = ?");
            preparedStatement.setInt(1, taxYear);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Tax tax = new Tax();
                // Set tax details from ResultSet
                tax.setTaxID(rs.getInt("taxId"));
                tax.setEmployeeID(rs.getInt("employeeID"));
                tax.setTaxYear(rs.getInt("taxYear"));
                tax.setTaxableIncome(rs.getDouble("taxableIncome"));
                tax.setTaxAmount(rs.getDouble("taxAmount"));

                // Add tax to the list
                taxes.add(tax);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taxes;
    }

    /**
     * Closes the resources such as ResultSet, PreparedStatement, and Connection.
     */
    private void closeResources() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            // Connection should not be closed in the middle. It should be managed by the application or a connection pool.
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



	
}
