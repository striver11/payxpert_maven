package com.hexaware.payxpert.model;

import java.util.Date;

/**
 * The Payroll class represents the payroll information for an employee during a specific pay period.
 * It contains details such as payroll ID, employee ID, pay period start and end dates, basic salary,
 * overtime pay, other pay, deductions, gross salary, tax amount, and net salary.
 */
public class Payroll {
    private int payrollID;
    private int employeeID;
    private Date payPeriodStartDate;
    private Date payPeriodEndDate;
    private double basicSalary;
    private double overtimePay;
    private double otherPay;
    private double deductions;
    private double grossSalary;
    private double taxAmount;
    private double netSalary;

    /**
     * Default constructor for the Payroll class.
     */
    public Payroll() {
        // Default constructor
    }
    /**
     * Parameterized constructor to create a Payroll with specific details.
     *
     * @param payrollID           The unique identifier for the payroll.
     * @param employeeID          The unique identifier for the associated employee.
     * @param payPeriodStartDate  The start date of the pay period.
     * @param payPeriodEndDate    The end date of the pay period.
     * @param basicSalary         The basic salary for the employee.
     * @param overtimePay         The overtime pay for the employee.
     * @param otherPay            Other additional pay for the employee.
     * @param deductions          Deductions from the salary.
     * @param grossSalary         The gross salary before deductions.
     * @param taxAmount           The amount of tax deducted.
     * @param netSalary           The net salary after deductions and taxes.
     */
    public Payroll(int payrollID, int employeeID, Date payPeriodStartDate, Date payPeriodEndDate,
                   double basicSalary, double overtimePay, double otherPay, double deductions,
                   double grossSalary, double taxAmount, double netSalary) {
        this.payrollID = payrollID;
        this.employeeID = employeeID;
        this.payPeriodStartDate = payPeriodStartDate;
        this.payPeriodEndDate = payPeriodEndDate;
        this.basicSalary = basicSalary;
        this.overtimePay = overtimePay;
        this.otherPay = otherPay;
        this.deductions = deductions;
        this.grossSalary = grossSalary;
        this.taxAmount = taxAmount;
        this.netSalary = netSalary;
    }

    public Payroll(int employeeID, Date payPeriodStartDate, Date payPeriodEndDate,
            double basicSalary, double overtimePay, double otherPay, double deductions) {
 this.employeeID = employeeID;
 this.payPeriodStartDate = payPeriodStartDate;
 this.payPeriodEndDate = payPeriodEndDate;
 this.basicSalary = basicSalary;
 this.overtimePay = overtimePay;
 this.otherPay = otherPay;
 this.deductions = deductions;
}

    public int getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(int payrollID) {
        this.payrollID = payrollID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Date getPayPeriodStartDate() {
        return payPeriodStartDate;
    }

    public void setPayPeriodStartDate(Date payPeriodStartDate) {
        this.payPeriodStartDate = payPeriodStartDate;
    }

    public Date getPayPeriodEndDate() {
        return payPeriodEndDate;
    }

    public void setPayPeriodEndDate(Date payPeriodEndDate) {
        this.payPeriodEndDate = payPeriodEndDate;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getOvertimePay() {
        return overtimePay;
    }

    public void setOvertimePay(double overtimePay) {
        this.overtimePay = overtimePay;
    }

    public double getOtherPay() {
        return otherPay;
    }

    public void setOtherPay(double otherPay) {
        this.otherPay = otherPay;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }
    	
    /**
     * Returns a string representation of the Payroll object.
     *
     * @return A string containing the details of the payroll.
     */
    @Override
    public String toString() {
        return "Payroll{" +
                "payrollID=" + payrollID +
                ", employeeID=" + employeeID +
                ", payPeriodStartDate=" + payPeriodStartDate +
                ", payPeriodEndDate=" + payPeriodEndDate +
                ", basicSalary=" + basicSalary +
                ", overtimePay=" + overtimePay +
                ", otherPay=" + otherPay +
                ", deductions=" + deductions +
                ", grossSalary=" + grossSalary +
                ", taxAmount=" + taxAmount +
                ", netSalary=" + netSalary +
                '}';
    }
}
