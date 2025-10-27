package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class AuthenticationUser {
	public static void main(String[] args) {
		Connection c = null;
		PreparedStatement p = null;
		ResultSet r = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your UserName and Password");
		String username = sc.next();
		int pwd = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjd_a4?useSSL=false", "root", "Rahul");
			p = c.prepareStatement("Select * from userlogin where username=?");
			p.setString(1, username);
			r = p.executeQuery();

			if (r.next()) {
				int pass = r.getInt("password");
				if (pass == pwd) {
					System.out.println("Login Success");
				} else {
					System.out.println("Invalid Password!");
				}
			} else {
				System.out.println("UserName is Invalid");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
