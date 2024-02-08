/**
 * The PayrollService class provides functionality to generate payroll for employees,
 * retrieve payroll details by ID, and fetch payrolls for employees and specific periods.
 * It interacts with the EmployeeDao and PayrollDao to perform database operations.
 * 
 * @author Praveen Kumar Kuruba
 * @version 1.0
 * @since 2024-02-07
 */
package com.hexaware.payxpert.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.hexaware.payxpert.dao.EmployeeDao;
import com.hexaware.payxpert.dao.IEmployeeDao;
import com.hexaware.payxpert.dao.IPayrollDao;
import com.hexaware.payxpert.dao.PayrollDao;
import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.exception.PayrollGenerationException;
import com.hexaware.payxpert.model.Employee;
import com.hexaware.payxpert.model.Payroll;

public class PayrollService implements IPayrollService {
    private EmployeeDao employeeDao;
    private PayrollDao payrollDao;
    /**
     * Constructs a PayrollService object with the specified EmployeeDao and PayrollDao.
     *
     * @param employeeDao The EmployeeDao to be used by the service.
     * @param payrollDao  The PayrollDao to be used by the service.
     */
    public PayrollService(IEmployeeDao employeeDao, IPayrollDao payrollDao) {
        this.employeeDao = (EmployeeDao) employeeDao;
        this.payrollDao = (PayrollDao) payrollDao;
    }
    /**
     * Generates payroll for an employee based on the provided details.
     *
     * @param employeeId   The ID of the employee for whom payroll is generated.
     * @param startDateStr The start date of the payroll period in string format (yyyy-mm-dd).
     * @param endDateStr   The end date of the payroll period in string format (yyyy-mm-dd).
     * @param basicSalary  The basic salary of the employee.
     * @param overtimePay  The overtime pay for the employee.
     * @param otherPay     Any other additional pay for the employee.
     * @param deductions   Deductions from the employee's salary.
     */
    public void generatePayroll(int employeeId, String startDateStr, String endDateStr,
            double basicSalary, double overtimePay, double otherPay, double deductions) {
        try {
            Date startDate = Date.valueOf(startDateStr);
            Date endDate = Date.valueOf(endDateStr);

            Employee employee = employeeDao.getEmployeeById(employeeId);

            if (employee != null) {
                long daysWorked = calculateDaysWorked(startDate, endDate);
                double dailySalary = getDailySalaryByDesignation(employee.getPosition());

                double baseSalary = daysWorked * dailySalary + basicSalary;
                double totalOvertimePay = overtimePay;
                double totalOtherPay = otherPay;
                double totalDeductions = deductions;

                double totalSalary = baseSalary + totalOvertimePay + totalOtherPay - totalDeductions;

                // Print or store the payroll details as needed
                System.out.println("Payroll Details:");
                System.out.println("Employee ID: " + employeeId);
                System.out.println("Employee Name: " + employee.getFirstName() + " " + employee.getLastName());
                System.out.println("Base Salary: " + baseSalary);
                System.out.println("Overtime Pay: " + totalOvertimePay);
                System.out.println("Other Pay: " + totalOtherPay);
                System.out.println("Deductions: " + totalDeductions);
                System.out.println("Total Salary: " + totalSalary);
                System.out.println();

                // Create Payroll object and save it to the database using PayrollDao
                Payroll payroll = new Payroll(employeeId, startDate, endDate, baseSalary, totalOvertimePay, totalOtherPay, totalDeductions);
                payrollDao.createPayroll(payroll);
            } else {
                
                throw new PayrollGenerationException("Payroll cannot be generated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Private method to get daily salary based on job designatio
    private double getDailySalaryByDesignation(String designation) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose your job designation:");
        System.out.println("1. Manager");
        System.out.println("2. Data Scientist");
        System.out.println("3. Senior Software Developer");
        System.out.println("4. Junior Developer");
        System.out.println("5. Tester");
        System.out.println("6. Janitor");

        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                // Manager
                return 2000.0;
            case 2:
                // Data Scientist
                return 2500.0;
            case 3:
                // Senior Software Developer
                return 1800.0;
            case 4:
                // Junior Developer
                return 1500.0;
            case 5:
                // Tester
                return 1600.0;
            case 6:
            	return 300.0;
            default:
                // Default case or invalid choice
                return 0.0;
        }
    }

    // Private method to calculate days worked between two dates
    private long calculateDaysWorked(Date startDate, Date endDate) {
        long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    
    
    
    
    /**
     * Retrieves and displays the details of a payroll based on the provided payroll ID.
     *
     * @param payrollId The ID of the payroll to retrieve.
     * @throws DatabaseConnectionException If there is an issue connecting to the database.
     */    
    public void getPayrollById(int payrollId) throws DatabaseConnectionException {
        // Retrieve payroll record by ID using PayrollDao
        Payroll payroll = payrollDao.getPayrollById(payrollId);

        if (payroll != null) {
            // Print or display the payroll details
            System.out.println("Payroll Details for Payroll ID " + payrollId + ":");
            System.out.println("Employee ID: " + payroll.getEmployeeID());
            System.out.println("Start Date: " + payroll.getPayPeriodStartDate());
            System.out.println("End Date: " + payroll.getPayPeriodEndDate());
            System.out.println("Basic Salary: " + payroll.getBasicSalary());
            System.out.println("Overtime Pay: " + payroll.getOvertimePay());
            System.out.println("Other Pay: " + payroll.getOtherPay());
            System.out.println("Deductions: " + payroll.getDeductions());
            System.out.println();
        } else {
            System.out.println("Payroll with ID " + payrollId + " not found.");
        }
    }
    
    /**
     * Retrieves a list of payrolls associated with a specific employee.
     *
     * @param employeeId The ID of the employee for whom payrolls should be retrieved.
     * @return A list of Payroll objects representing the employee's payrolls.
     */
    @Override
    public List<Payroll> getPayrollsForEmployee(int employeeId) {
        try {
            // method in EmployeeDao to get the employee by ID
            Employee employee = employeeDao.getEmployeeById(employeeId);

            if (employee != null) {
                // method in PayrollDao to get payrolls for a specific employee
                List<Payroll> payrolls = payrollDao.getPayrollsForEmployee(employeeId);

                if (payrolls != null && !payrolls.isEmpty()) {
                    
                    System.out.println("Payrolls for Employee ID " + employeeId + ":");
                    for (Payroll payroll : payrolls) {
                    	  System.out.println("Payroll ID: " + payroll.getPayrollID());
                          System.out.println("Employee ID: " + payroll.getEmployeeID());
                          System.out.println("Start Date: " + payroll.getPayPeriodStartDate());
                          System.out.println("End Date: " + payroll.getPayPeriodEndDate());
                          System.out.println("Base Salary: " + payroll.getBasicSalary());
                          System.out.println("Overtime Pay: " + payroll.getOvertimePay());
                          System.out.println("Other Pay: " + payroll.getOtherPay());
                          System.out.println("Deductions: " + payroll.getDeductions());
                       System.out.println();
                    }
                } else {
                    System.out.println("No payrolls found for Employee ID " + employeeId);
                }

                return payrolls;
            } else {
                System.out.println("Employee with ID " + employeeId + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>(); 
    }
    
    /**
     * Retrieves a list of payrolls for a specific period.
     *
     * @param startPeriod The start date of the period for which payrolls should be retrieved.
     * @param endPeriod   The end date of the period for which payrolls should be retrieved.
     * @return A list of Payroll objects representing payrolls for the specified period.
     */   
    public List<Payroll> getPayrollsForPeriod(String startPeriod, String endPeriod) {
        try {
           
            List<Payroll> payrolls = payrollDao.getPayrollsForPeriod(startPeriod, endPeriod);

            if (payrolls != null && !payrolls.isEmpty()) {
                // Print or return payrolls as needed
                System.out.println("Payrolls for Period " + startPeriod + " to " + endPeriod + ":");
                for (Payroll payroll : payrolls) {
                    System.out.println("Payroll ID: " + payroll.getPayrollID());
                    System.out.println("Employee ID: " + payroll.getEmployeeID());
                    System.out.println("Start Date: " + payroll.getPayPeriodStartDate());
                    System.out.println("End Date: " + payroll.getPayPeriodEndDate());
                    System.out.println("Base Salary: " + payroll.getBasicSalary());
                    System.out.println("Overtime Pay: " + payroll.getOvertimePay());
                    System.out.println("Other Pay: " + payroll.getOtherPay());
                    System.out.println("Deductions: " + payroll.getDeductions());
                    System.out.println();
                    
                }
            } else {
                System.out.println("No payrolls found for the specified period.");
            }

            return payrolls;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }



}
