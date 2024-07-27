package tui;

import java.util.List; // Imports the List interface from java.util package for handling collections of objects
import org.w3c.dom.Text; // Imports the Text class from the org.w3c.dom package (note: not used in this code)

import controller.CustomerController; // Imports the CustomerController class for managing customers
import controller.OrderController; // Imports the OrderController class for managing orders
import model.Customer; // Imports the Customer class, a superclass for different types of customers
import model.Product; // Imports the Product class for handling product data
import model.Business; // Imports the Business class for business customers
import model.Private; // Imports the Private class for private customers
import model.Employee; // Imports the Employee class for handling employee data
import model.Order; // Imports the Order class for handling order data
import model.OrderLine; // Imports the OrderLine class for handling individual order lines

/**
 * CustomerTUI class is responsible for handling text-based user interface for managing customers.
 * 
 * The CustomerTUI class provides a text-based user interface for managing customers in a system. 
 * It interacts with the CustomerController to perform various operations like creating, 
 * updating, deleting, and listing customers. The class allows an employee to manage customer 
 * information through a simple menu-driven interface.
 * 
 */
public class CustomerTUI {
	private CustomerController customerController; // Controller for managing customers
	private Employee employee; // Current employee using the system
	private Customer customer; // Current customer being managed
	private String email; // Email of the customer

	/**
	 * Constructor initializes the CustomerController and sets the employee.
	 */
	public CustomerTUI(Employee employee) {
		// Initializes the customer controller
		customerController = new CustomerController(); 
		// Sets the current employee
		this.employee = employee; 
	}

	/**
	 * Starts and displays the customer menu loop. Allows the user to make choices until they choose to exit.
	 */
	public void start() {
		// Flag to keep the loop running
		boolean running = true; 
		while (running) {
			// Displays menu and gets user's choice
			int choice = writeCustomerMenu(); 
			if (choice == 1) {
				// Calls method to create a customer
				createCustomer(); 
			} else if (choice == 2) {
				// Calls method to update a customer
				updateCustomer(); 
			} else if (choice == 3) {
				// Calls method to delete a customer
				deleteCustomer(); 
			} else if (choice == 4) {
				// Calls method to display customer list
				customerList(); 
			} else {
				// Exits the loop
				running = false; 
			}
		}
	}

	/**
	 * Creates a customer by collecting necessary details from the user.
	 */
	private void createCustomer() {
		// Calls method to add a customer
		addCustomer(); 

		// Flag to keep adding customers
		boolean keepAdding = true; 
		while (keepAdding) {
			// Asks if the user wants to add more customers
			String addMore1 = TextInput.inputString("Ønsker du at tilføje flere kunder(Ja/Nej)"); 
			if (addMore1.equalsIgnoreCase("ja")) {
				// Calls method to add another customer
				addCustomer(); 
			} else if (addMore1.equalsIgnoreCase("nej")) {
				// Stops adding customers
				keepAdding = false; 
			} else {
				// Prompts user to provide a valid response
				System.out.println("Angiv venligst et af svarmulighederne"); 
			}
		}
		
		// Gets the current customer
		Customer customerToPrint = customerController.getCurrentCustomer(); 
		// Checks if the customer exists
		if (customerToPrint != null) { 
			// Prints customer's name
			System.out.println("Navn: " + customerToPrint.getName()); 
			// Prints customer's phone number
			System.out.println("Telefon: " + customerToPrint.getPhoneNo()); 
			// Prints customer's email
			System.out.println("Email: " + customerToPrint.getEmail()); 
			// Prints customer's address
			System.out.println("Adresse: " + customerToPrint.getAddress()); 

			// Checks if the customer is a private customer and prints specific details
			if (customerToPrint instanceof Private) {
				Private p = (Private) customerToPrint;
				System.out.println("KundeNr: " + p.getCustomerNo());
			}
			// Checks if the customer is a business customer and prints specific details
			if (customerToPrint instanceof Business) {
				Business b = (Business) customerToPrint;
				System.out.println("Firmanavn: " + b.getCompanyName());
				System.out.println("CVR: " + b.getCvr());
				System.out.println("Erhverv kundenr: " + b.getBusinessCustomerNo());
			}
		} else {
			// Prints a message if the action cannot be completed
			System.out.println("Handlingen kan ikke gennemføres."); 
		}
	}

	/**
	 * Updates customer information based on user input.
	 */
	private void updateCustomer() {
		// Prompts for current email
		String email = TextInput.inputString("Indtast kundens nuværende email: "); 
		// Finds the customer by email
		Customer customer = customerController.findCustomer(email); 
		// Prompts for the detail to change
		String replace = TextInput.inputString("Hvad ønsker du at ændre på? (email/adresse/telefon)"); 
	    // Gets current email
		String newEmail = customer.getEmail(); 
	    // Gets current address
		String newAddress = customer.getAddress(); 
	    // Gets current phone number
		String newPhoneNo = customer.getPhoneNo(); 
		if (replace.equalsIgnoreCase("email")) {
			// Prompts for new email
			newEmail = TextInput.inputString("Indtast ny email: "); 
		} else if (replace.equalsIgnoreCase("adresse")) {
			// Prompts for new address
			newAddress = TextInput.inputString("Indtast ny adresse: "); 
		} else if (replace.equalsIgnoreCase("telefon")) {
			// Prompts for new phone number
			newPhoneNo = TextInput.inputString("Indtast nyt telefonnummer: "); 
		} else {
			// Prompts for a valid response
			System.out.println("Angiv venligst et af svarmulighederne"); 
		}
		
		// Re-initializes the customer controller
		customerController = new CustomerController(); 
	    // Updates the customer
		Customer isUpdated = customerController.updateCustomer(email, newEmail, newPhoneNo, newAddress); 
	    if (isUpdated != null) {
	    	// Confirms update
	        System.out.println("Kundeoplysningerne er blevet opdateret."); 
	    } else {
	    	// Reports customer not found
	        System.out.println("Kunden blev ikke fundet."); 
	    }
	}

