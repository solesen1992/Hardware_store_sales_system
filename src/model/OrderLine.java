package model;  // Declares the package where the OrderLine class is located.

/**
 * OrderLine class
 * 
 * This class represents a line item in an order, including the quantity of the product
 * and the total price for that quantity. It also provides methods to get and set the
 * product details and quantity.
 * 
 * @author Gruppe 2
 * @version 1
 */
public class OrderLine {
    private int quantity;  // The quantity of the product in this order line.
    private Product product;  // The generic product associated with this order line.
    private SimpleProduct simpleProduct;  // Reference to a SimpleProduct, if applicable.
    private UniqueProduct uniqueProduct;  // Reference to a UniqueProduct, if applicable.
    private ProductCopy productCopy;  // Reference to a ProductCopy, if applicable.

    /**
     * Constructor to initialize an OrderLine object.
     * 
     * @param quantity The quantity of the product in this order line.
     * @param product The product associated with this order line.
     */
    public OrderLine(int quantity, Product product) {
        this.quantity = quantity;  // Sets the quantity of the product.
        this.product = product;  // Sets the product associated with this order line.
    }

    /**
     * Calculates and returns the subtotal price for this order line.
     * 
     * @return The total price for the quantity of the product.
     */
    public double getSubTotal() {
        double price = product.getPrice();  // Retrieves the price of the product.
        double res = quantity * price;  // Calculates the subtotal price.
        return res;  // Returns the subtotal price.
    }

    /**
     * Gets the product associated with this order line.
     * 
     * @return The product in this order line.
     */
    public Product getProduct() {
        return product;  // Returns the product.
    }

    /**
     * Sets the product for this order line.
     * 
     * @param product The product to be set.
     */
    public void setProduct(Product product) {
        this.product = product;  // Sets the product.
    }

    /**
     * Gets the product copy associated with this order line.
     * 
     * @return The product copy.
     */
    public ProductCopy getProductCopy() {
        return productCopy;  // Returns the product copy.
    }

    /**
     * Sets the product copy for this order line.
     * 
     * @param productCopy The product copy to be set.
     */
    public void setProductCopy(ProductCopy productCopy) {
        this.productCopy = productCopy;  // Sets the product copy.
    }

    /**
     * Gets the simple product associated with this order line.
     * 
     * @return The simple product.
     */
    public SimpleProduct getSimpleProduct() {
        return simpleProduct;  // Returns the simple product.
    }

    /**
     * Sets the simple product for this order line.
     * 
     * @param simpleProduct The simple product to be set.
     */
    public void setSimpleProduct(SimpleProduct simpleProduct) {
        this.simpleProduct = simpleProduct;  // Sets the simple product.
    }

    /**
     * Gets the unique product associated with this order line.
     * 
     * @return The unique product.
     */
    public UniqueProduct getUniqueProduct() {
        return uniqueProduct;  // Returns the unique product.
    }

    /**
     * Sets the unique product for this order line.
     * 
     * @param uniqueProduct The unique product to be set.
     */
    public void setUniqueProduct(UniqueProduct uniqueProduct) {
        this.uniqueProduct = uniqueProduct;  // Sets the unique product.
    }

    /**
     * Gets the quantity of the product in this order line.
     * 
     * @return The quantity of the product.
     */
    public int getQuantity() {
        return quantity;  // Returns the quantity.
    }

    /**
     * Sets the quantity of the product in this order line.
     * 
     * @param quantity The quantity to be set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;  // Sets the quantity.
    }
}