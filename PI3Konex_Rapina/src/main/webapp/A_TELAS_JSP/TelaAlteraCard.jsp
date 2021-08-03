<%-- 
    TELA REFERENTE AO MARCO II
    
    Document   : TelaAlteraCard
    Created on : 30 de abr de 2021, 18:18:27
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cartão</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">

        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/cardUser.css">
        <style>
            .erroInput{
                border: 2px solid red;
                border-radius: 5px;
            }
        </style>

    </head>
    <body>

        <div id="container-landing" style="margin-top: 250px;">
            <div class="form-container">
                <div class="form-block">
                    <section class="form-data">
                        <c:if test="${sessionScope.cli.tipo_user==2}">
                        <a href="${pageContext.request.contextPath}/segura/MenuCliente" style="text-decoration: none;" >Voltar ao Menu</a>
                        </c:if>
                        <c:if test="${sessionScope.esta.tipo_user==3}">
                        <a href="${pageContext.request.contextPath}/segura/MenuEsta" style="text-decoration: none;" >Voltar ao Menu</a>
                        </c:if>
                        <form action="${pageContext.request.contextPath}/AlteraCartao" method="get">
                            <div class="input-field ${not empty erro ? 'erroInput' : ''}">
                                <div class="card">
                                    <img src="${pageContext.request.contextPath}/images/icons/card-number.png" alt="cardnumber-icon" />
                                </div>

                                <!--INPUT NUM CARTAO-->
                                <input type="text" name="numCartao" placeholder="Digite o número do cartão" value="${cartaoAtt.num_cartao}" maxlength="16" />
                            </div>
                            <div class="input-field ${not empty erro ? 'erroInput' : ''}">
                                <div class="cvv">
                                    <img src="${pageContext.request.contextPath}/images/icons/cvv-number.png" alt="cvv-icon" />
                                </div>
                                <!--INPUT CVV-->
                                <input type="text" name="cvv" placeholder="CVV" maxlength="3" minlength="3" />

                                <!--INPUT VALIDADE-->
                                <input type="text" name="val" placeholder="Validade" class="data" maxlength="7" minlength="7" />
                                <div class="data-icon">
                                    <svg width="19" height="19" viewBox="0 0 19 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <g opacity="0.15">
                                    <path d="M14.0861 2.63586H4.27152C2.46471 2.63586 1 4.10057 1 5.90739V14.0862C1 15.893 2.46471 17.3577 4.27152 17.3577H14.0861C15.8929 17.3577 17.3576 15.893 17.3576 14.0862V5.90739C17.3576 4.10057 15.8929 2.63586 14.0861 2.63586Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                    <path d="M5.90723 1V4.27152" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                    <path d="M12.4502 1V4.27152" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                    <path d="M1 7.54309H17.3576" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                    </g>
                                    </svg>
                                </div>
                            </div>
                            <div class="input-field ${not empty erro ? 'erroInput' : ''}">
                                <div class="user">
                                    <img src="${pageContext.request.contextPath}/images/icons/user-icon.png" alt="user-icon" />
                                </div>

                                <!--TITULAR-->
                                <input type="text" name="titular" placeholder="Nome do titular do cartão" value="${cartaoAtt.titular}"/>
                            </div>
                            <div class="submit-block">
                                <input type="submit" name="submit-block" value="Salvar cartão" />
                            </div>
                        </form>
                    </section>
                </div>
                <section class="card-user">
                    <div class="circle1"></div>
                    <div class="circle2"></div>
                    <div class="circle3"></div>

                    <div class="data-user">
                        <div class="box"></div>
                        <div class="zip-code">
                            <p>0000  0000  0000  0000</p>
                        </div>
                        <div class="username">
                            <p>Nome escrito</p>
                            <section>
                                <h5>VALID DATES</h5>
                                <p>XX/XX</p>
                            </section>
                            <section>
                                <h5>CVV</h5>
                                <p>XXX</p>
                            </section>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>