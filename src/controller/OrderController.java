package controller; // Specifies the package this class belongs to

import model.Customer; // Imports the Customer class from the model package
import model.Employee; // Imports the Employee class from the model package
//import model.ProductCopy; // Imports the ProductCopy class from the model package (commented out)
import model.Order; // Imports the Order class from the model package
import model.OrderContainer; // Imports the OrderContainer class from the model package
import model.Product; // Imports the Product class from the model package
import model.ProductCopy; // Imports the ProductCopy class from the model package
import model.SimpleProduct; // Imports the SimpleProduct class from the model package
import model.UniqueProduct; // Imports the UniqueProduct class from the model package
import model.OrderLine; // Imports the OrderLine class from the model package

/**
 * OrderController class
 * The OrderController class in the provided code serves as a controller, 
 * managing order-related operations within an application. This class acts as an intermediary 
 * between the view layer (user interface) and the model layer (data and business logic), 
 * handling the creation, manipulation, and completion of orders.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class OrderController {
	// Declares a CustomerController instance variable
    private CustomerController customerController; 
    // Declares a ProductController instance variable
    private ProductController productController; 
 // Declares an Order instance variable
    private Order order; 
    // Declares an Employee instance variable
    private Employee employee; 

    /**
     * The constructor for OrderController which initializes the controllers that
     * are used and an employee
     * 
     * @param employee The employee associated with this order
     */
    public OrderController(Employee employee) {
    	// Initializes the customerController
        customerController = new CustomerController(); 
        // Initializes the productController
        productController = new ProductController(); 
        // Sets the employee for this controller
        this.employee = employee; 
        // Initializes the order to null
        this.order = null; 
    }

    /**
     * This method creates a new order and returns it
     * 
     * @return The newly created order
     */
    public Order createOrder() {
    	// Creates a new Order object
        order = new Order(); 
        // Returns the new Order object
        return order; 
    }

    /**
     * This method creates an OrderLine for the given product and quantity
     * 
     * @param product The product to be added to the order line
     * @param quantity The quantity of the product
     * @return The newly created OrderLine object
     */
    private OrderLine createOrderLine(Product product, int quantity) {
    	// Creates a new OrderLine object
        OrderLine orderLine = new OrderLine(quantity, product); 
        // Returns the OrderLine object
        return orderLine; 
    }

    /**
     * This method finds customer from CustomerController and adds it to the order
     * 
     * @param email The email of the customer to find
     * @return The found Customer object
     */
    public Customer findAndAddCustomer(String email) {
    	// Finds the customer by email
        Customer customer = customerController.findCustomer(email); 
        // If customer is found
        if (customer != null) { 
        	// Adds the customer to the order
            setCustomerToOrder(customer); 
        }
        // Returns the customer
        return customer; 
    }
    
    /**
     * This method only finds and returns the product based on the barcode, without adding it to the order
     * 
     * @param barcode The barcode of the product to find
     * @return The found Product object
     */
    public Product findProduct(String barcode) {
    	// Finds and returns the product by barcode
        return productController.findProduct(barcode);
    }

    /**
     * This method calls the method findProduct from productController using
     * barcode. Then it checks if the product is an instance of SimpleProduct class
     * and is not null. If the condition is true, it will create an OrderLine ol
     * object by calling the createOrderLine method with res and quantity as
     * argument. It will then add this Orderline object to order object. After that,
     * it checks if the product is an instance of UniqueProduct. If this condition
     * is true, then it will create another OrderLine ol object with res and
     * quantity as argument. It will then add this Orderline object to order object.
     * 
     * @param barcode The barcode of the product to find
     * @param quantity The quantity of the product
     * @return The found Product object
     */
    public Product findAndAddProduct(String barcode, int quantity) {
    	// Finds the product by barcode
        Product product = productController.findProduct(barcode); 
     // If product is an instance of SimpleProduct and not null
        if (product instanceof SimpleProduct && product != null) { 
        	// Creates an OrderLine for the product
            OrderLine orderLine = createOrderLine(product, quantity); 
            // Adds the OrderLine to the order
            order.addOrderLine(orderLine); 
        }
        // If product is an instance of UniqueProduct and not null
        if (product instanceof UniqueProduct && product != null) { 
        	// Creates another OrderLine for the product
            OrderLine ol1 = createOrderLine(product, quantity); 
            // Adds the OrderLine to the order
            order.addOrderLine(ol1); 
        }
        // Returns the product
        return product; 
    }

    /**
     * This method sets productCopy to order and the method is called from class
     * productController.
     * 
     * @param serialNo The serial number of the product copy
     * @param uniqueProduct The unique product to which the product copy belongs
     * @return The found ProductCopy object
     */
    public ProductCopy findAndAddProductCopy(String serialNo, UniqueProduct uniqueProduct) {
    	// Finds the product copy by serial number and unique product
        ProductCopy res = productController.findProductCopy(serialNo, uniqueProduct);
        // If product copy is found
        if (res != null) { 
        	// Sets the product copy to the order
            setProductCopyToOrder(res); 
        }
        // Returns the product copy
        return res; 
    }

    /**
     * This method accesses the order object and retrieves the list of OrderLines and
     * the last OrderLine object from the list by using
     * order.getOrderLines().size()-1. Then it calls the setProductCopy on the
     * retrieved OrderLine object.
     * 
     * @param productCopy The product copy to set to the order line
     */
    private void setProductCopyToOrder(ProductCopy productCopy) {
    	// Sets the product copy to the last OrderLine in the order
        order.getOrderLines().get(order.getOrderLines().size() - 1).setProductCopy(productCopy); 
    }

    /**
     * This method sets a customer to the current order
     * 
     * @param customer The customer to set to the order
     */
    private void setCustomerToOrder(Customer customer) {
    	// Sets the customer to the order
        order.setCustomer(customer); 
    }

    /**
     * This method returns the current order
     * 
     * @return The current Order object
     */
    public Order getOrder() {
    	// Returns the current order
        return order; 
    }

    /**
     * This method completes the order and adds it to the container. This Order will
     * persist in OrderContainer and order is set to null.
     * 
     * @return The completed Order object
     */
    public Order completeOrder() {
        Order res;
        // Checks if the order has a customer and order lines
        if (order.getCustomer() != null && !order.getOrderLines().isEmpty()) { 
        	// Adds the order to the OrderContainer
            OrderContainer.getInstance().addOrder(order); 
            // Sets the employee to the order
            order.setEmployee(employee); 
            // Assigns the order to the result
            res = order; 
            // Sets the current order to null
            order = null; 
        } else {
        	// If conditions are not met, sets the result to null
            res = null; 
        }
        // Returns the result
        return res; 
    }
}