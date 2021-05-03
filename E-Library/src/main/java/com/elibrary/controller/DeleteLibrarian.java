package com.elibrary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.dao.AdminDao;

@WebServlet("/DeleteLibrarian")
public class DeleteLibrarian extends HttpServlet
{
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			int id=Integer.parseInt(request.getParameter("id"));
			try
			{
			boolean delete=AdminDao.deleteLibrarian(id);
			if(delete)
			{
				response.sendRedirect("view_librarian.jsp?delete=delete");
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
}
