package com.elibrary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.bean.IssuedBookBean;
import com.elibrary.dao.LibrarianDao;

@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			String callno=request.getParameter("callno");
			int sid=Integer.parseInt(request.getParameter("sid"));
			String sname=request.getParameter("sname");
			String mob=request.getParameter("smob");
			
			IssuedBookBean bean=new IssuedBookBean();
			bean.setCallno(callno);
			bean.setSid(sid);
			bean.setSname(sname);
			bean.setMob(mob);
			try
			{
			int i=LibrarianDao.issueBook(bean);
			if(i>0)
			{
				response.sendRedirect("issue_book.jsp?issuebook=issuebook");
			}
			else
			{
				response.sendRedirect("issue_book.jsp?booknotavailable=booknotavailable");
			}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

}
