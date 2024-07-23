package gui;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Order;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.OrderController;
import java.awt.Toolkit;

/**
 * GUI for the Payment dialog
 * 
 * @version 1.0
 */
public class Payment extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCard;
	private JButton cancelButton;
	private Order order; 
	private OrderController oc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Payment dialog = new Payment(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * 
	 * @param oc The OrderController instance
	 */
	public Payment(OrderController oc) {
		// Set the icon image for the dialog
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\albie\\Downloads\\V logo.png"));
		this.oc = oc;
		this.order = oc.getOrder();
		setModal(true); // Make the dialog modal
		setBounds(100, 100, 600, 500); // Set the size and position of the dialog
		setLocationRelativeTo(null); // Center the dialog on the screen
		getContentPane().setLayout(null);

		// Configure the content panel
		contentPanel.setBounds(0, 0, 600, 370);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);

		// Add the "Cash" button
		JButton btnCash = new JButton("Kontant");
		btnCash.setBounds(180, 60, 250, 80);
		btnCash.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		contentPanel.add(btnCash);

		// Add the "Card" button
		btnCard = new JButton("Betalingskort");
		btnCard.setBounds(180, 160, 250, 80);
		btnCard.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		contentPanel.add(btnCard);

		// Configure the button panel
		JPanel buttonPane = new JPanel();
		buttonPane.setBounds(0, 350, 600, 89);
		getContentPane().add(buttonPane);
		buttonPane.setLayout(null);

		// Add the "Cancel" button
		cancelButton = new JButton("Tilbage");
		cancelButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		cancelButton.setBounds(240, 30, 150, 60);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

		// Add the "Print" button and its ActionListener
		JButton btnPrintInvoice = new JButton("Print");
		btnPrintInvoice.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		btnPrintInvoice.setBounds(400, 30, 150, 60);
		btnPrintInvoice.setActionCommand("Print\n");
		buttonPane.add(btnPrintInvoice);
		
		btnPrintInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				printInvoicePayed();
			}
		});
	}

	/**
	 * Handle the printing of the invoice
	 */
	private void printInvoicePayed() {
		setVisible(false); // Hide the current dialog
		dispose(); // Dispose of system resources associated with the dialog
		Order orderToPrint = oc.completeOrder(); // Complete the order
		Invoice invoice = new Invoice(orderToPrint); // Create an instance of the Invoice class
		invoice.setSize(450, 500); // Set the size of the Invoice dialog
		invoice.printInvoice(order); // Print the invoice
		invoice.setVisible(true); // Display the Invoice dialog
	}
}