package model;  // Declares the package where the CustomerContainer class is located.

import java.util.ArrayList;  // Imports the ArrayList class for use in storing customers.
import java.util.List;  // Imports the List interface to return lists of customers.

/**
 * A container for managing customers.
 * This class manages a list of customers and provides methods to add, find, update, and delete customers.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class CustomerContainer {
    private static CustomerContainer instance;  // Singleton instance of the CustomerContainer class.
    private ArrayList<Customer> customers;  // List to store Customer objects.

    /**
     * Private constructor for CustomerContainer. Initializes the 'customers' list
     * with a new ArrayList upon object creation.
     */
    public CustomerContainer() {
    	// Initializes the ArrayList that will hold Customer objects.
        customers = new ArrayList<>();  
    }

    /**
     * Retrieves or creates a single instance of the CustomerContainer. If an
     * instance doesn't exist, then a new instance is created. If an instance
     * already exists, then it is returned.
     * 
     * @return The single instance of CustomerContainer.
     */
    public static CustomerContainer getInstance() {
        if (instance == null) {
        	// Creates a new instance if one doesn't exist.
            instance = new CustomerContainer();  
        }
        // Returns the single instance of CustomerContainer.
        return instance;  
    }

    /**
     * Updates the details of an existing customer.
     * 
     * @param email The email of the customer to update.
     * @param updatedEmail The new email address.
     * @param updatedPhoneNo The new phone number.
     * @param updatedAddress The new address.
     * @return The updated customer object, or null if the customer was not found.
     */
    public Customer updateCustomer(String email, String updatedEmail, String updatedPhoneNo, String updatedAddress) {
        // Finds the customer by email.
    	Customer customer = findCustomer(email);  
        if (customer != null) {
        	// Updates the customer's email.
            customer.setEmail(updatedEmail);  
            // Updates the customer's phone number.
            customer.setPhoneNo(updatedPhoneNo);  
            // Updates the customer's address.
            customer.setAddress(updatedAddress);  
        }
        // Returns the updated customer, or null if not found.
        return customer;  
    }

    /**
     * Finds a customer by their email address.
     * 
     * @param email The email address of the customer to find.
     * @return The customer object if found, otherwise null.
     */
    public Customer findCustomer(String email) {
    	// Initialize result as null.
        Customer res = null;  
        // Retrieves all customers.
        List<Customer> allCustomers = findAll();  
        
        // Iterates through the list of customers.
        for (Customer customer : allCustomers) {  
        	// Checks if the customer's email matches.
            if (customer.getEmail().equalsIgnoreCase(email)) {  
            	// Sets the result to the matching customer.
                res = customer;  
            }
        }
        // Returns the found customer or null if not found.
        return res;  
    }

    /**
     * Adds a customer to the container.
     * 
     * @param customer The customer object to add.
     * @return True if the customer was added successfully, otherwise false.
     */
    public boolean addCustomer(Customer customer) {
    	// Checks if the customer is not null.
        boolean res = customer != null;  
        if (res) {
        	// Adds the customer to the list.
            customers.add(customer);  
        }
        // Returns true if the customer was added, otherwise false.
        return res;  
    }

    /**
     * Deletes a customer from the container.
     * 
     * @param email The email of the customer to delete.
     * @return The deleted customer object, or null if not found.
     */
    public Customer deleteCustomer(String email) {
    	// Finds the customer to delete.
        Customer customer = findCustomer(email);  
        if (customer != null) {
        	// Removes the customer from the list.
            customers.remove(customer);  
        }
        // Returns the deleted customer or null if not found.
        return customer;  
    }

    /**
     * Retrieves a list of all customers.
     * 
     * @return A list containing all customers.
     */
    public List<Customer> findAll() {
    	// Returns a new ArrayList containing all customers.
        return new ArrayList<>(this.customers);  
    }
}