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

import com.elibrary.bean.Admin;
import com.elibrary.dao.AdminDao;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		 response.setDateHeader("Expires", 0);
		HttpSession session= request.getSession(false);
		session.invalidate();
		System.out.println("hlooo");
		PrintWriter out = response.getWriter();
	    out.print(" you are not authorised");
		response.sendRedirect("login.jsp");	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		 response.setDateHeader("Expires", 0);
		
		String email=request.getParameter("adminemail");
		String password=request.getParameter("adminpassword");
		
		Admin admin=new Admin();
		admin.setEmail(email);
		admin.setPassword(password);
		
		
		try
		{
			boolean status=AdminDao.loginCheck(admin);
			
			if(status)
			{
				HttpSession session=request.getSession();
				session.setAttribute("adminemail",email);
				RequestDispatcher rd=request.getRequestDispatcher("admin_section.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("login.jsp?wrongadmin=wrongadmin");
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
