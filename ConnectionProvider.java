package JDBCDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProvider {
	
	public static Connection getConnection() throws SQLException {
		
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "mysql");
			System.out.println("Connedction done");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
		
		
	}
	public static void main(String[] args) {
		try {
			ConnectionProvider.getConnection();
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

}
