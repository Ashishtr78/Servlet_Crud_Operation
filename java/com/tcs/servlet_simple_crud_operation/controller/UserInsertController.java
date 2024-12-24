package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;
import java.util.logging.Logger;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.tcs.servlet_simple_crud_operation.Entity.User;
import com.tcs.servlet_simple_crud_operation.connection.MainConnection;
import com.tcs.servlet_simple_crud_operation.dao.UserDao;

import jakarta.servlet.RequestDispatcher;

//import com.mysql.cj.jdbc.Driver;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

public class UserInsertController  implements Servlet{


	UserDao ud=new UserDao();

	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
	int id=	Integer.parseInt(req.getParameter("userId"));
	String userName=req.getParameter("userName");
	String password=req.getParameter("userPassword");
	String emailid=req.getParameter("userEmail");
	String dobString=req.getParameter("userDob");
	LocalDate  dob=LocalDate.parse(dobString);
	String gender=req.getParameter("gender");
	
	System.out.println(id);
	System.out.println(userName);
	System.out.println(password);
	System.out.println(emailid);
	System.out.println(dob);
	System.out.println(gender);
	User user=new User(id, userName, password, emailid, dob, gender);
	User user2=ud.saveUserDataDao(user);
	PrintWriter p = res.getWriter();

	if (user2 != null) {

		p.write("<html><body><h5 style='color:green;'> today date = " + LocalDate.now() + "</h5></body></html>");

		p.write("<html><body><h5 style='color:green;'> current time = " + LocalTime.now() + "</h5></body></html>");

		p.write("success");

		p.write("<html><body><h5 style='color:green;'>SUCCESS</h5></body></html>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");

		dispatcher.include(req, res);
	} else {
		p.write("<html><body><h5 style='color:red;'>Data-Not-Stored</h5></body></html>");

		RequestDispatcher dispatcher = req.getRequestDispatcher("register.jsp");

		dispatcher.include(req, res);
	}
   
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

}
