<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String s1 = request.getParameter("name1");
	String s2 = request.getParameter("name2");
	%>
	<% for(int i=0; i<4; i++) { %>
		<h3> <%=s1%> <%=s2%>hello </h3>
	<%}%>	
</body>
</html>