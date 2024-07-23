package model;  // Declares the package where the Employee class is located.

import java.util.ArrayList;  // Import statements are not needed here, but could be relevant in other parts of the project.

/**
 * Employee class
 * This class models an employee with basic information including name and employee number.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class Employee {
    private String name;  // Private attribute to store the name of the employee.
    private String employeeNo;  // Private attribute to store the employee number.

    /**
     * Constructor for the class.
     * Initializes the Employee object with the provided name and employee number.
     * 
     * @param name The name of the employee.
     * @param employeeNo The employee number.
     */
    public Employee(String name, String employeeNo) {
        this.name = name;  // Sets the name of the employee.
        this.employeeNo = employeeNo;  // Sets the employee number.
    }

    /**
     * Sets the name of the employee.
     * 
     * @param name The new name of the employee.
     */
    public void setName(String name) {
        this.name = name;  // Updates the name of the employee.
    }

    /**
     * Returns the employee's name.
     * 
     * @return The current name of the employee.
     */
    public String getName() {
        return name;  // Retrieves the name of the employee.
    }

    /**
     * Sets the employee number.
     * 
     * @param employeeNo The new employee number.
     */
    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;  // Updates the employee number.
    }

    /**
     * Returns the employee number.
     * 
     * @return The current employee number.
     */
    public String getEmployeeNo() {
        return employeeNo;  // Retrieves the employee number.
    }
}