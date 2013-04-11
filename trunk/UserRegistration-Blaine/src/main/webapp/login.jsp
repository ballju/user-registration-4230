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
	<form method="get">
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email: <input type="text" name="email"></p>
	<p>Password: <input type="password" name="pass"></p>
	<input type="button" value="Login" onclick="location.href('welcome.jsp')">&nbsp;&nbsp;<input type="submit" value="Clear">
	<br />
	<input type="button" value="Forgot Password?" onclick="location.href('changePass.jsp')">
	<br />
	<input type="button" value="Register" onclick="location.href('changePass.jsp')">
	</form>
</body>
</html>