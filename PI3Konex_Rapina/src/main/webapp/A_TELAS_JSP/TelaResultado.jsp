<%-- 
    Document   : TelaResultado
    Created on : 29 de abr de 2021, 18:40:39
    Author     : Gabriel
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Email Informado:<c:out value="${sessionScope.dadosAcesso.email}"></c:out></h1>
        <h1>Senha obtida:<c:out value="${userLogado.senha}"></c:out></h1>
        <h1>Tipo Reconhecido:<c:out value="${sessionScope.dadosAcesso.tipo_usuario}"></c:out></h1>
        <h1>Retorno verificador senha:<c:out value="${rtSenha}"></c:out></h1>
    </body>
</html>
