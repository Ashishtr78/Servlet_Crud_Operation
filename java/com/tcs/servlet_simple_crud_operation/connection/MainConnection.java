package com.tcs.servlet_simple_crud_operation.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class MainConnection {
	public static Connection getMainConnection()
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/servletdatabase";
			String username="root";
			String password="Ashish";
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}
}
