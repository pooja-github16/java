<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Register</h1>
	<form action="register" method="post">
		<label for="username"><b>username</b></label><br> <input
			type="text" name="username" placeholder="username" required><br>
		<label for="Password"><b>Password</b></label><br> <input
			type="text" name="password" placeholder="Password" required><br>
		<br>
		<button type="submit" class="btn">register</button>
	</form>
</body>
</html>