package login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CurrentUsers {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CurrentUsers window = new CurrentUsers();
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
	public CurrentUsers() throws ClassNotFoundException {
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
				
		Object[] columnNames = {"User ID", "Username", "Password", "Email", "Creation Date",};
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
			String orderQuery = "select * from java1.login";
			ResultSet result = dataObject.queryData(orderQuery);
			while(result.next()) {
				int userId = result.getInt("userID");
				String username = result.getString("username");
				String pass = result.getString("password");
				String email = result.getString("email");
				String dateCreated = result.getString("creationDate");
				model.addRow(new Object[]{userId,username,pass,email,dateCreated});
			}
			result.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JLabel viewOrderLbl = new JLabel("View/Delete Users");
		viewOrderLbl.setBounds(298, 0, 344, 66);
		viewOrderLbl.setFont(new Font("Serif", Font.BOLD, 40));
		frame.getContentPane().add(viewOrderLbl);
		
		JButton allUserBtn = new JButton("All Users");
		allUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				model.setRowCount(0);
				try {
					String orderQuery = "select * from java1.login";
					ResultSet result = dataObject.queryData(orderQuery);
					while(result.next()) {
						int userId = result.getInt("userID");
						String username = result.getString("username");
						String pass = result.getString("password");
						String email = result.getString("email");
						String dateCreated = result.getString("creationDate");
						model.addRow(new Object[]{userId,username,pass,email,dateCreated});
					}
					
					result.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		allUserBtn.setBounds(146, 488, 225, 50);
		frame.getContentPane().add(allUserBtn);
		
		JButton deleteBtn = new JButton("Delete User");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] rowToDelete = orderTable.getSelectedRows();
				
				for(int i = 0; i < rowToDelete.length; i++) {
					try {
						int userId = (int) model.getValueAt(rowToDelete[rowToDelete.length - 1 - i], 0);
						String query = "delete from java1.login where userID=" + userId;
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
		deleteBtn.setBounds(564, 488, 225, 50);
		frame.getContentPane().add(deleteBtn);
		
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        dataObject.close();
		    }
		});
	}

}
