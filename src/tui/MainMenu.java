package tui; // Defines the package this class belongs to
import tryme.TryMe; // Imports the TryMe class
import model.Employee; // Imports the Employee class

/**
 * MainMenu class which represents the main entry point of the system.
 * Serves as the main entry point of the system, providing a user interface 
 * for interacting with the application.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class MainMenu {
    // Declares instance variables for OrderTUI, CustomerTUI, and Employee
	private OrderTUI orderTUI;
	private CustomerTUI customerTUI;
	private Employee employee;

	/**
	 * The main method is the entry point of the program.
	 */
	public static void main(String[] args) {
        // Creates an instance of MainMenu with a new Employee object
		MainMenu menu = new MainMenu(new Employee("Maria", "11234"));
        // Starts the menu
		menu.start();
	}

	/**
	 * Constructor that initializes the OrderTUI and CustomerTUI instances.
	 */
	public MainMenu(Employee employee) {
        // Initializes orderTUI with the provided employee
		orderTUI = new OrderTUI(employee);
        // Initializes customerTUI with the provided employee
		customerTUI = new CustomerTUI(employee);
        // Sets the employee instance variable
		this.employee = employee;
	}

	/**
	 * Starts the main menu loop. Allows the user to make a choice until choosing to
	 * exit. Calls other methods based on user choices.
	 */
	public void start() {
        // Variable to control the loop
		boolean exit = false;
        // Loop until the user decides to exit
		while (!exit) {
            // Displays the main menu and gets the user's choice
			int choice = writeMainMenu();
            // If the user chooses option 2, print a not implemented message
			if (choice == 2) {
				System.out.println("Denne er endnu ikke implementeret");
            // If the user chooses option 1, start the orderTUI
			} else if (choice == 1) {
				orderTUI.start();
            // If the user chooses option 3, start the customerTUI
			} else if (choice == 3) {
				customerTUI.start();
            // If the user chooses option 4, generate test data
			} else if (choice == 4) {
				TryMe.generateTestData();
				System.out.println("Test data er genereret");
            // If the user chooses any other option, exit the loop
			} else {
				writeEnd();
				exit = true;
			}
		}
	}

	/**
	 * Creates and displays the main menu options. Uses TextOptions. Returns the
	 * user's choice based on the displayed menu.
	 */
	private int writeMainMenu() {
        // Creates a new TextOptions menu with the title "****Hovedmenu****" and the option "Afslut programmet"
		TextOptions menu = new TextOptions("\n ****Hovedmenu****", "Afslut programmet");
        // Adds the option "Ordremenu" to the menu
		menu.addOption("Ordremenu");
        // Adds the option "Produktmenu" to the menu
		menu.addOption("Produktmenu");
        // Adds the option "Kundemenu" to the menu
		menu.addOption("Kundemenu");
        // Adds the option "Generer testdata" to the menu
		menu.addOption("Generer testdata");
        // Prompts the user to choose an option and returns the choice
		return menu.prompt();
	}

	/**
	 * Prints a "the end" message when the user chooses to exit the program.
	 */
	private void writeEnd() {
        // Prints a farewell message to the console
		System.out.println("Tak for denne gang");
	}
}