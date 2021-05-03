<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Logout</title>
</head>
<body>
	<%
	session.setAttribute("adminemail",null);
	session.removeAttribute("adminemail");
	session.invalidate();
	response.sendRedirect("login.jsp?logout=logout");
	%>
	

</body>
</html>