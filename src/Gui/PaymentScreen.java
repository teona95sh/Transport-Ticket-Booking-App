package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PaymentScreen { //without payment option and verification

	private JFrame frame;
	private JTextField textField_card; 
	private JTextField textField_cvv;
	private JTextField textField_holder_name;
	private JTextField textField_month;
	private JTextField textField_year;
	private static String name;
	private static String year;
	private static String month;
	private static String holder_name;
	private static String cvv;
	private static String card;
	private static int card_num;
	private static int year_num;


	/**
	 * Launch the application.
	 */
	public static void PaymentScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentScreen window = new PaymentScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\schi-\\eclipse-workspace\\TransportTiketsBookingAppProject\\resources\\ticket-icon-white-background-vector-illustration-eps-113357837.jpg"));

		
		JLabel lblNewLabel = new JLabel("Enter your credit card number:");
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel.setBounds(132, 71, 259, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Expiry date:");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(132, 130, 144, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CVV:");
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(132, 213, 49, 29);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Card holder name:");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(132, 260, 205, 27);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_card = new JTextField();
		textField_card.setBounds(133, 99, 205, 20);
		frame.getContentPane().add(textField_card);
		textField_card.setColumns(10);
		
		textField_cvv = new JTextField();
		textField_cvv.setBounds(133, 235, 205, 20);
		frame.getContentPane().add(textField_cvv);
		textField_cvv.setColumns(10);
		
		textField_holder_name = new JTextField();
		textField_holder_name.setBounds(133, 286, 205, 20);
		frame.getContentPane().add(textField_holder_name);
		textField_holder_name.setColumns(10);
		
		textField_month = new JTextField();
		textField_month.setBounds(133, 183, 70, 20);
		frame.getContentPane().add(textField_month);
		textField_month.setColumns(10);
		
		textField_year = new JTextField();
		textField_year.setBounds(237, 183, 101, 20);
		frame.getContentPane().add(textField_year);
		textField_year.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Month:");
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(132, 161, 70, 27);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Year:");
		lblNewLabel_5.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(237, 161, 101, 27);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("Pay ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField_holder_name.getText().isEmpty()) ||(textField_year.getText().isEmpty()) ||
						(textField_month.getText().isEmpty()) || (textField_card.getText().isEmpty()) || 
								(textField_cvv.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "One of the fields is empty,please fill all the fields");
					//if the user doesn't fill one of the fields text,then error will appear
				}
				else {
					name = textField_holder_name.getText();
					year = textField_year.getText();
				    year_num = Integer.parseInt(year);
				    month = textField_month.getText();
				    card = textField_card.getText();
				    card_num  =Integer.parseInt(year);
				    cvv = textField_cvv.getText();
				
				    frame.setVisible(false);
			        InvoiceScreen screen = new InvoiceScreen();
			        screen.NewInvoiceScreen();
			}
			    
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(365, 329, 89, 23);
		btnNewButton.setBackground(new Color(255, 222, 173));
		frame.getContentPane().add(btnNewButton);
	}
}
