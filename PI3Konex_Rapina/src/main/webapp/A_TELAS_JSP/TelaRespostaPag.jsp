<%-- 
    Document   : TelaRespostaPag
    Created on : 24 de mai de 2021, 19:21:46
    Author     : gusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Recado Estabelecimento</title>
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
                            <a href="${pageContext.request.contextPath}/segura/MenuADM">
                                <img src="${pageContext.request.contextPath}/images/icons/arrow-left.png" alt="arrow" />
                            </a>
                        </div>
                        <div class="header-text">
                            <h2>Recado</h2>
                        </div>
                    </div>
                    <form action="${pageContext.request.contextPath}/NotificaPagamento" method="get">
                        <div class="textarea-field">
                            <article>
                                <p>Caro, <c:out value="${sessionScope.dadosPag.nomeUser}"/>, consta em nosso sistema
                                    um atraso referente a sua fatura no valor de: <c:out value="${sessionScope.dadosPag.valor_total}"/>
                                    ,que se encontra vencida desde: <c:out value="${sessionScope.dadosPag.data_cobranca}"/>.
                                    Ficamos no Aguardo da Regularização desta pendencia.
                                    Atenciosamente Grato,
                                    Rapina.
                                </p>
                                <input type="hidden" name="mensagem" value="Caro, <c:out value="${sessionScope.dadosPag.nomeUser}"/>, consta em nosso sistema um atraso referente a sua fatura no valor de: <c:out value="${sessionScope.dadosPag.valor_total}"/> ,que se encontra vencida desde: <c:out value="${sessionScope.dadosPag.data_cobranca}"/>. Ficamos no Aguardo da Regularização desta pendencia. Atenciosamente Grato, Rapina."  >
                            </article>
                        </div>

                        <button name="btn" value="enviaNotiEsta">
                            Envia
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
