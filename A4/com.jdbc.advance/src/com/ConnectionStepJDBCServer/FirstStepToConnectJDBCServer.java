package com.ConnectionStepJDBCServer;

import java.sql.DriverManager;
import java.sql.SQLException;

public class FirstStepToConnectJDBCServer {

	public static void main(String[] args) throws SQLException {
		java.sql.Driver d = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d); // driver registered
		
		System.out.println("Driver loaded and Registered");

	}

}
