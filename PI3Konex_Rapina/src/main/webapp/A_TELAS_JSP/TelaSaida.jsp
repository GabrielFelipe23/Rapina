<%-- 
    TELA REFERENTE AO MARCO II

    Document   : TelaSaida
    Created on : 30 de abr de 2021, 19:57:33
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/ateProx.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
    <title>Até em breve</title>
</head>
<body>
    <div class="todo">
        <img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="">
        <h1>Até a próxima Rapinante</h1>
        <br>
        <!--ENVIA PARA INDEX-->
        <a href="${pageContext.request.contextPath}/TelaInicial" id="btnSair"><button>Home</button></a>
    </div>
    
</body>
</html>