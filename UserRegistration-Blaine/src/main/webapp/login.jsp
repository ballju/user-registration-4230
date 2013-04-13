<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<link href="login.css" rel="Stylesheet" type="text/css" />
</head>
<body>
	<h2>Login</h2>
	<form method="POST" action="Login">
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email: <input type="text" name="email"></p>
	<p>Password: <input type="password" name="pass"></p>
	<input type="submit" value="Login">&nbsp;&nbsp;
<!--        <input type="button" value="Clear">-->
        </form>
	<br />
	<input type="button" value="Forgot Password?" onclick="document.location.href = 'changePass.jsp'">
        <br />
	<input type="button" value="Register" onclick="document.location.href = 'changePass.jsp'">
	</form>
</body>
</html>