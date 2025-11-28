<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="a.jsp"%> <!-- errorPage this will handle error -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
	
		Connection c = null;
		PreparedStatement pst = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=Rahul");
		pst = c.prepareStatement("insert into cjd_a4.userlogin values(?,?)");
		pst.setString(1, name);
		pst.setString(2,	pass);
		pst.executeUpdate();
	%>
		<h2>Data Inserted</h2>
</body>
</html>