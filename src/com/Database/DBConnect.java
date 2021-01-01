package com.Database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.Constants.Properties;

public class DBConnect {

	private static String URL = Properties.DBConstatns.DB_URL;
	private static String USER_NAME = Properties.DBConstatns.USER_NAME;
	private static String PASSWORD = Properties.DBConstatns.PASSWORD;
	
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
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			logger.log(Level.WARNING, e.getMessage());
		}
		
		return con;
		
	}
	
	
}
