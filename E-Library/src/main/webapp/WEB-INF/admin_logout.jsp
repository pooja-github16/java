<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log Out</title>
</head>
<body>
	<% 
	session.setAttribute("adminname","");
	session.removeAttribute("adminname");
	response.sendRedirect("admin_login.jsp?logout=msg");
	%>
	
</body>
</html>