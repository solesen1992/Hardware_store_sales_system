package test; // Declare the package name

import static org.junit.jupiter.api.Assertions.*; // Import assertions from JUnit
import model.Business; // Import the Business class from the model package
import model.Customer; // Import the Customer class from the model package
import model.Private; // Import the Private class from the model package
import model.CustomerContainer; // Import the CustomerContainer class from the model package
import org.junit.jupiter.api.AfterAll; // Import JUnit's AfterAll annotation
import org.junit.jupiter.api.AfterEach; // Import JUnit's AfterEach annotation
import org.junit.jupiter.api.BeforeAll; // Import JUnit's BeforeAll annotation
import org.junit.jupiter.api.BeforeEach; // Import JUnit's BeforeEach annotation
import org.junit.jupiter.api.Test; // Import JUnit's Test annotation

import controller.CustomerController;

/**
 * The CustomerControllerTest class is a JUnit test class that tests the functionality 
 * of the CustomerController class. This class contains several methods annotated with 
 * @Test, @BeforeAll, @BeforeEach, and @AfterEach to set up and clean up the test 
 * environment before and after each test case. The tests cover creating, updating, 
 * finding, deleting, and getting the current customer.
 * */

class CustomerControllerTest {
	private CustomerController customerController; // Declare a private variable for CustomerController
	
	// This method is executed once before all tests in the class
	@BeforeAll
	static void setUpBeforeClass() throws Exception {	
	}
	
	// This method is executed before each test in the class
	@BeforeEach
	void setUp() throws Exception {
		// Get the singleton instance of CustomerContai
		CustomerContainer container = CustomerContainer.getInstance();

		// Create a private customer
		Customer privateCustomer = new Private("Private Customer", "Private Phone", "private@example.com",
				"Private Address", "PrivateCustomerNo");
		
		// Create a business customer
		Customer businessCustomer = new Business("Business Customer", "Business Phone", "business@example.com",
				"Business Address", "Business Company", "Business CVR", "BusinessCustomerNo");

		// Add the private customer to the container
		container.addCustomer(privateCustomer);
		
		// Add the business customer to the container
		container.addCustomer(businessCustomer);

		// Initialize the CustomerController
		customerController = new CustomerController();
	}

	@Test
	void testCustomerController() {
		// Placeholder test, which currently fails
		fail("Not yet implemented"); 
	}
	
	// Test finding a private customer
	@Test
	void testFindCustomer() {
		Customer privateCustomer = customerController.findCustomer("private@example.com");
		// Assert that the private customer is found
		assertNotNull(privateCustomer); 
		// Assert that the name is correct
		assertEquals("Private Customer", privateCustomer.getName()); 

		// Test finding a business customer
		Customer businessCustomer = customerController.findCustomer("business@example.com");
		// Assert that the business customer is found
		assertNotNull(businessCustomer); 
		// Assert that the name is correct
		assertEquals("Business Customer", businessCustomer.getName()); 

		// Test finding a non-existent customer
		Customer nonExistentCustomer = customerController.findCustomer("nonexistent@example.com");
		// Assert that the customer is not found
		assertNull(nonExistentCustomer); 
	}
	
	// Test updating a private customer
	@Test
	void testUpdateCustomer() {
		Customer privateCustomer = customerController.findCustomer("private@example.com");
		// Assert that the private customer is found
		assertNotNull(privateCustomer); 

		Customer updatedPrivateCustomer = customerController.updateCustomer("private@example.com", "Updated Private Name", "Updated Private Phone", "Updated Private Address");
		// Assert that the private customer is updated
		assertNotNull(updatedPrivateCustomer); 
		// Assert that the name is updated
		assertEquals("Updated Private Name", updatedPrivateCustomer.getName()); 

		// Test updating a business customer
		Customer businessCustomer = customerController.findCustomer("business@example.com");
		// Assert that the business customer is found
		assertNotNull(businessCustomer); 

		Customer updatedBusinessCustomer = customerController.updateCustomer("business@example.com", "Updated Business Name", "Updated Business Phone", "Updated Business Address");
		// Assert that the business customer is updated
		assertNotNull(updatedBusinessCustomer); 
		// Assert that the name is updated
		assertEquals("Updated Business Name", updatedBusinessCustomer.getName()); 
	}
	
	// Test deleting a private customer
	@Test
	void testDeleteCustomer() {
		
		Customer privateCustomer = customerController.findCustomer("private@example.com");
		// Assert that the private customer is found
		assertNotNull(privateCustomer); 

		Customer deletedPrivateCustomer = customerController.deleteCustomer("private@example.com");
		// Assert that the private customer is deleted
		assertNull(deletedPrivateCustomer); 
		
		// Assert that the private customer cannot be found after deletion
		assertNull(customerController.findCustomer("private@example.com"));

		// Test deleting a business customer
		Customer businessCustomer = customerController.findCustomer("business@example.com");
		// Assert that the business customer is found
		assertNotNull(businessCustomer); 

		Customer deletedBusinessCustomer = customerController.deleteCustomer("business@example.com");
		// Assert that the business customer is deleted
		assertNull(deletedBusinessCustomer); 
		
		// Assert that the business customer cannot be found after deletion
		assertNull(customerController.findCustomer("business@example.com"));
	}

	/**
	 * Test for adding a customer
	 * */
	@Test
	void testAddCustomer() {
		// Create a new private customer
		Customer newPrivateCustomer = new Private("New Private Customer", "Private Phone", "newprivate@example.com", "Private Address", "PrivateCustomerNo");
		
		// Create a new business customer
		Customer newBusinessCustomer = new Business("New Business Customer", "Business Phone", "newbusiness@example.com", "Business Address", "Business Company", "Business CVR", "BusinessCustomerNo");

		// Test adding a new private customer
		assertTrue(customerController.addCustomer(newPrivateCustomer));
		
		// Test adding a new business customer
		assertTrue(customerController.addCustomer(newBusinessCustomer));

		// Assert that the new private customer can be found
		Customer addedPrivateCustomer = customerController.findCustomer("newprivate@example.com");
		assertNotNull(addedPrivateCustomer);
		assertEquals("New Private Customer", addedPrivateCustomer.getName());

		// Assert that the new business customer can be found
		Customer addedBusinessCustomer = customerController.findCustomer("newbusiness@example.com");
		assertNotNull(addedBusinessCustomer);
		assertEquals("New Business Customer", addedBusinessCustomer.getName());
	}

	/**
	 * Test getting the current customer
	 * */
	@Test
	void testGetCurrentCustomer() {
		// Test getting the current customer when no customer is selected
		Customer currentCustomer = customerController.getCurrentCustomer();
		// Assert that the current customer is null
		assertNull(currentCustomer); 

		// Test finding and setting a private customer as the current customer
		Customer privateCustomer = customerController.findCustomer("private@example.com");

		currentCustomer = customerController.getCurrentCustomer();
		// Assert that the current customer is not null
		assertNotNull(currentCustomer); 
		// Assert that the name is correct
		assertEquals("Private Customer", currentCustomer.getName()); 
	}
}