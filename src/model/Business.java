package model;  // Declares the package where the Business class is located.

/**
 * Business class
 * Represents a customer of type Business, extending from the Customer class.
 */

public class Business extends Customer {  // Declares the Business class which extends the Customer class.
    private String companyName;  // Field to store the name of the company.
    private String cvr;  // Field to store the CVR (Central Business Register) number.
    private String businessCustomerNo;  // Field to store the business customer number.
    
    /**
     * Constructor for the Business class.
     * Initializes a new Business instance with the provided details.
     * 
     * @param name The name of the contact person.
     * @param phoneNo The contact phone number.
     * @param email The email address.
     * @param address The address of the business.
     * @param companyName The name of the company.
     * @param cvr The CVR number of the business.
     * @param businessCustomerNo The unique business customer number.
     */
    public Business(String name, String phoneNo, String email, String address,
            String companyName, String cvr, String businessCustomerNo) {
        super(name, phoneNo, email, address);  // Calls the constructor of the superclass Customer to initialize common fields.
        this.businessCustomerNo = businessCustomerNo;  // Initializes the business customer number.
        this.companyName = companyName;  // Initializes the company name.
        this.cvr = cvr;  // Initializes the CVR number.
    }
    
    /**
     * Gets the company name.
     * 
     * @return The company name.
     */
    public String getCompanyName() {
        return companyName;  // Returns the company name.
    }
    
    /**
     * Sets the company name.
     * 
     * @param companyName The new company name to set.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;  // Sets the company name.
    }
    
    /**
     * Gets the CVR number.
     * 
     * @return The CVR number.
     */
    public String getCvr() {
        return cvr;  // Returns the CVR number.
    }
    
    /**
     * Sets the CVR number.
     * 
     * @param cvr The new CVR number to set.
     */
    public void setCvr(String cvr) {
        this.cvr = cvr;  // Sets the CVR number.
    }
    
    /**
     * Gets the business customer number.
     * 
     * @return The business customer number.
     */
    public String getBusinessCustomerNo() {
        return businessCustomerNo;  // Returns the business customer number.
    }
    
    /**
     * Sets the business customer number.
     * 
     * @param businessCustomerNo The new business customer number to set.
     */
    public void setBusinessCustomerNo(String businessCustomerNo) {
        this.businessCustomerNo = businessCustomerNo;  // Sets the business customer number.
    }
}