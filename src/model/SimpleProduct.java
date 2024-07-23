package model;  // Declares the package where the SimpleProduct class is located.

/**
 * SimpleProduct class represents a type of product with additional information about the package size.
 * It extends the Product class to inherit common product attributes.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class SimpleProduct extends Product {
    /**
     * Additional attribute specific to SimpleProduct: packageSize.
     */
    private String packageSize;  // Instance variable to store the package size of the product.

    /**
     * Constructor for initializing a SimpleProduct object with specified attributes.
     * 
     * @param name         The name of the product.
     * @param type         The type or category of the product.
     * @param price        The price of the product.
     * @param stockAmount  The amount of the product in stock.
     * @param brand        The brand of the product.
     * @param barcode      The barcode of the product.
     * @param packageSize  The size of the package in which the product is sold.
     */
    public SimpleProduct(String name, String type, double price, int stockAmount, String brand, String barcode,
            String packageSize) {
        super(name, type, price, stockAmount, brand, barcode);  // Calls the constructor of the superclass (Product) to initialize common attributes.
        this.packageSize = packageSize;  // Initializes the packageSize attribute specific to SimpleProduct.
    }

    /**
     * Getter method to retrieve the package size of the product.
     * 
     * @return The package size of the product.
     */
    public String getPackageSize() {
        return packageSize;  // Returns the current value of the packageSize attribute.
    }

    /**
     * Setter method to update the package size of the product.
     * 
     * @param packageSize The new package size to set for the product.
     */
    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;  // Updates the packageSize attribute with the provided value.
    }
}