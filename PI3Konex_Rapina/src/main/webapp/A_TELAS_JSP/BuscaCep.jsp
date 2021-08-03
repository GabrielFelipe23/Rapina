<%-- 
    Document   : BuscaCep
    Created on : 29 de mai de 2021, 19:43:24
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Busca</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/modalBusca.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logo.jpeg">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
        
        <style>
            .erroInput{
                border: 1px solid red;
            }
        </style>
    </head>
    <body>
        <div id="modal-container">
            <div class="form-container">
                <div>
                    <img src="${pageContext.request.contextPath}/images/icons/arrow-upper.png" alt="icon" />
                </div>
                <h2>Onde você quer comer?</h2>
                <form action="${pageContext.request.contextPath}/BuscaCEP" method="get">
                    <div class="input-field">
                        <button type="button">
                            <img src="${pageContext.request.contextPath}/images/icons/search-zipcode.png" alt="search-icon" />
                        </button>
                        <input type="search" name="cepDigitado" placeholder="Buscar por CEP" maxlenght="11" minlength="8">
                        <div class="underline"></div>
                    </div>
                    <div class="submit-block">              
                        <input type="submit" name="button-submit" value="Confirmar" />
                    </div>
                </form>

                <footer class="alternative-class">
                    <section class="selection-acess">
                        <p>Você já tem algum lugar favorito?</p>
                        <p>Entre em sua conta e selecione</p>
                        <div style="width: 140px; margin-left: auto; margin-right: auto;">
                            <a href="${pageContext.request.contextPath}/LogEmail"><h4>Entrar ou&nbsp;</h4></a>
                            
                            <a href="${pageContext.request.contextPath}/Pre_Cadastro"><h4>cadastrar</h4></a>
                        </div>
                    </section>
                </footer>
            </div>
        </div>
    </body>
</html>