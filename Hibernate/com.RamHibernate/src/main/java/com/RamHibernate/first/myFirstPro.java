package com.RamHibernate.first;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class myFirstPro {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306",
				"root", "Rahul");
		PreparedStatement statement = connection.prepareStatement("SELECT * FROM cjd_a4.userlogin");
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			String name = rs.getString(1);
			String pass = rs.getString(2);
			System.out.println(name + "\t" + pass);
		}

		connection.close();
	}
}
