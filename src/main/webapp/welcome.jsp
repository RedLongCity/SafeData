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
</head>
<body>
<form action='Message' method="post">
    <fieldset style= "margin:auto text-align:center">
        <p><label for="message">Message</label> <input placeholder="Input Your Message Please" type="text" name="message" id="message" required/></p>
        <br>
        <input class="submit" type="submit" value="Send"/>
    </fieldset>
</form>
</body>
</html>
