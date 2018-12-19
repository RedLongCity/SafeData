<%--
  Created by IntelliJ IDEA.
  User: Валера
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/main.min.js?v=0.01"></script>
    <script type="text/javascript" src="resources/js/encryptionHandler.js?v=0.07"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div align="center">
    <h2>Hello, please log in:</h2>
    <br><br>
</div>
<div align="center" id="loginBox">
    <form name="stat" id="stat" action='Login' method="post" id="userform">
        <input type="hidden" id="encr_username" name="encr_username"/>
        <input type="hidden" id="encr_psword" name="encr_psword"/>
    </form>
    <fieldset style="margin:auto text-align:center">
        <legend class="legend-bold">Login</legend>
        <div>
            <label>Username:</label>
            <input class="theinput" type="text" id="username" placeholder="Enter your name" name="username" required/>
        </div>
        <div>
            <label>Password:</label>
            <input class="theinput" type="password" id="psword" placeholder="Enter password" name="psword" required/>
        </div>
        <br>
    </fieldset>
    <button class="btn btn-success" onclick="go()">Login</button>
</div>
<script type="text/javascript">
    function go() {
        encrypt('http://localhost:8080/SafeData/Encryption', ['username', 'psword'])
            .then(
                result => {
                    $('#stat').submit();
                },
                error => {
                    alert('error');
                })
    }
</script>
</body>
</html>
