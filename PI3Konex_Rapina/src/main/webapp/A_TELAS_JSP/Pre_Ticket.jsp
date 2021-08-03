<%-- 
    Document   : Pre_Ticket
    Created on : 31 de mai de 2021, 12:24:58
    Author     : Gabriel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sair</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/exitModal.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body style="background-color: #E5E5E5;">
        <div id="only-screen">
            <div class="outline-color">
                <div class="query-select">
                    <h3>Deseja fazer a reserva?</h3>
                    <p>Data:<c:out value="${sessionScope.dataRes}"/> Horário:<c:out value="${sessionScope.horaRes}"/> Qtd. de Acompanhantes:<c:out value="${sessionScope.qtdAcom}"/></p>
                </div>
                <form action="${pageContext.request.contextPath}/ConfirmaReserva" method="get">
                    <input type="hidden" name="idEstab" value="${sessionScope.idEst}">
                    <input type="hidden" name="dataReserva" value="${sessionScope.dataRes}">
                    <input type="hidden" name="horaReserva" value="${sessionScope.horaRes}">
                    <input type="hidden" name="Acomp" value="${sessionScope.qtdAcom}">
                    
                    <footer class="option">
                        <button type="submit" name="btn" value="cancela">Cancelar</button>
                        <button type="submit" name="btn" value="reservar">Reservar</button>
                    </footer>
                </form>
            </div>
        </div>
    </body>
</html