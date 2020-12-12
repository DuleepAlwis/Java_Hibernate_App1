package com.Database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

	private static String URL = "jdbc:mysql://localhost:3306/test_3";
	private static String USER_NAME = "user1";
	private static String PASSWORD = "password";
	
	private static Connection con = null;
	private static Logger logger = Logger.getLogger(DBConnect.class.getName());

	private DBConnect() {
		
	}
	
	public static DBConnect getInstance() {
		
		return new DBConnect();
	}
	
	public Connection getConnection() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			logger.log(Level.WARNING, e.getMessage());
		}
		
		return con;
		
	}
	
	
}
