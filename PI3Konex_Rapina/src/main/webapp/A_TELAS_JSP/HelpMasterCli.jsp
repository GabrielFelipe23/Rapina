<%-- 
    Document   : HelpMasterCli
    Created on : 28 de mai de 2021, 18:48:30
    Author     : Gabriel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Recado</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Message.css">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="container-landing">
            <div class="form-container">
                <div class="form-content">
                    <div class="header">
                        <div class="arrow-left-icon">
                            <a href="${pageContext.request.contextPath}/segura/MenuCliente">
                                <img src="${pageContext.request.contextPath}/images/icons/arrow-left.png" alt="arrow" />
                            </a>
                        </div>
                        <div class="header-text">
                            <h2>Solicitação</h2>
                        </div>
                    </div>
                    <form action="${pageContext.request.contextPath}/RapinaHelpCli" method="get">
                        <input type="hidden" name="idUsuario" value="${sessionScope.idUser}">
                        <div class="textarea-field">
                            <article>
                                <p name="mensagem">
                                    Olá Rapina Master, preciso de ajuda, recebi uma cobrança que não a reconheço,
                                    por gentileza podem verificar o que houve? <br><br>
                                    A descrição da cobrança é referente <br><c:out value="${sessionScope.descTaxaPag}"/>, <br><br>
                                    a data de cobrança é: <c:out value="${sessionScope.dataCobrancaPag}"/> e o valor 
                                    é de: <c:out value="${sessionScope.valorCobrancaPag}"/>
                                
                                    Desde já agradeço,<br><br>
                                </p>
                                <input type="hidden" name="mensagem" value="Olá Rapina Master, preciso de ajuda, recebi uma cobrança que não a reconheço,por gentileza podem verificar o que houve?A descrição da cobrança é referente <c:out value="${sessionScope.descTaxaPag}"/>a data de cobrança é: <c:out value="${sessionScope.dataCobrancaPag}"/> e o valor é de: <c:out value="${sessionScope.valorCobrancaPag}"/>">
                            </article>
                        </div>
                        <div class="submit-block">
                            <input type="submit" name="submit-button" value="OK" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
