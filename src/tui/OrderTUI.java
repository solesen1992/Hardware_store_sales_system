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
        orderController = new OrderController(employee); // Initializes the OrderController with the given employee
        this.employee = employee; // Assigns the given employee to the employee instance variable
    }

    /**
     * Starts and displays the order menu loop. Allows the user to make choices
     * until choosing to exit the program. Calls other methods based on user
     * choices.
     */
    public void start() {
        boolean running = true; // Sets a flag to control the loop
        while (running) { // Loops until the flag is set to false
            int choice = writeOrderMenu(); // Displays the order menu and gets the user's choice
            if (choice == 1) { // If the user chooses to create an order
                createOrder(); // Calls the createOrder method
            } else { // If the user chooses to exit
                running = false; // Sets the flag to false to exit the loop
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
        orderController.createOrder(); // Creates a new order using the OrderController
        addProduct(); // Calls the addProduct method to add a product to the order

        // This boolean asks the user if they want to add more products to the order.
        boolean keepAdding = true;
        while (keepAdding) { // Loops until the user decides to stop adding products
            String addMore1 = TextInput.inputString("Ønsker du at tilføje flere produkter(Ja/Nej)"); // Asks the user if they want to add more products
            if (addMore1.equalsIgnoreCase("ja")) { // If the user wants to add more products
                addProduct(); // Calls the addProduct method
            } else if (addMore1.equalsIgnoreCase("nej")) { // If the user does not want to add more products
                keepAdding = false; // Sets the flag to false to exit the loop
            } else {
                System.out.println("Angiv venligst et af svarmulighederne"); // Asks the user to provide a valid answer
            }
        }

        String email = TextInput.inputString("Indtast kundens email"); // Asks the user to input the customer's email
        orderController.findAndAddCustomer(email); // Finds and adds the customer to the order using the email

        Order orderToPrint = orderController.completeOrder(); // Completes the order and gets the order details
        if (orderToPrint != null) { // If the order exists
            if (orderToPrint.getCustomer() != null) { // If the customer exists
                System.out.println("Kunde: " + orderToPrint.getCustomer().getName()); // Prints the customer's name
            }
            List<OrderLine> ols = orderToPrint.getOrderLines(); // Gets the list of order lines
            System.out.println("Medarbejder: " + orderToPrint.getEmployee().getName()); // Prints the employee's name
            System.out.println("Ordrenummer: " + orderToPrint.getOrderNo()); // Prints the order number
            System.out.println("Dato: " + orderToPrint.getLdt()); // Prints the order date
            for (OrderLine ol : ols) { // Iterates over the order lines
                Product p = ol.getProduct(); // Gets the product in the order line
                ProductCopy pc = ol.getProductCopy(); // Gets the product copy in the order line
                if (p != null) { // If the product exists
                    System.out.println("Navn på produkt: " + p.getName()); // Prints the product name
                    System.out.println("Pris pr. stk.: " + p.getPrice()); // Prints the product price
                    System.out.println("Produkt type: " + p.getType()); // Prints the product type

                    /**
                     * If the product is an instance of SimpleProduct, then PackageSize will get
                     * printed. If the product is an instance of UniqueProduct, then Warranty and
                     * SerialNo will be printed.
                     */
                    if (p instanceof SimpleProduct) { // If the product is a SimpleProduct
                        SimpleProduct sp = (SimpleProduct) p; // Casts the product to SimpleProduct
                        System.out.println("Pakkestørrelse: " + sp.getPackageSize()); // Prints the package size
                    } else if (p instanceof UniqueProduct) { // If the product is a UniqueProduct
                        UniqueProduct up = (UniqueProduct) p; // Casts the product to UniqueProduct
                        System.out.println("Garanti: " + up.getWarranty()); // Prints the warranty
                        if (ol.getProductCopy() != null) { // If the product copy exists
                            System.out.println("SerieNummer: " + pc.getSerialNo()); // Prints the serial number
                        }
                    }
                    System.out.println("Antal: " + ol.getQuantity()); // Prints the quantity
                } else {
                    System.out.println("ordren kan ikke gennemføres."); // Prints an error message if the order cannot be completed
                }
            }
            System.out.println("Pris i alt: " + orderToPrint.getTotal()); // Prints the total price
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
        String barcode = TextInput.inputString("Indtast stregkode"); // Prompts the user to input a barcode
        Product p = orderController.findProduct(barcode); // Finds the product using the barcode
        if (p instanceof UniqueProduct) { // If the product is a UniqueProduct
            UniqueProduct uniqueProduct = (UniqueProduct) p; // Casts the product to UniqueProduct
            String serialNo = TextInput.inputString("Indtast serienummer"); // Prompts the user to input a serial number
            if (uniqueProduct.isValidSerialNumber(serialNo)) { // Checks if the serial number is valid
                orderController.findAndAddProduct(barcode, 1); // Adds the product to the order
                orderController.findAndAddProductCopy(serialNo, uniqueProduct); // Adds the product copy to the order
            } else {
                System.out.println("Ugyldigt serienummer."); // Prints an error message if the serial number is invalid
            }
        } else {
            int quantity = TextInput.inputNumber("Indtast mængde i tal"); // Prompts the user to input a quantity
            orderController.findAndAddProduct(barcode, quantity); // Adds the product to the order with the specified quantity
        }
    }

    /**
     * Creates and displays the order menu options. It returns the user's choice.
     */
    private int writeOrderMenu() {
        TextOptions menu = new TextOptions("\n ***** Ordremenu *****"); // Creates a new TextOptions menu with the title "Ordremenu"
        menu.addOption("Opret en ordre"); // Adds the option "Create an order" to the menu
        menu.addOption("Tilbage"); // Adds the option "Back" to the menu

        int choice = menu.prompt(); // Displays the menu and gets the user's choice

        return choice; // Returns the user's choice
    }
}