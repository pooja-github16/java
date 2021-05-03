<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.elibrary.dao.AdminDao, com.elibrary.bean.Librarian " %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Librarian</title>
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
  %>
	<% int id=Integer.parseInt(request.getParameter("id"));
	 Librarian l=AdminDao.getLibrarian(id);
	%>
	<form action="UpdateLibrarian" method="post">
		<input type="hidden" name="id" value="<%= l.getId() %>">
		Name: <input type="text" name="name" value="<%= l.getName() %>"><br>
		E-mail: <input type="text" name="email" value="<%= l.getEmail() %>"><br>
		Password: <input type="password" name="password" value="<%= l.getPassword() %>"><br>
		Mobile No.: <input type="text" name="mob" value="<%= l.getMob() %>"><br>
		<input type="submit" value="Update">
		
	</form>
		  
</body>

</html>
		

