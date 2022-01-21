package Gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import classes.TrainDailyTicket;
import classes.TrainSingleTicket;
import classes.TrainWeeklyTicket;
import classes.TrainMonthlyTicket;
import java.awt.Cursor;

public class ChooseTicketTrainType   {

	private JFrame frame;
	JButton button = new JButton(); //Train Single Ticket button
	private JButton button_3; //Train Monthly Ticket button
	private JButton button_2; //Train Weekly Ticket button
	private JButton button_1; //Train Daily Ticket button
	ConfirmationScreen conf = new ConfirmationScreen();
	/**
	 * Launch the application.
	 */
	public static void NewTrainScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseTicketTrainType window = new ChooseTicketTrainType();
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
	public ChooseTicketTrainType() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 510, 414);
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\schi-\\eclipse-workspace\\TransportTiketsBookingAppProject\\resources\\ticket-icon-white-background-vector-illustration-eps-113357837.jpg"));

		button = new JButton("Train Single Ticket");
		button.setFocusPainted(false);   
		button.setForeground(new Color(255, 255, 255));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setFont(new Font("Sitka Display", Font.BOLD, 18));
		button.setBackground(new Color(233, 150, 122));
		button.addActionListener(conf);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pressing the Train Single Ticket button will transfer to Train Single Ticket Screen

				String str= button.getText();
				frame.setVisible(false);
				TrainSingleTicketScreen t1 = new TrainSingleTicketScreen();
				t1.TrainNewSingleTicket();
			}
		});
		button.setBounds(37, 120, 201, 68);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("Train Daily Ticket");
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_1.setFont(new Font("Sitka Display", Font.BOLD, 18));
		button_1.setBackground(new Color(233, 150, 122));
		button_1.addActionListener(conf);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pressing the Train Daily Ticket button will transfer to Train Daily Ticket Screen

				String str= button.getText();
				frame.setVisible(false);
				TrainDailyTicketScreen t1 = new TrainDailyTicketScreen();
				t1.TrainNewDailyTicket();
				
			}
		});
		button_1.setBounds(260, 120, 201, 68);
		frame.getContentPane().add(button_1);
		
		button_2  = new JButton("Train Weekly Ticket");
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_2.setFont(new Font("Sitka Display", Font.BOLD, 18));
		button_2.setBackground(new Color(233, 150, 122));
		button_2.addActionListener(conf);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pressing the Train Weekly Ticket button will transfer to Train Weekly Ticket Screen

				String str= button.getText();
				frame.setVisible(false);
				TrainWeeklyTicketScreen t1 = new TrainWeeklyTicketScreen();
				t1.TrainNewWeeklyTicket();
			}
		});
		button_2.setBounds(37, 211, 201, 68);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("Train Monthly Ticket");
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button_3.setFont(new Font("Sitka Display", Font.BOLD, 18));
		button_3.setBackground(new Color(233, 150, 122));
		button_3.addActionListener(conf);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pressing the Train Monthly Ticket button will transfer to Train Monthly Ticket Screen

				String str= button.getText();
				frame.setVisible(false);
				TrainMonthlyTicketScreen t1 = new TrainMonthlyTicketScreen();
				t1.TrainNewMonthlyTicket();
			}
		});
		button_3.setBounds(260, 211, 201, 68);
		frame.getContentPane().add(button_3);
	
		
		JLabel lblNewLabel = new JLabel("Choose kind of train ticket:");
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		lblNewLabel.setBounds(120, 48, 263, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("Back");
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_4.setBackground(new Color(255, 222, 173));
		btnNewButton_4.addActionListener(new ActionListener() {
			//goes back to previous screen
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ChooseTransport w2 = new ChooseTransport();
				w2.initialize();
				w2.frame.setVisible(true);
				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(27, 330, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		//frame.setVisible(true);
	}
}
