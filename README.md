# PayXpert: Payroll Management System

## Overview

PayXpert is a comprehensive Payroll Management System implemented in Java. It is designed to handle Employee Management, Payroll Processing, Tax Calculation, and Financial Reporting. The application follows object-oriented principles, utilizes SQL for data storage, and provides a menu-driven interface for users.

## Directory Structure

- src
  - entity/model
    - Employee.java
    - Payroll.java
    - Tax.java
    - FinancialRecord.java
  - dao
    - IEmployeeService.java
    - EmployeeService.java
    - IPayrollService.java
    - PayrollService.java
    - ITaxService.java
    - TaxService.java
    - IFinancialRecordService.java
    - FinancialRecordService.java
    - DatabaseContext.java
  - exception
    - EmployeeNotFoundException.java
    - PayrollGenerationException.java
    - TaxCalculationException.java
    - FinancialRecordException.java
    - InvalidInputException.java
    - DatabaseConnectionException.java
  - util
    - DBPropertyUtil.java
    - DBConnUtil.java
  - main
    - MainModule.java
  - tests
    - CalculateGrossSalaryTest.java
    - CalculateNetSalaryTest.java
    - VerifyTaxCalculationTest.java
    - ProcessPayrollTest.java
    - VerifyErrorHandlingTest.java

## Entity Classes

### Employee
- Properties: EmployeeID, FirstName, LastName, DateOfBirth, Gender, Email, PhoneNumber, Address, Position, JoiningDate, TerminationDate
- Methods: CalculateAge()

### Payroll
- Properties: PayrollID, EmployeeID, PayPeriodStartDate, PayPeriodEndDate, BasicSalary, OvertimePay, Deductions, NetSalary

### Tax
- Properties: TaxID, EmployeeID, TaxYear, TaxableIncome, TaxAmount

### FinancialRecord
- Properties: RecordID, EmployeeID, RecordDate, Description, Amount, RecordType

## Services

### EmployeeService (implements IEmployeeService)
- Methods: GetEmployeeById, GetAllEmployees, AddEmployee, UpdateEmployee, RemoveEmployee

### PayrollService (implements IPayrollService)
- Methods: GeneratePayroll, GetPayrollById, GetPayrollsForEmployee, GetPayrollsForPeriod

### TaxService (implements ITaxService)
- Methods: CalculateTax, GetTaxById, GetTaxesForEmployee, GetTaxesForYear

### FinancialRecordService (implements IFinancialRecordService)
- Methods: AddFinancialRecord, GetFinancialRecordById, GetFinancialRecordsForEmployee, GetFinancialRecordsForDate

## Database Connection

- Create a connection string using DBPropertyUtil.
- Use DBConnUtil to establish a connection to the SQL Server database.
- SqlCommand class is used to execute SQL queries.

## Custom Exceptions

- EmployeeNotFoundException
- PayrollGenerationException
- TaxCalculationException
- FinancialRecordException
- InvalidInputException
- DatabaseConnectionException

## Unit Testing

- NUnit tests are provided to ensure the correctness and reliability of the system.
- Test cases include calculating gross salary, net salary after deductions, verifying tax calculation for high-income employees, processing payroll for multiple employees, and handling invalid input data gracefully.

## How to Run

1. Compile the Java files.
2. Run MainModule.java.
3. Follow the menu-driven interface to demonstrate various functionalities.

## Dependencies

- Java 8 or higher
- SQL Server

## Contributors

- Your Name
- Any other contributors


