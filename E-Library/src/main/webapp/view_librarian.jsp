<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.elibrary.dao.AdminDao, java.util.*,com.elibrary.bean.Librarian " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	 
	 if(session.getAttribute("adminemail")==null)
	 {
		request.setAttribute("Error","Session has ended. please login again..");			
		 RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		 rd.forward(request, response);
		}
  %>	<div class="topnav">
 		 <a class="active" href="">eLibrary</a>
  		<a href="add_librarian.jsp">Add Librarian</a>
  		<a href="view_librarian.jsp">View Librarian</a>
 		 <a href="AdminLogout">Log out</a>
	</div>
	
	<%
		if(request.getParameter("update")!=null){
	%>
	<h3> librarian Updated..</h3>
	<% } %>
	
	<%
		if(request.getParameter("delete")!=null)
		{
	%>
	<h3> Librarian deleted</h3>
	<%	
		}
	%>
	
	<h1> Librarian Details</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th> E-mail</th>
			<th> Password</th>
			<th> Mobile</th>
			<th> Update </th>
			<th> Delete</th>
		</tr>
		
	
	<%
		List<Librarian> list=AdminDao.viewLibrarian();
		for(Librarian librarian:list){
	%>
	<tr>
		<td> <%= librarian.getId() %> </td>
		<td><%= librarian.getName() %> </td>
		<td><%= librarian.getEmail() %> </td>
		<td> <%= librarian.getPassword() %> </td>
		<td> <%= librarian.getMob() %> </td>
		<td> <a href="update_librarian.jsp?id=<%= librarian.getId()%>"><button>Update</button></a></td>
		<td> <a href="DeleteLibrarian?id=<%= librarian.getId()%>"><button>Delete</button></a></td>
	</tr>
	<% } %>
	</table>
</body>
</html>