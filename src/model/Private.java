package model;  // Declares the package where the Private class is located.

/**
 * Private class that extends the Customer class to represent private customers.
 * This class adds an additional attribute specific to private customers: customer number.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class Private extends Customer {
    private String customerNo;  // Unique customer number specific to private customers.

    /**
     * Constructor to initialize a Private customer object.
     * 
     * @param name The name of the private customer.
     * @param phoneNo The phone number of the private customer.
     * @param email The email address of the private customer.
     * @param address The address of the private customer.
     * @param customerNo The unique customer number for the private customer.
     */
    public Private(String name, String phoneNo, String email, String address, String customerNo) {
        super(name, phoneNo, email, address);  // Calls the constructor of the superclass (Customer) to initialize the common attributes.
        this.customerNo = customerNo;  // Sets the unique customer number for the private customer.
        // TODO Auto-generated constructor stub  // This is a placeholder comment, typically used by IDEs to indicate that the constructor was auto-generated.
    }

    /**
     * Getter method to retrieve the unique customer number.
     * 
     * @return The customer number of the private customer.
     */
    public String getCustomerNo() {
        return customerNo;  // Returns the unique customer number.
    }

    /**
     * Setter method to update the unique customer number.
     * 
     * @param customerNo The new customer number to set.
     */
    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;  // Updates the unique customer number.
    }
}