package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextField;

import managaer.RestaurantManager;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginSystem {

	private JFrame frame;
	private JTextField usernameInput;
	private JPasswordField passwordInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSystem window = new LoginSystem();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public LoginSystem() throws ClassNotFoundException, SQLException {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		
		DatabaseConnection dataObject = new DatabaseConnection();
		
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(200, 200, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel loginLabel = new JLabel("Restaurant Manager Login");
		loginLabel.setBounds(209, 36, 150, 16);
		frame.getContentPane().add(loginLabel);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(71, 98, 73, 16);
		frame.getContentPane().add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(71, 175, 73, 16);
		frame.getContentPane().add(passwordLabel);
		
		usernameInput = new JTextField();
		usernameInput.setBounds(171, 95, 351, 22);
		frame.getContentPane().add(usernameInput);
		usernameInput.setColumns(10);
		
		passwordInput = new JPasswordField();
		passwordInput.setBounds(171, 172, 351, 22);
		frame.getContentPane().add(passwordInput);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				usernameInput.setText(null);
				passwordInput.setText(null);
			}
		});
		resetBtn.setBounds(50, 250, 97, 25);
		frame.getContentPane().add(resetBtn);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet loginQuery;
				String username = usernameInput.getText();
				String password = passwordInput.getText();
				System.out.println("Made it in LoginBtn");
				try {
					loginQuery = dataObject.queryData("Select * from login where username='"+username+"' AND password='"+password+"'");
					if(loginQuery.next()) {
						usernameInput.setText(null);
						passwordInput.setText(null);
						
						RestaurantManager manager = new RestaurantManager();
						RestaurantManager.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "Invalid Login");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		});
		loginBtn.setBounds(250, 250, 97, 25);
		frame.getContentPane().add(loginBtn);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		exitBtn.setBounds(450, 250, 97, 25);
		frame.getContentPane().add(exitBtn);
		
		JButton forgetPassBtn = new JButton("Forgot Password");
		forgetPassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		forgetPassBtn.setBounds(330, 300, 150, 25);
		frame.getContentPane().add(forgetPassBtn);
		
		JButton newUserBtn = new JButton("Create New Account");
		newUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		newUserBtn.setBounds(130, 300, 150, 25);
		frame.getContentPane().add(newUserBtn);
	}
}
