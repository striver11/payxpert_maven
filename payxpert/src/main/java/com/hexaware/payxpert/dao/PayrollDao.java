package com.hexaware.payxpert.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.payxpert.exception.DatabaseConnectionException;

import com.hexaware.payxpert.util.DatabaseContext;
import com.hexaware.payxpert.model.Payroll;
/**
 * The {@code PayrollDao} class provides methods for performing database
 * operations related to payroll records. It includes methods for creating,
 * retrieving, and querying payroll records.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
public class PayrollDao implements IPayrollDao{
	 Connection con;
	    PreparedStatement ps;
	    ResultSet rs;
	    /**
	     * Creates a payroll record in the database.
	     * 
	     * @param payroll The Payroll object containing payroll details.
	     * @throws DatabaseConnectionException If there is an issue connecting to the
	     *                                     database.
	     */	    
	    public void createPayroll(Payroll payroll) throws DatabaseConnectionException {
	        try {
	            con = DatabaseContext.getDBConn();
	            ps = con.prepareStatement(
	                    "INSERT INTO payroll (employeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, otherpay, Deductions) VALUES (?, ?, ?, ?, ?, ?, ?)");

	            ps.setInt(1, payroll.getEmployeeID());
	            ps.setDate(2, new java.sql.Date(payroll.getPayPeriodStartDate().getTime()));
	            ps.setDate(3, new java.sql.Date(payroll.getPayPeriodEndDate().getTime()));
	            ps.setDouble(4, payroll.getBasicSalary());
	            ps.setDouble(5, payroll.getOvertimePay());
	            ps.setDouble(6, payroll.getOtherPay());
	            ps.setDouble(7, payroll.getDeductions());

	            int noOfRows = ps.executeUpdate();
	            System.out.println(noOfRows + " payroll record inserted successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }
	    }
	    
	    /**
	     * Retrieves a payroll record by its ID from the database.
	     * 
	     * @param payrollId The ID of the payroll record to retrieve.
	     * @return The Payroll object if found, otherwise null.
	     * @throws DatabaseConnectionException If there is an issue connecting to the
	     *                                     database.
	     */	    
	    public Payroll getPayrollById(int payrollId) throws DatabaseConnectionException {
	        Payroll payroll = null;
	        try {
	            con = DatabaseContext.getDBConn();
	            ps = con.prepareStatement("SELECT * FROM payroll WHERE payrollID = ?");
	            ps.setInt(1, payrollId);
	            rs = ps.executeQuery();

	            if (rs.next()) {
	                // Populate the Payroll object
	                payroll = new Payroll(
	                        rs.getInt("employeeID"),
	                        payrollId, rs.getDate("PayPeriodStartDate"),
	                        rs.getDate("PayPeriodEndDate"),
	                        rs.getDouble("BasicSalary"),
	                        rs.getDouble("OvertimePay"),
	                        rs.getDouble("otherPay"),
	                        rs.getDouble("deductions"),
	                        rs.getDouble("grosssalary"),
	                        rs.getDouble("taxAmount"),
	                        rs.getDouble("NetSalary")
	                        
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }

	        return payroll;
	    }
	    /**
	     * Retrieves all payroll records associated with a specific employee from the
	     * database.
	     * 
	     * @param employeeId The ID of the employee for whom payroll records should be
	     *                   retrieved.
	     * @return A list of Payroll objects.
	     */	    
	    public List<Payroll> getPayrollsForEmployee(int employeeId) {
	        List<Payroll> payrolls = new ArrayList<>();

	        try {
	            con = DatabaseContext.getDBConn();
	            ps = con.prepareStatement("SELECT * FROM payroll WHERE employeeID = ?");
	            ps.setInt(1, employeeId);

	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Payroll payroll = new Payroll();
	                // Set payroll details from ResultSet
	                payroll.setPayrollID(rs.getInt("payrollID"));
	                payroll.setEmployeeID(rs.getInt("employeeID"));
	                payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
	                payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
	                payroll.setBasicSalary(rs.getDouble("BasicSalary"));
	                payroll.setOvertimePay(rs.getDouble("overtimePay"));
	                payroll.setOtherPay(rs.getDouble("otherPay"));
	                payroll.setDeductions(rs.getDouble("deductions"));

	                // Add payroll to the list
	                payrolls.add(payroll);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (DatabaseConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
	            closeResources();
	        }

	        return payrolls;
	    }
	    
	    /**
	     * Retrieves all payroll records for a specific pay period from the database.
	     * 
	     * @param startPeriod The start date of the pay period.
	     * @param endPeriod   The end date of the pay period.
	     * @return A list of Payroll objects.
	     * @throws DatabaseConnectionException If there is an issue connecting to the
	     *                                     database.
	     */	    
	    public List<Payroll> getPayrollsForPeriod(String startPeriod, String endPeriod) throws DatabaseConnectionException {
	        List<Payroll> payrolls = new ArrayList<>();

	        try {
	            con = DatabaseContext.getDBConn();
	            ps = con.prepareStatement(
	                    "SELECT * FROM payroll WHERE PayPeriodStartDate >= ? AND PayPeriodEndDate <= ?");

	            ps.setDate(1, Date.valueOf(startPeriod));
	            ps.setDate(2, Date.valueOf(endPeriod));

	            rs = ps.executeQuery();

	            while (rs.next()) {
	                Payroll payroll = new Payroll();
	                // Set payroll details from the result set
	                payroll.setPayrollID(rs.getInt("payrollID"));
	                payroll.setEmployeeID(rs.getInt("employeeID"));
	                payroll.setPayPeriodStartDate(rs.getDate("PayPeriodStartDate"));
	                payroll.setPayPeriodEndDate(rs.getDate("PayPeriodEndDate"));
	                payroll.setBasicSalary(rs.getDouble("BasicSalary"));
	                payroll.setOvertimePay(rs.getDouble("overtimePay"));
	                payroll.setOtherPay(rs.getDouble("otherPay"));
	                payroll.setDeductions(rs.getDouble("deductions"));

	                payrolls.add(payroll);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeResources();
	        }

	        return payrolls;
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
	            if (con != null) {
	                con.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
