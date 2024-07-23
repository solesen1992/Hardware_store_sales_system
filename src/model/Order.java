package model;  // Declares the package where the Order class is located.

import java.time.LocalDateTime;  // Importing LocalDateTime class for date and time handling.
import java.util.ArrayList;  // Importing ArrayList class to use a dynamic array for order lines.
import java.util.List;  // Importing List interface to return a list of order lines.

/**
 * Order class
 * 
 * This class models an order with details such as order number, date and time,
 * associated customer and employee, and the order lines.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class Order {
    /**
     * Instance variables of details that an Order will store
     */
    private LocalDateTime ldt;  // The date and time when the order was created.
    private String orderNo;  // The unique identifier for the order.
    private ArrayList<OrderLine> orderLines;  // List to store all the order lines associated with the order.
    private Customer customer;  // The customer who placed the order.
    private Employee employee;  // The employee who processed the order.

    /**
     * Constructor which initializes an Order object
     * Initializes the order with the current date and time, an empty list of order lines, and null references for customer and employee.
     */
    public Order() {
        this.ldt = LocalDateTime.now();  // Sets the order date and time to the current date and time.
        this.orderNo = orderNo;  // This should be corrected to properly initialize orderNo.
        this.orderLines = new ArrayList<>();  // Initializes the orderLines list as an empty ArrayList.
        this.customer = null;  // Initializes the customer reference to null.
        this.employee = null;  // Initializes the employee reference to null.
    }

    /**
     * Getter method to retrieve the Order number
     * 
     * @return The order number as a String.
     */
    public String getOrderNo() {
        return orderNo;  // Returns the current order number.
    }

    /**
     * Setter method to update the Order number
     * 
     * @param orderNo The new order number to set.
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;  // Updates the order number.
    }

    /**
     * Getter method to retrieve order time and date
     * 
     * @return The date and time of the order as a LocalDateTime object.
     */
    public LocalDateTime getLdt() {
        return ldt;  // Returns the current date and time of the order.
    }

    /**
     * Setter method to update order time and date
     * 
     * @param ldt The new date and time to set.
     */
    public void setLdt(LocalDateTime ldt) {
        this.ldt = ldt;  // Updates the order date and time.
    }

    /**
     * Getter method to retrieve the associated customer
     * 
     * @return The customer associated with the order.
     */
    public Customer getCustomer() {
        return customer;  // Returns the customer who placed the order.
    }

    /**
     * Setter method to update the associated customer
     * 
     * @param customer The new customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;  // Updates the customer associated with the order.
    }

    /**
     * Getter method to retrieve the employee
     * 
     * @return The employee associated with the order.
     */
    public Employee getEmployee() {
        return employee;  // Returns the employee who processed the order.
    }

    /**
     * Setter method to update the associated employee
     * 
     * @param employee The new employee to set.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;  // Updates the employee associated with the order.
    }

    /**
     * Method to add an order line to the ArrayList
     * 
     * @param ol The OrderLine object to add.
     */
    public void addOrderLine(OrderLine ol) {
        orderLines.add(ol);  // Adds the specified OrderLine object to the list of order lines.
    }

    /**
     * Method to calculate and return the total cost of an Order
     * Loops through each OrderLine and adds the sum of the subtotals.
     * 
     * @return The total cost of the order as a double.
     */
    public double getTotal() {
        double res = 0;  // Initializes the result variable to store the total cost.
        for (OrderLine orderline : orderLines) {  // Iterates over each OrderLine in the orderLines list.
            res = res + orderline.getSubTotal();  // Adds the subtotal of each OrderLine to the result.
        }
        return res;  // Returns the total cost of the order.
    }

    /**
     * Getter method to retrieve all order lines
     * 
     * @return A new ArrayList containing all order lines.
     */
    public List<OrderLine> getOrderLines() {
        return new ArrayList<>(orderLines);  // Returns a new ArrayList containing all the order lines.
    }
}