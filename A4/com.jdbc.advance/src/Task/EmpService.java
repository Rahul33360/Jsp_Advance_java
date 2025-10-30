package Task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpService {
	static String url = "jdbc:mysql://localhost:3306/cjd_a4?useSSL=false";
	static String user = "root";
	static String pass = "Rahul";
	static Connection c;
	static PreparedStatement pre;
	static ResultSet res;
	static Scanner s = new Scanner(System.in);
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	public static boolean add(Emp e) {
		String sql = "INSERT into EMP (empid,empname,empage) values(?,?,?)";
		try {
			pre = c.prepareStatement(sql);
			pre.setInt(1, e.getId());
			pre.setString(2, e.getName());
			pre.setInt(3, e.getAge());

			int rows = pre.executeUpdate();
			return rows > 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public static boolean remove(int id) {
		String sql = "DELETE from emp where empid=?";
		try {
			pre = c.prepareStatement(sql);
			pre.setInt(1, id);
			int rows = pre.executeUpdate();
			return rows > 0;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;

	}

	public static void fetch() {
		String sql = "SELECT * from emp ";
		int sno = 1;
		boolean hasData = false;
		try {
			pre = c.prepareStatement(sql);
			res = pre.executeQuery();
			System.out.println("Sno." + "\t" + "Id" + "\t" + "Name" + "\t" + "Age" + "\n");
			while (res.next()) {
				hasData = true;
				int id = res.getInt("empid");
				String name = res.getString("empname");
				int age = res.getInt("empage");
				System.out.println(sno++ + "\t" + id + "\t" + name + "\t" + age + "\n");
			}
			if (!hasData) {
				System.out.println("No employees found in the company!");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public static boolean update(int upId, int operation) {

		try {
			if (operation == 1) {
				System.out.println("Enter the New EmpId ");
				int newId = s.nextInt();
				pre = c.prepareStatement("update emp set Empid=? where Empid=?");
				pre.setInt(1, newId);
				pre.setInt(2, upId);
				pre.executeUpdate();
				return true;

			} else if (operation == 2) {
				System.out.println("Enter the New EmpName ");
				String name = s.next();
				pre = c.prepareStatement("update emp set Empname=? where Empid=?");
				pre.setString(1, name);
				pre.setInt(2, upId);
				pre.executeUpdate();
				return true;
			} else if (operation == 3) {
				System.out.println("Enter the New EmpAge ");
				int newage = s.nextInt();
				pre = c.prepareStatement("update emp set Empage=? where Empid=?");
				pre.setInt(1, newage);
				pre.setInt(2, upId);
				pre.executeUpdate();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean exit() {
		try {
			if (res != null)
				res.close();
			if (pre != null)
				pre.close();
			if (c != null)
				c.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
