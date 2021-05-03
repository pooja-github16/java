<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return Book Form</title>
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
</style>

</head>
<body>

	<%
	  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	  response.setHeader("Pragma", "no-cache");
	  response.setDateHeader("Expires", 0);	 
	 
	   if(session.getAttribute("librarianEmail")==null){
			 
			 response.sendRedirect("login.jsp");
			}
  %>
	<div class="topnav">
 		 <a class="active" href="">eLibrary</a>
  		<a href="">Home</a>
  		<a href="add_book.jsp">Add Book</a>
 		 <a href="view_book.jsp">View Book</a>
 		 <a href="issue_book.jsp">Issue Book</a>
 		 <a href="view_issued_book.jsp">View Issued Book</a>
 		 <a href="return_book.jsp">Return Book</a>
 		 <a href="librarian_logout.jsp">Log out</a>
	</div>
	<% if(request.getParameter("returnbook")!=null){ 
	%>
	<h3> Book returned successfully..</h3>
	<% } %>
	
	
	<% if(request.getParameter("failreturn")!=null){ 
	%>
	<h3> Book Return Process is failed , Try again..</h3>
	<% } %>
	
	
	<h1> Return Book Form</h1>
	<form action="ReturnBook" method="post">
		Call No.: <input type="text" name="callno"><br>
		Student ID: <input type="text" name="sid"><br>
		<input type="submit"  value="Return Book">
	</form>
</body>
</html>