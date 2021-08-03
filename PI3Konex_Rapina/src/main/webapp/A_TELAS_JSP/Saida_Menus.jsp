<%-- 
    Document   : Saida_Menus
    Created on : 22 de mai de 2021, 17:49:33
    Author     : gusta
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sair</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/exitModal.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
    </head>
    <body style="background: url(AdmImagem.PNG);">
        <div id="only-screen">
            <div class="outline-color">
                <div class="query-select">
                    <h3>Deseja realmente sair?</h3>
                    <p>Caso não, clique em cancelar</p>
                </div>
                <form action="${pageContext.request.contextPath}/ExitSession" method="get">

                    <footer class="option">

                        <button type="submit" name="btn" value="cancela">Cancelar</button>
                        <button type="submit" name="btn" value="sair">Sair</button>

                    </footer>
                </form>
            </div>
        </div>
    </body>
</html>
