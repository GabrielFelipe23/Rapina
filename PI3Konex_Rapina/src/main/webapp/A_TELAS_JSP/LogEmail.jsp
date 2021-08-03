<!--
    TELA REFERENTE AO MARCO II
-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Entre com Email</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/formEmail.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="../images/icons/logotipo.png">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">

        <style>
            .erroInput{
                border: 2px solid red;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <div id="container-landing">
            <section class="menu-bar">
                <div>
                    <a href="${pageContext.request.contextPath}/Home"><img src="${pageContext.request.contextPath}/images/icons/logotipo.png" alt="logo-image" class="logo-icon" /></a>
                </div>
            </section>


            <div class="main-page">
                <div class="cloud">
                    <div class="hand">
                        <div class="lock">
                            <main class="form-container">
                                <h3>Login entrar com email</h3>
                                <form action="${pageContext.request.contextPath}/LoginEmail" method="get">
                                    <div  class="input-field ${not empty erroEmail ? 'erroInput' : ''}" >
                                        <input type="email" name="email" placeholder="Email" maxlength="30" value="${acessoAtt.email}"/>
                                        <span>
                                            <img src="${pageContext.request.contextPath}/images/icons/Vector-email.png" alt="email-icon" />
                                        </span>
                                        <div class="underline"></div>
                                    </div>
                                    <div class="submit-block">
                                        <input type="submit" value="Continuar" />
                                    </div>
                                </form>
                            </main>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</body>
</html>

