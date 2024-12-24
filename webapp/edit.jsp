<%@page import="com.tcs.servlet_simple_crud_operation.dao.UserDao"%>
<%@page import="com.tcs.servlet_simple_crud_operation.Entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit form</title>
</head>
<body>

          <%
          int id=Integer.parseInt(request.getParameter("id"));
  		
            User user=new UserDao().getUserById(id);
            
          %>
  <h3>edit-form</h3>
       <div>
            <form action="editForm" method="get">
                <label>USER-ID:</label>
                <input type="number"  name="userId" value="<%=user.getId() %>"><br>
                <label>USER-NAME:</label>
                <input type="text"  name="userName" value="<%=user.getName()%>"><br>
                 <label>PASSWORD:</label>
                <input type="password" placeholder="enter password" name="userPassword" value="<%=user.getPassword()%>"><br>
                <label>USER-EMAIL:</label>
                <input type="email" placeholder="enter user email" name="userEmail" value=" <%=user.getEmail()%>"><br>
                <label>USER-DOB:</label>
                <input type="date"  name="userDob" value="<%=user.getDob() %>"><br>
                <label>USER-Gender:</label>
                <input type="radio" name="gender" value="Male" <%if(user.getGender().equalsIgnoreCase("male")){ %>checked="checked"<%} %>>Male 
                <input type="radio" name="gender" value="Female" <%if(user.getGender().equalsIgnoreCase("female")){ %>checked="checked"<%} %>>Female<br>
                <input type="submit" value="edit">
</body>
</html>