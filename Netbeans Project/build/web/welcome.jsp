<%@page import="com.blainesmith.userregistration.User"
        import="javax.servlet.ServletException"
        import="javax.servlet.http.HttpServlet"
        import="javax.servlet.http.HttpServletRequest"
        import="javax.servlet.http.HttpServletResponse" 
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
    Object u = session.getAttribute("user");
    
    User user = new User();
    if (u != null)
        user = (User)u;
    else
        response.sendRedirect("login.jsp");
        
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!</title>
<link href="login.css" rel="Stylesheet" type="text/css" />
</head>
<body>
    <% 
        if (u != null) {
    %>
        <h2>Welcome <%=user.getFirstName()%>!</h2>
    <%
        }
        else {
    %>
        <h2>Welcome!</h2>
    <% } %>
	<h2>You may change your settings below</h2>
        <input type="button" value="Change Info" onclick="document.location.href = 'changeInfo.jsp'">
        <form action="Logout" method="POST">
            <input type="submit" value="Logout" />
        </form>
</body>
</html>