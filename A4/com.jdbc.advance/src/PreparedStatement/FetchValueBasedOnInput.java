package PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class FetchValueBasedOnInput {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection c = null;
		PreparedStatement p = null;
		ResultSet r = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjd_a4?user=root&password=Rahul&useSSL=false");
			p = c.prepareStatement("Select * from premium_student where age=?");
			System.out.println("Enter the Age to Search : ");
			p.setInt(1, sc.nextInt());
			r = p.executeQuery();
			
//			while(r.next()) {	
//			}
			
			if (r.next()) {
				System.out.println(r.getInt("age") + "\t" + r.getString("name") + "\t" + r.getInt("score"));
			} else {
				System.out.println("User Not Found");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
