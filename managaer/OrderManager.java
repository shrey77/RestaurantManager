package managaer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import login.DatabaseConnection;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JScrollPane;

public class OrderManager {

	private JFrame frame;
	private JTable orderTable;
	private double orderTotal;
	private final JPanel panel = new JPanel();
	private JTextField orderNameField;
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
	 * @throws ClassNotFoundException 
	 */
	public OrderManager() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		frame.setBounds(200, 200, 800, 600);
		
		DatabaseConnection dataObject = new DatabaseConnection();
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
		scrollPane.setBounds(408, 164, 374, 320);
		frame.getContentPane().add(scrollPane);
		JTable orderTable = new JTable();
		orderTable.setModel(model);
		orderTable.setBounds(408, 164, 339, 360);
		orderTable.setBackground(Color.GRAY);
		orderTable.setForeground(Color.WHITE);
		orderTable.setFont(new Font("Serif", Font.PLAIN, 24));
		orderTable.setRowHeight(30);
		scrollPane.setViewportView(orderTable);
		
		panel.setBounds(0, 0, 782, 164);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		String initalFormat = String.format("$%,.2f", orderTotal);
		
		JLabel orderSubtotalNum = new JLabel(initalFormat, SwingConstants.RIGHT);
		orderSubtotalNum.setFont(new Font("Serif", Font.BOLD, 24));
		orderSubtotalNum.setBounds(535, 484, 67, 34);
		frame.getContentPane().add(orderSubtotalNum);
		
		JLabel orderTotalNum = new JLabel(initalFormat, SwingConstants.RIGHT);
		orderTotalNum.setFont(new Font("Serif",Font.BOLD, 24));
		orderTotalNum.setBounds(703, 484, 67, 34);
		frame.getContentPane().add(orderTotalNum);
		
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
					double itemTotal = foodQuant * price;
					
