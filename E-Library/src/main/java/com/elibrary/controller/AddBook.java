package com.elibrary.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.elibrary.bean.Book;
import com.elibrary.dao.LibrarianDao;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
			String callno=request.getParameter("callno");
			String name=request.getParameter("name");
			String author=request.getParameter("author");
			String publisher=request.getParameter("publisher");
			int quantity=Integer.parseInt(request.getParameter("quantity"));
			
			Book book=new Book();
			book.setCallno(callno);
			book.setName(name);
			book.setAuthor(author);
			book.setPublisher(publisher);
			book.setQuantity(quantity);
			book.setIssued(0);
			
			try
			{
				LibrarianDao.addBook(book);
				response.sendRedirect("add_book.jsp?addbook=addbook");
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		
	    }

}
