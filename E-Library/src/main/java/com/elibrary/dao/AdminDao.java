package com.elibrary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.elibrary.bean.Admin;
import com.elibrary.bean.Librarian;

public class AdminDao 
{
	static Connection con=ConnectionDao.getConnection();
	
	public static boolean loginCheck(Admin admin) throws SQLException
	{
		PreparedStatement ps=con.prepareStatement("select * from admin_login where email=? and password=?");
		
		ps.setString(1,admin.getEmail());
		ps.setString(2,admin.getPassword());
		
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
	
	public static void addLibrarian(Librarian librarian) throws SQLException 
	{
		  PreparedStatement ps=con.prepareStatement("insert into librarian(name,email,password,mob) values(?,?,?,?)");
		  ps.setString(1, librarian.getName() );
		  ps.setString(2, librarian.getEmail());
		  ps.setString(3, librarian.getPassword());
		  ps.setString(4, librarian.getMob());
		  ps.executeUpdate();
	}
	
	 public static List viewLibrarian() throws SQLException
	  {
		 List<Librarian> list=new ArrayList<Librarian>();
		 PreparedStatement ps=con.prepareStatement("select * from librarian");
		 ResultSet rs=ps.executeQuery();
		  while(rs.next())
		  {
			  Librarian librarian=new Librarian();
			  librarian.setId(rs.getInt("id"));
			  librarian.setName(rs.getString("name"));
			  librarian.setEmail(rs.getString("email"));
			  librarian.setPassword(rs.getString("password"));
			  librarian.setMob(rs.getString("mob"));
			  list.add(librarian);
		 }
		  
		  return list;
	  }
	
	 public static Librarian getLibrarian(int id) throws SQLException
	 {
		 Librarian l=null;
		 PreparedStatement ps= con.prepareStatement("select * from librarian where id=?");
		 ps.setInt(1, id);
		 ResultSet rs= ps.executeQuery();
		 while(rs.next())
		 {
			 l= new Librarian();
			 l.setId(rs.getInt("id"));
			 l.setName(rs.getString("name"));
			 l.setEmail(rs.getString("email"));
			 l.setPassword(rs.getString("password"));
			 l.setMob(rs.getString("mob"));
			 return l;
		 }
		 return l;
	 }
	 
	 public static boolean updateLibrarian(int id, String name, String email,String password, String mob) throws SQLException
	  {
		  PreparedStatement ps=con.prepareStatement("update librarian set name=?, email=?, password=?, mob=? where id=?");
		  ps.setString(1,name);
		  ps.setString(2, email);
		  ps.setString(3,password);
		  ps.setString(4, mob);
		  ps.setInt(5, id);
		  int executeUpdate = ps.executeUpdate();
		  if(executeUpdate!=0)
		  {
			  return true;
		  }
		  else 
		  {
			  return false;
		  }
	  }
	 public static boolean deleteLibrarian(int id) throws SQLException
	 {
		 PreparedStatement ps=con.prepareStatement("delete from librarian where id=?");
		 ps.setInt(1, id);
		 int executeUpdate=ps.executeUpdate();
		 if(executeUpdate!=0)
		 {
			return true; 
		 }
		 else
		 {
			 return false;
		 }
			 
	 }
	

}
