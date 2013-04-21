<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
<link href="login.css" rel="Stylesheet" type="text/css" />
</head>
<body>
    <p>Please enter the email address you provided when you registered:</p>
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
    <form action="ChangePass" method="POST">
        <input type="text" name="email" />
        <input class="button" type="submit" value="Submit" />
    </form>
    <input class="button" type="button" value="Cancel" onclick="document.location.href = 'login.jsp'" />
</body>
</html>