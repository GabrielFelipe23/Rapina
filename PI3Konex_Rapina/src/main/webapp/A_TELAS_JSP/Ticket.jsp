<%-- 
    Document   : Ticket
    Created on : 31 de mai de 2021, 13:18:51
    Author     : Gabriel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Verifique sua reserva</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/codReserv.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logo.jpeg">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="container-landing">

            <main class="main-container" style="margin-top:200px;">
                <div class="main-information">
                    <div class="code-reservation">
                        <p>Reserva realizada com sucesso</p>
                        <h2>Veja as informações</h2>
                        <br>
                        <p>Data Reservada:<c:out value="${sessionScope.dataRes}"/>   Horário Reservado:<c:out value="${sessionScope.horaRes}"/></p>
                        <br>
                        <c:forEach var="a" items="${sessionScope.dados}" >
                            <p>Nome do restaurante: <c:out value="${a.nome_estabelecimento}"/></p>
                            <p style="margin-top: 5px;">Endereço: <c:out value="${a.logadouro_estabelecimento}"/>,Nº <c:out value="${a.numero}"/></p>
                        </c:forEach>
                    </div>

                    <div class="code-image">
                        <img src="${pageContext.request.contextPath}/images/qr-code.png" alt="code-image" />
                        <p>cod.reserva:0000<c:out value="${sessionScope.codRes}"/></p>
                    </div>
                </div>
            </main>

            <footer>
                <button type="submit" >
                    <a href="${pageContext.request.contextPath}/LogEmail" style="text-decoration: none; color: white;">
                        <img src="${pageContext.request.contextPath}/images/icons/door-exit.png" alt="door-icon" />
                        <span>Sair</span>
                        <a/>
                </button>
            </footer>

            <section class="sub-footer">
                <footer>
                    <p>Apresente o QrCode para o funcionário do estabelecimento</p>
                </footer>
            </section>
        </div>
    </body>
</html>
