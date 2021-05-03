package com.elibrary.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elibrary.bean.Admin;
import com.elibrary.bean.Book;
import com.elibrary.bean.IssuedBookBean;
import com.elibrary.bean.Librarian;


public class LibrarianDao 
{
static Connection con=ConnectionDao.getConnection();
	
	public static boolean loginCheck(Librarian l) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement("select * from librarian  where email=? and password=?");
		
		ps.setString(1,l.getEmail());
		ps.setString(2,l.getPassword());
		
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			return true;
		}
		else
		{
			return false;
		}	
		
	}
	
	public static void addBook(Book book) throws SQLException 
	{
		  PreparedStatement ps=con.prepareStatement("insert into book(callno,name,author,publisher, quantity, issued) values(?,?,?,?,?,?)");
		  ps.setString(1,book.getCallno());
		  ps.setString(2, book.getName());
		  ps.setString(3, book.getAuthor());
		  ps.setString(4, book.getPublisher());
		  ps.setInt(5, book.getQuantity());
		  ps.setInt(6, book.getIssued());
		  
		  ps.executeUpdate();
	}
	
	 public static List viewBook() throws SQLException
	  {
		  List<Book> list=new ArrayList<Book>();
		  PreparedStatement ps=con.prepareStatement("select * from book");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  Book book= new Book();
			  book.setCallno(rs.getString("callno"));
			  book.setName(rs.getString("name"));
			  book.setAuthor(rs.getString("author"));
			  book.setPublisher(rs.getString("publisher"));
			  book.setQuantity(rs.getInt("quantity"));
			  book.setIssued(rs.getInt("issued"));
			  list.add(book);
		 }
		  
		  return list;
	  }
	 
	 public static int getIssued(String callno) throws SQLException
	 {
		 int issued=0;
		 PreparedStatement ps=con.prepareStatement("select * from book where callno=?");
		 ps.setString(1, callno);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next())
		 {
			 issued=rs.getInt("issued");
		 }
		 return issued;
	 }
	 
	public static boolean checkIssue(String callno) throws SQLException 
	{
		System.out.println("call no: "+callno);
		boolean status=false;
		
		PreparedStatement ps=con.prepareStatement("select * from book where callno=? and quantity>issued");
		ps.setString(1,callno);
		
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())
		{
			status=true;
		}
		else
		{
			System.out.println("Result set is empty");
		}
		System.out.println("Checked Status: "+status);
		
		return status;
	}
	
	public static int issueBook(IssuedBookBean bean) throws SQLException
	{
		int status=0;
		String callno= bean.getCallno();
		boolean checkStatus=checkIssue(callno);
		
		
		if(checkStatus)
		{
			
			PreparedStatement ps=con.prepareStatement("insert into issued_book values (?,?,?,?,?,?)");
			ps.setString(1, bean.getCallno());
			ps.setInt(2,  bean.getSid());
			ps.setString(3, bean.getSname());
			ps.setString(4, bean.getMob());
			Date date=new Date(System.currentTimeMillis());
			ps.setDate(5, date);
			ps.setString(6,"no");
			status=ps.executeUpdate();
			
			if(status>0)
			{
				ps=con.prepareStatement("update book set issued=? where callno=?");
			
				ps.setInt(1, getIssued(callno)+1);
				ps.setString(2, callno);
				status=ps.executeUpdate();
			}
		}
		
		return status;
	}
	
	 public static List viewIssuedBook() throws SQLException
	  {
		  List<IssuedBookBean> list=new ArrayList<IssuedBookBean>();
		  PreparedStatement ps=con.prepareStatement("select * from issued_book");
		  ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  IssuedBookBean bean=new IssuedBookBean();
			  bean.setCallno(rs.getString("callno"));
			  bean.setSid(rs.getInt("sid"));
			  bean.setSname(rs.getString("sname"));
			  bean.setMob(rs.getString("mob"));
			  bean.setIssueDate(rs.getDate("issued_date"));
			  bean.setReturnStatus(rs.getString("return_status"));
			  
			  list.add(bean);
		  }
		  
		  return list;
	  }
	 public static int returnBook(String callno,int sid) throws SQLException
	 {
		 int status=0;
		 PreparedStatement ps=con.prepareStatement("update issued_book set return_status='yes' where callno=? and sid=? and return_status='no'");
		 ps.setString(1, callno);
		 ps.setInt(2, sid);
		 status=ps.executeUpdate();
		 
		  if(status>0)
		  {
			  PreparedStatement ps2=con.prepareStatement("update book set issued=? where callno=?");
			  ps2.setInt(1, getIssued(callno)-1);
			  ps2.setString(2, callno);
			  status= ps2.executeUpdate();
			  
		  }
		 
		 return status;
	 }
	
}
