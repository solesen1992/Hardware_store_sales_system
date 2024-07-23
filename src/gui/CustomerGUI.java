package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.OrderController;
import model.Order;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Toolkit;

/**
 * The CustomerGUI class creates a graphical user interface (GUI) for handling customer 
 * information within an order management system. 
 * It extends JDialog to create a modal dialog window. 
 * */

public class CustomerGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	
	// Components for the GUI
	private final JPanel contentPanel = new JPanel();
	private JButton btnConfirm;
	private JTextField textField;
	private OrderController oc;
	private Order currOrder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			// Creating and displaying the CustomerGUI dialog
			CustomerGUI dialog = new CustomerGUI(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerGUI(OrderController oc) {
		// Set icon image for the dialog
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\albie\\Downloads\\V logo.png"));
		
		// Initialize order controller and get current order
		this.oc = oc;
		this.currOrder = oc.getOrder();
		
		// Setting up the main properties of the dialog
		setBounds(100, 100, 600, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		// Configure content panel
		contentPanel.setBounds(0, 0, 650, 380);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			// Creating and configuring the center panel for email input
			JPanel centerPanel = new JPanel();
			centerPanel.setBounds(0, 5, 650, 380);
			contentPanel.add(centerPanel);
			centerPanel.setLayout(null);
			{
				// Label for customer email
				JLabel customerEmailPanel = new JLabel("Kundens email");
				customerEmailPanel.setBounds(150, 200, 144, 40);
				customerEmailPanel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
				centerPanel.add(customerEmailPanel);
			}
			{
				// Text field for entering customer email
				textField = new JTextField();
				textField.setBounds(300, 200, 184, 40);
				centerPanel.add(textField);
				textField.setColumns(10);
			}
		}
		{
			// Creating and configuring the bottom button panel
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 390, 650, 71);
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				// Button for confirming input
				btnConfirm = new JButton("Næste");
				btnConfirm.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
				btnConfirm.setBackground(UIManager.getColor("Button.background"));
				btnConfirm.setBounds(400, 2, 150, 60);
				btnConfirm.setActionCommand("Confirm");
				buttonPane.add(btnConfirm);
			}
			
			// Button for going back
			JButton btnNewButton = new JButton("Tilbage");
			btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
			btnNewButton.setBounds(240, 2, 150, 60);
			buttonPane.add(btnNewButton);

			// Adding an ActionListener to the confirmation button
			btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Retrieve the text entered in the textField
					String email = textField.getText();
					
					// Call the findAndAddCustomer method of the OrderController class, passing the retrieved email address
					oc.findAndAddCustomer(email);
					
					// Check if the customer has been found and added to the current order
					if (currOrder.getCustomer() != null) {
						confirm(); // Call the confirm method
					}
				}
			});
		}
	}

	// Method to handle confirmation action
	private void confirm() {
		setVisible(false); // Hide the current dialog
		dispose(); // Dispose of system resources associated with the dialog

		// Create an instance of the Payment class
		Payment payment = new Payment(oc);
		
		// Set the size and display the Payment dialog
		payment.setSize(600, 500);
		payment.setVisible(true);
	}
}