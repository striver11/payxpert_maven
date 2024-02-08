
package com.hexaware.payxpert.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.model.FinancialRecord;

import com.hexaware.payxpert.util.DatabaseContext;
/**
 * The {@code FinancialRecordDao} class provides methods to interact with the
 * database for Financial Record-related operations, such as retrieving records
 * by ID, by employee ID, and for a specific date. It interacts with the
 * FinancialRecord table in the database.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public class FinancialRecordDao  implements IFinancialRecordDao{
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    /**
     * Constructs a FinancialRecordDao object with the default database connection.
     * 
     * @throws DatabaseConnectionException If there is an issue connecting to the
     *                                     database.
     */
    public FinancialRecordDao() throws DatabaseConnectionException {
        con = DatabaseContext.getDBConn();
    }

    /**
     * Constructs a FinancialRecordDao object with the specified database
     * connection.
     * 
     * @param con The database connection to be used by the dao.
     */
    public FinancialRecordDao(Connection con) {
        this.con = con;
    }
    
    /**
     * Retrieves a financial record by its ID from the database.
     * 
     * @param recordID The ID of the financial record to retrieve.
     * @return The FinancialRecord object if found, otherwise null.
     */
    public FinancialRecord getFinancialRecordById(int recordID) {
        FinancialRecord financialRecord = null;

        try {
            // Using a PreparedStatement to avoid SQL injection
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM FinancialRecord WHERE recordID = ?");
            preparedStatement.setInt(1, recordID);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                financialRecord = new FinancialRecord();
                // Set financial record details from ResultSet
                financialRecord.setRecordID(rs.getInt("recordID"));
                financialRecord.setEmployeeID(rs.getInt("employeeID"));
                financialRecord.setRecordDate(rs.getString("recordDate"));
                financialRecord.setDescription(rs.getString("descriptions"));
                financialRecord.setAmount(rs.getDouble("amount"));
                financialRecord.setRecordType(rs.getString("recordType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return financialRecord;
    }

    
    /**
     * Retrieves financial records for a specific employee from the database.
     * 
     * @param employeeId The ID of the employee for whom records should be
     *                   retrieved.
     * @return A list of FinancialRecord objects.
     */
    public List<FinancialRecord> getFinancialRecordByEmployeeId(int employeeId) {
        List<FinancialRecord> financialRecords = new ArrayList<>();

        try {
            // Using a PreparedStatement to avoid SQL injection
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM FinancialRecord WHERE employeeId = ?");
            preparedStatement.setInt(1, employeeId);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                FinancialRecord financialRecord = new FinancialRecord();
                // Set financial record details from ResultSet
                financialRecord.setRecordID(rs.getInt("recordID"));
                financialRecord.setEmployeeID(rs.getInt("employeeID"));
                financialRecord.setRecordDate(rs.getString("recordDate"));
                financialRecord.setDescription(rs.getString("descriptions"));
                financialRecord.setAmount(rs.getDouble("amount"));
                financialRecord.setRecordType(rs.getString("recordType"));

                
                
                // Add financial record to the list
                financialRecords.add(financialRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return financialRecords;
    }
    
    /**
     * Retrieves financial records for a specific date from the database.
     * 
     * @param recordDate The date for which records should be retrieved (in the
     *                   format yyyy-MM-dd).
     * @return A list of FinancialRecord objects.
     */   
    public List<FinancialRecord> getFinancialRecordsForDate(String recordDate) {
        List<FinancialRecord> financialRecords = new ArrayList<>();

        try {
            
                // Correct the date format pattern
                SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = inputDateFormat.parse(recordDate);
                SimpleDateFormat sqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = sqlDateFormat.format(date);

                PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM FinancialRecord WHERE recordDate = ?");
                preparedStatement.setString(1, formattedDate);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    FinancialRecord financialRecord = new FinancialRecord();
                    financialRecord.setRecordID(rs.getInt("recordID"));
                    financialRecord.setEmployeeID(rs.getInt("employeeID"));
                    financialRecord.setRecordDate(rs.getString("recordDate"));
                    financialRecord.setDescription(rs.getString("descriptions"));
                    financialRecord.setAmount(rs.getDouble("amount"));
                    financialRecord.setRecordType(rs.getString("recordType"));
                   

                    financialRecords.add(financialRecord);
                    
                   

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            closeResources();
        }

        return financialRecords;
    }
    // Private method to close database resources    
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