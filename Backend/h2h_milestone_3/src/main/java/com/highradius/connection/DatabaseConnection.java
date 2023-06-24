package com.highradius.connection;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
		// Database credentials
		private static final String url = "jdbc:mysql://localhost:3306/h2h10962k?useSSl=false";
		private static final String username = "root";
		private static final String password = "C_20051685";
		
		public static Connection con() throws SQLException {
	        Connection con = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	        return con;
	    }

	}
