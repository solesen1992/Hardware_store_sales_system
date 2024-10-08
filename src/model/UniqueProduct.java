package model;  // Declares the package where the UniqueProduct class is located.

import java.util.ArrayList;  // Imports the ArrayList class from the java.util package.

/**
 * UniqueProduct class represents a product with unique attributes, including warranty and individual copies.
 * It extends the Product class to include additional properties and functionalities for unique products.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class UniqueProduct extends Product {
    private int warranty;  // Instance variable to store the warranty period for the unique product.
    private ArrayList<ProductCopy> productCopies;  // List to store all copies of this unique product.

    /**
     * Constructor for initializing a UniqueProduct object with specified attributes.
     * 
     * @param name         The name of the product.
     * @param type         The type or category of the product.
     * @param price        The price of the product.
     * @param stockAmount  The amount of the product in stock.
     * @param brand        The brand of the product.
     * @param barcode      The barcode of the product.
     * @param warranty     The warranty period for the product.
     */
    public UniqueProduct(String name, String type, double price, int stockAmount, String brand, String barcode,
            int warranty) {
        super(name, type, price, stockAmount, brand, barcode);  // Calls the constructor of the superclass (Product) to initialize common attributes.
        this.warranty = warranty;  // Initializes the warranty attribute specific to UniqueProduct.
        this.productCopies = new ArrayList<>();  // Initializes the productCopies list to hold copies of the unique product.
    }

    /**
     * Getter method to retrieve the warranty period of the unique product.
     * 
     * @return The warranty period.
     */
    public int getWarranty() {
        return warranty;  // Returns the current warranty period of the unique product.
    }

    /**
     * Setter method to update the warranty period of the unique product.
     * 
     * @param warranty The new warranty period to set.
     */
    public void setWarranty(int warranty) {
        this.warranty = warranty;  // Updates the warranty period of the unique product.
    }

    /**
     * Finds a product copy based on the provided serial number.
     * 
     * @param serialNo The serial number of the product copy to find.
     * @return The ProductCopy object if found, otherwise returns null.
     */
    public ProductCopy findProductCopy(String serialNo) {
    	// Initialize the result variable to null.
        ProductCopy res = null;  
        // Iterate through the list of product copies.
        for (int i = 0; i < productCopies.size() && res == null; i++) {  
            // Check if the serial number matches (case insensitive).
        	if (productCopies.get(i).getSerialNo().equalsIgnoreCase(serialNo)) {  
                // Set the result to the matching ProductCopy.
        		res = productCopies.get(i);  
            }
        }
        // Return the found ProductCopy or null if not found.
        return res;  
    }

    /**
     * Adds a copy of this unique product to the list of product copies.
     * 
     * @param productCopy The ProductCopy object to add.
     * @return True if the product copy was successfully added, false otherwise.
     */
    public boolean addCopy(ProductCopy productCopy) {
    	// Check if the productCopy is not null.
        boolean res = productCopy != null;  
        if (res) {
        	// Add the productCopy to the list of product copies.
            productCopies.add(productCopy);  
        }
        // Return true if the productCopy was added, otherwise false.
        return res;  
    }
    
    /**
     * Checks if a given serial number is valid by checking if it exists in the list of product copies.
     * 
     * @param serialNo The serial number to check.
     * @return True if the serial number is valid (exists in the list), otherwise false.
     */
    public boolean isValidSerialNumber(String serialNo) {
    	// Iterate through each ProductCopy in the list.
        for (ProductCopy copy : productCopies) {  
        	// Check if the serial number matches (case insensitive).
            if (copy.getSerialNo().equalsIgnoreCase(serialNo)) {  
                // Return true if a match is found.
            	return true;  
            }
        }
        // Return false if no match is found after checking all product copies.
        return false;  
    }
}