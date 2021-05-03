package com.elibrary.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.elibrary.bean.Librarian;
import com.elibrary.dao.LibrarianDao;

@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
	
		response.sendRedirect("login.jsp");	
	}
	
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
			{
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				
				Librarian l=new Librarian();
				l.setEmail(email);
				l.setPassword(password);
				try
				{
				boolean status=LibrarianDao.loginCheck(l);
				if(status)
				{
					HttpSession session=request.getSession();
					session.setAttribute("librarianEmail", email);
					RequestDispatcher rd=request.getRequestDispatcher("librarian_section.jsp");
					rd.forward(request, response);
				}
				else
				{
					response.sendRedirect("login.jsp?wronglibrarian=wronglibrarian");
				}
				}
				catch(Exception e)
				{
					
				}
			}

}
