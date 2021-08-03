<%-- 
    Document   : Erro404
    Created on : 8 de jun de 2021, 19:17:44
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/erro404.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
    <title>Erro 404</title>
</head>
<body>
    <div class="todo">
        <h1>404</h1>
        <h2>Error Page not Found </h2>
        <img src="${pageContext.request.contextPath}/images/404Error.png" alt="">
        <a href="${pageContext.request.contextPath}/Home">
            <button style="cursor: pointer;">Ir para Home</button>
        </a>
    </div>
</body>
</html>