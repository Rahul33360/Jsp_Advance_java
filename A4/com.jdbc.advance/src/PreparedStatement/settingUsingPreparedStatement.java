package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class settingUsingPreparedStatement {
	public static void main(String[] args) {
		Connection c = null;
		PreparedStatement pst = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjd_a4?user=root&password=Rahul&useSSL=false");
			pst = c.prepareStatement("insert into cjd_a4.premium_student values(?,?,?)");
			int age = 0, score = 0;
			String name = "";
			Scanner sc = new Scanner(System.in);
			int val = 1;
			do {
				System.out.println("Enter Your Age ");
				age = sc.nextInt();
				System.out.println("Enter Your Name");
				name = sc.next();
				System.out.println("Enter Your Score ");
				score = sc.nextInt();
				pst.setInt(1, age);
				pst.setString(2, name);
				pst.setInt(3, score);
				pst.executeUpdate();
				System.out.println("Executed");
				System.out.println("Age : " + age + "\t" + "Name : " + name + "\t" + "Score : " + score);
				// displaying the entire table
				int tab = 0;
				System.out.println("Enter 1 if you want to see the table Details else 0");

				System.out.println("Do you Want to Continue Inserting Then Press 1 else 0 :  ");

				System.out.println();
				val = sc.nextInt();
			} while (val == 1);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
