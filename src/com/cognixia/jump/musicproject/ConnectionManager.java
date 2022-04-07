package com.cognixia.jump.musicproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	
	// when the connection manager is loaded into the program, the connection object
	// is going to be null
	private static Connection connection;
	
	private static void makeConnection() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
	
			// load in the credentials from a properties file
			Properties properties = new Properties();
			
			// load in the properties file into the properties object
			properties.load( new FileInputStream("resources/config.properties") );
			
			// extract the values
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connected");

		
	}
	
	public static Connection getConnection() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		// if connection is null, that means the connection object 
		// hasn't been created yet
		if(connection == null) {
			makeConnection();
		}
		
		return connection;
	}
	
	public static void main(String[] args) {
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			
			
		} catch (ClassNotFoundException | IOException | SQLException e1) {
			
			System.out.println("Couldn't connect");
		}
		
		// the same connection object as above
		//Connection otherConn = BetterConnectionManager.getConnection();
		
		try {
			conn.close();
			System.out.println("Connection Closed");
			
		} catch (SQLException e) {
			System.out.println("Couldn't close connection");
		}
		
		System.out.println("End of program");
		
	}
	
	
	

}