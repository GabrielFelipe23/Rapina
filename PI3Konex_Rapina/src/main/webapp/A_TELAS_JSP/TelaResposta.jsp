<%-- 
    TELA REFERENTE AO MARCO II

    Document   : TelaResposta
    Created on : 5 de mai de 2021, 21:48:03
    Author     : gusta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/digitaEmail.css">
        <title>Document</title>
    </head>
    <body>
        <div class="todo">
            <div class="bloco">
                <form action="${pageContext.request.contextPath}/ControlaResposta" method="get">
                    <div class="link">
                        <a href="${pageContext.request.contextPath}/segura/MenuADM"><svg width="13" height="25" viewBox="0 0 13 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path opacity="1" d="M10.4231 24.9999C10.1564 25.0008 9.89279 24.9419 9.65177 24.8276C9.41076 24.7133 9.19843 24.5464 9.03038 24.3392L0.40619 13.626C0.143569 13.3065 0 12.9057 0 12.4921C0 12.0786 0.143569 11.6778 0.40619 11.3583L9.33392 0.645033C9.637 0.280394 10.0725 0.0510867 10.5447 0.00755554C11.0168 -0.0359756 11.4869 0.109836 11.8515 0.412911C12.2162 0.715987 12.4455 1.1515 12.489 1.62365C12.5325 2.09579 12.3867 2.56589 12.0837 2.93053L4.10227 12.5011L11.8158 22.0716C12.0342 22.3337 12.1729 22.6528 12.2155 22.9913C12.2581 23.3297 12.2029 23.6733 12.0564 23.9814C11.9099 24.2894 11.6782 24.5491 11.3888 24.7296C11.0993 24.9101 10.7642 25.0039 10.4231 24.9999Z" fill="#4361ee"/>
                            </svg>
                        </a>
                    </div>

                    <h1 id="preen">Preencha os campos abaixo</h1>
                    <input class="inputID" type="text" name="tipoDestinatario" placeholder="Tipo de Destinatário" required>

                    <input class="inputD" type="text" name="idUser" placeholder="Código do destinatário" required>

                    <textarea class="InputM" name="assunto" placeholder="Escreva a mensagem" required rows="5"></textarea>

                    <button id="valOut"  value="Submit">Enviar</button>
                </form>
            </div>
        </div>
    </body>
</html>
