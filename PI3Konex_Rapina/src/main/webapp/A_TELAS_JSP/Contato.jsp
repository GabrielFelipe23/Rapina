<%-- 
    Document   : Contato
    Created on : 23 de mai de 2021, 14:05:42
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Formulário</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/contato.css">
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

            <div class="background-image">
                <div class="page-container">
                    <h3>Fale conosco</h3>
                    <form action="${pageContext.request.contextPath}/ControlaDuvidas2" method="post">
                        <div class="input-block">
                            <input type="text" name="nome" maxlength="30" placeholder="Qual é o seu nome?" required />
                            <div class="underline"></div>
                        </div>
                        <div class="input-block">
                            <input type="text" name="email" maxlength="50" placeholder="Digite o seu email" required />
                            <div class="underline"></div>
                        </div>
                        <div class="input-block">
                            <textarea name="mensagem" id="block-text" placeholder="Como podemos te ajudar?" rows="10" cols="10" required></textarea>
                        </div>
                        <div class="submit-block">
                            <input type="submit" value="Enviar" />
                        </div>
                    </form>
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
        </div>
    </body>
</html>