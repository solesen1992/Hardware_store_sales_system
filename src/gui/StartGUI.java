package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.*;
import controller.*;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Main GUI class for the application.
 * This class initializes and displays the main application window.
 * It allows the user to manage orders, add products, and perform other actions.
 */
public class StartGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane; // Main panel for the content
	private JTextField textFieldBarcode; // Text field for barcode input
	private JTextField textFieldQuantity; // Text field for quantity input
	private JTextField textFieldTotal; // Text field for displaying the total price
	private JTable table; // Table to display order details
	private OrderController oc; // Controller for handling orders
	private StartPageGUI spg; // GUI component for displaying order details
	private Employee employee; // Employee handling the order
	private ProductController pc; // Controller for handling products
	private Product currProduct; // Currently selected product
	private Order currOrder; // Current order

	/**
	 * Launch the application.
	 * This method initializes the GUI and makes it visible.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartGUI frame = new StartGUI(); // Create an instance of StartGUI
					frame.setVisible(true); // Make the frame visible
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the frame
				} catch (Exception e) {
					e.printStackTrace(); // Print any exceptions that occur
				}
			}
		});
	}

	/**
	 * Creates the frame and initialize its components.
	 */
	public StartGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\albie\\Downloads\\V logo.png")); // Set the frame icon
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
		setBounds(100, 100, 1200, 400); // Set the size and position of the frame
		contentPane = new JPanel(); // Initialize the content pane
		contentPane.setBackground(Color.WHITE); // Set background color
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // Set border for the content pane
		setContentPane(contentPane); // Set the content pane for the frame
		contentPane.setLayout(null); // Use null layout for manual positioning

		// Creates and configure the "Rediger" button
		JButton btnEdit = new JButton("Rediger");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Add functionality for editing
			}
		});
		btnEdit.setBackground(UIManager.getColor("Button.darkShadow")); // Set button background color
		btnEdit.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set button font
		btnEdit.setBounds(50, 40, 250, 80); // Set button position and size
		contentPane.add(btnEdit); // Add button to the content pane

		// Creates and configure the "Kunde" button
		JButton btnCostumer = new JButton("Kunde");
		btnCostumer.setBackground(UIManager.getColor("Button.background")); // Set button background color
		btnCostumer.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set button font
		btnCostumer.setBounds(50, 150, 250, 80); // Set button position and size
		contentPane.add(btnCostumer); // Add button to the content pane

		// Creates and configure the "Retur" button
		JButton btnReturn = new JButton("Retur");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Add functionality for returns
			}
		});
		btnReturn.setBackground(UIManager.getColor("Button.background")); // Set button background color
		btnReturn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set button font
		btnReturn.setBounds(50, 270, 250, 80); // Set button position and size
		contentPane.add(btnReturn); // Add button to the content pane

		// Creates and configure the "Lager" button
		JButton btnStorage = new JButton("Lager");
		btnStorage.setOpaque(false); // Set button transparency
		btnStorage.setBackground(UIManager.getColor("Button.background")); // Set button background color
		btnStorage.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set button font
		btnStorage.setBounds(50, 400, 250, 80); // Set button position and size
		btnStorage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Add functionality for storage
			}
		});
		contentPane.add(btnStorage); // Add button to the content pane

		// Creates and configure the "Udskrivning" button
		JButton btnPrintOut = new JButton("Udskrivning");
		btnPrintOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: Add functionality for printing
			}
		});
		btnPrintOut.setBackground(UIManager.getColor("Button.focus")); // Set button background color
		btnPrintOut.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set button font
		btnPrintOut.setBounds(50, 645, 250, 80); // Set button position and size
		contentPane.add(btnPrintOut); // Add button to the content pane

		// Creates and configure the "Gavekort" button
		JButton btnGiftcard = new JButton("Gavekort");
		btnGiftcard.setBackground(UIManager.getColor("Button.background")); // Set button background color
		btnGiftcard.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set button font
		btnGiftcard.setBounds(50, 524, 250, 80); // Set button position and size
		contentPane.add(btnGiftcard); // Add button to the content pane

		// Creates and configure the "Næste" button
		JButton btnNext = new JButton("Næste");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCustomerGUI(oc); // Open the customer GUI
			}
		});
		btnNext.setBackground(UIManager.getColor("Button.background")); // Set button background color
		btnNext.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set button font
		btnNext.setBounds(935, 660, 300, 65); // Set button position and size
		contentPane.add(btnNext); // Add button to the content pane

		// Creates and configure the barcode text field
		textFieldBarcode = new JTextField();
		textFieldBarcode.setBounds(500, 550, 300, 40); // Set text field position and size
		contentPane.add(textFieldBarcode); // Add text field to the content pane
		textFieldBarcode.setColumns(10); // Set text field column count

		// Creates and configure the quantity text field
		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(500, 600, 300, 40); // Set text field position and size
		contentPane.add(textFieldQuantity); // Add text field to the content pane
		textFieldQuantity.setColumns(10); // Set text field column count

		// Creates and configure the barcode label
		JLabel lblBarcode = new JLabel("Stregkode");
		lblBarcode.setBackground(Color.CYAN); // Set label background color
		lblBarcode.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set label font
		lblBarcode.setBounds(385, 550, 150, 40); // Set label position and size
		contentPane.add(lblBarcode); // Add label to the content pane

		// Create and configure the quantity label
		JLabel lblQuantity = new JLabel("Antal");
		lblQuantity.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set label font
		lblQuantity.setBounds(435, 600, 150, 40); // Set label position and size
		contentPane.add(lblQuantity); // Add label to the content pane

		// Create and configure the total label
		JLabel Total = new JLabel("Total");
		Total.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set label font
		Total.setBounds(934, 550, 140, 80); // Set label position and size
		contentPane.add(Total); // Add label to the content pane

		// Create and configure the "Tilføj" button
		JButton btnAdd = new JButton("Tilføj");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okClicked(); // Process the addition of product and quantity
				displayOrder(); // Update the table with the current order
				Double priceTotal = currOrder.getTotal(); // Calculate the total price
				String printTotal = Double.toString(priceTotal); // Convert total price to string
				textFieldBarcode.setText(null); // Clear the barcode text field
				textFieldQuantity.setText(null); // Clear the quantity text field
				textFieldTotal.setText(printTotal); // Display the total price
			}
		});
		btnAdd.setBackground(UIManager.getColor("Button.background")); // Set button background color
		btnAdd.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set button font
		btnAdd.setBounds(500, 660, 300, 65); // Set button position and size
		contentPane.add(btnAdd); // Add button to the content pane

		// Create and configure the total text field
		textFieldTotal = new JTextField();
		textFieldTotal.setBackground(new Color(255, 255, 255)); // Set text field background color
		textFieldTotal.setEditable(false); // Make text field read-only
		textFieldTotal.setBounds(1090, 570, 140, 40); // Set text field position and size
		contentPane.add(textFieldTotal); // Add text field to the content pane
		textFieldTotal.setColumns(10); // Set text field column count

		// Create and configure the scroll pane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(UIManager.getColor("List.background")); // Set scroll pane background color
		scrollPane.setBounds(400, 40, 835, 440); // Set scroll pane position and size
		contentPane.add(scrollPane); // Add scroll pane to the content pane

		// Create and configure the table
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Set table selection mode
		table.setSize(new Dimension(3, 0)); // Set table size
		table.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set table font
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Produkt", "Antal", "Pris" })); // Set table model
		scrollPane.setViewportView(table); // Add table to scroll pane

		init(); // Initialize components and controllers
	}

	/**
	 * Initialize components and controllers.
	 * This method sets up the initial state of the GUI and controllers.
	 */
	private void init() {
		employee = new Employee("Maria", "11234"); // Initialize employee
		pc = new ProductController(); // Initialize product controller
		oc = new OrderController(employee); // Initialize order controller with the employee
		currOrder = oc.createOrder(); // Create a new order
		displayOrder(); // Display the current order in the table
	}

	/**
	 * Display the current order in the GUI table.
	 * This method updates the table with the current order details.
	 */
	public void displayOrder() {
		List<OrderLine> data = oc.getOrder().getOrderLines(); // Get order lines from the current order
		spg = new StartPageGUI(data); // Create a StartPageGUI with order data
		this.table.setModel(spg); // Update the table model with the StartPageGUI
	}

	/**
	 * Open the customer GUI window.
	 * 
	 * @param orderController The order controller to be passed to the customer GUI.
	 */
	private void openCustomerGUI(OrderController orderController) {
		CustomerGUI customerGUI = new CustomerGUI(orderController); // Create a new CustomerGUI with the order controller
		customerGUI.setVisible(true); // Make the customer GUI visible
	}

	/**
	 * Process the click event on the "Tilføj" button.
	 * Retrieves product information from the text fields and adds it to the current order.
	 */
	private void okClicked() {
		String stregkode = textFieldBarcode.getText(); // Get the barcode from the text field
		String antal = textFieldQuantity.getText(); // Get the quantity from the text field
		if (!stregkode.isEmpty() && !antal.isEmpty()) { // Check if both fields are not empty
			currProduct = pc.findProduct(stregkode); // Find the product by barcode
			if (currProduct != null) {
				if(currProduct instanceof UniqueProduct) { // Check if the product is a unique product
					UniqueProduct uniqueProduct = (UniqueProduct) currProduct; // Cast to UniqueProduct
					SerialNo serialNoDialog = new SerialNo(); // Create a new SerialNo dialog
					serialNoDialog.setVisible(true); // Show the dialog
					String serialNo = serialNoDialog.getEnteredValue(); // Get the entered serial number
					if(uniqueProduct.isValidSerialNumber(serialNo)) { // Validate the serial number
						oc.findAndAddProduct(stregkode, 1); // Add the product to the order
						oc.findAndAddProductCopy(serialNo, uniqueProduct); // Add the product copy to the order
					} else {
						System.out.println("Ugyldigt serienummer."); // Print invalid serial number message
					}
				} else {
					int quantity = Integer.parseInt(antal); // Convert quantity to integer
					oc.findAndAddProduct(stregkode, quantity); // Add the product to the order
				}
			}
		}
	}
}