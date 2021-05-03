package com.elibrary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.bean.Librarian;
import com.elibrary.dao.AdminDao;

@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mob=request.getParameter("mob");
		
		Librarian librarian=new Librarian();
		librarian.setName(name);
		librarian.setEmail(email);
		librarian.setPassword(password);
		librarian.setMob(mob);
		
		try
		{
			AdminDao.addLibrarian(librarian);
			response.sendRedirect("add_librarian.jsp?save=save");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

}
