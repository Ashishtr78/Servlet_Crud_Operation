package com.tcs.servlet_simple_crud_operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.tcs.servlet_simple_crud_operation.Entity.User;
import com.tcs.servlet_simple_crud_operation.connection.MainConnection;

public class UserDao {

	private final String INSERTUSERDATAQUERY="insert into user(id,name,email,password,dob,gender) values(?,?,?,?,?,?)";
	private final String USERLOGINDATAQUERY="select * from user where email=?";
	private final String DISPLAYUSERDATAQUERY="select * from user";
	private final String DELETEUSERDATAQUERY="delete from user where id=?";
	private final String USERDATABYIDQUERY="Select * from user where id=?";
	private final String UPDATEUSERDATAQUERY="update user SET name = ?,  email = ?,password = ?, dob = ?, gender = ? WHERE id = ?";
	Connection conn=MainConnection.getMainConnection();
	PreparedStatement ps=null;
	public User saveUserDataDao(User user) {
	 conn=MainConnection.getMainConnection();
//	 System.out.println(user.getId());
//		System.out.println(user.getName());
//		System.out.println(user.getEmail());
//		System.out.println(user.getPassword());
//		System.out.println(user.getDob());
//		System.out.println(user.getGender());
		try {
			 ps=conn.prepareStatement(INSERTUSERDATAQUERY);
			ps.setInt(1,user.getId());
			ps.setString(2, user.getName());
			ps.setString(3,user.getEmail());
			ps.setString(4,user.getPassword());
			ps.setObject(5,user.getDob());
			ps.setString(6,user.getGender());
			int a=ps.executeUpdate();
			if(a>0)
			{
				System.out.println("data insert successfully");
				return user;
			}
			else {
				return null;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	 
//	public User loginValidationDao(String emailid) {
//		try {
//			ps=conn.prepareStatement(USERLOGINDATAQUERY);
//			ps.setString(1, emailid);
//			ResultSet res=ps.executeQuery();
//			
//			String email=res.getString("email");
//			String password=res.getString("password");
//			User user=new User(password, email);
//			return user;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return null;
//		}
//	}

	public User loginValidationDao(String email) {
		try {
			ps=conn.prepareStatement(USERLOGINDATAQUERY);
			ps.setString(1, email);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
			String password=res.getString("password");
			User user=new User(password, email);
			if(user!=null) {
		    	return user;
			}else {
				return null;
			}
	        }
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<User> displayUserData() {
		List<User> users=new ArrayList<User>();
		try {
			 ps=conn.prepareStatement(DISPLAYUSERDATAQUERY);
			  ResultSet res=ps.executeQuery();
			 while(res.next())
			 {
				int id=res.getInt("id");
				String name=res.getString("name");
				String email=res.getString("email");
				LocalDate dob = res.getDate("dob").toLocalDate();
				String gender=res.getString("gender");
				User user=new User(id, name, email, dob, gender);
				users.add(user);
			 }
			
				return users;
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	public int deletUserDataDao(int id) {
//		List<User> users=new ArrayList<User>();
		System.out.println(id);
		try {
			ps=conn.prepareStatement(DELETEUSERDATAQUERY);
			ps.setInt(1,id);
			int a= ps.executeUpdate();
			System.out.println(a);
			return a;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public User getUserById(int uid) {
		User user=null;
		try {
			 ps=conn.prepareStatement(USERDATABYIDQUERY);
			 ps.setInt(1, uid);
			  ResultSet res=ps.executeQuery();
			 while(res.next())
			 {
				int id=res.getInt("id");
				String name=res.getString("name");
				String email=res.getString("email");
				String password=res.getString("password");
				LocalDate dob = res.getDate("dob").toLocalDate();
				String gender=res.getString("gender");
				 user=new User(id, name, password, email, dob, gender);
			
			 }
				return user;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
		
	}
	public User updateUserData(User user) {
		 conn=MainConnection.getMainConnection();
//		 System.out.println(user.getId());
//			System.out.println(user.getName());
//			System.out.println(user.getEmail());
//			System.out.println(user.getPassword());
//			System.out.println(user.getDob());
//			System.out.println(user.getGender());
			try {
				 ps=conn.prepareStatement(UPDATEUSERDATAQUERY);
				//ps.setInt(1,user.getId());
				ps.setString(1, user.getName());
				ps.setString(2,user.getEmail());
				ps.setString(3,user.getPassword());
				ps.setObject(4,user.getDob());
				ps.setString(5,user.getGender());
				ps.setInt(6,user.getId());
				int a=ps.executeUpdate();
				if(a>0)
				{
					System.out.println("data insert successfully");
					return user;
				}
				else {
					return null;
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				return null;
			}
		
	}
}
