<%@page import="com.tcs.servlet_simple_crud_operation.dao.UserDao"%>
<%@page import="com.tcs.servlet_simple_crud_operation.Entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display User Data</title>
</head>
<body>
<%
           HttpSession httpSession=request.getSession();
     String email=(String)httpSession.getAttribute("email");
     if(email!=null){
    String msg = (String) request.getAttribute("msg");
    List<User> users = new UserDao().displayUserData();
   httpSession.getMaxInactiveInterval();
    if (users != null && !users.isEmpty()) {
%>
     <% if(msg!=null){ %>
     <h3><%= msg %></h3>
     <%} %>
     
        <h2>User Data</h2>
        <table border="2px">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>DOB</th>
                <th>Gender</th>
                <th colspan="2">Actions</th>
            </tr>
            <% for (User user : users) { %>
                <tr>
                    <td><%= user.getId() %></td>
                    <td><%= user.getName() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getDob() %></td>
                    <td><%= user.getGender() %></td>
                    <td><a href="edit.jsp?id=<%= user.getId() %>">Edit</a></td>
                    <td><a href="delete?id=<%= user.getId() %>">Delete</a></td>
                </tr>
            <% } %>
        </table>
        
       <a href="register.jsp">register</a>
       <a href="logout?email=<%= email %>">Logout</a>
<% } else { %>
    <h3 style="color:red">No Users Found</h3>
<% } %>
<%} %>
</body>
</html>
