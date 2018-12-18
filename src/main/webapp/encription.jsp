<%--
  Created by IntelliJ IDEA.
  User: Валера
  Date: 16.12.2018
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Encrypt</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css"/>
    <script type="text/javascript" src="resources/js/main.min.js?v=0.06"></script>
</head>
<head>
</head>
<body>
<div class="container">
    <h1>Encrypt</h1>
    <input id="message"/>
    <div>
        <button id="getPublicKey">get public key</button>
    </div>

    <p style="word-wrap: break-word" id="publicKey"/>
    <div>
        <button id="encryption">encrypt</button>
    </div>
    <p style="word-wrap: break-word" id="encryptionResult"/>
    <div>
        <button id="decryption">decrypt</button>
    </div>
    <p style="word-wrap: break-word" id="decryptionResult"/>
</div>
</body>
</html>
