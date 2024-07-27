package test;  // Defines the package where this test class resides.

import static org.junit.jupiter.api.Assertions.*;  // Imports assertion methods from JUnit 5.
import org.junit.jupiter.api.BeforeAll;  // Imports annotation for setup tasks that run once before all tests.
import org.junit.jupiter.api.BeforeEach;  // Imports annotation for setup tasks that run before each test.
import org.junit.jupiter.api.Test;  // Imports annotation to mark test methods.

import controller.ProductController;
import model.Product;  // Imports the Product class from the model package.
import model.ProductContainer;  // Imports the ProductContainer class from the model package.
import model.SimpleProduct;  // Imports the SimpleProduct class from the model package.

/**
 * This test class contains test cases for the ProductController class
 * The ProductControllerTest class is a unit test class written to ensure that the 
 * methods in the ProductController class work correctly. It uses the JUnit testing 
 * framework to define and execute test cases.
 * 
 * @author Gruppe 2 
 * @version 1 
 */
class ProductControllerTest {
	// Declares a ProductContainer instance for use in tests.
    private ProductContainer productContainer;  
    // Declares a ProductController instance for use in tests.
    private ProductController productController;  
    
    /**
     * This sets up the task that needs to be done before anything else.
     * @throws Exception
     */
    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        // This method is empty because no setup is required before any test methods are executed.
        // It can be used for global setup if needed.
    }

    /**
     * This sets up tasks that need to be done before any tests
     * @throws Exception
     */
    @BeforeEach
    void setUp() throws Exception {
    	// Retrieves the singleton instance of ProductContainer.
        productContainer = ProductContainer.getInstance();  
        // Initializes a new instance of ProductController.
        productController = new ProductController();  
    }

    @Test
    void test() {
    	// This test is a placeholder that will fail until implemented.
        fail("Not yet implemented");  
    }

    /**
     * This is a test case for findProduct method in the ProductController class
     */
    @Test
    public void testFindProduct() {
    	// Defines a barcode for the product to be tested.
        String barcode = "1234567890";  
        // Creates a new SimpleProduct with specified details.
        SimpleProduct product = new SimpleProduct("Product Name", "Hardware", 100.00, 10, "Brand Name", barcode, "size");
        // Adds the product to the ProductContainer.
        productContainer.addProduct(product);  
        
        // Finds the product using the barcode.
        Product foundProduct = productController.findProduct(barcode);  

        // Asserts that the found product's details match the expected product's details.
        assertEquals(product.getName(), foundProduct.getName());
        assertEquals(product.getType(), foundProduct.getType());
        assertEquals(product.getPrice(), foundProduct.getPrice());
        assertEquals(product.getStockAmount(), foundProduct.getStockAmount());
        assertEquals(product.getBrand(), foundProduct.getBrand());
        assertEquals(product.getBarcode(), foundProduct.getBarcode());
    }
}