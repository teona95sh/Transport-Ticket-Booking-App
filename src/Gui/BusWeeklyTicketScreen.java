package Gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import classes.BusWeeklyTicket;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Cursor;

public class BusWeeklyTicketScreen  {

	private JFrame frame;
	private final Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
	private String datePattern = "dd-MM-yyyy";
	private Date end_date;
	private JTextField textField_name;
	static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
	public static  ArrayList<String> array_list = new ArrayList<>(); //list of ticket details
	public static String name;
	public static String start_date;
	public static String final_date;

	/**
	 * Launch the application.
	 */
	public static void NewBusWeeklyTicketScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusWeeklyTicketScreen window = new BusWeeklyTicketScreen();
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
	public BusWeeklyTicketScreen() {
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
		
		JLabel lblNewLabel = new JLabel("Choose the start date:");
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel.setBounds(165, 178, 173, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(165, 205, 149, 19);
		dateChooser.setMinSelectableDate(new Date());
		dateChooser.setLocale(Locale.ENGLISH);
		dateChooser.setDateFormatString(datePattern);
		frame.getContentPane().add(dateChooser);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(368, 332, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField_name.getText().isEmpty()) ||
						dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "One of the fields is empty,please fill all the fields");
					//if the user doesn't fill one of the fields text,then error will appear
				}
				else {
					String kind_of_ticket = "Bus Weekly Ticket";
					name = textField_name.getText();
					SimpleDateFormat Date_Format = new SimpleDateFormat("dd-MM-yyyy"); 
					start_date = Date_Format.format(dateChooser.getDate());
					Calendar cal = Calendar.getInstance();
					cal.setTime(dateChooser.getDate());
					cal.add(Calendar.DATE, 7);
					end_date = cal.getTime();
					final_date =Date_Format.format(end_date);
					BusWeeklyTicket new_ticket = new BusWeeklyTicket(kind_of_ticket,name,start_date,final_date);
					int price= new_ticket.getPrice();
				    char  shekel = '?';
					if (!array_list.isEmpty()) { /* when array list is not empty,the items will be reset */
						array_list.clear();
					}
					array_list.add("Kinf of Ticket: "+kind_of_ticket);
					array_list.add("Name: "+name);
					array_list.add("Start Date: "+start_date);
					array_list.add("End Date: "+ final_date);
					array_list.add("Price: "+price + shekel);
					frame.setVisible(false);
					new ConfirmationScreen(array_list).NewScreen();
				    new InvoiceScreen(array_list);

				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back"); //goes back to previous screen
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ChooseTicketBusType w2 = new ChooseTicketBusType();
				w2.NewBusScreen();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(43, 332, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your name:");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(165, 123, 149, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_name = new JTextField();
		textField_name.setBounds(163, 147, 151, 20);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
		//frame.setVisible(true);

	}

}
