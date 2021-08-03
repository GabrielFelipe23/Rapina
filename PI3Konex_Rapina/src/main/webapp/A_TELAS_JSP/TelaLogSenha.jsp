<%-- 
    TELA REFERENTE AO MARCO II
    Document   : TelaLogSenha
    Created on : 29 de abr de 2021, 20:24:04
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Confirmar a senha</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/formPass.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="../images/icons/logotipo.png">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">

        <style>
            .erroInput{
                border: 1px solid red;
            }
        </style>
    </head>
    <body>
        <div id="container-landing">
            <div class="principle-page">
                <section class="menu-bar">
                    <div>
                        <img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="logo-image" class="logo-icon" />
                    </div>
                </section>

                <section class="image-saly">
                    <img src="${pageContext.request.contextPath}/images/saly.png" alt="image" />
                </section>
                <div class="form-container">
                    <h3>Confirmar login com a senha</h3>

                    <form action="${pageContext.request.contextPath}/LogSenha" method="get">
                        <!--Puxando os hiddens do input-->
                        <input type="hidden" name="idEstab" value="${sessionScope.idEst}">
                        <input type="hidden" name="dataReserva" value="${sessionScope.dataRes}">
                        <input type="hidden" name="horaReserva" value="${sessionScope.horaRes}">
                        <input type="hidden" name="Acomp" value="${sessionScope.qtdAcom}">
                        
                        <div class="input-field ${not empty erroSenha ? 'erroInput' : ''}">
                            <input type="password" name="senha" placeholder="Digite a senha" maxlength="28" minlength="1" />
                            <span>
                                <img src="${pageContext.request.contextPath}/images/icons/lock-pass.png" alt="password-icon" />
                            </span>
                            <div class="underline"></div>
                        </div>
                        <div class="submit-block">
                            <input type="submit" value="Entrar" />
                        </div>

                        <footer>
                            <p>
                                Não lembra a senha?
                                <a href="recPass.html">
                                    <strong>Clique aqui</strong>
                                </a>
                            </p>
                        </footer>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

