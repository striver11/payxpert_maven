package com.hexaware.payxpert.model;


/**
 * The Tax class represents tax-related information for an employee in a specific tax year.
 * It contains details such as tax ID, employee ID, tax year, taxable income, and tax amount.
 */
public class Tax {
    private int taxID;
    private int employeeID;
    private int taxYear;
    private double taxableIncome;
    private double taxAmount;

    /**
     * Default constructor for the Tax class.
     */
    public Tax() {
        // Default constructor
    }
    
    /**
     * Parameterized constructor to create a Tax with specific details.
     *
     * @param taxID         The unique identifier for the tax record.
     * @param employeeID    The unique identifier for the associated employee.
     * @param taxYear       The tax year for which the tax is calculated.
     * @param taxableIncome The taxable income of the employee.
     * @param taxAmount     The amount of tax calculated for the employee.
     */
    public Tax(int taxID, int employeeID, int taxYear, double taxableIncome, double taxAmount) {
        this.taxID = taxID;
        this.employeeID = employeeID;
        this.taxYear = taxYear;
        this.taxableIncome = taxableIncome;
        this.taxAmount = taxAmount;
    }



    public int getTaxID() {
        return taxID;
    }

    public void setTaxID(int taxID) {
        this.taxID = taxID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getTaxYear() {
        return taxYear;
    }

    public void setTaxYear(int taxYear) {
        this.taxYear = taxYear;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    /**
     * Returns a string representation of the Tax object.
     *
     * @return A string containing the details of the tax record.
     */
	@Override
	public String toString() {
		return "Tax [taxID=" + taxID + ", employeeID=" + employeeID + ", taxYear=" + taxYear + ", taxableIncome="
				+ taxableIncome + ", taxAmount=" + taxAmount + "]";
	}

	
}
