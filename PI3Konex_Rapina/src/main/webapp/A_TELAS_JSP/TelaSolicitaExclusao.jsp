<%-- 
    TELA REFERENTE AO MARCO II

    Document   : TelaSolicitaExclusao
    Created on : 2 de mai de 2021, 16:39:19
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/confAttDados.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <title>Eita :( </title>
    </head>
    <body>
        <div class="todo">
            <br>
            <img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="">
            <h1>Deseja realmente solicitar a exclusão?</h1>
            <p>Selecione uma das opções</p>
            <br><br>

            <form action="${pageContext.request.contextPath}/DeletaConta" method="get">
                <div class="floatleft">
                    <button type="submit" name="btn" value="Sim" id="btn" >Sim</button>
                </div>
                <div class="floatleft">
                    <button type="submit" name="btn" value="Sim" id="btn2">Não</button>
                </div>
                <!--Verifica a Exclusão-->
                <c:if test="${not empty erroSolicita}">
                    <h3 style="color: #4361ee;"><c:out value="${erroSolicita}"/></h3>
                </c:if>  
            </form>
        </div>  
    </body>
</html>
