package test; // Declare the package name

import static org.junit.Assert.assertNotNull; // Import JUnit's assertNotNull method
import static org.junit.jupiter.api.Assertions.assertEquals; // Import JUnit's assertEquals method
import static org.junit.jupiter.api.Assertions.assertNull; // Import JUnit's assertNull method
import org.junit.jupiter.api.BeforeAll; // Import JUnit's BeforeAll annotation
import org.junit.jupiter.api.Test; // Import JUnit's Test annotation

import controller.OrderController;
import model.Business; // Import the Business class from the model package
import model.Customer; // Import the Customer class from the model package
import model.CustomerContainer; // Import the CustomerContainer class from the model package
import model.Employee; // Import the Employee class from the model package
import model.Private; // Import the Private class from the model package

/**
 * This class contains test cases for the OrderController class
 * The OrderControllerTest class is a unit test class for the OrderController class. 
 * It is designed to verify that the methods in OrderController behave correctly.
 * 
 * @version 1
 */
class OrderControllerTest {
	private static OrderController orderController; // Declare a static OrderController variable

	/**
	 * This sets the OrderController instance up before any methods
	 * used to test are executed and initializes an OrderController with a new 
	 * order and an employee
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		// Initializes the OrderController with an Employee
		orderController = new OrderController(new Employee("Ben", "23123")); 
		// Creates a new order
		orderController.createOrder(); 
	}
	
	/**
	 * This is a test method for the findAndAddCustomer method in the OrderController
	 * It will find and add a customer to the order and check if it is 
	 * the right customer.
	 */
	@Test
	public void findAndAddPrivateCustomerTest() {
		// Create a new private customer
		Customer res = new Private("Simon", "12345678", "simon@simon.dk", "Aalborg", "123"); 
		// Add the customer to the CustomerContainer
		CustomerContainer.getInstance().addCustomer(res); 
		// Find and add the customer to the order
		orderController.findAndAddCustomer("simon@simon.dk"); 
		// Assert that the customer in the order is the same as the created customer
		assertEquals(orderController.getOrder().getCustomer(), res); 
	}
	
	/**
	 * This is a test method for findAndAddCustomer method with incorrect email
	 */
	@Test
	public void findAndAddPrivateCustomerTestFail() {
		// Create a new private customer
		Customer res = new Private("Sara", "22334455", "sara@sara.dk", "Aalborg", "333"); 
		// Add the customer to the CustomerContainer
		CustomerContainer.getInstance().addCustomer(res); 
		// Try to find and add a customer with a wrong email
		orderController.findAndAddCustomer("saar@saar.dk"); 
		// This test is expected to fail as the emails do not match
		assertEquals(orderController.getOrder().getCustomer(), res); 
	}

	/**
	 * This is a test method for the findAndAddCustomer method for business customer
	 */
	@Test
	public void findAndAddBusinessCustomerTest() {
		// Create a new business customer
		Customer res = new Business("Simon", "12345678", "simon@simon.dk", "Aalborg", "1", "lol", "12345678"); 
		// Add the customer to the CustomerContainer
		CustomerContainer.getInstance().addCustomer(res); 
		// Find and add the customer to the order
		orderController.findAndAddCustomer("simon@simon.dk"); 
		// Assert that the customer in the order is the same as the created customer
		assertEquals(orderController.getOrder().getCustomer(), res); 
	}
	
	/**
	 * This is a test method for findAndAddCustomer method with incorrect email for business customer
	 */
	@Test
	public void findAndAddBusinessCustomerTestFail() {
		// Create a new business customer
		Customer res = new Business("Sara", "22334455", "sara@sara.dk", "Aalborg", "2", "stor sol", "2"); 
		// Add the customer to the CustomerContainer
		CustomerContainer.getInstance().addCustomer(res); 
		// Try to find and add a customer with a wrong email
		orderController.findAndAddCustomer("saar@saar.dk"); 
		// This test is expected to fail as the emails do not match
		assertEquals(orderController.getOrder().getCustomer(), res); 
	}
}