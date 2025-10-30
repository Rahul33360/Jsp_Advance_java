package StoredProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class callableInterface {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/cjd_a4?useSSL=false";
		String user = "root";
		String pass = "Rahul";
		Connection c = null;
		CallableStatement cst = null;
		ResultSet res = null;
		Scanner s = new Scanner(System.in);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, user, pass);
			cst = c.prepareCall("call cjd_a4.SELECTALL()");
			res = cst.executeQuery();
			

			while (res.next()) {
				System.out.println(
						res.getInt("Empid") + "\t" + res.getString("Empname") + "\t" + res.getInt("Empage") + "\n");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static CallableStatement prepareCall(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
