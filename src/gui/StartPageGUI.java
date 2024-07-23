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
            data = new ArrayList<>(); // Initialize data if it is null
        }
    }

    /**
     * Returns the number of rows in the table.
     * 
     * @return Number of rows in the table.
     */
    @Override
    public int getRowCount() {
        return data.size(); // Return the size of the data list as the row count
    }

    /**
     * Returns the name of a specific column.
     * 
     * @param col The index of the column.
     * @return The name of the column.
     */
    @Override
    public String getColumnName(int col) {
        return COL_NAMES[col]; // Return the column name based on the column index
    }

    /**
     * Returns the number of columns in the table.
     * 
     * @return Number of columns in the table.
     */
    @Override
    public int getColumnCount() {
        return COL_NAMES.length; // Return the length of COL_NAMES array as the column count
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
        OrderLine ol = data.get(rowIndex); // Get the OrderLine object for the specified row
        String res = ""; // Initialize result variable
        switch (columnIndex) {
            case 0:
                res = ol.getProduct().getName(); // Get the product name for the first column
                break;
            case 1:
                int quantity = ol.getQuantity(); // Get the quantity for the second column
                res = Integer.toString(quantity); // Convert quantity to string
                break;
            case 2:
                double price = ol.getProduct().getPrice(); // Get the price for the third column
                res = Double.toString(price); // Convert price to string
                break;
        }
        return res; // Return the result
    }
}