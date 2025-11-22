package SignUp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SignUp extends GenericServlet {
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("number");
		String password = req.getParameter("password");

		PrintWriter p = res.getWriter();
		Connection c = null;
		PreparedStatement pst = null;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjd_a4?", "root", "Rahul");

			pst = c.prepareStatement("INSERT INTO infologin VALUES (?,?,?,?)");
			pst.setString(1, name);
			pst.setString(2, email);
			pst.setString(3, mobile);
			pst.setString(4, password);
			pst.executeUpdate();

			pst = c.prepareStatement("INSERT INTO userlogin VALUES (?,?)");
			pst.setString(1, name);
			pst.setString(2, password);
			pst.executeUpdate();

			req.getRequestDispatcher("index.html").include(req, res);
			p.println("<html><body><h1>Your Registration is Completed</h1></body></html>");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
