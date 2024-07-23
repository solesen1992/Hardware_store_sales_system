package model;  // Declares the package where the ProductCopy class is located.

/**
 * ProductCopy class represents a specific copy of a product with a unique serial number.
 * 
 * @author Gruppe 2
 * @version 1 
 */
public class ProductCopy {
    private String serialNo;  // Instance variable to store the serial number of the product copy.
    
    /**
     * Constructor for initializing a ProductCopy object with a specific serial number.
     * 
     * @param serialNo The serial number of this product copy.
     */
    public ProductCopy(String serialNo) {
        this.serialNo = serialNo;  // Initializes the serial number of this product copy.
    }

    /**
     * Gets the serial number of this product copy.
     * 
     * @return The serial number of this product copy.
     */
    public String getSerialNo() {
        return serialNo;  // Returns the current serial number of this product copy.
    }

    /**
     * Sets the serial number of this product copy.
     * 
     * @param serialNo The new serial number to be set for this product copy.
     */
    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;  // Updates the serial number of this product copy with the given value.
    }
}