package Gui;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.Canvas;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JDesktopPane;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.border.LineBorder;

public class ChooseTransport {

	public JFrame frame;
	private ImageIcon background;
	private JLabel mylabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseTransport window = new ChooseTransport();
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
	public ChooseTransport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.WHITE);
		frame.setFont(new Font("Dialog", Font.PLAIN, 15));
		frame.setBackground(Color.WHITE);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\schi-\\eclipse-workspace\\TransportTiketsBookingAppProject\\resources\\ticket-icon-white-background-vector-illustration-eps-113357837.jpg"));
		frame.getContentPane().setBackground(new Color(250, 235, 215));
		frame.setBounds(100, 100, 510, 414);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		JButton btnNewButton = new JButton("Bus");
		btnNewButton.setFocusPainted(false);   
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Sitka Display", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(233, 150, 122));
		btnNewButton.setBounds(90, 223, 136, 89);
		btnNewButton.addActionListener(new ActionListener() {
			//pressing the Bus button will transfer to Choose Ticket Bus Type Screen
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				ChooseTicketBusType w1 = new ChooseTicketBusType();
				w1.NewBusScreen();				
			}
		});
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton); //add Bus button to frame
		
		JButton btnNewButton_1 = new JButton("Train"); // Train button
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setFont(new Font("Sitka Display", Font.BOLD, 20));
		btnNewButton_1.setBackground(new Color(233, 150, 122));
		btnNewButton_1.setBounds(261, 223, 136, 89);
		btnNewButton_1.addActionListener(new ActionListener() {  
			//pressing the Train button will transfer to Choose Ticket Train Type Screen
			public void actionPerformed(ActionEvent e) { 
				frame.setVisible(false); 
				ChooseTicketTrainType w2 = new ChooseTicketTrainType();
				w2.NewTrainScreen();


			}
		});
		frame.getContentPane().add(btnNewButton_1); // add Train button to frame
		
		JLabel lblNewLabel = new JLabel("Choose a transport:"); 
		lblNewLabel.setFont(new Font("Sitka Display", Font.PLAIN, 22));
		lblNewLabel.setBounds(156, 120, 188, 83);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Transport Ticket Booking");
		lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 35));
		lblNewLabel_1.setBounds(55, 40, 399, 77);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
