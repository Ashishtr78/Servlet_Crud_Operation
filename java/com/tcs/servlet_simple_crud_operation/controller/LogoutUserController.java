package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/logout")
public class LogoutUserController extends HttpServlet {
	      
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   HttpSession httpSession=req.getSession();
		String email=req.getParameter("email");
		if(email !=null) {
			
			httpSession.invalidate();
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("display.jsp").forward(req, resp);
		}
	}
	
	

}
