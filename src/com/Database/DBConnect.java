package com.Database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

	private static String URL = "jdbc:mysql://localhost:3306/company";
	private static String USER_NAME = "root";
	private static String PASSWORD = "root";
	
	private static Connection con = null;
	private static Logger logger = Logger.getLogger(DBConnect.class.getName());
	private static DBConnect dbconnect = null;

	private DBConnect() {
		
	}
	
	public static DBConnect getInstance() {
		
		if(dbconnect==null) {
			dbconnect = new DBConnect();
		}
		return dbconnect;
	}
	
	public Connection getConnection() {
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			System.out.println(con.toString());
			
		} catch (ClassNotFoundException | SQLException e) {
			
			logger.log(Level.WARNING, e.getMessage());
		}
		
		return con;
		
	}
	
	
}
