package managaer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JScrollPane;

public class OrderManager {

	private JFrame frame;
	private JTable orderTable;
	private final JPanel panel = new JPanel();
	private static int tableNum;
	private static boolean ordered;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderManager window = new OrderManager();
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
	public OrderManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(200, 200, 800, 600);
			
		String[] menuItems = {"Pasta", "Lasagna", "Breadsticks", "Soup", "Salad"};
		Integer[] quantity = new Integer[10];
		for(int i = 1; i <= 10; i++) {
			quantity[i-1] = i;
		}
				
		Object[] columnNames = {"Item", "Quantity", "Price", "Item Total"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(408, 164, 374, 338);
		frame.getContentPane().add(scrollPane);
		JTable orderTable_1 = new JTable(model);
		orderTable_1.setBounds(408, 164, 339, 360);
		orderTable_1.setBackground(Color.GRAY);
		orderTable_1.setForeground(Color.WHITE);
		orderTable_1.setFont(new Font("Serif", Font.PLAIN, 24));
		orderTable_1.setRowHeight(30);
		scrollPane.setViewportView(orderTable_1);
		
		panel.setBounds(0, 0, 782, 164);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel orderPanel = new JPanel();
		orderPanel.setBounds(0, 164, 408, 389);
		frame.getContentPane().add(orderPanel);
		orderPanel.setLayout(new CardLayout(0, 0));
		
		JPanel addItemPanel = new JPanel();
		orderPanel.add(addItemPanel, "");
		addItemPanel.setLayout(null);
		
		JComboBox itemDropDown = new JComboBox(menuItems);
		itemDropDown.setBounds(24, 31, 300, 38);
		addItemPanel.add(itemDropDown);
		
		JComboBox quantityCombo = new JComboBox(quantity);
		quantityCombo.setBounds(340, 31, 56, 38);
		addItemPanel.add(quantityCombo);
		
		JButton addItemBtn = new JButton("Add Item");
		addItemBtn.setBounds(284, 344, 112, 32);
		addItemPanel.add(addItemBtn);
		addItemBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String foodItem = (String) itemDropDown.getSelectedItem();
				int foodQuant =  (int) quantityCombo.getSelectedItem();
				if(foodItem == "Pasta") {
					double price = 10.99;
					double itemTotal = price * foodQuant;
					model.addRow(new Object[]{foodItem, foodQuant, price, itemTotal});
					
				}
				else if (foodItem == "Lasagna") {
					
				}
				else if (foodItem == "Breadsticks") {
					
				}
				else if (foodItem == "Soup") {
					
				}
				else if (foodItem == "Salad") {
	
				}
			}
		});
		
		JPanel deleteItemPanel = new JPanel();
		orderPanel.add(deleteItemPanel, "");
		deleteItemPanel.setLayout(null);
		
		JLabel deleteItemLabel = new JLabel("<html>Select the item(s) you wish to delete from the table<br/> and click the \"Delete\" button below.</html>");
		deleteItemLabel.setBounds(59, 116, 315, 66);
		deleteItemPanel.add(deleteItemLabel);
		
		JButton deleteItemsBtn = new JButton("Delete");
		deleteItemsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rowsToDelete = orderTable_1.getSelectedRows();
				for(int i = 0; i < rowsToDelete.length; i++){
					System.out.println(rowsToDelete[i]);
					model.removeRow(rowsToDelete[i]);
				}
			}
		});
		deleteItemsBtn.setBounds(122, 308, 153, 48);
		deleteItemPanel.add(deleteItemsBtn);
		
		JButton addTabBtn = new JButton("Add Item");
		addTabBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderPanel.removeAll();
				orderPanel.add(addItemPanel);
				orderPanel.repaint();
				orderPanel.revalidate();
			}
		});
		addTabBtn.setBounds(52, 59, 138, 68);
		panel.add(addTabBtn);
		
		JButton deleteTabBtn = new JButton("Delete Item");
		deleteTabBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderPanel.removeAll();
				orderPanel.add(deleteItemPanel);
				orderPanel.repaint();
				orderPanel.revalidate();
			}
		});
		deleteTabBtn.setBounds(214, 59, 138, 68);
		panel.add(deleteTabBtn);
		JLabel tableLabel = new JLabel("Order For Table " + tableNum);
		tableLabel.setFont(new Font("Serif", Font.BOLD, 36));
		tableLabel.setBounds(446, 59, 324, 68);
		panel.add(tableLabel);
		
		JButton placeOrderBtn = new JButton("Place Order");
		placeOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOrder order = new MenuOrder();
			}
		});
		placeOrderBtn.setFont(new Font("Serif", Font.PLAIN, 24));
		placeOrderBtn.setBounds(408, 501, 374, 52);
		frame.getContentPane().add(placeOrderBtn);

	}
	
	public void setTable(int table) {
		tableNum = table;
	}
	
	public boolean isOrdered() {
		return ordered;
	}
}
