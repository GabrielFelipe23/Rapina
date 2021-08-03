<%-- 
    Document   : Cancelamento
    Created on : 28 de mai de 2021, 14:36:16
    Author     : Gabriel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cancelar reserva</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/cancelReserv.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="only-screen">
            <div class="outline-color">
                <div class="query-select">
                    <h3>Deseja realmente cancelar a reserva de Nº <c:out value="${sessionScope.numReserva}"/>?</h3>
                    <p>A taxa de cancelamento desse restaurante é de <c:out value="${sessionScope.valorTaxa}"/></p>
                </div>
                <footer class="option">
                    <form action="${pageContext.request.contextPath}/CancelarReserva" method="get">
                        <input type="hidden" name="lineIdReserva" value="${sessionScope.numReserva}">
                        <button type="submit" name="btn" value="Voltar">Voltar &nbsp;</button>
                        <button type="submit" name="btn" value="Confirmar">Confirmar</button>
                    </form>
                </footer>
            </div>
        </div>
    </body>
</html>
