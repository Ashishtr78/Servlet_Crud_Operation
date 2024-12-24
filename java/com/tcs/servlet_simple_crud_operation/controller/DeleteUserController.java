package com.tcs.servlet_simple_crud_operation.controller;

import java.io.IOException;

import com.tcs.servlet_simple_crud_operation.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/delete")
public class DeleteUserController extends HttpServlet {
   UserDao dao=new UserDao();
	
//	
   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
//		System.out.println(id);
		 int a =dao.deletUserDataDao(id);
//		 System.out.println(a);
		 if(a>0) {
			 req.setAttribute("msg","delete operation is successfully ");
			 req.getRequestDispatcher("display.jsp").forward(req, resp);
		 }else {
			 req.setAttribute("msg","delete operation is fail");
			 req.getRequestDispatcher("display.jsp").forward(req, resp);
		 }
	}
}	