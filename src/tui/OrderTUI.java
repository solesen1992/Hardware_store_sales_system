package tui; // Defines the package this class belongs to

import java.util.List; // Imports the List interface

import org.w3c.dom.Text; // Imports the Text interface (not used in the code)

import controller.OrderController; // Imports the OrderController class
import model.Order; // Imports the Order class
import model.OrderLine; // Imports the OrderLine class
import model.Product; // Imports the Product class
import model.ProductCopy; // Imports the ProductCopy class
import model.SimpleProduct; // Imports the SimpleProduct class
import model.UniqueProduct; // Imports the UniqueProduct class
import model.Employee; // Imports the Employee class

/**
 * Start menu for managing orders. Text-based user interface.
 * Provides a text-based user interface for managing orders.
 */

public class OrderTUI {
    private OrderController orderController; // Declares an instance of OrderController
    private Employee employee; // Declares an instance of Employee

    /**
     * Constructor that initializes the OrderController instance.
     */
    public OrderTUI(Employee employee) {
    	// Initializes the OrderController with the given employee
        orderController = new OrderController(employee); 
        // Assigns the given employee to the employee instance variable
        this.employee = employee; 
    }

    /**
     * Starts and displays the order menu loop. Allows the user to make choices
     * until choosing to exit the program. Calls other methods based on user
     * choices.
     */
    public void start() {
    	// Sets a flag to control the loop
        boolean running = true; 
        // Loops until the flag is set to false
        while (running) { 
        	// Displays the order menu and gets the user's choice
            int choice = writeOrderMenu(); 
            // If the user chooses to create an order
            if (choice == 1) { 
            	// Calls the createOrder method
                createOrder(); 
              // If the user chooses to exit
            } else { 
            	// Sets the flag to false to exit the loop
                running = false; 
            }
        }
    }

    /**
     * Creates an order by using the OrderController. Happens when the user has
     * clicked on "order menu". The user now has to give necessary information.
     * The user adds the product's barcode and the product gets added to the order.
     * The user adds the customer's email and the customer gets added to the order.
     * Completes the order. If both the order and customer exist, then it prints the
     * order details. Otherwise, the order gets cancelled.
     */
    private void createOrder() {
    	// Creates a new order using the OrderController
        orderController.createOrder(); 
        // Calls the addProduct method to add a product to the order
        addProduct(); 

        // This boolean asks the user if they want to add more products to the order.
        boolean keepAdding = true;
        // Loops until the user decides to stop adding products
        while (keepAdding) { 
        	// Asks the user if they want to add more products
            String addMore1 = TextInput.inputString("Ønsker du at tilføje flere produkter(Ja/Nej)"); 
            // If the user wants to add more products
            if (addMore1.equalsIgnoreCase("ja")) { 
                // Calls the addProduct method
            	addProduct(); 
            	// If the user does not want to add more products
            } else if (addMore1.equalsIgnoreCase("nej")) { 
            	// Sets the flag to false to exit the loop
                keepAdding = false; 
            } else {
            	// Asks the user to provide a valid answer
                System.out.println("Angiv venligst et af svarmulighederne"); 
            }
        }

        // Asks the user to input the customer's email
        String email = TextInput.inputString("Indtast kundens email"); 
        // Finds and adds the customer to the order using the email
        orderController.findAndAddCustomer(email); 

        // Completes the order and gets the order details
        Order orderToPrint = orderController.completeOrder(); 
        // If the order exists
        if (orderToPrint != null) { 
        	// If the customer exists
            if (orderToPrint.getCustomer() != null) { 
            	// Prints the customer's name
                System.out.println("Kunde: " + orderToPrint.getCustomer().getName()); 
            }
            // Gets the list of order lines
            List<OrderLine> ols = orderToPrint.getOrderLines(); 
            // Prints the employee's name
            System.out.println("Medarbejder: " + orderToPrint.getEmployee().getName()); 
            // Prints the order number
            System.out.println("Ordrenummer: " + orderToPrint.getOrderNo()); 
            // Prints the order date
            System.out.println("Dato: " + orderToPrint.getLdt()); 
            // Iterates over the order lines
            for (OrderLine ol : ols) { 
            	// Gets the product in the order line
                Product p = ol.getProduct(); 
                // Gets the product copy in the order line
                ProductCopy pc = ol.getProductCopy(); 
                // If the product exists
                if (p != null) { 
                	// Prints the product name
                    System.out.println("Navn på produkt: " + p.getName()); 
                    // Prints the product price
                    System.out.println("Pris pr. stk.: " + p.getPrice()); 
                    // Prints the product type
                    System.out.println("Produkt type: " + p.getType()); 

                    /**
                     * If the product is an instance of SimpleProduct, then PackageSize will get
                     * printed. If the product is an instance of UniqueProduct, then Warranty and
                     * SerialNo will be printed.
                     */
                    // If the product is a SimpleProduct
                    if (p instanceof SimpleProduct) { 
                    	// Casts the product to SimpleProduct
                        SimpleProduct sp = (SimpleProduct) p; 
                     // Prints the package size
                        System.out.println("Pakkestørrelse: " + sp.getPackageSize()); 
                    // If the product is a UniqueProduct
                    } else if (p instanceof UniqueProduct) { 
                    	// Casts the product to UniqueProduct
                        UniqueProduct up = (UniqueProduct) p; 
                        // Prints the warranty
                        System.out.println("Garanti: " + up.getWarranty()); 
                        // If the product copy exists
                        if (ol.getProductCopy() != null) { 
                        	// Prints the serial number
                            System.out.println("SerieNummer: " + pc.getSerialNo()); 
                        }
                    }
                    // Prints the quantity
                    System.out.println("Antal: " + ol.getQuantity()); 
                } else {
                	// Prints an error message if the order cannot be completed
                    System.out.println("ordren kan ikke gennemføres."); 
                }
            }
            // Prints the total price
            System.out.println("Pris i alt: " + orderToPrint.getTotal()); 
        }
    }

