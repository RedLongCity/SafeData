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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
    <script type="text/javascript" src="resources/js/main.min.js?v=0.01"></script>
    <script type="text/javascript" src="resources/js/encryptionHandler.js?v=0.07"></script>
</head>
<body>
<form name="stat" id="stat" action='Register' method="post" id="regform">
    <input type="hidden" id="encr_usnm" name="encr_usnm"/>
    <input type="hidden" id="encr_eml" name="encr_eml"/>
    <input type="hidden" id="encr_psword" name="encr_psword"/>
    <input type="hidden" id="encr_cfmpsword" name="encr_cfmpsword"/>
</form>
<div align="center" id="loginBox">
    <fieldset style="margin:auto text-align:center">
        <legend class="legend-bold">Login</legend>
        <div>
            <label>Username:</label>
            <input class="theinput" type="text" id="username" placeholder="Enter your name" name="username" required/>
        </div>
        <div>
            <label>Email:</label>
            <input class="theinput" type="email" id="eml" placeholder="Enter email" name="eml"/>
        </div>
        <div>
            <label>Password:</label>
            <input class="theinput" type="password" id="psword" placeholder="Enter password" name="psword" required/>
        </div>
        <div>
            <label>Confirm:</label>
            <input class="theinput" type="password" id="cfmpsword" placeholder="Enter password" name="cfmpsword" required/>
        </div>
        <br>
    </fieldset>
</div>
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

    function go() {
        encrypt('http://localhost:8080/SafeData/Encryption', ['usnm', 'psword'])
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
