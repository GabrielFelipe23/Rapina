<%-- 
    Document   : TelaDoacao
    Created on : 15 de mai de 2021, 20:13:08
    Author     : gusta
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/doacoes.css">
        <title>Document</title>
    </head>
    <body>
        <div class="todo">
            <div class="bloco">

                <div class="link">
                    <a href="${pageContext.request.contextPath}/segura/MenuCliente">
                        <svg width="14" height="21" viewBox="0 0 14 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.6771 20.9999C11.3782 21.0007 11.083 20.9512 10.813 20.8552C10.5429 20.7591 10.3051 20.619 10.1168 20.4449L0.455058 11.4458C0.160841 11.1774 0 10.8408 0 10.4934C0 10.146 0.160841 9.80935 0.455058 9.54098L10.4569 0.541827C10.7964 0.235531 11.2843 0.0429128 11.8133 0.00634665C12.3422 -0.0302195 12.8689 0.0922618 13.2774 0.346846C13.6859 0.601429 13.9428 0.967262 13.9915 1.36386C14.0403 1.76047 13.877 2.15535 13.5374 2.46165L4.5958 10.5009L13.2374 18.5401C13.482 18.7603 13.6374 19.0284 13.6851 19.3127C13.7329 19.597 13.671 19.8856 13.5069 20.1443C13.3428 20.4031 13.0832 20.6212 12.7589 20.7728C12.4346 20.9244 12.0592 21.0032 11.6771 20.9999Z" fill="#4361EE"/>
                        </svg>
                        <p>Fazer uma doação</p>
                    </a>
                </div>
                <form action="${pageContext.request.contextPath}/ControlaDoacao" method="get" >
                    <div class="select">
                        <select name="nomeEsta">
                            <option>Selecione a Instituição</option>
                            <c:forEach var="fav" items="${sessionScope.listaNomes}">
                                <option>
                                    <c:out value="${fav.nome_estabelecimento}"/>
                                </option>
                            </c:forEach>
                        </select>
                        <div class="select__arrow"></div>
                    </div>


                    <div class="svg">
                        <svg width="10" height="18" viewBox="0 0 10 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M5.43914 7.92C3.81914 7.38 2.27914 6.94 2.27914 5.63C2.27914 4.4 3.61914 3.96 4.44914 3.96C5.41914 3.96 6.01914 4.42 6.35914 4.86C6.64914 5.24 7.14914 5.39 7.58914 5.21C8.20914 4.95 8.41914 4.17 7.99914 3.63C7.51914 2.99 6.69914 2.3 5.37914 2.08V1C5.37914 0.45 4.92914 0 4.37914 0C3.82914 0 3.37914 0.45 3.37914 1V2.11C2.00914 2.38 0.189142 3.5 0.189142 5.67C0.189142 8.24 2.49914 9.03 4.20914 9.64C6.09914 10.31 6.93914 10.93 6.93914 12.08C6.93914 13.44 5.68914 14 4.56914 14C3.15914 14 2.39914 13.07 2.00914 12.34C1.76914 11.87 1.18914 11.69 0.709142 11.89L0.649143 11.92C0.0891427 12.15 -0.160858 12.8 0.109142 13.34C0.599142 14.29 1.53914 15.45 3.37914 15.87V17C3.37914 17.55 3.82914 18 4.37914 18C4.92914 18 5.37914 17.55 5.37914 17V15.92C5.43914 15.91 9.04914 15.51 9.04914 12.05C9.06914 9.82 7.59914 8.67 5.43914 7.92Z" fill="black" fill-opacity="0.6"/>
                        </svg>

                    </div>                         
                    <input class="text" type="text" id="valDoa" name="valDoa" placeholder="Valor da doação">

                    <div class="select">
                        <select name="idCartao">
                            <option>Selecione o Cartão</option>
                            <c:forEach var="card" items="${sessionScope.listaCartao}">
                                <option><c:out value="${card.id_card}" /></option>
                            </c:forEach>
                        </select>
                        <div class="select__arrow"></div>
                    </div>
                    
                    <div class="Continuar">
                        <button >
                            Continuar
                        </button>  
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>