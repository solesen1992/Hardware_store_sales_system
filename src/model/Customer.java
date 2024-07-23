package model;  // Declares the package where the Customer class is located.

/**
 * Customer class
 * This is an abstract class representing a general customer with basic contact information.
 * It is meant to be extended by more specific types of customers, such as Private or Business.
 * 
 * @author Gruppe 2
 * @version 1
 */
public abstract class Customer {  // Declares the Customer class as abstract, meaning it cannot be instantiated directly.
    private String name;  // Field to store the customer's name.
    private String phoneNo;  // Field to store the customer's phone number.
    private String email;  // Field to store the customer's email address.
    private String address;  // Field to store the customer's physical address.

    /**
     * Constructor for the Customer class.
     * Initializes a new Customer instance with the provided details.
     * 
     * @param name The name of the customer.
     * @param phoneNo The phone number of the customer.
     * @param email The email address of the customer.
     * @param address The physical address of the customer.
     */
    public Customer(String name, String phoneNo, String email, String address) {
        this.name = name;  // Sets the name of the customer.
        this.phoneNo = phoneNo;  // Sets the phone number of the customer.
        this.email = email;  // Sets the email address of the customer.
        this.address = address;  // Sets the physical address of the customer.
    }

    /**
     * Gets the name of the customer.
     * 
     * @return The name of the customer.
     */
    public String getName() {
        return name;  // Returns the name of the customer.
    }

    /**
     * Sets the name of the customer.
     * 
     * @param name The new name to set for the customer.
     */
    public void setName(String name) {
        this.name = name;  // Updates the name of the customer.
    }

    /**
     * Gets the phone number of the customer.
     * 
     * @return The phone number of the customer.
     */
    public String getPhoneNo() {
        return phoneNo;  // Returns the phone number of the customer.
    }

    /**
     * Sets the phone number of the customer.
     * 
     * @param phoneNo The new phone number to set for the customer.
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;  // Updates the phone number of the customer.
    }

    /**
     * Gets the email address of the customer.
     * 
     * @return The email address of the customer.
     */
    public String getEmail() {
        return email;  // Returns the email address of the customer.
    }

    /**
     * Sets the email address of the customer.
     * 
     * @param email The new email address to set for the customer.
     */
    public void setEmail(String email) {
        this.email = email;  // Updates the email address of the customer.
    }

    /**
     * Gets the physical address of the customer.
     * 
     * @return The physical address of the customer.
     */
    public String getAddress() {
        return address;  // Returns the physical address of the customer.
    }

    /**
     * Sets the physical address of the customer.
     * 
     * @param address The new address to set for the customer.
     */
    public void setAddress(String address) {
        this.address = address;  // Updates the physical address of the customer.
    }
}