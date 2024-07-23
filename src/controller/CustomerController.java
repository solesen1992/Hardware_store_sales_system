package controller; // Specifies the package this class belongs to

import java.util.List; // Imports the List interface from the java.util package

import model.Customer; // Imports the Customer class from the model package
import model.CustomerContainer; // Imports the CustomerContainer class from the model package
import model.Product; // Imports the Product class from the model package
import model.ProductContainer; // Imports the ProductContainer class from the model package

/**
 * CustomerController class. The CustomerController class serves as a controller.
 * This class acts as an intermediary between the view layer (user interface) and 
 * the model layer (data and business logic) and provides methods for performing 
 * CRUD (Create, Read, Update, Delete) operations on customer data.
 * 
 * @author Gruppe 2
 * @version 1
 */

public class CustomerController {
    // Declaration of a private instance variable to hold the current customer
    private Customer currentCustomer;

    /**
     * The constructor for the CostumerController which initializes the
     * Customer
     */
    public CustomerController() {
        // Initializes the currentCustomer to null
        this.currentCustomer = null;
    }

    /**
     * This method finds customer by their email in the CustomerContainer
     * 
     * @param email The email of the customer to find
     * @return The found Customer object, or null if not found
     */
    public Customer findCustomer(String email) {
        // Calls the findCustomer method of CustomerContainer and assigns the result to foundCustomer
        Customer foundCustomer = CustomerContainer.getInstance().findCustomer(email);
        // If a customer is found, sets currentCustomer to the found customer
        if (foundCustomer != null) {
            currentCustomer = foundCustomer;
        }
        // Returns the found customer
        return foundCustomer;
    }

    /**
     * Updates an existing customer's information.
     * 
     * @param email The email of the customer to update
     * @param updatedEmail The new email to update
     * @param updatedPhoneNo The new phone number to update
     * @param updatedAddress The new address to update
     * @return The updated Customer object if the update was successful, otherwise null.
     */
    public Customer updateCustomer(String email, String updatedEmail, String updatedPhoneNo, String updatedAddress) {
        // Calls the updateCustomer method of CustomerContainer and updates currentCustomer with the result
        currentCustomer = CustomerContainer.getInstance().updateCustomer(email, updatedEmail, updatedPhoneNo, updatedAddress);
        // Returns the updated customer
        return currentCustomer;
    }

    /**
     * Deletes a customer by email.
     * 
     * @param email The email of the customer to delete
     * @return The deleted Customer object if the deletion was successful, otherwise null.
     */
    public Customer deleteCustomer(String email) {
        // Calls the deleteCustomer method of CustomerContainer and returns the result
        return CustomerContainer.getInstance().deleteCustomer(email);
    }

    /**
     * Adds an existing customer to the ArrayList 'customers' in CustomerContainer.
     * The customer must exist before you can add it to the ArrayList. If the
     * customer doesn't exist, it doesn't add anything.
     * 
     * @param customer The customer to be added.
     * @return True if the customer was added successfully, false otherwise.
     */
    public boolean addCustomer(Customer customer) {
        // Calls the addCustomer method of CustomerContainer and returns the result
        return CustomerContainer.getInstance().addCustomer(customer);
    }

    /**
     * Getter for the currentCustomer
     * 
     * @return The current customer
     */
    public Customer getCurrentCustomer() {
        // Returns the currentCustomer
        return currentCustomer;
    }
    
    /**
     * Finds all customers in the CustomerContainer.
     * 
     * @return A list of all customers
     */
    public List<Customer> findAll() {
        // Calls the findAll method of CustomerContainer and returns the result
        return CustomerContainer.getInstance().findAll();
    }
}