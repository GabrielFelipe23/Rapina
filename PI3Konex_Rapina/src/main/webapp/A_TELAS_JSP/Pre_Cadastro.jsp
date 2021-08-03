<%-- 
    TELA REFERENTE AO MARCO II

    Document   : Pre-Cadrasto
    Created on : 27 de abr de 2021, 22:28:53
    Author     : Gabriel
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Loja parceira</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">  
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/partnerStore.css">

        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div id="container-landing">
            <section class="menu-bar">
                <div>
                    <img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="logo-image" class="logo-icon" />
                </div>
                <div>
                    <ul>
                        <div class="bar"></div>
                        <div class="bar"></div>
                        <div class="bar"></div>
                    </ul>
                </div>
            </section>

            <div class="grid-container">
                <div class="grid-layout-partner">
                    <article>
                        <div class="welcome">
                            <h1>Bem vindo(a),</h1>
                            <p>
                                Você está prestes a se tornar um rapinante.
                                Escolha qual tipo que você é.
                            </p>
                        </div>
                        <div class="becomer-option">
                            <form action="${pageContext.request.contextPath}/IniciaCadastro">
                                <!--PEGAR OS INPUTS DA SESSÃO-->
                                <input type="hidden" name="nomeEstb" value="${sessionScope.nomeEst}">
                                <input type="hidden" name="idEstab" value="${sessionScope.idEst}">
                                <input type="hidden" name="dataReserva" value="${sessionScope.dataRes}">
                                <input type="hidden" name="horaReserva" value="${sessionScope.horaRes}">
                                <input type="hidden" name="Acomp" value="${sessionScope.qtdAcom}">
                                
                                <div class="button-becomer-partner">
                                    <span>
                                        <img src="${pageContext.request.contextPath}/images/icons/house.png" alt="icon-house" />
                                    </span>
                                    <button type="submit" name="button" value="Cadastro Estabelecimento">
                                        <h3>Loja parceira</h3>
                                        <p>Eu quero fazer parte do grupo de lojas</p>
                                    </button>
                                </div>
                                <div class="button-becomer-rap">
                                    <span>
                                        <img src="${pageContext.request.contextPath}/images/icons/bird.png" alt="icon-house" />
                                    </span>
                                    <button type="submit" name="button" value="Cadastro Cliente">
                                        <h3>Rapinista</h3>
                                        <p>Eu quero fazer reservas e favoritar restauraurantes.</p>
                                    </button>
                                </div>
                            </form>
                        </div>

                        <section class="questions-box">
                            <footer>
                                <p>
                                    Tem dúvidas sobre a rapina?
                                    <a href="${pageContext.request.contextPath}/CriaTelaDuvidas">
                                        <span>Clique aqui</span>
                                    </a>
                                </p>
                            </footer>
                        </section>
                    </article>
                </div>
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