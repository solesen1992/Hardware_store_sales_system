package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

/**
 * A dialog for entering a serial number.
 * This class creates a modal dialog that prompts the user to enter a serial number,
 * and provides a button to submit the entered value.
 * 
 * @version 1.0
 */
public class SerialNo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel(); // Panel to hold the input field and label
	private JTextField textField; // Text field for user to enter serial number
	private String enteredValue; // Variable to store the entered serial number

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SerialNo dialog = new SerialNo(); // Create a new instance of SerialNo dialog
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Ensure the dialog closes properly
			dialog.setVisible(true); // Display the dialog
		} catch (Exception e) {
			e.printStackTrace(); // Print any exception stack trace
		}
	}

	/**
	 * Creates the dialog.
	 */
	public SerialNo() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\albie\\Downloads\\V logo.png")); // Set the icon for the dialog
		setModal(true); // Make the dialog modal, so it blocks input to other windows
		setBounds(100, 100, 450, 300); // Set the size and position of the dialog
		setLocationRelativeTo(null); // Center the dialog on the screen
		getContentPane().setLayout(new BorderLayout()); // Use BorderLayout for the dialog
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Set border for content panel
		getContentPane().add(contentPanel, BorderLayout.CENTER); // Add content panel to the center of the dialog
		GridBagLayout gbl_contentPanel = new GridBagLayout(); // Create GridBagLayout for content panel
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 }; // Set column widths
		gbl_contentPanel.rowHeights = new int[] { 0, 76, 0, 0 }; // Set row heights
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE }; // Set column weights
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE }; // Set row weights
		contentPanel.setLayout(gbl_contentPanel); // Apply GridBagLayout to content panel
		
		// Label for serial number input
		JLabel lblSerialNoLabel = new JLabel("SerieNr:"); 
		lblSerialNoLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set font for the label
		GridBagConstraints gbc_lblSerialNoLabel = new GridBagConstraints(); // Create GridBagConstraints for label
		gbc_lblSerialNoLabel.insets = new Insets(0, 0, 0, 5); // Set insets
		gbc_lblSerialNoLabel.anchor = GridBagConstraints.EAST; // Align label to the east
		gbc_lblSerialNoLabel.gridx = 0; // Set gridx position
		gbc_lblSerialNoLabel.gridy = 2; // Set gridy position
		contentPanel.add(lblSerialNoLabel, gbc_lblSerialNoLabel); // Add label to content panel
		
		// Text field for user to enter serial number
		textField = new JTextField(); 
		GridBagConstraints gbc_textField = new GridBagConstraints(); // Create GridBagConstraints for text field
		gbc_textField.fill = GridBagConstraints.HORIZONTAL; // Fill horizontally
		gbc_textField.gridx = 1; // Set gridx position
		gbc_textField.gridy = 2; // Set gridy position
		contentPanel.add(textField, gbc_textField); // Add text field to content panel
		textField.setColumns(8); // Set the width of the text field

		// Panel for buttons
		JPanel buttonPane = new JPanel(); 
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Use FlowLayout for buttons
		getContentPane().add(buttonPane, BorderLayout.SOUTH); // Add button panel to the bottom of the dialog

		// Button to submit the serial number
		JButton næsteButton = new JButton("Næste");
		næsteButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20)); // Set font for the button
		næsteButton.addActionListener(new ActionListener() { // Add action listener to handle button click
			public void actionPerformed(ActionEvent e) {
				enteredValue = textField.getText(); // Retrieve entered serial number
				dispose(); // Close the dialog
			}
		});
		næsteButton.setActionCommand("OK"); // Set action command for the button
		buttonPane.add(næsteButton); // Add button to button panel
		getRootPane().setDefaultButton(næsteButton); // Set default button to 'Næste'
	}

	/**
	 * Gets the value entered by the user.
	 * 
	 * @return The entered serial number.
	 */
	public String getEnteredValue() {
		return enteredValue; // Return the entered serial number
	}
}