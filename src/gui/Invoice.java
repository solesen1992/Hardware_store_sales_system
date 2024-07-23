package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import model.Order;
import model.OrderLine;
import model.UniqueProduct;
import model.ProductCopy;

import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.Toolkit;

/**
 * JDialog window for displaying and printing the invoice for an order
 * 
 * @version 1.0
 */
public class Invoice extends JDialog {

	private static final long serialVersionUID = 1L;
	private static JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Invoice dialog = new Invoice(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Invoice(Order order) {
		// Set the icon image for the dialog
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\albie\\Downloads\\V logo.png"));
		setBounds(100, 100, 450, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());

		// Create and add a button panel at the bottom of the dialog
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}

		// Create and add a JTextPane for displaying the invoice
		{
			textPane = new JTextPane();
			textPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
			textPane.setEditable(false);
			getContentPane().add(textPane, BorderLayout.CENTER);
		}
	}

	/**
	 * Method to print the invoice content to the JTextPane
	 * 
	 * @param order The order for which the invoice is to be printed
	 */
	public void printInvoice(Order order) {

		// Setting up the header of the invoice
		textPane.setText("\t                 VestBjerg Byggecenter A/S \n");
		textPane.setText(textPane.getText() + "\t\t       9000 Aalborg \n");
		textPane.setText(textPane.getText() + "\t\t     CVR: 11111111 \n");

		// Adding date, order number, employee and customer details
		textPane.setText(textPane.getText() + "  Dato: "
				+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")) + "\n");
		textPane.setText(textPane.getText() + "  Ordrenummer: " + order.getOrderNo() + "\n");
		textPane.setText(textPane.getText() + "  Medarbejder: " + order.getEmployee().getName() + "\n");
		textPane.setText(textPane.getText() + "  Kunde: " + order.getCustomer().getName() + "\n");

		// Adding a separator
		textPane.setText(textPane.getText()
				+ "  ------------------------------------------------------------------------------------------------------\n");
		textPane.setText(textPane.getText() + "  Vare\t\t   Antal\t\t 	Beløb \n");
		textPane.setText(textPane.getText()
				+ "  ------------------------------------------------------------------------------------------------------\n");

		// Loop through the order lines and add product details
		for (OrderLine ol : order.getOrderLines()) {
			textPane.setText(textPane.getText() + "  " + ol.getProduct().getName() + "\t\t      " + ol.getQuantity()
					+ "\t\t\t" + ol.getProduct().getPrice() + "\n");
			if (ol.getProduct() instanceof UniqueProduct) {
				UniqueProduct up = (UniqueProduct) ol.getProduct();
				if (ol.getProductCopy() != null) {
					textPane.setText(textPane.getText() + "SerieNummer: " + ol.getProductCopy().getSerialNo() + "\n");
					textPane.setText(textPane.getText() + "Garanti: " + up.getWarranty() + " år" + "\n");
				}
			}
		}

		// Adding a separator and total amount
		textPane.setText(textPane.getText()
				+ "  ------------------------------------------------------------------------------------------------------\n");
		textPane.setText(textPane.getText() + "  Total: " + order.getTotal() + " Kr \n");

		// Adding a thank you message
		textPane.setText(textPane.getText() + "  ********************************************************************* \n");
		textPane.setText(textPane.getText() + "  \t                TAK FOR BESØGET OG PÅ GENSYN\n");
		textPane.setText(textPane.getText() + "  ********************************************************************* \n");
	}
}