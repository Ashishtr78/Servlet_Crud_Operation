<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
             <%
              String msg=(String)request.getAttribute("msg");
             if(msg!=null){
              %>    
           <h3 style="color:red"><%= msg %></h3>
           <%} %>
          <h2>Login form</h2>
          <form action="userLogin" method="get">
                 <label>USER-EMAIL:</label>
                 <input type="email" placeholder="enter user email" name="userEmail"><br>
                 <label>PASSWORD:</label>
                 <input type="password" placeholder="enter password" name="userPassword"><br>
                 <input type="submit"  value="login">
          </form>
                
   
</body>
</html>