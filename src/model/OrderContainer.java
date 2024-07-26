package model;  // Declares the package where the OrderContainer class is located.

import java.util.ArrayList;  // Imports the ArrayList class for managing a dynamic list of orders.

/**
 * A container class for managing orders.
 * 
 * This class acts as a singleton container to manage a collection of orders. It allows
 * adding new orders, assigning unique order numbers, and provides a way to access 
 * a single instance of the container.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class OrderContainer {
    private ArrayList<Order> orders;  // List to store all orders in the container.
    private static OrderContainer instance;  // Static variable to hold the single instance of OrderContainer.
    private int nextOrderNo;  // The next order number to be assigned.

    /**
     * Constructor to initialize the orders list.
     * 
     * Initializes the orders list as an empty ArrayList and sets the nextOrderNo to 1000000.
     * The constructor is private to enforce singleton pattern.
     */
    private OrderContainer() {
    	// Sets the initial value for the next order number.
        this.nextOrderNo = 1000000;  
        // Initializes the orders list as a new ArrayList.
        orders = new ArrayList<>();  
    }

    /**
     * Retrieves or creates a single instance of the OrderContainer. If an instance
     * doesn't exist, it is created. If an instance already exists, it is returned.
     * 
     * @return The singleton instance of OrderContainer.
     */
    public static OrderContainer getInstance() {
        if (instance == null) {
        	// Creates a new instance if one does not exist.
            instance = new OrderContainer();  
        }
        // Returns the singleton instance.
        return instance;  
    }

    /**
     * Adds an order to the container. It returns true when the order is added.
     * 
     * @param order The Order object to add to the container.
     * @return True if the order was added successfully.
     */
    public boolean addOrder(Order order) {
    	// Adds the provided Order object to the list of orders.
        orders.add(order);  
        // Sets a unique order number to the order and increments the nextOrderNo.
        order.setOrderNo("" + nextOrderNo++);  
        // Returns true to indicate that the order was added successfully.
        return true;  
    }
}