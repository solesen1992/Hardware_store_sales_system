package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.OrderLine;

/**
 * A custom table model class for displaying order details in a JTable.
 * Extends AbstractTableModel to provide data for the JTable based on a list of OrderLine objects.
 */

public class StartPageGUI extends AbstractTableModel {
    private static final long serialVersionUID = 1L; // Unique identifier for serialization
    private List<OrderLine> data; // List of OrderLine objects to be displayed in the table
    private static final String[] COL_NAMES = { "Navn", "Antal", "Pris" }; // Column names for the table

    /**
     * Constructor to initialize the StartPageGUI with a list of OrderLine objects.
     * 
     * @param data List of OrderLine objects to be displayed in the table.
     */
    public StartPageGUI(List<OrderLine> data) {
        this.data = data; // Set the data for the table
        if (data == null) {
        	// Initialize data if it is null
            data = new ArrayList<>(); 
        }
    }

    /**
     * Returns the number of rows in the table.
     * 
     * @return Number of rows in the table.
     */
    @Override
    public int getRowCount() {
    	// Return the size of the data list as the row count
        return data.size(); 
    }

    /**
     * Returns the name of a specific column.
     * 
     * @param col The index of the column.
     * @return The name of the column.
     */
    @Override
    public String getColumnName(int col) {
    	// Return the column name based on the column index
        return COL_NAMES[col]; 
    }

    /**
     * Returns the number of columns in the table.
     * 
     * @return Number of columns in the table.
     */
    @Override
    public int getColumnCount() {
    	// Return the length of COL_NAMES array as the column count
        return COL_NAMES.length; 
    }

    /**
     * Returns the value at a specific cell in the table.
     * 
     * @param rowIndex The row index of the cell.
     * @param columnIndex The column index of the cell.
     * @return The value at the specified cell.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	// Get the OrderLine object for the specified row
        OrderLine ol = data.get(rowIndex); 
        // Initialize result variable
        String res = ""; 
        switch (columnIndex) {
            case 0:
            	// Get the product name for the first column
                res = ol.getProduct().getName(); 
                break;
            case 1:
            	// Get the quantity for the second column
                int quantity = ol.getQuantity(); 
                // Convert quantity to string
                res = Integer.toString(quantity); 
                break;
            case 2:
            	// Get the price for the third column
                double price = ol.getProduct().getPrice(); 
                // Convert price to string
                res = Double.toString(price); 
                break;
        }
        // Return the result
        return res; 
    }
}