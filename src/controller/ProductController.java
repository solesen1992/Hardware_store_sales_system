package controller; // Declare the package name

import model.ProductCopy; // Import the ProductCopy class from the model package
import model.SimpleProduct; // Import the SimpleProduct class from the model package

import java.util.List; // Import the List interface from the java.util package
import model.Product; // Import the Product class from the model package
import model.ProductContainer; // Import the ProductContainer class from the model package
import model.UniqueProduct; // Import the UniqueProduct class from the model package

/**
 * ProductController class
 * This class handles operations related to products in the system.
 * The ProductController class manages product-related operations in an application. 
 * It acts as an intermediary between the view layer and the model layer, handling the 
 * retrieval and management of products and their copies. 
 * 
 * @author Gruppe 2
 * @version 1
 */
public class ProductController {

    // Declare a private variable to store the current product
    private Product currProduct;

    /**
     * Constructor for the ProductController class
     * Initializes the current product to null.
     */
    public ProductController() {
        this.currProduct = null;
    }

    /**
     * This method finds and retrieves a product by its barcode.
     * 
     * @param barcode The barcode of the product to be found.
     * @return The Product object if found, otherwise null.
     */
    public Product findProduct(String barcode) {
    	// Call the findProduct method from ProductContainer
        return ProductContainer.getInstance().findProduct(barcode); 
    }

    /**
     * This method retrieves a list of all products.
     * 
     * @return A list of all Product objects.
     */
    public List<Product> findAll() {
    	// Call the findAll method from ProductContainer
        return ProductContainer.getInstance().findAll(); 
    }

    /**
     * This method finds a product copy by its serial number.
     * 
     * @param serialNo The serial number of the product copy to be found.
     * @param uniqueProduct The UniqueProduct object to search within.
     * @return The ProductCopy object if found, otherwise null.
     */
    public ProductCopy findProductCopy(String serialNo, UniqueProduct uniqueProduct) {
    	// Call the findProductCopy method from the UniqueProduct object
        return uniqueProduct.findProductCopy(serialNo); 
    }
}