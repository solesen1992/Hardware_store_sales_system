package tui; // Defines the package this class belongs to
import java.util.Scanner; // Imports the Scanner class

/**
 * TextInput class 
 * 
 * Provides methods for getting user input from the console.
 * 
 * @version 0.0.2 initial draft version
 * @authors Istvan Knoll, Mogens Holm Iversen, Gruppe 2 
 */
public class TextInput {
    // No instance variables are declared in this class

    /**
     * Constructor for objects of TextInput
     */
    public TextInput() {
        // Empty constructor since no initialization is required for this class
    }
    
    /**
     * This method asks the user a question and reads the input.
     * It shows an error message if the user's input is not valid.
     * 
     * @param question The question to ask the user
     * @return The number input by the user
     */
    public static int inputNumber(String question) {
        // Creates a Scanner object to read input from the keyboard
        Scanner keyboard = new Scanner(System.in);
        // Initializes the number variable
        int number = 0;
        // Prints the question to the user
        printQuesiton(question);
        // Loops until a valid integer is entered
        while (!keyboard.hasNextInt()) {
            // Prints an error message if the input is not an integer
            System.out.println("Input skal være et tal - prøv igen");
            // Clears the invalid input
            keyboard.nextLine();
        }
        // Reads the valid integer input
        number = keyboard.nextInt();
        // Returns the integer input
        return number;
    }
    
    /**
     * This method asks the user a question and returns the input as a string.
     * 
     * @param question The question to ask the user
     * @return The string input by the user
     */
    public static String inputString(String question) {
        // Creates a Scanner object to read input from the keyboard
        Scanner keyboard = new Scanner(System.in);
        // Prints the question to the user
        printQuesiton(question);
        // Reads and returns the input as a string
        return keyboard.nextLine();
    }
    
    /**
     * This method prints the question out in the console.
     * 
     * @param question The question to be printed
     */
    private static void printQuesiton(String question) {
        // Prints the question to the console
        System.out.print(" " + question + ": ");
    }
}