	package com.hexaware.payxpert.main;
	


import com.hexaware.payxpert.controller.EmployeeService;
import com.hexaware.payxpert.controller.IEmployeeService;
import com.hexaware.payxpert.controller.FinancialRecordService;
import com.hexaware.payxpert.controller.IFinancialRecordService;
import com.hexaware.payxpert.controller.IPayrollService;
import com.hexaware.payxpert.controller.PayrollService;
import com.hexaware.payxpert.controller.ITaxService;
import com.hexaware.payxpert.controller.TaxService;
import com.hexaware.payxpert.dao.EmployeeDao;
import com.hexaware.payxpert.dao.PayrollDao;
import com.hexaware.payxpert.dao.TaxDao;
import com.hexaware.payxpert.exception.DatabaseConnectionException;
import com.hexaware.payxpert.exception.EmployeeNotFoundException;
import com.hexaware.payxpert.exception.FinancialRecordException;
import com.hexaware.payxpert.exception.PayrollGenerationException;
import com.hexaware.payxpert.dao.IEmployeeDao;
import com.hexaware.payxpert.dao.IPayrollDao;
import com.hexaware.payxpert.dao.ITaxDao;

import java.time.LocalDate;
import java.util.Scanner;
/**
 * The main class for the PayXpert application.
 * This class contains the main method for executing the PayXpert application.
 */
public class PayXpertApp {

