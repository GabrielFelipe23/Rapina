<%-- 
    Document   : PoliticaPrivacidade
    Created on : 23 de mai de 2021, 13:13:41
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
    To change this license header, choose License Headers in Project Properties.
    To change this template file, choose Tools | Templates
    and open the template in the editor.
-->
<html>
    <head>
        <title>Declaração de privacidade</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/politicaPrivacidade.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">

    </head>
    <body>
        <div id="container-landing">
            <section class="menu-bar">
                <div>
                    <a href="${pageContext.request.contextPath}/Home"><img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="logo-image" class="logo-icon" /></a>
                </div>
                <div>
            
                    <div class="dropdown">
                        <button class="dropbtn">
                            <svg width="40" height="31" viewBox="0 0 40 31" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <rect width="40" height="3" fill="#4361EE"/>
                                <rect y="28" width="40" height="3" fill="#4361EE"/>
                                <rect y="14" width="40" height="3" fill="#4361EE"/>
                            </svg> 
                        </button>
                        <div class="dropdown-content">
                            <a href="${pageContext.request.contextPath}/Pre_Cadastro">Voe Com a Rapina</a>
                            <a href="${pageContext.request.contextPath}/LogEmail">Login</a>
                            <a href="${pageContext.request.contextPath}/TelaDoacao">Doações</a>
                            <a href="${pageContext.request.contextPath}/Home">Site Institucional</a>
                        </div>
                      </div>
                </div>
            </section>

            <div class="container-content-privacy">
                <main class="privacy-container">
                    <h1>Declaração de privacidade</h1>
                </main>

                <article>
                    <h3>1. Serviços oferecidos</h3>
                    <p>
                        Os dados são seus. Respeitamos a sua privacidade e tratamos os seus dados como parte 
                        da nossa missão de proporcionar um serviço cada vez melhor. Essa Declaração de Privacidade
                        descreve como obtemos, armazenamos, utilizamos e compartilhamos suas informações.
                    </p>
                    <p>
                        A proteção dos seus dados e da sua privacidade sao muito importantes para a Rapina. Recomendamos que você
                        conheça as nossas práticas como um todo, mas aqui estão alguns pontos importantes para que você entenda
                        como seus dados são tratados no Rapina:
                    </p>

                    <p>- Os dados que você cadastra em nosss plataformas são tratadas de forma segura e limitamos o tratamento para suas devidsa finalidades.</p>
                    <p>- Você poderá tirar suas dúvidas e solicitar informações a qualquer momento através da aba "Ajuda" em nosa plataforma.</p>
                </article>
            </div>
        </div>
        <div class="subRodape">
            <div class="grupo">
                <div class="txt1">
                    <p>©Copyright 2021 - todos os direitos reservados Papina</p>
                </div>
                <div class="txt2">
                    <p>Desenvolvido por konex</p>
                </div>
            </div>
        </div>
    </body>
</html>

