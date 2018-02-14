package managaer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Tables {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tables window = new Tables();
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
	public Tables() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		OrderManager manager = new OrderManager();
		
		JButton table1Btn = new JButton("Table 1");
		table1Btn.setFont(new Font("Serif", Font.BOLD, 32));
		table1Btn.setForeground(Color.WHITE);
		table1Btn.setBackground(Color.BLUE);
		table1Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.setTable(1);
				OrderManager.main(null);
				boolean order = manager.isOrdered();
				if(order) {
					table1Btn.setBackground(Color.RED);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, table1Btn, 20, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table1Btn, 52, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table1Btn, 107, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table1Btn, 212, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(table1Btn);
		
		JButton table2Btn = new JButton("Table 2");
		table2Btn.setFont(new Font("Serif", Font.BOLD, 32));
		table2Btn.setForeground(Color.WHITE);
		table2Btn.setBackground(Color.BLUE);
		table2Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.setTable(2);
				OrderManager.main(null);
				boolean order = manager.isOrdered();
				if(order) {
					table2Btn.setBackground(Color.RED);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, table2Btn, 0, SpringLayout.NORTH, table1Btn);
		springLayout.putConstraint(SpringLayout.WEST, table2Btn, 90, SpringLayout.EAST, table1Btn);
		springLayout.putConstraint(SpringLayout.SOUTH, table2Btn, 0, SpringLayout.SOUTH, table1Btn);
		frame.getContentPane().add(table2Btn);
		
		JButton table3Btn = new JButton("Table 3");
		table3Btn.setFont(new Font("Serif", Font.BOLD, 32));
		table3Btn.setForeground(Color.WHITE);
		table3Btn.setBackground(Color.BLUE);
		table3Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.setTable(3);
				OrderManager.main(null);
				boolean order = manager.isOrdered();
				if(order) {
					table3Btn.setBackground(Color.RED);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, table2Btn, -96, SpringLayout.WEST, table3Btn);
		springLayout.putConstraint(SpringLayout.NORTH, table3Btn, 20, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table3Btn, 0, SpringLayout.SOUTH, table1Btn);
		springLayout.putConstraint(SpringLayout.EAST, table3Btn, -64, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table3Btn, -224, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(table3Btn);
		
		JButton table5Btn = new JButton("Table 5");
		table5Btn.setFont(new Font("Serif", Font.BOLD, 32));
		table5Btn.setForeground(Color.WHITE);
		table5Btn.setBackground(Color.BLUE);
		table5Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.setTable(5);
				OrderManager.main(null);
				boolean order = manager.isOrdered();
				if(order) {
					table5Btn.setBackground(Color.RED);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, table5Btn, -116, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, table5Btn, 52, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table5Btn, -29, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table5Btn, 0, SpringLayout.EAST, table1Btn);
		frame.getContentPane().add(table5Btn);
		
		JButton table6Btn = new JButton("Table 6");
		table6Btn.setFont(new Font("Serif", Font.BOLD, 32));
		table6Btn.setForeground(Color.WHITE);
		table6Btn.setBackground(Color.BLUE);
		table6Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.setTable(6);
				OrderManager.main(null);
				boolean order = manager.isOrdered();
				if(order) {
					table6Btn.setBackground(Color.RED);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.WEST, table6Btn, 90, SpringLayout.EAST, table5Btn);
		springLayout.putConstraint(SpringLayout.SOUTH, table6Btn, -29, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(table6Btn);
		
		JButton table7Btn = new JButton("Table 7");
		table7Btn.setFont(new Font("Serif", Font.BOLD, 32));
		table7Btn.setForeground(Color.WHITE);
		table7Btn.setBackground(Color.BLUE);
		table7Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.setTable(7);
				OrderManager.main(null);
				boolean order = manager.isOrdered();
				if(order) {
					table7Btn.setBackground(Color.RED);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, table6Btn, -96, SpringLayout.WEST, table7Btn);
		springLayout.putConstraint(SpringLayout.SOUTH, table7Btn, 0, SpringLayout.SOUTH, table5Btn);
		springLayout.putConstraint(SpringLayout.NORTH, table7Btn, 0, SpringLayout.NORTH, table5Btn);
		springLayout.putConstraint(SpringLayout.WEST, table7Btn, -224, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, table7Btn, 0, SpringLayout.EAST, table3Btn);
		frame.getContentPane().add(table7Btn);
		
		JButton table4Btn = new JButton("Table 4");
		table4Btn.setFont(new Font("Serif", Font.BOLD, 32));
		table4Btn.setForeground(Color.WHITE);
		table4Btn.setBackground(Color.BLUE);
		table4Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manager.setTable(4);
				OrderManager.main(null);
				boolean order = manager.isOrdered();
				if(order) {
					table4Btn.setBackground(Color.RED);
				}
			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, table6Btn, 31, SpringLayout.SOUTH, table4Btn);
		springLayout.putConstraint(SpringLayout.NORTH, table4Btn, 29, SpringLayout.SOUTH, table1Btn);
		springLayout.putConstraint(SpringLayout.WEST, table4Btn, 195, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, table4Btn, -31, SpringLayout.NORTH, table5Btn);
		springLayout.putConstraint(SpringLayout.EAST, table4Btn, 570, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(table4Btn);
		frame.setBounds(200, 200, 800, 600);
	}
}
