<%-- 
    Document   : ConfirmaMensagem
    Created on : 2 de jun de 2021, 16:58:53
    Author     : gusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Confirmação da mensagem</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/messageConfirm.css">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="container-landing">
            <div class="message-container">
                <div class="message-content">
                    <img src="${pageContext.request.contextPath}/images/icons/check.png" alt="check-icons" />
                    <section class="compose">
                        <h3>
                            A mensagem foi enviada com sucesso!
                        </h3>
                        <c:if test="${sessionScope.adm.tipo_user==1}">
                            <button name="btn"><a style="text-decoration: none;" href="${pageContext.request.contextPath}/segura/MenuADM">Voltar</a></button>
                        </c:if>
                        <c:if test="${sessionScope.cli.tipo_user==2}">
                            <button name="btn"><a style="text-decoration: none;" href="${pageContext.request.contextPath}/segura/MenuCliente">Voltar</a></button>
                        </c:if>
                        <c:if test="${sessionScope.esta.tipo_user==3}">
                            <button name="btn"><a style="text-decoration: none;" href="${pageContext.request.contextPath}/segura/MenuEsta">Voltar</a></button>
                        </c:if>
                    </section>
                </div>
            </div>
        </div>
    </body>
</html>

