<%-- 
    Document   : TelaValidaReserva
    Created on : 18 de mai de 2021, 17:23:28
    Author     : gusta
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/valRes.css">
    <title>Document</title>
    <style>
        .erroInput{
            color:red;
        }
    </style>
</head>
<body style="background-color: #E5E5E5;">
    <div class="todo">
        <div class="link">
            <a href="${pageContext.request.contextPath}/segura/MenuEsta">
                <svg width="20" height="31" viewBox="0 0 20 31" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M16.6815 30.9998C16.2546 31.001 15.8328 30.928 15.4471 30.7862C15.0614 30.6444 14.7215 30.4375 14.4526 30.1806L0.650083 16.8962C0.229774 16.5 0 16.0031 0 15.4902C0 14.9774 0.229774 14.4805 0.650083 14.0843L14.9384 0.79984C15.4234 0.347689 16.1204 0.0633475 16.8761 0.00936887C17.6317 -0.0446097 18.3841 0.136196 18.9677 0.51201C19.5512 0.887824 19.9182 1.42786 19.9879 2.01332C20.0576 2.59878 19.8242 3.18171 19.3392 3.63386L6.56543 15.5013L18.9105 27.3688C19.26 27.6938 19.4819 28.0895 19.5502 28.5092C19.6184 28.9289 19.5301 29.3549 19.2956 29.7369C19.0611 30.1189 18.6903 30.4408 18.227 30.6646C17.7638 30.8885 17.2274 31.0048 16.6815 30.9998Z" fill="#4361EE"/>
                </svg>
            </a>  
                <p>Voltar para o menu principal</p>

        </div>
        <div class="valiRes">
            <form action="${pageContext.request.contextPath}/ValidaReserva" method="get">
                <input type="text" placeholder="Digite o código da reserva" name="numReserva">
                <button name="btn" value="confirmaReserva" >Validar reserva</button>
                <button name="btn" value="registraSaida" >Registrar Saida</button>
            </form>
            </div> 
            <c:forEach var="a" items="${lista}">
        <div class="cofRes">
            <h3>Confirmação da reserva</h3>
        </div>
        <div class="infos">
            <p>Cliente: <c:out value="${a.nome_reservado}"></c:out></p>
            <p>Acompanhantes: <c:out value="${a.qtd_acompanhantes}"></c:out> pessoas.</p>
            <div class="time">
                <p>Data: <c:out value="${a.data_reservada}"></c:out></p>
                <p>Horário: <c:out value="${a.horario_reservado}"></c:out></p>
            </div>
        </div>
        <div class="status">
            <p>Status da Reserva: <c:out value="${a.reserva_status}"></c:out></p>
        <br>
           
        </div>
        </c:forEach>
         <p id="valSus" class="${not empty erroValida ? 'erroInput' : '' }"></p>
         <c:if test="${not empty erroValida}">
             <span class="erroInput"><c:out value="${erroValida}"></c:out></span>
         </c:if>
    </div>
</body>
</html>
