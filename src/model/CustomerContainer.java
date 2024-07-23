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
        customers = new ArrayList<>();  // Initializes the ArrayList that will hold Customer objects.
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
            instance = new CustomerContainer();  // Creates a new instance if one doesn't exist.
        }
        return instance;  // Returns the single instance of CustomerContainer.
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
        Customer customer = findCustomer(email);  // Finds the customer by email.
        if (customer != null) {
            customer.setEmail(updatedEmail);  // Updates the customer's email.
            customer.setPhoneNo(updatedPhoneNo);  // Updates the customer's phone number.
            customer.setAddress(updatedAddress);  // Updates the customer's address.
        }
        return customer;  // Returns the updated customer, or null if not found.
    }

    /**
     * Finds a customer by their email address.
     * 
     * @param email The email address of the customer to find.
     * @return The customer object if found, otherwise null.
     */
    public Customer findCustomer(String email) {
        Customer res = null;  // Initialize result as null.
        List<Customer> allCustomers = findAll();  // Retrieves all customers.

        for (Customer customer : allCustomers) {  // Iterates through the list of customers.
            if (customer.getEmail().equalsIgnoreCase(email)) {  // Checks if the customer's email matches.
                res = customer;  // Sets the result to the matching customer.
            }
        }
        return res;  // Returns the found customer or null if not found.
    }

    /**
     * Adds a customer to the container.
     * 
     * @param customer The customer object to add.
     * @return True if the customer was added successfully, otherwise false.
     */
    public boolean addCustomer(Customer customer) {
        boolean res = customer != null;  // Checks if the customer is not null.
        if (res) {
            customers.add(customer);  // Adds the customer to the list.
        }
        return res;  // Returns true if the customer was added, otherwise false.
    }

    /**
     * Deletes a customer from the container.
     * 
     * @param email The email of the customer to delete.
     * @return The deleted customer object, or null if not found.
     */
    public Customer deleteCustomer(String email) {
        Customer customer = findCustomer(email);  // Finds the customer to delete.
        if (customer != null) {
            customers.remove(customer);  // Removes the customer from the list.
        }
        return customer;  // Returns the deleted customer or null if not found.
    }

    /**
     * Retrieves a list of all customers.
     * 
     * @return A list containing all customers.
     */
    public List<Customer> findAll() {
        return new ArrayList<>(this.customers);  // Returns a new ArrayList containing all customers.
    }
}