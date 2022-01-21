package Gui;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerDateModel;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.Date;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;

import classes.BusSingleTicket;

import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class BusSingleTicketScreen {
	private final Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
	private String datePattern = "dd-MM-yyyy";
	String type="Bus Single";

	public JFrame frame;
	public JTextField textField_name; //Name input
	public JTextPane textPane;
	public static  ArrayList<String> array_list = new ArrayList<>(); //list of ticket details
	public static String name;
	public static String bus;
	public static int bus_num;
	public static String date;
	public static String time;

	ConfirmationScreen conf = new ConfirmationScreen();
	

	/**
	 * Launch the application.
	 */
	public static void NewBusSingleTicketScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusSingleTicketScreen window = new BusSingleTicketScreen();
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
	public BusSingleTicketScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setBounds(100, 100, 510, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\schi-\\eclipse-workspace\\TransportTiketsBookingAppProject\\resources\\ticket-icon-white-background-vector-illustration-eps-113357837.jpg"));

		
		JTextField bus_number_input = new JTextField();
		bus_number_input.setEditable(true);
		bus_number_input.setBounds(167, 188, 149, 20);
		
		frame.getContentPane().add(bus_number_input);
		bus_number_input.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Write the bus line number:");
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel.setBounds(166, 160, 223, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(166, 130, 149, 19);
		dateChooser.setMinSelectableDate(new Date());
		dateChooser.setLocale(Locale.ENGLISH);
		dateChooser.setDateFormatString(datePattern);

		frame.getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_2 = new JLabel("Choose the date:");
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(166, 112, 167, 20);
		
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Choose the time:");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(167, 220, 167, 26);
		
		frame.getContentPane().add(lblNewLabel_3);
		
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		timeSpinner.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		timeSpinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timeSpinner.setBounds(167, 242, 149, 20);
	
		frame.getContentPane().add(timeSpinner);
		
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date()); 

	    SimpleDateFormat Date_Format = new SimpleDateFormat("dd-MM-yyyy"); 

		JButton btnNewButton = new JButton("Next");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField_name.getText().isEmpty()) ||(bus_number_input.getText().isEmpty())||
						dateChooser.getDate() == null || (timeSpinner.getValue() == null) ) {
					JOptionPane.showMessageDialog(null, "One of the fields is empty,please fill all the fields");
					//if the user doesn't fill one of the fields text,then error will appear
				}
				else {
					String kind_of_ticket = "Bus Single Ticket";
				    name = textField_name.getText();
				    bus = bus_number_input.getText();
				    bus_num = Integer.parseInt(bus);
				    date = Date_Format.format(dateChooser.getDate());
				    time = timeEditor.getFormat().format(timeSpinner.getValue());
				    BusSingleTicket new_ticket = new BusSingleTicket(kind_of_ticket,name,bus_num,date,time);
				    int price = new_ticket.getPrice();
				    char  shekel = '¤';
				    if (!array_list.isEmpty()) {  /* when array list is not empty,the items will be reset */
				    	array_list.clear(); 
				     }
				    array_list.add("Kind of ticket: "+ kind_of_ticket);
				    array_list.add("Name: "+ name);
				    array_list.add("Bus Line: " + bus);
				    array_list.add("Date: " + date);
				    array_list.add("Time: "+ time);
				    array_list.add("Price: " + price +shekel);
				    frame.setVisible(false);
				    new ConfirmationScreen(array_list).NewScreen(); 
				    new InvoiceScreen(array_list);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(374, 315, 89, 26);
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
		btnNewButton_1.setBounds(34, 315, 89, 26);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("Enter your name:");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(166, 47, 167, 26);
		frame.getContentPane().add(lblNewLabel_1);
		textField_name = new JTextField();
		textField_name.setCaretColor(new Color(0, 0, 0));
		textField_name.setHorizontalAlignment(SwingConstants.LEFT);
		textField_name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_name.setBounds(166, 74, 149, 20);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
		
		 
	}
}
