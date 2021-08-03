<%-- 
    TELA REFERENTE AO MARCO II
    Document   : TelaInicial
    Created on : 2 de mai de 2021, 16:28:40
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bem vindo(a) a Rapina</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/TelaIndex.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="container-landing">
            <section class="menu-bar">
                <div>
                    <img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="logo-image" class="logo-icon" />
                </div>
            </section>

            <div class="main-container">
                <h1>
                    Para você fazer a sua reserva é necessário ser cadastrado
                </h1>
                <p class="first-paragraph">
                    Cliquem em cadastrar e em instantes você poderá reservar.
                </p>
                <br>
                <footer>
                    <form action="${pageContext.request.contextPath}/PosClickReserva" method="get">
                        <!--PEGAR OS INPUTS DA SESSÃO-->
                        <input type="hidden" name="nomeEstb" value="${sessionScope.nomeEst}">
                        <input type="hidden" name="idEstab" value="${sessionScope.idEst}">
                        <input type="hidden" name="dataReserva" value="${sessionScope.dataRes}">
                        <input type="hidden" name="horaReserva" value="${sessionScope.horaRes}">
                        <input type="hidden" name="Acomp" value="${sessionScope.qtdAcom}">
                        <button type="submit" name="btn" value="cadastrar" style="margin-left: 0px ">Cadastrar</button>
                    </form>
                </footer>
            </div>
        </div>
    </body>
</html>
