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
        products = new ArrayList<>(); // Initializes the list of products.
        uniqueProducts = new ArrayList<>(); // Initializes the list of unique products.
    }

    /**
     * Singleton pattern implementation. Returns the single instance of ProductContainer.
     * Creates a new instance if it doesn't exist yet.
     * 
     * @return The single instance of ProductContainer.
     */
    public static ProductContainer getInstance() {
        if (instance == null) {
            instance = new ProductContainer(); // Creates a new instance if none exists.
        }
        return instance; // Returns the existing instance.
    }

    /**
     * Adds a product to the list of products.
     * 
     * @param product The product to add to the list.
     */
    public void addProduct(Product product) {
        products.add(product); // Adds the given product to the products list.
    }

    /**
     * Finds a product by its barcode.
     * Iterates through the list of products to find a match.
     * 
     * @param barcode The barcode of the product to find.
     * @return The product with the matching barcode, or null if not found.
     */
    public Product findProduct(String barcode) {
        Product res = null; // Variable to store the result.
        for (int i = 0; i < products.size() && res == null; i++) { // Iterates through the list of products.
            if (barcode.equals(products.get(i).getBarcode())) { // Checks if the barcode matches.
                res = products.get(i); // Sets the result to the matched product.
            }
        }
        return res; // Returns the found product or null.
    }

    /**
     * Finds a ProductCopy by its serial number.
     * Iterates through the list of unique products to find the matching product copy.
     * 
     * @param serialNo The serial number of the product copy to find.
     * @return The product copy with the matching serial number, or null if not found.
     */
    public ProductCopy findProductCopy(String serialNo) {
        ProductCopy res = null; // Variable to store the result.
        for (int i = 0; i < uniqueProducts.size() && res == null; i++) { // Iterates through the list of unique products.
            res = uniqueProducts.get(i).findProductCopy(serialNo); // Searches for the product copy within each unique product.
        }
        return res; // Returns the found product copy or null.
    }
    
    /**
     * Returns a copy of the list of all products.
     * 
     * @return A list containing all products.
     */
    public List<Product> findAll() {
        return new ArrayList<>(this.products); // Returns a new ArrayList with the contents of the products list.
    }
}