<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.elibrary.dao.LibrarianDao, java.util.*,com.elibrary.bean.Book " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Books Detail</title>
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
	

</head>
<body>
	<h1> Books Details</h1>
	<table border="1">
		<tr>
			<th>Call No.</th>
			<th>Book Name</th>
			<th>Author Name</th>
			<th>Publisher</th>
			<th>quantity</th>
			<th> Issued </th>
			<th> Delete</th>
		</tr>
		<% List<Book> list= LibrarianDao.viewBook(); %>
		<% for(Book b:list){
		%>
		<tr>
			<td> <%=b.getCallno() %></td>
			<td> <%= b.getName() %></td>
			<td> <%= b.getAuthor() %></td>
			<td> <%= b.getPublisher() %></td>
			<td> <%= b.getQuantity() %></td>
			<td><%= b.getIssued() %></td>
			<td> <a href="DeleteBook?id=<%=b.getCallno()%>"><button>Delete</button></a>
		</tr>
		<% } %>
	</table>
</body>
</html>