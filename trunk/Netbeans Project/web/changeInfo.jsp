<%-- 
    Document   : changeInfo
    Created on : Apr 14, 2013, 1:06:55 PM
    Author     : Christopher
--%>

<%@page import="com.blainesmith.userregistration.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Object u = session.getAttribute("user");
    
    User user = new User();
    if (u != null)
        user = (User)u;
    else
        response.sendRedirect("login.jsp");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Information</title>
        <link href="login.css" rel="Stylesheet" type="text/css" />
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/jquery-validate.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#changeInfoForm").validate({
            onKeyup : true,
            eachValidField : function() {
                    $(this).closest('div').removeClass('error').addClass('success');
            },
            eachInvalidField : function() {

                    $(this).closest('div').removeClass('success').addClass('error');
            },
            description : {
                    email : {
                        pattern : '<span style="margin-left: 10px; color: red;">Must be a valid email</span>'
                    },
                    pass1 : {
                        pattern : '<span style="margin-left: 10px; color: red;">Password must contain a letter, a number, an uppercase letter and a symbol</span>'
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
        <h1>Update User Info</h1>
        <h3>Add information to any of the boxes to change that information</h3>
        <form id="changeInfoForm" action="ChangeInfo" method="POST">
            <table>
                <tr>
                    <td>
                        <label for="pass1">Password:</label>
                    </td>
                    <td>
                        <div class="control-group input-append">
                            <input data-description="pass1" data-describedby="pass1-description" data-pattern="(?=[^A-Z]*[A-Z])(?=[^!@#\$%]*[!@#\$%])" type="password" id="pass1" name="pass1">
                            <span class="error" id="pass1-description"></span>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="pass2">Retype password:</label>
                    </td>
                    <td>
                        <div class="control-group input-append">
                            <input data-description="pass2" data-describedby="pass2-description" type="password" id="pass2" name="pass2" data-conditional="pass2">
                            <span class="error" id="pass2-description"></span>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="first">First name:</label>
                    </td>
                    <td>
                        <input value="<%= (u != null && user.getFirstName() != null) ? user.getFirstName() : ""%>" type="text" name="first" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="last">Last name:</label>
                    </td>
                    <td>
                        <input value="<%= (u != null && user.getLastName() != null) ? user.getLastName() : ""%>" type="text" name="last" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="email">Email:</label>
                    </td>
                    <td>
                        <div class="control-group input-append">
                            <input value="<%= (u != null && user.getEmail() != null) ? user.getEmail() : ""%>" data-description="email" data-describedby="email-description" data-pattern="^([a-zA-Z0-9_\.\-\+])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$" type="text" id="email" name="email">
                            <span class="error" id="email-description"></span>
                        </div>
                    </td>
                </tr>
            </table>
            <input class="button" type="submit" value="Submit" />
            <br />
            <input class="button" type="button" value="Cancel" onclick="document.location.href = 'welcome.jsp'" />
        </form>
    </body>
</html>
