package managaer;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import login.DatabaseConnection;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CurrentOrder {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentOrder window = new CurrentOrder();
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
	public CurrentOrder() throws ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException {
		frame = new JFrame();
		frame.setBounds(200, 200, 968, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DatabaseConnection dataObject = new DatabaseConnection();
				
		Object[] columnNames = {"Order #", "Name", "Total", "Pasta", "Lasagna", "Breadsticks", "Soup", "Salad", "Date",};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		
		JScrollPane scrollPane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 67, 950, 375);
		frame.getContentPane().add(scrollPane);
		JTable orderTable = new JTable();
		orderTable.setModel(model);
		orderTable.setBounds(0, 67, 950, 375);
		orderTable.setBackground(Color.GRAY);
		orderTable.setForeground(Color.WHITE);
		orderTable.setFont(new Font("Serif", Font.PLAIN, 24));
		orderTable.setRowHeight(30);
		scrollPane.setViewportView(orderTable);
		
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String today = simpleDateFormat.format(new Date());
			String orderQuery = "select * from java1.order WHERE orderDate='" + today + "'";
			ResultSet result = dataObject.queryData(orderQuery);
			while(result.next()) {
				String orderNum = result.getString("orderNum");
				String orderName = result.getString("name");
				String orderTotal = result.getString("total");
				String pasta = result.getString("pasta");
				String lasagna = result.getString("lasagna");
				String bread = result.getString("bread");
				String soup = result.getString("soup");
				String salad = result.getString("salad");
				String orderDate = result.getString("orderDate");
				model.addRow(new Object[]{orderNum, orderName, orderTotal, pasta, lasagna, bread, soup, salad, orderDate});
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		JLabel viewOrderLbl = new JLabel("View/Delete Orders");
		viewOrderLbl.setBounds(298, 0, 344, 66);
		viewOrderLbl.setFont(new Font("Serif", Font.BOLD, 40));
		frame.getContentPane().add(viewOrderLbl);
		
		JButton btnNewButton = new JButton("All Orders");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				try {
					String orderQuery = "select * from java1.order";
					ResultSet result = dataObject.queryData(orderQuery);
					while(result.next()) {
						String orderNum = result.getString("orderNum");
						String orderName = result.getString("name");
						String orderTotal = result.getString("total");
						String pasta = result.getString("pasta");
						String lasagna = result.getString("lasagna");
						String bread = result.getString("bread");
						String soup = result.getString("soup");
						String salad = result.getString("salad");
						String orderDate = result.getString("orderDate");
						model.addRow(new Object[]{orderNum, orderName, orderTotal, pasta, lasagna, bread, soup, salad, orderDate});
					}
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(25, 488, 225, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("Today's Orders");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				try {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String today = simpleDateFormat.format(new Date());
					String orderQuery = "select * from java1.order WHERE orderDate='" + today + "'";
					ResultSet result = dataObject.queryData(orderQuery);
					while(result.next()) {
						String orderNum = result.getString("orderNum");
						String orderName = result.getString("name");
						String orderTotal = result.getString("total");
						String pasta = result.getString("pasta");
						String lasagna = result.getString("lasagna");
						String bread = result.getString("bread");
						String soup = result.getString("soup");
						String salad = result.getString("salad");
						String orderDate = result.getString("orderDate");
						model.addRow(new Object[]{orderNum, orderName, orderTotal, pasta, lasagna, bread, soup, salad, orderDate});
					}
					result.close();
				} catch (SQLException exception) {
					// TODO Auto-generated catch block
					exception.printStackTrace();
				}
			}
		});
		button.setBounds(360, 488, 225, 50);
		frame.getContentPane().add(button);
		
		JButton deleteBtn = new JButton("Delete Order");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rowToDelete = orderTable.getSelectedRows();
				
				for(int i = 0; i < rowToDelete.length; i++) {
					try {
						int orderN = (int) model.getValueAt(rowToDelete[rowToDelete.length - 1 - i], 0);
						String query = "delete from java1.order where orderNum=" + orderN;
						int deleteQuery = dataObject.updateData(query);
						if(deleteQuery > 0) {
							model.removeRow(rowToDelete[rowToDelete.length - 1 - i]);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		deleteBtn.setBounds(700, 488, 225, 50);
		frame.getContentPane().add(deleteBtn);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        dataObject.close();
		    }
		});
	}
}
