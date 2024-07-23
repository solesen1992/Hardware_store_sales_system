package tui; // Defines the package this class belongs to
import java.util.ArrayList; // Imports the ArrayList class

/**
 * TextOptions class 
 * 
 * Provides a text-based menu interface for displaying options and getting user input.
 * 
 * @author knol, mhi, Gruppe 2 
 * @version 2023.15.12 
 */
public class TextOptions {
    // Declares a list to store menu options
    private ArrayList<String> options;
    // Declares a title for the menu
    private String title;
    // Declares a flag to indicate if the menu is cancellable
    private boolean cancellable;

    /**
     * Constructor for objects of TextOptions
     * 
     * @param title The title of the menu
     * @param cancelText The text for the cancel option
     */
    public TextOptions(String title, String cancelText) {
        // Initializes the options list
        options = new ArrayList<>();
        // Sets the title of the menu
        this.title = title;
        // Checks if cancelText is not null
        if (cancelText != null) {
            // Sets the cancellable flag to true
            cancellable = true;
        }
        // Adds the cancel option to the list
        addOption(cancelText);
    }

    /**
     * Overloaded constructor that takes only the title
     * 
     * @param title The title of the menu
     */
    public TextOptions(String title) {
        // Calls the main constructor with a null cancelText
        this(title, null);
    }

    /**
     * Adds an option to the options list
     * 
     * @param option The option to be added
     */
    public void addOption(String option) {
        // Adds the option to the list
        options.add(option);
    }

    /**
     * Displays the menu and prompts the user for input
     * 
     * @return The index of the chosen option
     */
    public int prompt() {
        // Prints the title of the menu
        System.out.println(title);
        // Gets the number of options
        int size = options.size();
        // Loops through each option and prints it
        for (int i = 0; i < size; i++) {
            String currentOption = options.get(i);
            if (currentOption != null) {
                // Prints the option with its index
                System.out.println(" [" + i + "]\t" + currentOption);
            }
        }
        // Variable to store the user's choice
        int choice = -1;
        // Sets the lower bound for valid choices
        int lowerBound = 0;
        // If the menu is not cancellable, the lower bound is set to 1
        if (!cancellable) {
            lowerBound = 1;
        }
        // Loops until a valid choice is made
        while (choice < lowerBound || choice >= size) {
            // Prompts the user for a number input
            choice = TextInput.inputNumber("Vælg et tal");
        }
        // Returns the user's choice
        return choice;
    }

}