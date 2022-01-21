package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JMonthChooser;

import classes.BusDailyTicket;
import classes.BusMonthlyTicket;
import classes.TrainMonthlyTicket;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Cursor;

public class TrainMonthlyTicketScreen {
	private final Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
	private String datePattern = "dd-MM-yyyy";
	private JFrame frame;
	private JTextField textField_name;
	public static  ArrayList<String> array_list = new ArrayList<>(); //list of ticket details
	public static String name;
	public static String month;


	/**
	 * Launch the application.
	 */
	public static void TrainNewMonthlyTicket() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainMonthlyTicketScreen window = new TrainMonthlyTicketScreen();
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
	public TrainMonthlyTicketScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 414);
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\schi-\\eclipse-workspace\\TransportTiketsBookingAppProject\\resources\\ticket-icon-white-background-vector-illustration-eps-113357837.jpg"));

		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.getSpinner().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		monthChooser.getComboBox().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		monthChooser.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 15));
		monthChooser.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 15));
		monthChooser.setBounds(170, 194, 125, 30);
		monthChooser.setLocale(Locale.ENGLISH);
		frame.getContentPane().add(monthChooser);
		
		JLabel lblNewLabel = new JLabel("Choose the month:");
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel.setBounds(170, 169, 179, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField_name.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "One of the fields is empty,please fill all the fields");
					//if the user doesn't fill one of the fields text,then error will appear

				}
				else {
					name = textField_name.getText();
					DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM",Locale.ENGLISH);
					month = monthFormatter.format(Month.of(monthChooser.getMonth() + 1));
					String kind_of_ticket="Train Monthly Ticket";
					TrainMonthlyTicket new_ticket = new TrainMonthlyTicket(kind_of_ticket,name,month);
					int price= new_ticket.getPrice();
				    char  shekel = '¤';
					if (!array_list.isEmpty()) { /* when array list is not empty,the items will be reset */
						array_list.clear();
					}
					array_list.add("Kind of ticket: "+ kind_of_ticket);
					array_list.add("Name: "+name);
					array_list.add("Month: "+ month);
					array_list.add("Price: " + price+ shekel);
					frame.setVisible(false);
					new ConfirmationScreen(array_list).NewScreen();
				    new InvoiceScreen(array_list);

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(374, 321, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back"); //goes back to previous screen
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ChooseTicketTrainType w2 = new ChooseTicketTrainType();
				w2.NewTrainScreen();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(37, 321, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your name:");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(170, 108, 153, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_name = new JTextField();
		textField_name.setBounds(170, 138, 125, 20);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
	}

}
