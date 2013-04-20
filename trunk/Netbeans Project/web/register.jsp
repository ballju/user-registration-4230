<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info</title>
<link href="login.css" rel="Stylesheet" type="text/css" />
<script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-validate.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#registerForm").validate({
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
                                        first : {
						required : '<span style="margin-left: 10px; color: red;">Required</span>'
					},
                                        last : {
						required : '<span style="margin-left: 10px; color: red;">Required</span>'
					},
                                        pass1 : {
						required : '<span style="margin-left: 10px; color: red;">Required</span>',
                                                pattern : '<span style="margin-left: 10px; color: red;">Password must contain a lowercase letter, a number, an uppercase letter, a symbol and be 8 characters long</span>'
					},
                                        pass2 : {
                                                conditional : '<span style="margin-left: 10px; color: red;">Passwords must be the same</span>'
					}
				},
                                conditional : {
					pass2 : function() {

						return $(this).val() == $('#pass1').val();
					}
				}
			});
    });
</script>
</head>
<body>
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
    
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<h2>User Info</h2>
	<form id="registerForm" method="POST" action="Register">
        <div class="control-group input-append">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email: <input data-description="email" data-describedby="email-description" data-required data-pattern="^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$" type="text" id="email" name="email"><span class="error" id="email-description"></span></p>
        </div>
        <div class="control-group input-append">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;First Name: <input data-description="first" data-describedby="first-description" id="first" data-required type="text" name="first"><span class="error" id="first-description"></span></p>
        </div>
        <div class="control-group input-append">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Last Name: <input data-description="last" data-describedby="last-description" id="last" data-required type="text" name="last"><span class="error" id="last-description"></span><p>
        </div>
        <div class="control-group input-append">
            <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;New Password: <input data-description="pass1" data-describedby="pass1-description" data-pattern="(?=[^A-Z]*[A-Z])(?=[^a-z]*[a-z])(?=[^!@#\$%]*[!@#\$%])(?=[^0-9]*[0-9])(.{8})" data-required type="password" id="pass1" name="pass1"><span class="error" id="pass1-description"></span></p>
        </div>
        <div class="control-group input-append">
            <p>Re-enter Password: <input data-description="pass2" data-describedby="pass2-description" type="password" id="pass2" name="pass2" data-conditional="pass2"><span class="error" id="pass2-description"></span></p>
        </div>
	<input class="button" type="submit" value="Save">&nbsp;&nbsp;<input class="button" type="button" value="Cancel" onclick="document.location.href = 'login.jsp'">
	</form>
</body>
</html>