<%-- 
    Document   : TelaPagamentoEsta
    Created on : 25 de mai de 2021, 18:23:14
    Author     : gusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <a href="${pageContext.request.contextPath}/MenuEsta">
                            <img src="${pageContext.request.contextPath}/images/icons/arrow-left.png" alt="arrow" />
                            </a>
                        </div>
                        <div class="header-text">
                            <h2>Recado</h2>
                        </div>
                    </div>
                    <form action="${pageContext.request.contextPath}/EnviaPerguntaEsta" method="get">
                        <div class="textarea-field">
                            <article>
                                <p>
                                    Caro,Rapina Master, consta em meu sistema um atraso referente a fatura 
                                    no valor de: <c:out value="${sessionScope.dadosPagMes.valor}"/>. <br><br>
                                    Este Pagamento ja foi Debitado, porque estou sendo cobrado?<br><br>
                                    Atenciosamente<br><br>
                                </p>
                                <input type="hidden" name="mensagem" value="Caro,Rapina Master, consta em meu sistema um atraso referente a fatura,no valor de: <c:out value="${sessionScope.dadosPagMes.valor}"/> Este Pagamento ja foi Debitado, porque estou sendo cobrado <c:out value="${sessionScope.dadosPagMes.nome}"/> Atenciosamente.">
                                    
                            </article>
                        </div>
                        <div class="submit-block">
                            <button name="btn" value="enviaNoti">
                                Envia
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
