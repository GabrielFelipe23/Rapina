<%-- 
    Document   : VerTicket
    Created on : 9 de jun de 2021, 17:18:04
    Author     : gusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <p>Sua Reserva</p>
                        <h2>Veja as informações</h2>
                            <br>
                            <p>Data Reservada:<c:out value="${sessionScope.dataRes}"/>   Horário Reservado:<c:out value="${sessionScope.horaRes}"/></p>
                            <br>

                            <p>Nome do restaurante: <c:out value="${sessionScope.estaRes}"/></p>
                            <p style="margin-top: 5px;">Endereço: <c:out value="${sessionScope.endRes}"/>,Nº <c:out value="${sessionScope.numRes}"/></p>
                    </div>

                    <div class="code-image">
                        <img src="${pageContext.request.contextPath}/images/qr-code.png" alt="code-image" />
                        <p>cod.reserva:0000<c:out value="${sessionScope.codRes}"/></p>
                    </div>
                </div>
            </main>

            <footer>
                <button type="submit" >
                    <a href="${pageContext.request.contextPath}/segura/MenuCliente" style="text-decoration: none; color: white;">
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
