<%--
  Created by IntelliJ IDEA.
  User: Валера
  Date: 15.12.2018
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>

<h2>Hello, please log in:</h2>
<br><br>
<div align="center" id="loginBox">
    <form action='Login' method="post" id="userform">
        <fieldset style="margin:auto text-align:center">
            <legend class="legend-bold">Login</legend>
            <div>
                <label>Username:</label>
                <input class="theinput" type="text" placeholder="Enter your name" name="username" required/>
            </div>
            <div>
                <label>Password:</label>
                <input class="theinput" type="password" placeholder="Enter password" name="psword" required/>
            </div>
            <br>
            <input class="submit" type="submit" value="Login"/>

        </fieldset>
    </form>
</div>
</html>
