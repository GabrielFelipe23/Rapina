<%-- 
    Document   : TelaRapinaPlanos
    Created on : 3 de mai de 2021, 22:49:19
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/rapinaPlanos.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
       
        <title>Planos Rapina- Voe alto</title>
    </head>
    <body>
        <div class="topo">
            <div id="container-landing">
                <section class="menu-bar">
                        <div>
                            <a href="${pageContext.request.contextPath}/segura/MenuEsta"><img src="${pageContext.request.contextPath}/images/icons/Logotipo-Branco 1.png" alt="logo-image" class="logo-icon" /></a>
                        </div>
                        <div>
            
                            <div class="dropdown">
                                <button class="dropbtn"><svg width="40" height="31" viewBox="0 0 40 31" fill="none" xmlns="http://www.w3.org/2000/svg">
                                  <rect width="40" height="3" fill="white"/>
                                  <rect y="28" width="40" height="3" fill="white"/>
                                  <rect y="14" width="40" height="3" fill="white"/>
                              </svg> </button>
                                <div class="dropdown-content">
                                    <a href="${pageContext.request.contextPath}/Pre_Cadastro">Voe Com a Rapina</a>
                                    <a href="${pageContext.request.contextPath}/LogEmail">Login</a>
                                    <a href="${pageContext.request.contextPath}/TelaDoacao">Doações</a>
                                    <a href="${pageContext.request.contextPath}/Home">Site Institucional</a>
                                </div>
                              </div>
                        </div>
                </section>
            </div>

        <div class="txtRap">
        <p>Rapina planos</p>
        <h1>Voe mais alto com a Rapina Líder</h1>
        </div>
    </div>
    <div class="Planos">
        <form action="${pageContext.request.contextPath}/PlanosRapina">
        <div class="Serrana">
            <img src="${pageContext.request.contextPath}/images/SERRANA 1.png" alt="">
            <h1>Serrana</h1>
            <div class="itensPlano">
                <p>Visibilidade Reduzida</p>
                <p>até 20 reservas por dia</p>
            </div>
            <div class="valor">
                <p>R$</p>
                <h1>19,90</h1>
                <p>/mês</p>
            </div>
            <button type="submit" name="button" value="Serrana">Contratar</button>
        </div>
        <div class="Rarpy">
            <img src="${pageContext.request.contextPath}/images/RARPY 1.png" alt="">
            <h1>Rarpy</h1>
            <div class="itensPlano">
                <p>Alta visibilidade</p>
                <p>Reservas ilimitadas</p>
                <p>Liberação favoritos</p>
                <p>Doações monetárias</p>
                <p>Liberação de Contratação</p>

            </div>
            <div class="valor">
                <p>R$</p>
                <h1>49,90</h1>
                <p>/mês</p>
            </div>
            <button type="submit" name="button" value="Rarpy">Contratar</button>
        </div>
        <div class="Açor">
            <img src="${pageContext.request.contextPath}/images/AÇOR 1.png" alt="">
            <h1>Açor</h1>
            <div class="itensPlano">   
                <p>Média visibilidade</p>
                <p>até 50 reservas por dia</p>
                <p>Liberação de favoritos</p>
            </div>
            <div class="valor">
                <p>R$</p>
                <h1>29,90</h1>
                <p>/mês</p>
            </div>
            <button type="submit" name="button" value="Acor">Contratar</button>
        </div>
        </form>
    </div>
    <div class="retangulo">
        <h1>Com o plano Rarpy você vai até o além</h1>
        <h1>#voenoespaço</h1>
    </div>

        <div class="subRodape" style="border: none;">
            <div class="grupo">
                <div class="txt1">
                    <p>©Copyright 2021 - todos os direitos reservados Papina</p>
                </div>
                <div class="txt2">
                    <p>Desenvolvido por konex</p>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