					boolean dupRow = false;
					int row;
					for(row = 0; row < model.getRowCount(); row++) {
						if(foodItem == orderTable.getValueAt(row, 0)) {
							dupRow = true;
							break;
						}
					}
					if(!dupRow) {
						model.addRow(new Object[]{foodItem, foodQuant, price, itemTotal});
					}
					else if (dupRow) {
						model.setValueAt(foodQuant, row, 1);
						model.setValueAt(itemTotal, row, 3);
					}
					
				}
				else if (foodItem == "Lasagna") {
					double price = 10.99;
					double itemTotal = foodQuant * price;
					boolean dupRow = false;
					int row;
					for(row = 0; row < model.getRowCount(); row++) {
						if(foodItem == orderTable.getValueAt(row, 0)) {
							dupRow = true;
							break;
						}
					}
					if(!dupRow) {
						model.addRow(new Object[]{foodItem, foodQuant, price, itemTotal});
					}
					else if (dupRow) {
						model.setValueAt(foodQuant, row, 1);
						model.setValueAt(itemTotal, row, 3);
					}
				}
				else if (foodItem == "Breadsticks") {
					double price = 5.99;
					double itemTotal = foodQuant * price;
					boolean dupRow = false;
					int row;
					for(row = 0; row < model.getRowCount(); row++) {
						if(foodItem == orderTable.getValueAt(row, 0)) {
							dupRow = true;
							break;
						}
					}
					if(!dupRow) {
						model.addRow(new Object[]{foodItem, foodQuant, price, itemTotal});
					}
					else if (dupRow) {
						model.setValueAt(foodQuant, row, 1);
						model.setValueAt(itemTotal, row, 3);
					}
				}
				else if (foodItem == "Soup") {
					double price = 8.99;
					double itemTotal = foodQuant * price;
					boolean dupRow = false;
					int row;
					for(row = 0; row < model.getRowCount(); row++) {
						if(foodItem == orderTable.getValueAt(row, 0)) {
							dupRow = true;
							break;
						}
					}
					if(!dupRow) {
						model.addRow(new Object[]{foodItem, foodQuant, price, itemTotal});
					}
					else if (dupRow) {
						model.setValueAt(foodQuant, row, 1);
						model.setValueAt(itemTotal, row, 3);
					}
				}
				else if (foodItem == "Salad") {
					double price = 8.99;
					double itemTotal = foodQuant * price;
					boolean dupRow = false;
					int row;
					for(row = 0; row < model.getRowCount(); row++) {
						if(foodItem == orderTable.getValueAt(row, 0)) {
							dupRow = true;
							break;
						}
					}
					if(!dupRow) {
						model.addRow(new Object[]{foodItem, foodQuant, price, itemTotal});
					}
					else if (dupRow) {
						model.setValueAt(foodQuant, row, 1);
						model.setValueAt(itemTotal, row, 3);
					}
				}
				
				int rowCount = orderTable.getRowCount();
				orderTotal = 0;
				for(int i = 0; i < rowCount; i++) {
					orderTotal = orderTotal + (double) model.getValueAt(i, 3);
				}
				double tax = 0.13;
				String subtotalFormat = String.format("$%,.2f", orderTotal);
				orderSubtotalNum.setText(subtotalFormat);
				String totalFormat = String.format("$%,.2f", orderTotal*(1+tax));
				orderTotalNum.setText(totalFormat);
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
				
				int rowToDelete = orderTable.getSelectedRow();
				
				if(rowToDelete >= 0) {
					model.removeRow(rowToDelete);
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
		addTabBtn.setBounds(12, 83, 367, 68);
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
		deleteTabBtn.setBounds(403, 83, 367, 68);
		panel.add(deleteTabBtn);
		
		JLabel orderNameLbl = new JLabel("Order Name:");
		orderNameLbl.setFont(new Font("Serif", Font.PLAIN, 40));
		orderNameLbl.setBounds(97, 13, 272, 57);
		panel.add(orderNameLbl);
		
		orderNameField = new JTextField("");
		orderNameField.setBounds(403, 13, 367, 57);
		panel.add(orderNameField);
		orderNameField.setColumns(10);
		
		JButton placeOrderBtn = new JButton("Place Order");
		placeOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(orderNameField.getText() == "") {
					JOptionPane.showMessageDialog(null, "Please fill in an order name.");
					return;
				}
				int pasta = 0, lasagna = 0, bread = 0, soup = 0, salad = 0;
				int rowCount = orderTable.getRowCount();
				orderTotal = 0;
				for(int i = 0; i < rowCount; i++) {
					if(model.getValueAt(i, 0) == "Pasta") {
						pasta = (int) model.getValueAt(i, 1);
					}
					else if(model.getValueAt(i, 0) == "Lasagna") {
						lasagna = (int) model.getValueAt(i, 1);
					}
					else if(model.getValueAt(i, 0) == "Breadsticks") {
						bread = (int) model.getValueAt(i, 1);
					}
					else if(model.getValueAt(i, 0) == "Soup") {
						soup = (int) model.getValueAt(i, 1);
					}
					else if(model.getValueAt(i, 0) == "Salad") {
						salad = (int) model.getValueAt(i, 1);
					}
					
				}
				
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String today = simpleDateFormat.format(new Date());
				String query = "insert into java1.order(name,total,pasta,lasagna,bread,soup,salad,orderDate) VALUES ('" + orderNameField.getText() + "',"
				+ orderTotal + "," + pasta + "," + lasagna + "," + bread + "," + soup + "," + salad + ",'" + today + "')";
				try {
					int orderQuery = dataObject.updateData(query);
					if(orderQuery > 0) {
						//frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Order Added to Database");
						
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Could not complete Order");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		placeOrderBtn.setFont(new Font("Serif", Font.PLAIN, 24));
		placeOrderBtn.setBounds(408, 519, 374, 34);
		frame.getContentPane().add(placeOrderBtn);
		
		JLabel orderTotalLbl = new JLabel("Total:");
		orderTotalLbl.setFont(new Font("Serif",Font.BOLD, 24));
		orderTotalLbl.setBounds(636, 484, 67, 34);
		frame.getContentPane().add(orderTotalLbl);
		
		JLabel orderSubtotalLbl = new JLabel("Subtotal:");
		orderSubtotalLbl.setFont(new Font("Serif", Font.BOLD, 24));
		orderSubtotalLbl.setBounds(418, 484, 105, 34);
		frame.getContentPane().add(orderSubtotalLbl);

	}
}
