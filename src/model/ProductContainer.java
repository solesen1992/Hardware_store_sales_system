package model;  // Declares the package where the ProductContainer class is located.

import java.util.ArrayList;  // Imports the ArrayList class for using dynamic arrays.
import java.util.List;      // Imports the List interface for using lists.

 /**
  * ProductContainer class that manages a collection of products.
  * This class follows the Singleton pattern to ensure only one instance exists.
  * 
  * @author Gruppe 2
  * @version 1
  */
public class ProductContainer {
    private static ProductContainer instance; // Singleton instance of ProductContainer.
    private ArrayList<Product> products; // List to store all products.
    private ArrayList<UniqueProduct> uniqueProducts; // List to store unique products (subtype of Product).

    /**
     * Constructor for initializing the ProductContainer.
     * Initializes the ArrayLists for products and uniqueProducts.
     */
    public ProductContainer() {
    	// Initializes the list of products.
        products = new ArrayList<>(); 
        // Initializes the list of unique products.
        uniqueProducts = new ArrayList<>(); 
    }

    /**
     * Singleton pattern implementation. Returns the single instance of ProductContainer.
     * Creates a new instance if it doesn't exist yet.
     * 
     * @return The single instance of ProductContainer.
     */
    public static ProductContainer getInstance() {
        if (instance == null) {
        	// Creates a new instance if none exists.
            instance = new ProductContainer(); 
        }
        // Returns the existing instance.
        return instance; 
    }

    /**
     * Adds a product to the list of products.
     * 
     * @param product The product to add to the list.
     */
    public void addProduct(Product product) {
    	// Adds the given product to the products list.
        products.add(product); 
    }

    /**
     * Finds a product by its barcode.
     * Iterates through the list of products to find a match.
     * 
     * @param barcode The barcode of the product to find.
     * @return The product with the matching barcode, or null if not found.
     */
    public Product findProduct(String barcode) {
    	// Variable to store the result.
        Product res = null; 
        // Iterates through the list of products.
        for (int i = 0; i < products.size() && res == null; i++) { 
        	// Checks if the barcode matches.
            if (barcode.equals(products.get(i).getBarcode())) { 
            	// Sets the result to the matched product.
                res = products.get(i); 
            }
        }
        // Returns the found product or null.
        return res; 
    }

    /**
     * Finds a ProductCopy by its serial number.
     * Iterates through the list of unique products to find the matching product copy.
     * 
     * @param serialNo The serial number of the product copy to find.
     * @return The product copy with the matching serial number, or null if not found.
     */
    public ProductCopy findProductCopy(String serialNo) {
    	// Variable to store the result.
        ProductCopy res = null; 
        // Iterates through the list of unique products.
        for (int i = 0; i < uniqueProducts.size() && res == null; i++) { 
        	// Searches for the product copy within each unique product.
            res = uniqueProducts.get(i).findProductCopy(serialNo); 
        }
        // Returns the found product copy or null.
        return res; 
    }
    
    /**
     * Returns a copy of the list of all products.
     * 
     * @return A list containing all products.
     */
    public List<Product> findAll() {
    	// Returns a new ArrayList with the contents of the products list.
        return new ArrayList<>(this.products); 
    }
}