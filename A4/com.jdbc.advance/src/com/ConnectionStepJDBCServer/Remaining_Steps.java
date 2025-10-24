package com.ConnectionStepJDBCServer;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Remaining_Steps {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Rahul&useSSl=false");
			Statement state=connection.createStatement();
			String sql="insert into cjd_a4.student_details values(121,'Rahulk',995)";
			state.execute(sql);
			System.out.println("data is inserted");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
