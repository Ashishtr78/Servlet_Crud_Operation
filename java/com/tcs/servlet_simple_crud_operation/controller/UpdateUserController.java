package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.tcs.servlet_simple_crud_operation.Entity.User;
import com.tcs.servlet_simple_crud_operation.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/editForm")
public class UpdateUserController extends HttpServlet {
      UserDao dao=new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=	Integer.parseInt(req.getParameter("userId"));
		String userName=req.getParameter("userName");
		String password=req.getParameter("userPassword");
		String emailid=req.getParameter("userEmail");
		String dobString=req.getParameter("userDob");
		LocalDate  dob=LocalDate.parse(dobString);
		String gender=req.getParameter("gender");
		
		User user=new User(id, userName, password, emailid, dob, gender);
		
		User user2=dao.updateUserData(user);
		//System.out.println(user2.getId());
		
		if (user2 != null) {
			req.getRequestDispatcher("display.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("msg","edit operation is failed");
		req.getRequestDispatcher("display.jsp").forward(req, resp);
			
		}
	}
	
}
