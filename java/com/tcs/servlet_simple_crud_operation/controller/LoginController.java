package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tcs.servlet_simple_crud_operation.Entity.User;
import com.tcs.servlet_simple_crud_operation.connection.MainConnection;
import com.tcs.servlet_simple_crud_operation.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet(value = "/userLogin")
public class LoginController extends HttpServlet{
	
	UserDao dao=new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession=req.getSession();
		String email=req.getParameter("userEmail");
		String password=req.getParameter("userPassword");
//		System.out.println(email);
//		System.out.println(password);
		
		User user=dao.loginValidationDao(email);
		//System.out.println(user.getPassword());
		if(user!=null) {
			if(password.equalsIgnoreCase(user.getPassword())) {
				httpSession.setAttribute("email", email);
				httpSession.setMaxInactiveInterval(30);
				req.setAttribute("msg", "login succesfully");
				
				req.getRequestDispatcher("display.jsp").forward(req, resp);;
			}
			else {
				req.setAttribute("msg","your password is incorrect");
				req.getRequestDispatcher("login.jsp").forward(req, resp);;
			}
		}
		else {
			req.setAttribute("msg","your email is incorrect");
			req.getRequestDispatcher("login.jsp").forward(req, resp);;
		}
		
	}
}
