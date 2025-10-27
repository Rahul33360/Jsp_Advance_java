package fetchData;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetInterface {
	public static void main(String[] args) throws SQLException {
		Connection c = null;
		Statement s = null;
		ResultSet r = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjd_a4?user=root&password=Rahul&useSSL=false");
			s = c.createStatement();
			String str = "select * from premium_student";
			r = s.executeQuery(str);
			System.out.println("Age \tName \tScore");
			System.out.println("---------------------");
			while (r.next()) {
//				int i = r.getInt(1);
//				System.out.println(i);
				// or (written below)
				int i = r.getInt("age");
				String st = r.getString("name");
				int j = r.getInt("score");

				System.out.println(i +"\t"+ st +"\t"+j);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if(c != null)
				c.close();
			if(s != null)
				s.close();
			if(r != null)
				r.close();
		}

	}
}
