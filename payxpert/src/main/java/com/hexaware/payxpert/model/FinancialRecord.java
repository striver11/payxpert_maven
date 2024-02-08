package com.hexaware.payxpert.model;



/**
 * The FinancialRecord class represents a financial record associated with an employee.
 * It contains details such as the record ID, employee ID, date, description, amount, and type of record.
 */
public class FinancialRecord {
    private int recordID;
    private int employeeID;
    private String recordDate;
    private String description;
    private double amount;
    private String recordType;

    /**
     * Default constructor for the FinancialRecord class.
     */
    public FinancialRecord() {
        // Default constructor
    }
    
    /**
     * Parameterized constructor to create a FinancialRecord with specific details.
     *
     * @param recordID    The unique identifier for the financial record.
     * @param employeeID  The unique identifier for the associated employee.
     * @param recordDate  The date when the financial record was created.
     * @param description A description of the financial record.
     * @param amount      The amount associated with the financial record.
     * @param recordType  The type or category of the financial record.
     */
    public FinancialRecord(int recordID, int employeeID, String recordDate, String description, double amount, String recordType) {
        this.recordID = recordID;
        this.employeeID = employeeID;
        this.recordDate = recordDate;
        this.description = description;
        this.amount = amount;
        this.recordType = recordType;
    }


    public int getRecordID() {
        return recordID;
    }

    public void setRecordID(int recordID) {
        this.recordID = recordID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    /**
     * Returns a string representation of the FinancialRecord object.
     *
     * @return A string containing the details of the financial record.
     */
    @Override
    public String toString() {
        return "FinancialRecord{" +
                "recordID=" + recordID +
                ", employeeID=" + employeeID +
                ", recordDate='" + recordDate + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", recordType='" + recordType + '\'' +
                '}';
    }
}

