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
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-validate.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#loginForm").validate({
				onKeyup : true,
				eachValidField : function() {

					$(this).closest('div').removeClass('error').addClass('success');
				},
				eachInvalidField : function() {

					$(this).closest('div').removeClass('success').addClass('error');
				},
				description : {
					email : {
						required : '<span style="margin-left: 10px; color: red;">Required</span>'
					},
                                        pass : {
						required : '<span style="margin-left: 10px; color: red;">Required</span>'
					}                          
				}
			});
    });
</script>
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
        
	<form id="loginForm" method="POST" action="Login">
        <div class="control-group input-append">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email: <input data-description="email" data-describedby="email-description" data-required id="email" type="text" name="email" /><span id="email-description"></span></p>
        </div>
        <div class="control-group input-append">
            <p>Password: <input data-required data-description="pass" data-describedby="pass-description" type="password" id="pass" name="pass"><span id="pass-description"></span></p>
        </div>
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