	    /**
	     * The main entry point for the PayXpert application.
	     *
	     * @param args The command line arguments (not used in this application).
	     * @throws DatabaseConnectionException If an error occurs while establishing a database connection.
	     */
	    public static void main(String[] args) throws DatabaseConnectionException {
	        Scanner scanner = new Scanner(System.in);
	        ITaxDao taxDao = new TaxDao(); 
	        ITaxService taxService = new TaxService(taxDao); // Passing TaxDao instance to TaxService constructor
	
	        IEmployeeDao employeeDao = new EmployeeDao(); 
	        IPayrollDao payrollDao = new PayrollDao(); 
	
	
	        // Instantiate services
	        IEmployeeService employeeService = new EmployeeService();
	        IPayrollService payrollService = new PayrollService(employeeDao, payrollDao);
	
		      
		        IFinancialRecordService financialRecordService = new FinancialRecordService();
	
	        do {
	        	System.out.println("**********************************************************************");
	        	System.out.println("************************* Welcome To Payxpert*************************");
	        	System.out.println("**********************************************************************");
	            System.out.println("Choose a service:");
	            System.out.println("1. EmployeeService");
	            System.out.println("2. PayrollService");
	            System.out.println("3. TaxService");
	            System.out.println("4. FinancialRecordService");
	            System.out.println("0. Exit");
	
	            int serviceChoice = scanner.nextInt();
	
	            switch (serviceChoice) {
	                case 1:
	                    performEmployeeService(employeeService, scanner);
	                    break;
	                case 2:
	                    performPayrollService(payrollService, scanner);
	                    break;
	                case 3:
	                    performTaxService(taxService, scanner);
	                    break;
	                case 4:
	                    performFinancialRecordService(financialRecordService, scanner);
	                    break;
	                case 0:
	                    System.out.println("Exiting PayXpertApp. Thank you!");
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	
	            System.out.println("Do you want to continue? (Y/N): ");
	            String choice = scanner.next();
	
	            if (!choice.equalsIgnoreCase("Y")) {
	                System.out.println("Exiting PayXpertApp. Thank you!");
	                break;
	            }
	        } while (true);
	
	        scanner.close();
	    }

	    /**
	     * Performs operations related to the EmployeeService based on user input.
	     *
	     * @param employeeService The EmployeeService instance to perform operations.
	     * @param scanner         The Scanner instance for user input.
	     * @throws DatabaseConnectionException If an error occurs while connecting to the database.
	     */	
	    private static void performEmployeeService(IEmployeeService employeeService, Scanner scanner) throws DatabaseConnectionException {
	        System.out.println("Choose operation for EmployeeService:");
	        System.out.println("1. getEmployeeById");
	        System.out.println("2. getAllEmployees");
	        System.out.println("3. addEmployee");
	        System.out.println("4. updateEmployee");
	        System.out.println("5. removeEmployee");
	
	        int operationChoice = scanner.nextInt();
	        switch (operationChoice) {
	        case 1:
	            System.out.println("Enter employeeId:");
	            int employeeId = scanner.nextInt();
	            try {
	            employeeService.getEmployeeById(employeeId);
	            }
	            catch(EmployeeNotFoundException eNFE)
	            {
	            	System.out.println("Employee with id "+employeeId+" not found");
	            }
	            break;
	        case 2:
	            employeeService.getAllEmployees();
	            break;
	        case 3:
	            employeeService.addEmployee();
	            break;
	        case 4:
	        	System.out.println("Enter employeeId:");
	            int employeeIdToUpdate = scanner.nextInt();
	            try {
	            employeeService.updateEmployee(employeeIdToUpdate);
	            }catch(EmployeeNotFoundException eNFE)
	            {
	            	System.out.println("Employee with ID " + employeeIdToUpdate + " not found.");
	            }
	            break;
	        case 5:
	            System.out.println("Enter employeeId to remove:");
	            int employeeIdToRemove = scanner.nextInt();
	            try {
	            employeeService.removeEmployee(employeeIdToRemove);
	            }catch(EmployeeNotFoundException eNFE)
	            {
	            	System.out.println("Employee with ID " + employeeIdToRemove + " not found.");
	            }
	            break;
	        default:
	            System.out.println("Invalid choice. Please enter a valid option.");
	    }
	    }
	

	    /**
	     * Performs operations related to the PayrollService based on user input.
	     *
	     * @param payrollService The PayrollService instance to perform operations.
	     * @param scanner        The Scanner instance for user input.
	     * @throws DatabaseConnectionException     If an error occurs while connecting to the database.
	     * @throws PayrollGenerationException      If an error occurs during payroll generation.
	     */
	    private static void performPayrollService(IPayrollService payrollService, Scanner scanner) throws DatabaseConnectionException {
	    	 System.out.println("Choose operation for PayrollService:");
	    	    System.out.println("1. generatePayroll");
	    	    System.out.println("2. getPayrollByPayrollId");
	    	    System.out.println("3. getPayrollsForEmployee");
	    	    System.out.println("4. getPayrollsForPeriod");
	
	    	    int operationChoice = scanner.nextInt();
	
	    	    switch (operationChoice) {
	    	    case 1:
	    	        System.out.println("Enter employeeId :");
	    	        int employeeId = scanner.nextInt();
	    	      
	    	        LocalDate startDate;
	    	        LocalDate endDate;

	    	        do {
	    	            System.out.println("Enter employee start date (yyyy-MM-dd):");
	    	            String startDateStr = scanner.next();
	    	            startDate = LocalDate.parse(startDateStr);

	    	            System.out.println("Enter employee end date (yyyy-MM-dd):");
	    	            String endDateStr = scanner.next();
	    	            endDate = LocalDate.parse(endDateStr);

	    	            if (startDate.isAfter(endDate)) {
	    	                System.out.println("End date must be after the start date. Please enter a valid end date.");
	    	            }
	    	        } while (startDate.isAfter(endDate));

	    	     
	    	        String startDateString = startDate.toString();
	    	        String endDateString = endDate.toString();

	    	        double basicSalary = 0;
	    	        System.out.println("Enter  overtimePay:");
	    	        double overtimePay = scanner.nextDouble();
	    	        System.out.println("Enter other pay:");
	    	        double otherPay = scanner.nextDouble();
	    	        System.out.println("Enter deductions:");
	    	        double deductions = scanner.nextDouble();
	    	        try {
	    	        payrollService.generatePayroll(employeeId, startDateString, endDateString, basicSalary, overtimePay, otherPay, deductions);
	    	        }catch(PayrollGenerationException pGE)
	    	        {
	    	        	System.out.println("Payroll cannot be generated");
	    	        }
	    	        break;
	    	        case 2:
	    	            System.out.println("Enter payrollId:");
	    	            int payrollId = scanner.nextInt();
	    	            payrollService.getPayrollById(payrollId);
	    	            break;
	    	        case 3:
	    	            System.out.println("Enter employeeId:");
	    	            int empIdForPayrolls = scanner.nextInt();
	    	            payrollService.getPayrollsForEmployee(empIdForPayrolls);
	    	            break;
	    	        case 4:
	    	            System.out.println("Enter startDate and endDate for the period:");
	    	            String startPeriod = scanner.next();
	    	            String endPeriod = scanner.next();
	    	            payrollService.getPayrollsForPeriod(startPeriod, endPeriod);
	    	            break;
	    	        default:
	    	            System.out.println("Invalid choice. Please enter a valid option.");
	    	    }
	    }

	    /**
	     * Performs operations related to the TaxService based on user input.
	     *
	     * @param taxService The TaxService instance to perform operations.
	     * @param scanner    The Scanner instance for user input.
	     * @throws DatabaseConnectionException If an error occurs while connecting to the database.
	     */	
	    private static void performTaxService(ITaxService taxService, Scanner scanner) throws DatabaseConnectionException {
	        System.out.println("Choose operation for TaxService:");
	        System.out.println("1. CalculateTax (Please skip this option because it is being done in database using triggers)");
	        System.out.println("2. GetTaxByTaxId");
	        System.out.println("3. GetTaxesForEmployee");
	        System.out.println("4. GetTaxesForYear");
	
	        int operationChoice = scanner.nextInt();
	
	        switch (operationChoice) {
	//            case 1:
	//                System.out.println("Enter employeeId and taxYear:");
	//                int empIdForTaxCalculation = scanner.nextInt();
	//                int taxYearForCalculation = scanner.nextInt();
	//                taxService.calculateTax(empIdForTaxCalculation, taxYearForCalculation);
	//                break;
	            case 2:
	                System.out.println("Enter taxId:");
	                int taxId = scanner.nextInt();
	                taxService.printTaxesById( taxId);
	                break;
	            case 3:
	                System.out.println("Enter employeeId:");
	                int empIdForTaxes = scanner.nextInt();
	                taxService.printTaxesByEmployeeId(empIdForTaxes);
	                break;
	            case 4:
	                System.out.println("Enter taxYear:");
	                int taxYear = scanner.nextInt();
	                taxService.printTaxesByTaxYear(taxYear);
	                break;
	            default:
	                System.out.println("Invalid choice. Please enter a valid option.");
	        }
	
	    }

	    /**
	     * Performs operations related to the FinancialRecordService based on user input.
	     *
	     * @param financialRecordService The FinancialRecordService instance to perform operations.
	     * @param scanner                The Scanner instance for user input.
	     */	
	    private static void performFinancialRecordService(IFinancialRecordService financialRecordService, Scanner scanner) {
	    	 System.out.println("Choose operation for FinancialRecordService:");
	    	    System.out.println("1. AddFinancialRecord(Please skip this option because it being done by triggers in database)");
	    	    System.out.println("2. GetFinancialRecordByRecordId");
	    	    System.out.println("3. GetFinancialRecordsForEmployee");
	    	    System.out.println("4. GetFinancialRecordsForDate");
	
	    	    int operationChoice = scanner.nextInt();
	
	    	    switch (operationChoice) {
//	    	        case 1:
//	    	            System.out.println("Enter employeeId, description, amount, and recordType:");
//	    	            int empIdForFinancialRecord = scanner.nextInt();
//	    	            String description = scanner.next();
//	    	            double amount = scanner.nextDouble();
//	    	            String recordType = scanner.next();
//	    	            financialRecordService.addFinancialRecord(empIdForFinancialRecord, description, amount, recordType);
//	    	            break;
	    	        case 2:
	    	            System.out.println("Enter recordId:");
	    	            int recordId = scanner.nextInt();
	    	            try {
	    	            financialRecordService.printFinancialRecordById(recordId);
	    	            }catch(FinancialRecordException fRE)
	    	            {
	    	            	System.out.println("No financial record found for Record ID " + recordId);
	    	            }
	    	            break;
	    	        case 3:
	    	            System.out.println("Enter employeeId:");
	    	            int empIdForFinancialRecords = scanner.nextInt();
	    	            try
	    	            {
	    	            financialRecordService.printFinancialRecordsByEmployeeId(empIdForFinancialRecords);
	    	            }catch(FinancialRecordException fRE)
	    	            {
	    	            	fRE.printStackTrace();
	    	            	//System.out.println("No financial record found for Record ID " + empIdForFinancialRecords);
	    	            }
	    	            break;
	    	        case 4:
	    	            System.out.println("Enter recordDate (in yyyy-MM-dd format):");
	    	            String recordDate = scanner.next();
	    	            try {
	    	            financialRecordService.printFinancialRecordsForDate(recordDate);
	    	            }catch(FinancialRecordException fRE)
	    	            {
	    	            	System.out.println("No financial records found for Date " + recordDate);
	    	            }
	    	            break;
	    	        default:
	    	            System.out.println("Invalid choice. Please enter a valid option.");
	    	    }
	    }
	}