	/**
	 * Deletes a customer based on email input.
	 */
	private void deleteCustomer() {
		// Prompts for email
		String email = TextInput.inputString("Indtast email"); 
		// Creates a new customer controller
	    CustomerController customerController = new CustomerController(); 

	    // Deletes the customer
	    Customer isDeleted = customerController.deleteCustomer(email); 

	    if (isDeleted != null) {
	    	// Confirms deletion
	        System.out.println("Kunde med mailen " + email + " er blevet slettet."); 
	    } else {
	    	// Reports customer not found
	        System.out.println("Kunde findes ikke " + email); 
	    }
	}

	/**
	 * Displays a list of all customers.
	 */
	private void customerList() {
		// Gets a list of all customers
		List<Customer> customers = new CustomerController().findAll(); 
		// Displays the list of customers
		displayCustomers(customers); 
	}

	/**
	 * Displays the details of the provided list of customers.
	 */
	private void displayCustomers(List<Customer> customers) {
		// Prints header
		System.out.println("Kunder:"); 
		for(Customer customer : customers) {
			// Prints customer details
			System.out.printf("\tNavn: %s\tEmail: %s\tTlf: %s\tAdresse: %s", customer.getName(), customer.getEmail(), customer.getPhoneNo(),
					 customer.getAddress()); 
			if (customer instanceof Private) {
				Private p = (Private) customer;
				// Prints private customer number
				System.out.printf("\tKundeNr: %s\n", p.getCustomerNo()); 
			}
			if (customer instanceof Business) {
				Business b = (Business) customer;
				// Prints business customer details
				System.out.printf("\tFirmanavn: %s\tCVR: %s\tErhverv kundenr: %s\n", b.getCompanyName(), b.getCvr(),
						b.getBusinessCustomerNo()); 
			}
		}
	}

	/**
	 * Adds a new customer by collecting necessary details from the user.
	 */
	private void addCustomer() {
		String name = TextInput.inputString("Indtast navn"); // Prompts for name
		String email = TextInput.inputString("Indtast email"); // Prompts for email
		String phoneNo = TextInput.inputString("Indtast telefonnummer"); // Prompts for phone number
		String address = TextInput.inputString("Indtast adresse"); // Prompts for address
		String addMore = TextInput.inputString("Er det en erhverskunde? (Ja/Nej)"); // Asks if it is a business customer
		if (addMore.equalsIgnoreCase("ja")) {
			String companyName = TextInput.inputString("Indtast firmanavn"); // Prompts for company name
			String cvr = TextInput.inputString("Indtast CVR"); // Prompts for CVR number
			String businessCustomerNo = TextInput.inputString("Indtast erhverv kundenummer"); // Prompts for business customer number
		    Customer bis = new Business(name, phoneNo, email, address, companyName, cvr, businessCustomerNo); // Creates a new business customer
		    customerController.addCustomer(bis); // Adds the business customer
		    displayAddedCustomerDetails(email); // Displays added customer details
		} else {
			String customerNo = TextInput.inputString("Indtast kundeNo"); // Prompts for customer number
			Customer priv = new Private(name, phoneNo, email, address, customerNo); // Creates a new private customer
			customerController.addCustomer(priv); // Adds the private customer
			displayAddedCustomerDetails(email); // Displays added customer details
		}
	}

	/**
	 * Displays the details of the added customer.
	 */
	private void displayAddedCustomerDetails(String email) {
	    Customer addedCustomer = customerController.findCustomer(email); // Finds the added customer by email
	    if (addedCustomer != null) {	
	        System.out.println("Kunden er blevet tilføjet:"); // Confirms addition
	    } else {
	        System.out.println("Kunden blev ikke tilføjet."); // Reports addition failure
	    }
	}

	/**
	 * Displays the customer menu and gets the user's choice.
	 */
	private int writeCustomerMenu() {
		TextOptions menu = new TextOptions("\n ***** Kundemenu *****"); // Creates a new menu
		menu.addOption("Opret en kunde"); // Adds "Create a customer" option
		menu.addOption("Redigere en kunde"); // Adds "Edit a customer" option
		menu.addOption("Slet en kunde"); // Adds "Delete a customer" option
		menu.addOption("Kundeliste"); // Adds "Customer list" option
		menu.addOption("Tilbage"); // Adds "Back" option

		int choice = menu.prompt(); // Displays the menu and gets the user's choice

		return choice; // Returns the user's choice
	}
}