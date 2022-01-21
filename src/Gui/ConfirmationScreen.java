package Gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.JLabel;
import javax.swing.JButton;
import com.toedter.components.JLocaleChooser;
import classes.BusDailyTicket;
import classes.BusMonthlyTicket;
import classes.BusSingleTicket;
import classes.BusWeeklyTicket;


import java.awt.ComponentOrientation;

public class ConfirmationScreen implements ActionListener {

	static String s="";
	public JFrame frame;
	static String button_pressed;
	JButton back_btn = new JButton();
	static JTextPane textPane;
	
	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmationScreen window = new ConfirmationScreen();
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
	public ConfirmationScreen() {
		initialize();
	}
	public ConfirmationScreen(ArrayList<String> k) {
		initialize();
		showMessage(k);
		
	}
	
	 void showMessage(ArrayList<String> k)
	{
		
		int i=-1;
			for (String d:k) {
				if(i == -1) {
				s = s + "*****Ticket details*****\n" ;
				i++;
				}
				s= s +d+ "\n";
				i++;
				
		}


			
	}
	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\schi-\\eclipse-workspace\\TransportTiketsBookingAppProject\\resources\\ticket-icon-white-background-vector-illustration-eps-113357837.jpg"));

		textPane = new JTextPane();
		textPane.setBounds(30, 24, 367, 171);
		frame.getContentPane().add(textPane);
		textPane.setText(s);
		textPane.setEditable(false);
		back_btn = new JButton("Back");
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s="";
				if(button_pressed == "Bus Single Ticket") {
					BusSingleTicketScreen bus_single = new BusSingleTicketScreen();
					frame.setVisible(false);
					bus_single.NewBusSingleTicketScreen();

				}
				
				if(button_pressed == "Bus Daily Ticket") {
					BusDailyTicketScreen bus_daily = new BusDailyTicketScreen();
					frame.setVisible(false);
					bus_daily.NewBusDailyTicketScreen();

				}
				
				if(button_pressed == "Bus Weekly Ticket") {
					BusWeeklyTicketScreen bus_weekly = new BusWeeklyTicketScreen();
					frame.setVisible(false);
					bus_weekly.NewBusWeeklyTicketScreen();

				}
				
				if(button_pressed == "Bus Monthly Ticket") {
					BusMonthlyTicketScreen bus_monthly = new BusMonthlyTicketScreen();
					frame.setVisible(false);
					bus_monthly.NewBusMonthlyTicketScreen();

				}
				
				if(button_pressed == "Train Single Ticket") {
					TrainSingleTicketScreen train_single = new TrainSingleTicketScreen();
					frame.setVisible(false);
					train_single.TrainNewSingleTicket();

				}
				
				if(button_pressed == "Train Daily Ticket") {
					TrainDailyTicketScreen train_daily = new TrainDailyTicketScreen();
					frame.setVisible(false);
					train_daily.TrainNewDailyTicket();

				}
				if(button_pressed == "Train Weekly Ticket") {
					TrainWeeklyTicketScreen train_weekly = new TrainWeeklyTicketScreen();
					frame.setVisible(false);
					train_weekly.TrainNewWeeklyTicket();

				}
				if(button_pressed == "Train Monthly Ticket") {
					TrainMonthlyTicketScreen train_monthly = new TrainMonthlyTicketScreen();
					frame.setVisible(false);
					train_monthly.TrainNewMonthlyTicket();

				}
				



			}
		});
		back_btn.setBackground(new Color(255, 222, 173));
		back_btn.setBounds(30, 218, 89, 23);
		back_btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(back_btn);
		
		
		JButton btnNewButton_1 = new JButton("Confirm");
		btnNewButton_1.setBackground(new Color(176, 224, 230));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				PaymentScreen w2 = new PaymentScreen();
				w2.PaymentScreen();
			}
		});
		btnNewButton_1.setBounds(308, 218, 89, 23);
		btnNewButton_1.setBackground(new Color(255, 222, 173));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnNewButton_1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button =(JButton)e.getSource();
		button_pressed = button.getText();

		//System.out.println(button_pressed);
	}
}
