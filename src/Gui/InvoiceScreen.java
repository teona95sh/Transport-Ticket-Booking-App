package Gui;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;

public class InvoiceScreen {

	private JFrame frame;
	static String s="";


	/**
	 * Launch the application.
	 */
	public static void NewInvoiceScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceScreen window = new InvoiceScreen();
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
	/**
	 * @wbp.parser.constructor
	 */
	public InvoiceScreen() {
		initialize();
	}
	public InvoiceScreen(ArrayList<String> k) {
		initialize();
		showMessage(k);
	}
	
	 void showMessage(ArrayList<String> k)
		{
			
			int i=-1;
				for (String d:k) {
					if(i == -1) {
					s = s + "*****Ticket*****\n" ;
					i++;
					}
					s= s +d+ "\n";
					i++;
				}
			}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\schi-\\eclipse-workspace\\TransportTiketsBookingAppProject\\resources\\ticket-icon-white-background-vector-illustration-eps-113357837.jpg"));

		
		JLabel lblNewLabel = new JLabel("Payment verified");
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel.setBounds(141, 11, 179, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(89, 67, 253, 144);
		textPane.setText(s);
		frame.getContentPane().add(textPane);
		
		
		JLabel lblNewLabel_1 = new JLabel("Your ticket is ready!");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(130, 33, 179, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Print"); //printing the ticket
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean print = textPane.print();
					if(!print) {
						JOptionPane.showMessageDialog(null, "Unable to print...");
					}

				} catch (PrinterException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(324, 229, 89, 23);
		btnNewButton.setBackground(new Color(255, 222, 173));
		frame.getContentPane().add(btnNewButton);
	}
}
