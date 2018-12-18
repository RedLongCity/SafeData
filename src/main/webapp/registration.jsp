<%--
  Created by IntelliJ IDEA.
  User: Валера
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
</head>
<body>
<form action='Register' method="post" id="regform">
    <fieldset align="center">
        <table align="center">
            <tr>
                <td><label for="usnm">Username</label></td>
                <td><input type="text" name="username" id="usnm" required/></td>
            </tr>

            <tr>
                <td><label for="eml">Email</label></td>
                <td><input type="text" name="email" id="eml" required/></td>
            </tr>

            <tr>
                <td><label for="psword">Password</label></td>
                <td><input type="password" id="psword" name="psword" required/></td>
            </tr>

            <tr>
                <td><label for="cfmpsword">Confirm Password</label></td>
                <td><input type="password" id="cfmpsword" name="cfmpsword" required/></td>
            </tr>
        </table>
        <br>
        <input class="submit" type="submit" value="Register"/>
    </fieldset>
</form>
<script>
    $(document).ready(function () {
        $("#regform").validate({
            rules: {
                cfmpsword:
                    {
                        equalTo: "#psword"
                    }
            }
        });
    });
</script>
</body>
</html>
