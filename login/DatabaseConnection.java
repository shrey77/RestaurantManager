package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
	private static Connection con;
	private static Statement stm;
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String urlcon = "jdbc:mysql://localhost:3306/java1?useSSL=false";
	private static String username = "root";
	
	public DatabaseConnection() throws ClassNotFoundException {
		Class.forName(driverName);
		
		try {
			con = DriverManager.getConnection(urlcon, username, password);
			stm = con.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public ResultSet queryData(String query) throws SQLException {
		ResultSet result = stm.executeQuery(query);
		return result;
	}
	
	public int updateData(String query) throws SQLException {
		int result = stm.executeUpdate(query);
		return result;
	}
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public boolean isClosed() throws SQLException {
		return con.isClosed();
	}
}
