<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
    Object u = session.getAttribute("user");
    
    if (u != null)
        response.sendRedirect("welcome.jsp");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<link href="login.css" rel="Stylesheet" type="text/css" />
</head>
<body>
	<h2>Login</h2>
        <% 
          String message = request.getParameter("message");
          
          if (message != null && !message.equals("")) {
        %>
            <p id="message" name="message" class="error-message"><%= message %></p>
        <%
          }
          else {
        %>
        <p id="message" name="message" class="error-message"></p>
        <%
          }
        %>
        
	<form method="POST" action="Login">
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email: <input type="text" name="email"></p>
	<p>Password: <input type="password" name="pass"></p>
	<input class="button" type="submit" value="Login">&nbsp;&nbsp;
<!--        <input type="button" value="Clear">-->
        </form>
	<br />
	<input class="button" type="button" value="Forgot Password?" onclick="document.location.href = 'changePass.jsp'">
        <br />
	<input class="button" type="button" value="Register" onclick="document.location.href = 'register.jsp'">
	</form>
</body>
</html>