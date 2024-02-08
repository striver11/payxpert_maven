package com.hexaware.payxpert.model;

import java.util.Date;

/**
 * The Employee class represents an individual employee in the system.
 * It contains various details such as personal information, contact details,
 * position, and employment dates.
 */
public class Employee {
    private int employeeID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String position;
    private Date joiningDate;
    private Date terminationDate;

    /**
     * Default constructor for the Employee class.
     */
    public Employee() {
        // Default constructor
    }

    /**
     * Parameterized constructor to create an Employee with specific details.
     *
     * @param employeeID      The unique identifier for the employee.
     * @param firstName       The first name of the employee.
     * @param lastName        The last name of the employee.
     * @param dateOfBirth     The date of birth of the employee.
     * @param gender          The gender of the employee.
     * @param email           The email address of the employee.
     * @param phoneNumber     The phone number of the employee.
     * @param address         The address of the employee.
     * @param position        The position or job title of the employee.
     * @param joiningDate     The date when the employee joined the company.
     * @param terminationDate The date when the employee was terminated (if applicable).
     */
    public Employee(int employeeID, String firstName, String lastName, Date dateOfBirth, String gender,
                    String email, String phoneNumber, String address, String position, Date joiningDate,
                    Date terminationDate) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.position = position;
        this.joiningDate = joiningDate;
        this.terminationDate = terminationDate;
    }

   

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }
    
    /**
     * Returns a string representation of the Employee object.
     *
     * @return A string containing the details of the employee.
     */
    
    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", joiningDate=" + joiningDate +
                ", terminationDate=" + terminationDate +
                '}';
    }
}
