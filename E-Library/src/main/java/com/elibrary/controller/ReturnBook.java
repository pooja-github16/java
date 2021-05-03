package com.elibrary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.dao.LibrarianDao;

@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet
{
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String callno=request.getParameter("callno");
			int sid=Integer.parseInt(request.getParameter("sid"));
			try
			{
			int status=LibrarianDao.returnBook(callno, sid);
			
			if(status>0)
			{
				response.sendRedirect("return_book.jsp?returnbook=returnbook");
			}
			else
			{
				response.sendRedirect("return_book.jsp?failreturn=failreturn");
				
			}
			
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
		}

}
