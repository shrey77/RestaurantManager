package managaer;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextField;

import login.Registration;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton tableBtn = new JButton("Tables");
		tableBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tableBtn.setBounds(250, 135, 307, 46);
		frame.getContentPane().add(tableBtn);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(250, 242, 307, 46);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(250, 343, 307, 46);
		frame.getContentPane().add(button_1);
		
		JButton newUserBtn = new JButton("Register New User");
		newUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration.main(null);
			}
		});
		newUserBtn.setBounds(250, 451, 307, 46);
		frame.getContentPane().add(newUserBtn);
		
		JLabel restaurantManagerLabel = new JLabel("Restaurant Manager");
		restaurantManagerLabel.setFont(new Font("Serif", Font.BOLD, 36));
		restaurantManagerLabel.setBounds(270, 55, 56, 16);
		frame.getContentPane().add(restaurantManagerLabel);
	}
}
