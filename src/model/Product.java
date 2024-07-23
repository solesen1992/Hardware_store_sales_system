package model;  // Declares the package where the Product class is located.

/**
 * Product class that serves as a blueprint for creating products with various attributes.
 * This class is abstract, meaning it cannot be instantiated directly and is intended
 * to be subclassed by other product types.
 * 
 * @author Gruppe 2
 * @version 1
 */
public abstract class Product {
    private String name;          // Name of the product.
    private String type;          // Type or category of the product.
    private double price;         // Price of the product.
    private int stockAmount;      // Amount of stock available for the product.
    private String brand;         // Brand of the product.
    private String barcode;       // Barcode associated with the product.

    /**
     * Constructor for creating a Product object with specified attributes.
     * 
     * @param name The name of the product.
     * @param type The type or category of the product.
     * @param price The price of the product.
     * @param stockAmount The amount of stock available for the product.
     * @param brand The brand of the product.
     * @param barcode The barcode associated with the product.
     */
    public Product(String name, String type, double price, int stockAmount, String brand, String barcode) {
        this.name = name;           // Initializes the product's name.
        this.type = type;           // Initializes the product's type.
        this.price = price;         // Initializes the product's price.
        this.stockAmount = stockAmount;  // Initializes the product's stock amount.
        this.brand = brand;         // Initializes the product's brand.
        this.barcode = barcode;     // Initializes the product's barcode.
    }

    /**
     * Gets the name of the product.
     * 
     * @return The name of the product.
     */
    public String getName() {
        return name;  // Returns the product's name.
    }

    /**
     * Sets the name of the product.
     * 
     * @param name The new name to set for the product.
     */
    public void setName(String name) {
        this.name = name;  // Updates the product's name.
    }

    /**
     * Gets the price of the product.
     * 
     * @return The price of the product.
     */
    public double getPrice() {
        return price;  // Returns the product's price.
    }

    /**
     * Sets the price of the product.
     * 
     * @param price The new price to set for the product.
     */
    public void setPrice(double price) {
        this.price = price;  // Updates the product's price.
    }

    /**
     * Gets the stock amount of the product.
     * 
     * @return The stock amount of the product.
     */
    public int getStockAmount() {
        return stockAmount;  // Returns the amount of stock available for the product.
    }

    /**
     * Sets the stock amount of the product.
     * 
     * @param stockAmount The new stock amount to set for the product.
     */
    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;  // Updates the product's stock amount.
    }

    /**
     * Gets the brand of the product.
     * 
     * @return The brand of the product.
     */
    public String getBrand() {
        return brand;  // Returns the product's brand.
    }

    /**
     * Sets the brand of the product.
     * 
     * @param brand The new brand to set for the product.
     */
    public void setBrand(String brand) {
        this.brand = brand;  // Updates the product's brand.
    }

    /**
     * Gets the barcode associated with the product.
     * 
     * @return The barcode of the product.
     */
    public String getBarcode() {
        return barcode;  // Returns the product's barcode.
    }

    /**
     * Sets the barcode associated with the product.
     * 
     * @param barcode The new barcode to set for the product.
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;  // Updates the product's barcode.
    }

    /**
     * Gets the type or category of the product.
     * 
     * @return The type or category of the product.
     */
    public String getType() {
        return type;  // Returns the product's type or category.
    }

    /**
     * Sets the type or category of the product.
     * 
     * @param type The new type or category to set for the product.
     */
    public void setType(String type) {
        this.type = type;  // Updates the product's type or category.
    }
}