    /**
     * This method prompts the user to input a barcode and then asks the user whether
     * it is a unique product or not. If the answer is yes, then it prompts the user
     * to input a serial number. Then it will call the findAndAddProduct from
     * OrderController, passing the serial number and typecasted to UniqueProduct as
     * arguments. If the answer is no, then it prompts the user to input quantity.
     * It then will call the findAndAddProduct from OrderController, passing the
     * barcode and quantity as arguments.
     */
    private void addProduct() {
    	// Prompts the user to input a barcode
        String barcode = TextInput.inputString("Indtast stregkode"); 
        // Finds the product using the barcode
        Product p = orderController.findProduct(barcode); 
        // If the product is a UniqueProduct
        if (p instanceof UniqueProduct) { 
        	// Casts the product to UniqueProduct
            UniqueProduct uniqueProduct = (UniqueProduct) p; 
            // Prompts the user to input a serial number
            String serialNo = TextInput.inputString("Indtast serienummer"); 
            // Checks if the serial number is valid
            if (uniqueProduct.isValidSerialNumber(serialNo)) { 
            	// Adds the product to the order
                orderController.findAndAddProduct(barcode, 1); 
                // Adds the product copy to the order
                orderController.findAndAddProductCopy(serialNo, uniqueProduct); 
            } else {
            	// Prints an error message if the serial number is invalid
                System.out.println("Ugyldigt serienummer."); 
            }
        } else {
        	// Prompts the user to input a quantity
            int quantity = TextInput.inputNumber("Indtast mængde i tal"); 
            // Adds the product to the order with the specified quantity
            orderController.findAndAddProduct(barcode, quantity); 
        }
    }

    /**
     * Creates and displays the order menu options. It returns the user's choice.
     */
    private int writeOrderMenu() {
    	// Creates a new TextOptions menu with the title "Ordremenu"
        TextOptions menu = new TextOptions("\n ***** Ordremenu *****"); 
        // Adds the option "Create an order" to the menu
        menu.addOption("Opret en ordre"); 
        // Adds the option "Back" to the menu
        menu.addOption("Tilbage"); 

        // Displays the menu and gets the user's choice
        int choice = menu.prompt(); 
        
        // Returns the user's choice
        return choice; 
    }
}