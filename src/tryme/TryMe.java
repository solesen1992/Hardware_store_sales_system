package tryme;  // Declares the package where the TryMe class is located.

import model.Business;  // Imports the Business class from the model package.
import model.Customer;  // Imports the Customer class from the model package.
import model.CustomerContainer;  // Imports the CustomerContainer class from the model package.
import model.Employee;  // Imports the Employee class from the model package.
import model.Private;  // Imports the Private class from the model package.
import model.ProductContainer;  // Imports the ProductContainer class from the model package.
import model.ProductCopy;  // Imports the ProductCopy class from the model package.
import model.SimpleProduct;  // Imports the SimpleProduct class from the model package.
import model.UniqueProduct;  // Imports the UniqueProduct class from the model package.
import tui.MainMenu;  // Imports the MainMenu class from the ui package.
import gui.StartGUI;  // Imports the StartGUI class from the GUI package.

/**
 * generateTestData Method: This method creates test data by instantiating objects for 
 * simple and unique products, customers, and product copies. It then adds these 
 * objects to their respective containers.
 * 
 * main Method: Calls the generateTestData method to initialize the data and then 
 * starts the GUI application.
 * */

public class TryMe {

    /**
     * Instantiates objects and adds them to ArrayLists.
     * This method creates test data for products, customers, and employees.
     */
    public static void generateTestData() {

        // Instantiates simple products.
        // Creates a SimpleProduct object named "Stålsøm" with its attributes.
        SimpleProduct simpleProduct1 = new SimpleProduct("Stålsøm", "Universalsøm", 27.95, 1000, "NKT Fasteners",
                "9365937", "Medium");

        // Creates a SimpleProduct object named "Papsøm" with its attributes.
        SimpleProduct simpleProduct2 = new SimpleProduct("Papsøm", "Universalsøm", 109.95, 600, "Paslode", "90909010",
                "Medium");

        // Creates a SimpleProduct object named "Røgalarm med sensor" with its attributes.
        SimpleProduct simpleProduct3 = new SimpleProduct("Røgalarm med sensor", "Røgalarm", 43.75, 500, "Elworks",
                "22200220", "Small");

        // Creates a SimpleProduct object named "Fodliste" with its attributes.
        SimpleProduct simpleProduct4 = new SimpleProduct("Fodliste", "Liste", 99.75, 300, "Hornbæk", "90265534",
                "Medium");

        // Creates a SimpleProduct object named "Stilo stige" with its attributes.
        SimpleProduct simpleProduct5 = new SimpleProduct("Stilo stige", "Stige", 399.95, 50, "Hjørring Stigefabrik",
                "909583047", "Small");

        // Instantiates unique products
        // Creates a UniqueProduct object named "Gasgrill" with its attributes.
        UniqueProduct uniqueProduct1 = new UniqueProduct("Gasgrill", "Grill", 24575, 5, "Weber", "052849261", 2);

        // Creates a ProductCopy object with serial number "Y0X89443".
        ProductCopy productCopy1 = new ProductCopy("Y0X89443");

        // Creates a ProductCopy object with serial number "OI074389".
        ProductCopy productCopy2 = new ProductCopy("OI074389");

        // Creates a UniqueProduct object named "Robotplæneklipper" with its attributes.
        UniqueProduct uniqueProduct2 = new UniqueProduct("Robotplæneklipper", "Plæneklipper", 4292, 9, "Worx",
                "04930284", 2);

        // Creates a ProductCopy object with serial number "UI093248".
        ProductCopy productCopy3 = new ProductCopy("UI093248");

        // Creates a ProductCopy object with serial number "HK893227".
        ProductCopy productCopy4 = new ProductCopy("HK893227");

        // Creates a UniqueProduct object named "Frontbetjent vaskemaskine" with its attributes.
        UniqueProduct uniqueProduct3 = new UniqueProduct("Frontbetjent vaskemaskine", "Vaskemaskine", 4499, 5, "Bosch",
                "397104833", 7);

        // Creates a ProductCopy object with serial number "AC937494".
        ProductCopy productCopy5 = new ProductCopy("AC937494");

        // Creates a ProductCopy object with serial number "AD984579".
        ProductCopy productCopy6 = new ProductCopy("AD984579");

        // Creates a UniqueProduct object named "Varmepumpe udedel" with its attributes.
        UniqueProduct uniqueProduct4 = new UniqueProduct("Varmepumpe udedel", "Varmepumpe", 4999, 10, "Wilfa",
                "64901038", 5);

        // Creates a ProductCopy object with serial number "DV534664".
        ProductCopy productCopy7 = new ProductCopy("DV534664");

        // Creates a ProductCopy object with serial number "DD346456".
        ProductCopy productCopy8 = new ProductCopy("DD346456");

        // Creates a UniqueProduct object named "Damprenser" with its attributes.
        UniqueProduct uniqueProduct5 = new UniqueProduct("Damprenser", "Rengøring", 899, 7, "Bisell", "7201938303", 2);

        // Creates a ProductCopy object with serial number "HK089724".
        ProductCopy productCopy9 = new ProductCopy("HK089724");

        // Creates a ProductCopy object with serial number "GS345345".
        ProductCopy productCopy10 = new ProductCopy("GS345345");

        // Instantiates customers
        // Creates a Private customer object with specified attributes.
        Private customer1 = new Private("Arne Arntsen", "12121212", "aartnsen@gmail.com", "Gadevej 20", "1");

        // Creates a Private customer object with specified attributes.
        Private customer2 = new Private("Bente Bentsen", "23232323", "bbentsen@live.dk", "Vejgade 36", "2");

        // Creates a Private customer object with specified attributes.
        Private customer3 = new Private("Carl Carlsen", "45454545", "ccsen@hotmail.com", "Vejbækgade 47", "3");

        // Creates a Business customer object with specified attributes.
        Business customer4 = new Business("Dorthe Dortsen", "67676767", "dorthed@gmail.com", "Øgadevej 11", "Byg A/S", "26401389", "2");

        // Creates a Business customer object with specified attributes.
        Business customer5 = new Business("Emil Emilsen", "89898989", "emilemil@live.dk", "Gadekilde 170", "Asfalt A/S", "25321376", "1");

        // Adds customers to the list of customers
        // Adds customer1 to the CustomerContainer's list of customers.
        CustomerContainer.getInstance().addCustomer(customer1);

        // Adds customer2 to the CustomerContainer's list of customers.
        CustomerContainer.getInstance().addCustomer(customer2);

        // Adds customer3 to the CustomerContainer's list of customers.
        CustomerContainer.getInstance().addCustomer(customer3);

        // Adds customer4 to the CustomerContainer's list of customers.
        CustomerContainer.getInstance().addCustomer(customer4);

        // Adds customer5 to the CustomerContainer's list of customers.
        CustomerContainer.getInstance().addCustomer(customer5);

        // Adds products to the list of products
        // Adds simpleProduct1 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(simpleProduct1);

        // Adds simpleProduct2 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(simpleProduct2);

        // Adds simpleProduct3 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(simpleProduct3);

        // Adds simpleProduct4 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(simpleProduct4);

        // Adds simpleProduct5 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(simpleProduct5);

        // Adds uniqueProduct1 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(uniqueProduct1);

        // Adds uniqueProduct2 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(uniqueProduct2);

        // Adds uniqueProduct3 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(uniqueProduct3);

        // Adds uniqueProduct4 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(uniqueProduct4);

        // Adds uniqueProduct5 to the ProductContainer's list of products.
        ProductContainer.getInstance().addProduct(uniqueProduct5);

        // Adds product copies to unique products
        // Adds productCopy1 to the list of copies for uniqueProduct1.
        uniqueProduct1.addCopy(productCopy1);

        // Adds productCopy2 to the list of copies for uniqueProduct1.
        uniqueProduct1.addCopy(productCopy2);

        // Adds productCopy3 to the list of copies for uniqueProduct2.
        uniqueProduct2.addCopy(productCopy3);

        // Adds productCopy4 to the list of copies for uniqueProduct2.
        uniqueProduct2.addCopy(productCopy4);

        // Adds productCopy5 to the list of copies for uniqueProduct3.
        uniqueProduct3.addCopy(productCopy5);

        // Adds productCopy6 to the list of copies for uniqueProduct3.
        uniqueProduct3.addCopy(productCopy6);

        // Adds productCopy7 to the list of copies for uniqueProduct4.
        uniqueProduct4.addCopy(productCopy7);

        // Adds productCopy8 to the list of copies for uniqueProduct4.
        uniqueProduct4.addCopy(productCopy8);

        // Adds productCopy9 to the list of copies for uniqueProduct5.
        uniqueProduct5.addCopy(productCopy9);

        // Adds productCopy10 to the list of copies for uniqueProduct5.
        uniqueProduct5.addCopy(productCopy10);

        // Instantiates employees
        // Uncommented code for employee instantiation, potentially for future use.
        // LoginController employee1 = new LoginController("Bo Bobsen", "123");
        // LoginController employee2 = new LoginController("Ib Ibsen", "234");
    }

    // The main method to execute the program.
    public static void main(String[] args) {
        // Calls the generateTestData method to populate the data.
        generateTestData();

        // Creates an instance of StartGUI and runs the main method of StartGUI.
        StartGUI startGUI = new StartGUI();
        startGUI.main(args);
    }
}