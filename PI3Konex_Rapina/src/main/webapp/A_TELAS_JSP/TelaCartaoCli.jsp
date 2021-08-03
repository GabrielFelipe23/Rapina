<%-- 
    TELA REFERENTE AO MARCO II

    Document   : TelaCartaoCli
    Created on : 27 de abr de 2021, 23:30:17
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/cartaoRegistro.css"/>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <title>Registrar Cartão</title>

        <style>
            .erroInput{
                width: auto;
                border: 1px solid red;
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
        </div>
        <div class="girl">
            <div class="espiral">
                <div class="linha">
                    <div class="bloco">
                        <form action="${pageContext.request.contextPath}/ControlaCartao" method="post">

                            <h1>Registrar cartão</h1>
                            <p>Para o cadastro ser concluido é necessário que tenha 1 cartão cadastrado.</p>

                            <div class="text526 ${not empty erro ? 'erroInput' : ''}" >
                                <div class="svg">
                                    <svg width="23" height="18" viewBox="0 0 23 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M20.1245 1.4375C20.5058 1.4375 20.8714 1.58895 21.141 1.85853C21.4106 2.12812 21.562 2.49375 21.562 2.875V14.375C21.562 14.7562 21.4106 15.1219 21.141 15.3915C20.8714 15.661 20.5058 15.8125 20.1245 15.8125H2.87451C2.49326 15.8125 2.12763 15.661 1.85805 15.3915C1.58846 15.1219 1.43701 14.7562 1.43701 14.375V2.875C1.43701 2.49375 1.58846 2.12812 1.85805 1.85853C2.12763 1.58895 2.49326 1.4375 2.87451 1.4375H20.1245ZM2.87451 0C2.11201 0 1.38075 0.302901 0.84158 0.842068C0.302413 1.38123 -0.000488281 2.1125 -0.000488281 2.875L-0.000488281 14.375C-0.000488281 15.1375 0.302413 15.8688 0.84158 16.4079C1.38075 16.9471 2.11201 17.25 2.87451 17.25H20.1245C20.887 17.25 21.6183 16.9471 22.1574 16.4079C22.6966 15.8688 22.9995 15.1375 22.9995 14.375V2.875C22.9995 2.1125 22.6966 1.38123 22.1574 0.842068C21.6183 0.302901 20.887 0 20.1245 0H2.87451Z" fill="black" fill-opacity="0.3"/>
                                    <path d="M2.87451 5.03125C2.87451 4.84063 2.95024 4.65781 3.08503 4.52302C3.21982 4.38823 3.40264 4.3125 3.59326 4.3125H6.46826C6.65889 4.3125 6.8417 4.38823 6.97649 4.52302C7.11129 4.65781 7.18701 4.84063 7.18701 5.03125V6.46875C7.18701 6.65937 7.11129 6.84219 6.97649 6.97698C6.8417 7.11177 6.65889 7.1875 6.46826 7.1875H3.59326C3.40264 7.1875 3.21982 7.11177 3.08503 6.97698C2.95024 6.84219 2.87451 6.65937 2.87451 6.46875V5.03125ZM2.87451 9.34375C2.87451 9.15313 2.95024 8.97031 3.08503 8.83552C3.21982 8.70072 3.40264 8.625 3.59326 8.625H10.7808C10.9714 8.625 11.1542 8.70072 11.289 8.83552C11.4238 8.97031 11.4995 9.15313 11.4995 9.34375C11.4995 9.53437 11.4238 9.71719 11.289 9.85198C11.1542 9.98678 10.9714 10.0625 10.7808 10.0625H3.59326C3.40264 10.0625 3.21982 9.98678 3.08503 9.85198C2.95024 9.71719 2.87451 9.53437 2.87451 9.34375ZM2.87451 12.2188C2.87451 12.0281 2.95024 11.8453 3.08503 11.7105C3.21982 11.5757 3.40264 11.5 3.59326 11.5H5.03076C5.22139 11.5 5.4042 11.5757 5.53899 11.7105C5.67379 11.8453 5.74951 12.0281 5.74951 12.2188C5.74951 12.4094 5.67379 12.5922 5.53899 12.727C5.4042 12.8618 5.22139 12.9375 5.03076 12.9375H3.59326C3.40264 12.9375 3.21982 12.8618 3.08503 12.727C2.95024 12.5922 2.87451 12.4094 2.87451 12.2188ZM7.18701 12.2188C7.18701 12.0281 7.26274 11.8453 7.39753 11.7105C7.53232 11.5757 7.71514 11.5 7.90576 11.5H9.34326C9.53389 11.5 9.7167 11.5757 9.85149 11.7105C9.98629 11.8453 10.062 12.0281 10.062 12.2188C10.062 12.4094 9.98629 12.5922 9.85149 12.727C9.7167 12.8618 9.53389 12.9375 9.34326 12.9375H7.90576C7.71514 12.9375 7.53232 12.8618 7.39753 12.727C7.26274 12.5922 7.18701 12.4094 7.18701 12.2188ZM11.4995 12.2188C11.4995 12.0281 11.5752 11.8453 11.71 11.7105C11.8448 11.5757 12.0276 11.5 12.2183 11.5H13.6558C13.8464 11.5 14.0292 11.5757 14.164 11.7105C14.2988 11.8453 14.3745 12.0281 14.3745 12.2188C14.3745 12.4094 14.2988 12.5922 14.164 12.727C14.0292 12.8618 13.8464 12.9375 13.6558 12.9375H12.2183C12.0276 12.9375 11.8448 12.8618 11.71 12.727C11.5752 12.5922 11.4995 12.4094 11.4995 12.2188ZM15.812 12.2188C15.812 12.0281 15.8877 11.8453 16.0225 11.7105C16.1573 11.5757 16.3401 11.5 16.5308 11.5H17.9683C18.1589 11.5 18.3417 11.5757 18.4765 11.7105C18.6113 11.8453 18.687 12.0281 18.687 12.2188C18.687 12.4094 18.6113 12.5922 18.4765 12.727C18.3417 12.8618 18.1589 12.9375 17.9683 12.9375H16.5308C16.3401 12.9375 16.1573 12.8618 16.0225 12.727C15.8877 12.5922 15.812 12.4094 15.812 12.2188Z" fill="black" fill-opacity="0.3"/>
                                    </svg>                    
                                </div>  
                                <input type="text" placeholder="Digite o número do cartão" name="numCartao" minlength="16" maxlength="19">
                            </div>

                            <div class="text279 ${not empty erro ? 'erroInput' : ''}">
                                <div class="svg">
                                    <svg width="23" height="18" viewBox="0 0 23 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M20.1245 1.4375C20.5058 1.4375 20.8714 1.58895 21.141 1.85853C21.4106 2.12812 21.562 2.49375 21.562 2.875V14.375C21.562 14.7562 21.4106 15.1219 21.141 15.3915C20.8714 15.661 20.5058 15.8125 20.1245 15.8125H2.87451C2.49326 15.8125 2.12763 15.661 1.85805 15.3915C1.58846 15.1219 1.43701 14.7562 1.43701 14.375V2.875C1.43701 2.49375 1.58846 2.12812 1.85805 1.85853C2.12763 1.58895 2.49326 1.4375 2.87451 1.4375H20.1245ZM2.87451 0C2.11201 0 1.38075 0.302901 0.84158 0.842068C0.302413 1.38123 -0.000488281 2.1125 -0.000488281 2.875L-0.000488281 14.375C-0.000488281 15.1375 0.302413 15.8688 0.84158 16.4079C1.38075 16.9471 2.11201 17.25 2.87451 17.25H20.1245C20.887 17.25 21.6183 16.9471 22.1574 16.4079C22.6966 15.8688 22.9995 15.1375 22.9995 14.375V2.875C22.9995 2.1125 22.6966 1.38123 22.1574 0.842068C21.6183 0.302901 20.887 0 20.1245 0H2.87451Z" fill="black" fill-opacity="0.3"/>
                                    <path d="M18.6245 8.90625C18.6245 8.71563 18.5488 8.53281 18.414 8.39802C18.2792 8.26322 18.0964 8.1875 17.9058 8.1875H10.7183C10.5276 8.1875 10.3448 8.26322 10.21 8.39802C10.0752 8.53281 9.99951 8.71563 9.99951 8.90625C9.99951 9.09687 10.0752 9.27969 10.21 9.41448C10.3448 9.54928 10.5276 9.625 10.7183 9.625H17.9058C18.0964 9.625 18.2792 9.54928 18.414 9.41448C18.5488 9.27969 18.6245 9.09687 18.6245 8.90625ZM18.6245 11.7812C18.6245 11.5906 18.5488 11.4078 18.414 11.273C18.2792 11.1382 18.0964 11.0625 17.9058 11.0625H16.4683C16.2776 11.0625 16.0948 11.1382 15.96 11.273C15.8252 11.4078 15.7495 11.5906 15.7495 11.7812C15.7495 11.9719 15.8252 12.1547 15.96 12.2895C16.0948 12.4243 16.2776 12.5 16.4683 12.5H17.9058C18.0964 12.5 18.2792 12.4243 18.414 12.2895C18.5488 12.1547 18.6245 11.9719 18.6245 11.7812Z" fill="black" fill-opacity="0.3"/>
                                    </svg>                    
                                </div>
                                <input type="text" placeholder="Código de segurança" name="cvv" maxlength="3" minlength="3">
                            </div>

                            <div class="val ${not empty erro ? 'erroInput' : ''}">
                                <input type="text" placeholder="Validade" name="val" value="${cartao.validade}" maxlength="7" minlength="7">
                            </div>
                            <div class="svgval">
                                <svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <g opacity="0.4">
                                <path d="M17 2.99976H5C2.79086 2.99976 1 4.79062 1 6.99976V16.9998C1 19.2089 2.79086 20.9998 5 20.9998H17C19.2091 20.9998 21 19.2089 21 16.9998V6.99976C21 4.79062 19.2091 2.99976 17 2.99976Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M7 0.999756V4.99976" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M15 0.999756V4.99976" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M1 8.99976H21" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                </g>
                                </svg>
                            </div>

                            <div class="text526 ${not empty erro ? 'erroInput' : ''}">
                                <div class="svg">
                                    <svg width="18" height="19" viewBox="0 0 18 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                                    <path opacity="0.4" d="M9 0C6.243 0 4 2.243 4 5C4 7.757 6.243 10 9 10C11.757 10 14 7.757 14 5C14 2.243 11.757 0 9 0ZM9 8C7.346 8 6 6.654 6 5C6 3.346 7.346 2 9 2C10.654 2 12 3.346 12 5C12 6.654 10.654 8 9 8ZM18 19V18C18 14.141 14.859 11 11 11H7C3.14 11 0 14.141 0 18V19H2V18C2 15.243 4.243 13 7 13H11C13.757 13 16 15.243 16 18V19H18Z" fill="black"/>
                                    </svg>
                                </div>
                                <input type="text" placeholder="Nome do titular do cartão" name="titular" value="${cartao.titular}">
                            </div>

                            <!--Puxando os hiddens do input-->
                            <input type="hidden" name="idEstab" value="${sessionScope.idEst}">
                            <input type="hidden" name="dataReserva" value="${sessionScope.dataRes}">
                            <input type="hidden" name="horaReserva" value="${sessionScope.horaRes}">
                            <input type="hidden" name="Acomp" value="${sessionScope.qtdAcom}">
                            
                            <button id="btn" type="Submit">Salvar cartão</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>