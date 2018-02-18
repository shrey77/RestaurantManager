package login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField usernameTxtField;
	private JTextField passwordTxtField;
	private JTextField emailTxtField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws ClassNotFoundException 
	 */
	public Registration() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.setBounds(300, 300, 350, 400);
		frame.getContentPane().setLayout(null);
		
		DatabaseConnection dataObject = new DatabaseConnection();
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(30, 100, 80, 20);
		frame.getContentPane().add(usernameLabel);
		
		usernameTxtField = new JTextField();
		usernameTxtField.setBounds(150, 100, 116, 22);
		frame.getContentPane().add(usernameTxtField);
		usernameTxtField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(30, 175, 80, 20);
		frame.getContentPane().add(passwordLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(30, 250, 38, 20);
		frame.getContentPane().add(emailLabel);
		
		passwordTxtField = new JTextField();
		passwordTxtField.setBounds(150, 175, 116, 22);
		frame.getContentPane().add(passwordTxtField);
		passwordTxtField.setColumns(10);
		
		emailTxtField = new JTextField();
		emailTxtField.setBounds(150, 250, 116, 22);
		frame.getContentPane().add(emailTxtField);
		emailTxtField.setColumns(10);
		
		JLabel registerLabel = new JLabel("Registration");
		registerLabel.setBounds(125, 50, 120, 20);
		frame.getContentPane().add(registerLabel);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = usernameTxtField.getText();
				String password = passwordTxtField.getText();
				String email = emailTxtField.getText();
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String today = simpleDateFormat.format(new Date());
				if(username != "" && password != "" && email != "" && email.matches("\\S+@\\S+")) {
					try {
						String query = "insert into login(username,password,email,creationDate) VALUES ('" + username + "','" + password + "','" + email
								+ "','" + today + "')";
						int registerQuery = dataObject.updateData(query);
						if(registerQuery > 0) {
							usernameTxtField.setText(null);
							passwordTxtField.setText(null);
							emailTxtField.setText(null);
							
							frame.setVisible(false);
							JOptionPane.showMessageDialog(null, "Registration Complete");
							
							frame.dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Could not register");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						dataObject.close();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect information was entered");
				}
			}
		});
		registerBtn.setBounds(125, 300, 120, 20);
		frame.getContentPane().add(registerBtn);
	}
}
