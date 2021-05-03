<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In Page</title>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #4CAF50;
	color: white;
}

body {
	background-image: url("C:\Users\HP\Desktop\image.jpg"); 
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;	
}
</style>

</head>
<body>
	<%
	 response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	//response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);	
	%>

	<div class="topnav">
		<a class="active" href="">eLibrary</a> <a href="login.jsp">Home</a> <a
			href="login.jsp">Admin</a> <a href="login.jsp">Librarian</a>
	</div>

	<%
	if (request.getParameter("wrongadmin") != null) {
	%>
	<h1>unauthorized,Please enter Right Email and password..</h1>
	<%
	}
	%>
	<%
	if (request.getParameter("logout") != null) {
	%>
	<h1>Admin Logged-out successfully..</h1>
	<%
	}
	%>

	<form action="AdminLogin" method="post">
		<h3>Admin Login</h3>
		<br> Email Address: <input type="email" name="adminemail"><br>
		<br> Password:<input type="password" name="adminpassword"><br>
		<br> <input type="submit" value="Login">
	</form>
	<br>
	<hr>
	<br>
	<%
	if (request.getParameter("wronglibrarian") != null) {
	%>
	<h1>unauthorized,Please enter Right Email and password..</h1>
	<%
	}
	%>
	<%
	if (request.getParameter("librarianlogout") != null) {
	%>
	<h1>Librarian Logged-out successfully..</h1>
	<%
	}
	%>

	<form action="LibrarianLogin" method="post">
		<h3>Librarian Login</h3>
		<br> Email Address: <input type="email" name="email"><br>
		<br> Password:<input type="password" name="password"><br>
		<br> <input type="submit" value="Login">
	</form>


</body>
</html>