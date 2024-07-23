package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Employee;
import model.Order;
import model.Product;
import controller.OrderController;
import controller.ProductController;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * GUI for the Order Menu
 * 
 * @version 1.0
 */
public class OrderMenu extends JFrame {
	private OrderController orderController;
	private Order currentOrder;
	private StartGUI sg;
	private Product currProduct;
	private ProductController pc;
	private Employee employee;
	private JButton btnOK;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMenu frame = new OrderMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderMenu() {
		// Set the icon image for the frame
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\albie\\Downloads\\V logo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Set the layout for the content pane
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		// Add a label for the OrderMenu title
		JLabel lblNewLabel_1 = new JLabel("OrderMenu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		// Add a panel for input fields and buttons
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 17, 0, 0, 20, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		// Add a label and text field for the barcode
		JLabel lblStregkode = new JLabel("Stregkode:");
		lblStregkode.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblStregkode = new GridBagConstraints();
		gbc_lblStregkode.anchor = GridBagConstraints.EAST;
		gbc_lblStregkode.insets = new Insets(0, 0, 5, 5);
		gbc_lblStregkode.gridx = 0;
		gbc_lblStregkode.gridy = 0;
		panel.add(lblStregkode, gbc_lblStregkode);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		// Add a label and text field for the quantity
		JLabel lblNewLabel = new JLabel("Antal");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		// Add a button to handle unique products
		JButton btnNewButton = new JButton("UnikProdukt");
		btnNewButton.addActionListener(new ActionListener() {
			SerialNo serialNo = new SerialNo();
			public void actionPerformed(ActionEvent e) {
				serialNo.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 2;
		panel.add(btnNewButton, gbc_btnNewButton);

		// Add a panel for the OK button
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		contentPane.add(panel_2, gbc_panel_2);

		// Add the OK button
		btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				okClicked();
				sg.displayOrder();
			}
		});
		btnOK.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_2.add(btnOK);

		init();
	}

	/**
	 * Initialize the controllers and StartGUI
	 */
	private void init() {
		orderController = new OrderController(employee);
		pc = new ProductController(); // ProductController is stateless
		sg = new StartGUI();
	}

	/**
	 * Handle the OK button click
	 */
	private void okClicked() {
		String stregkode = textField.getText();
		String antal = textField_1.getText();

		if (currProduct != null) {
			currProduct = pc.findProduct(stregkode);
			if (!stregkode.isEmpty() && !antal.isEmpty()) {
				int quantity = Integer.parseInt(antal);
				orderController.findAndAddProduct(stregkode, quantity);
			}
		}
	}

	/**
	 * Notify the StartGUI to display the order
	 * 
	 * @param sg The StartGUI instance
	 */
	public void toNotify(StartGUI sg) {
		this.sg = sg;
	}
}