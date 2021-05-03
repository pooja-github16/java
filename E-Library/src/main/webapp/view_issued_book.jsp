<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.elibrary.bean.IssuedBookBean, com.elibrary.dao.LibrarianDao, java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ISSUED BOOK LIST</title>
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
	
	<h1> Issued Books Details</h1>
	<table border="1">
		<tr>
			<th>Call No.</th>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Student Mobile Number</th>
			<th>Issued Date</th>
			<th> Return Status </th>
		</tr>
		<% List<IssuedBookBean> list= LibrarianDao.viewIssuedBook(); %>
		<% for(IssuedBookBean i:list){
		%>
			<tr>
				<td><%= i.getCallno() %> </td>
				<td> <%= i.getSid() %> </td>
				<td><%= i.getSname() %> </td>
				<td> <%= i.getMob() %></td>
				<td><%= i.getIssueDate() %> </td>
				<td><%= i.getReturnStatus() %></td>
			</tr>
			
		<% } %>

</body>
</html>