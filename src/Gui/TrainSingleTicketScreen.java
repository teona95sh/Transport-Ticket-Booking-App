package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import com.toedter.calendar.JDateChooser;

import classes.TrainSingleTicket;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class TrainSingleTicketScreen {
	private final Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
	private String datePattern = "dd-MM-yyyy";
	private JFrame frame;
	private JTextField textField_1st_station;
	private JTextField textField_final_station;
	private JTextField textField_name;
	public static  ArrayList<String> array_list = new ArrayList<>(); //list of ticket details
	public static String name;
	public static String bus;
	public static int bus_num;
	public static String date;
	public static String time;
	public static String first_station;
	public static String final_station;


	/**
	 * Launch the application.
	 */
	public static void TrainNewSingleTicket() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrainSingleTicketScreen window = new TrainSingleTicketScreen();
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
	public TrainSingleTicketScreen() {
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		dateChooser.setBounds(168, 212, 149, 19);
		dateChooser.setMinSelectableDate(new Date());
		dateChooser.setLocale(Locale.ENGLISH);
		dateChooser.setDateFormatString(datePattern);
		frame.getContentPane().add(dateChooser);
		
		JLabel lblNewLabel_2 = new JLabel("Choose the date:");
		lblNewLabel_2.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(168, 189, 167, 23);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Choose the time:");
		lblNewLabel_3.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(168, 242, 167, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
		timeSpinner.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		timeSpinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		timeSpinner.setBounds(168, 268, 149, 20);
		frame.getContentPane().add(timeSpinner);
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
		timeSpinner.setEditor(timeEditor);
		timeSpinner.setValue(new Date()); 
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField_name.getText().isEmpty()) || (textField_1st_station.getText().isEmpty()) ||
					(textField_final_station).getText().isEmpty() ||	dateChooser.getDate() == null || (timeSpinner.getValue() == null) ) {
					JOptionPane.showMessageDialog(null, "One of the fields is empty,please fill all the fields");
					//if the user doesn't fill one of the fields text,then error will appear

				}
				else {
					String kind_of_ticket = "Train Single Ticket";
				    name = textField_name.getText();
					first_station = textField_1st_station.getText();
					final_station = textField_final_station.getText();
					SimpleDateFormat Date_Format = new SimpleDateFormat("dd-MM-yyyy"); 
					date = Date_Format.format(dateChooser.getDate());
					time = timeEditor.getFormat().format(timeSpinner.getValue());
					TrainSingleTicket new_ticket = new TrainSingleTicket(kind_of_ticket,name,first_station,final_station,date,time);
					int price= new_ticket.getPrice();
				    char  shekel = '¤';
					if (!array_list.isEmpty()) { /* when array list is not empty,the items will be reset */
						array_list.clear();
					}
					array_list.add("Kind of ticket: "+ kind_of_ticket);
					array_list.add("Name: "+ name);
					array_list.add("Start station: "+first_station);
					array_list.add("End station: "+final_station);
					array_list.add("Date: " + date);
					array_list.add("Time: "+ time);
					array_list.add("Price: " + price + shekel);
					frame.setVisible(false);
					new ConfirmationScreen(array_list).NewScreen();
				    new InvoiceScreen(array_list);

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(364, 322, 89, 26);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Write the name of\r\n the start station:");
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel.setBounds(168, 60, 293, 36);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1st_station = new JTextField();
		textField_1st_station.setBounds(168, 95, 149, 20);
		frame.getContentPane().add(textField_1st_station);
		textField_1st_station.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Write the name of the end station:");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(165, 126, 288, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_final_station = new JTextField();
		textField_final_station.setBounds(168, 151, 149, 20);
		frame.getContentPane().add(textField_final_station);
		textField_final_station.setColumns(10);
		
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
		btnNewButton_1.setBounds(39, 324, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("Enter your name:");
		lblNewLabel_4.setFont(new Font("Sitka Display", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(165, 11, 234, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_name = new JTextField();
		textField_name.setBounds(166, 36, 151, 20);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
	}
}
