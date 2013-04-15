<%-- 
    Document   : changeInfo
    Created on : Apr 14, 2013, 1:06:55 PM
    Author     : Christopher
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Information</title>
        <link href="login.css" rel="Stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Update User Info</h1>
        <form action="ChangeInfo" method="POST">
            <table>
                <tr>
                    <td>
                        <label for="pass1">Password:</label>
                    </td>
                    <td>
                        <input type="password" name="pass1" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="pass2">Retype password:</label>
                    </td>
                    <td>
                        <input type="password" name="pass2" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="first">First name:</label>
                    </td>
                    <td>
                        <input type="text" name="first" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="last">Last name:</label>
                    </td>
                    <td>
                        <input type="text" name="last" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label for="email">Email:</label>
                    </td>
                    <td>
                        <input type="text" name="email" />
                    </td>
                </tr>
            </table>
            <input type="submit" value="submit" />
        </form>
    </body>
</html>
