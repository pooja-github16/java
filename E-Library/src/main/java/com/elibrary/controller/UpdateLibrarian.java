package com.elibrary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.dao.AdminDao;

@WebServlet("/UpdateLibrarian")
public class UpdateLibrarian extends HttpServlet {
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{
				int id=Integer.parseInt(request.getParameter("id"));
				String name=request.getParameter("name");
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				String mob=request.getParameter("mob");
				try
				{
				boolean update=AdminDao.updateLibrarian(id, name, email, password, mob);
				if(update)
				{
					response.sendRedirect("view_librarian.jsp?update=update");
				}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
		
			}

}
