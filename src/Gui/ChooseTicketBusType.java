package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Color;
import classes.BusDailyTicket;
import classes.BusMonthlyTicket;
import classes.BusSingleTicket;
import classes.BusWeeklyTicket;
import java.awt.Cursor;

public class ChooseTicketBusType  {

	private JFrame frame;
	JButton button = new JButton(); //Bus Single Ticket
	private JButton button_3; //Bus Monthly Ticket
	private JButton button_2; //Bus Weekly Ticket
	private JButton button_1; //Bus Daily Ticket
	ConfirmationScreen conf = new ConfirmationScreen();

	/**
	 * Launch the application.
	 */
	public static void NewBusScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseTicketBusType window = new ChooseTicketBusType();
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
	public ChooseTicketBusType() {
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
		
		button = new JButton("Bus Single Ticket");
		button.setForeground(new Color(255, 255, 255));
		button.setFocusPainted(false);   
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Sitka Display", Font.BOLD, 18));
		button.setBackground(new Color(233, 150, 122));
		button.addActionListener(conf);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//pressing the Bus Single Ticket button will transfer to Bus Single Ticket Screen
				String str= button.getText();
				frame.setVisible(false);
				BusSingleTicketScreen w1 = new BusSingleTicketScreen();
				w1.NewBusSingleTicketScreen();				
			}
		});
		button.setBounds(41, 119,  201, 68);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("Bus Daily Ticket");
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setFont(new Font("Sitka Display", Font.BOLD, 18));
		button_1.setBackground(new Color(233, 150, 122));
		button_1.addActionListener(conf);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//pressing the Bus Daily Ticket button will transfer to Bus Daily Ticket Screen
				String str= button.getText();
				frame.setVisible(false);
				BusDailyTicketScreen w2 = new BusDailyTicketScreen();
				w2.NewBusDailyTicketScreen();
			}
		});
		button_1.setBounds(262, 119, 201, 68);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("Bus Weekly Ticket");
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setFont(new Font("Sitka Display", Font.BOLD, 18));
		button_2.setBackground(new Color(233, 150, 122));
		button_2.addActionListener(conf);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			//pressing the Bus Weekly Ticket button will transfer to Bus Weekly Ticket Screen
				String str= button.getText();
				frame.setVisible(false);
				BusWeeklyTicketScreen w2 = new BusWeeklyTicketScreen();
				w2.NewBusWeeklyTicketScreen();

			}
		});
		button_2.setBounds(41, 202,  201, 68);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("Bus Monthly Ticket");
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setFont(new Font("Sitka Display", Font.BOLD, 18));
		button_3.setBackground(new Color(233, 150, 122));
		button_3.addActionListener(conf);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//pressing the Bus Monthly Ticket button will transfer to Bus Monthly Ticket Screen
				String str= button.getText();
				frame.setVisible(false);
				BusMonthlyTicketScreen w3 = new BusMonthlyTicketScreen();
				w3.NewBusMonthlyTicketScreen();

			}
		});
		button_3.setBounds(262, 202, 201, 68);
		frame.getContentPane().add(button_3);
		
		JLabel lblNewLabel = new JLabel("Choose kind of bus ticket:");
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		lblNewLabel.setBounds(136, 54, 262, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Back"); 
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBackground(new Color(255, 222, 173));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//goes back to previous screen
				frame.setVisible(false);
				ChooseTransport w2 = new ChooseTransport();
				w2.initialize();
				w2.frame.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(27, 330, 89, 23);
		frame.getContentPane().add(btnNewButton_4);

	}

}
