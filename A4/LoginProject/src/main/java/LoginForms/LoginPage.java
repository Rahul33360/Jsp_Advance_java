package LoginForms;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginPage extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter p = res.getWriter();
		Connection c = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/cjd_a4?useSSL=false", "root", "Rahul");
			pst = c.prepareStatement("Select * from cjd_a4.userlogin where username=?");
			pst.setString(1, username);
			rs = pst.executeQuery();
			if (rs.next()) {
				String DBPwd = rs.getString("password");
				if (DBPwd.equals(password)) {
//					System.out.println("Login Success");
					p.println("<!DOCTYPE html>\r\n"
							+ "<html lang=\"en\">\r\n"
							+ "<head>\r\n"
							+ "    <meta charset=\"UTF-8\">\r\n"
							+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
							+ "    <title>Login Success</title>\r\n"
							+ "    <style>\r\n"
							+ "        body {\r\n"
							+ "            font-family: Arial, sans-serif;\r\n"
							+ "            background-color: #f0f2f5;\r\n"
							+ "            display: flex;\r\n"
							+ "            justify-content: center;\r\n"
							+ "            align-items: center;\r\n"
							+ "            height: 100vh;\r\n"
							+ "            margin: 0;\r\n"
							+ "        }\r\n"
							+ "        .message-container {\r\n"
							+ "            background-color: #d4edda; /* Success background color */\r\n"
							+ "            color: #155724; /* Success text color */\r\n"
							+ "            padding: 2rem;\r\n"
							+ "            border-radius: 8px;\r\n"
							+ "            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);\r\n"
							+ "            text-align: center;\r\n"
							+ "            border: 1px solid #c3e6cb;\r\n"
							+ "        }\r\n"
							+ "        h1 {\r\n"
							+ "            margin-bottom: 1rem;\r\n"
							+ "        }\r\n"
							+ "    </style>\r\n"
							+ "</head>\r\n"
							+ "<body>\r\n"
							+ "    <div class=\"message-container\">\r\n"
							+ "        <h1>Login Successful!</h1>\r\n"
							+ "        <p>Welcome to the dashboard.</p>\r\n"
							+ "        <a href=\"index.html\">Return to Login</a>\r\n"
							+ "    </div>\r\n"
							+ "</body>\r\n"
							+ "</html>\r\n"
							+ "");

				} else {
//					System.out.println("Invalid Password!");
					p.println("<!DOCTYPE html>\r\n"
							+ "<html lang=\"en\">\r\n"
							+ "<head>\r\n"
							+ "    <meta charset=\"UTF-8\">\r\n"
							+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
							+ "    <title>Password Incorrect</title>\r\n"
							+ "    <style>\r\n"
							+ "        body {\r\n"
							+ "            font-family: Arial, sans-serif;\r\n"
							+ "            background-color: #f0f2f5;\r\n"
							+ "            display: flex;\r\n"
							+ "            justify-content: center;\r\n"
							+ "            align-items: center;\r\n"
							+ "            height: 100vh;\r\n"
							+ "            margin: 0;\r\n"
							+ "        }\r\n"
							+ "        .message-container {\r\n"
							+ "            background-color: #f8d7da; /* Error background color */\r\n"
							+ "            color: #721c24; /* Error text color */\r\n"
							+ "            padding: 2rem;\r\n"
							+ "            border-radius: 8px;\r\n"
							+ "            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);\r\n"
							+ "            text-align: center;\r\n"
							+ "            border: 1px solid #f5c6cb;\r\n"
							+ "        }\r\n"
							+ "        h1 {\r\n"
							+ "            margin-bottom: 1rem;\r\n"
							+ "        }\r\n"
							+ "    </style>\r\n"
							+ "</head>\r\n"
							+ "<body>\r\n"
							+ "    <div class=\"message-container\">\r\n"
							+ "        <h1>Error: Password Incorrect</h1>\r\n"
							+ "        <p>The password you entered is incorrect. Please try again.</p>\r\n"
							+ "        <a href=\"index.html\">Return to Login</a>\r\n"
							+ "    </div>\r\n"
							+ "</body>\r\n"
							+ "</html>\r\n"
							+ "");
				}
			} else {
//				System.out.println("UserName is Invalid");
				p.println("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>Invalid Username</title>\r\n"
						+ "    <style>\r\n"
						+ "        body {\r\n"
						+ "            font-family: Arial, sans-serif;\r\n"
						+ "            background-color: #f0f2f5;\r\n"
						+ "            display: flex;\r\n"
						+ "            justify-content: center;\r\n"
						+ "            align-items: center;\r\n"
						+ "            height: 100vh;\r\n"
						+ "            margin: 0;\r\n"
						+ "        }\r\n"
						+ "        .message-container {\r\n"
						+ "            background-color: #f8d7da; /* Error background color */\r\n"
						+ "            color: #721c24; /* Error text color */\r\n"
						+ "            padding: 2rem;\r\n"
						+ "            border-radius: 8px;\r\n"
						+ "            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);\r\n"
						+ "            text-align: center;\r\n"
						+ "            border: 1px solid #f5c6cb;\r\n"
						+ "        }\r\n"
						+ "        h1 {\r\n"
						+ "            margin-bottom: 1rem;\r\n"
						+ "        }\r\n"
						+ "    </style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "    <div class=\"message-container\">\r\n"
						+ "        <h1>Error: Invalid Username</h1>\r\n"
						+ "        <p>The username you entered does not exist. Please check your details.</p>\r\n"
						+ "        <a href=\"index.html\">Return to Login</a>\r\n"
						+ "    </div>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
