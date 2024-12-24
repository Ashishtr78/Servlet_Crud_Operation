<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body>
         <h3>Registration-form</h3>
       <div>
            <form action="userRegister" method="get">
                <label>USER-ID:</label>
                <input type="number" placeholder="enter user id" name="userId"><br>
                <label>USER-NAME:</label>
                <input type="text" placeholder="enter user name" name="userName"><br>
                 <label>PASSWORD:</label>
                <input type="password" placeholder="enter password" name="userPassword"><br>
                <label>USER-EMAIL:</label>
                <input type="email" placeholder="enter user email" name="userEmail"><br>
                <label>USER-DOB:</label>
                <input type="date"  name="userDob"><br>
                <label>USER-Gender:</label>
                <input type="radio" name="gender" value="Male">Male
                <input type="radio" name="gender" value="Female">Female<br>
                <input type="submit" value="register">
                <button><a href="login.jsp">Login</a></button>
                
                
            </form>
       </div>
</body>
</html>