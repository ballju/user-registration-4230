<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
<link href="login.css" rel="Stylesheet" type="text/css" />
</head>
<body>
	<h2>Welcome!</h2>
	<h2>You may change your settings below</h2>
	<form method="get">
	<input type="button" value="Change Info" onclick="document.location.href = 'changeInfo.jsp'">&nbsp;&nbsp;<input type="button" value="Cancel" onclick="document.location.href = 'login.jsp'">
	</form>
</body>
</html>