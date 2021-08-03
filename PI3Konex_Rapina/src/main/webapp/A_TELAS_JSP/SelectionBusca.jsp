<%-- 
    Document   : SelectionBusca
    Created on : 29 de mai de 2021, 21:40:14
    Author     : Gabriel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">    
        <title> Estabelecimento <c:out value="${sessionScope.nomeEst}"/></title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/selecao.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        
        
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
        <div class="todo">
            <div class="link">
                <a href="${pageContext.request.contextPath}/BuscaPorCep">
                    <svg width="14" height="21" viewBox="0 0 14 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M11.6771 20.9999C11.3782 21.0007 11.083 20.9512 10.813 20.8552C10.5429 20.7591 10.3051 20.619 10.1168 20.4449L0.455058 11.4458C0.160841 11.1774 0 10.8408 0 10.4934C0 10.146 0.160841 9.80935 0.455058 9.54098L10.4569 0.541827C10.7964 0.235531 11.2843 0.0429128 11.8133 0.00634665C12.3422 -0.0302195 12.8689 0.0922618 13.2774 0.346846C13.6859 0.601429 13.9428 0.967262 13.9915 1.36386C14.0403 1.76047 13.877 2.15535 13.5374 2.46165L4.5958 10.5009L13.2374 18.5401C13.482 18.7603 13.6374 19.0284 13.6851 19.3127C13.7329 19.597 13.671 19.8856 13.5069 20.1443C13.3428 20.4031 13.0832 20.6212 12.7589 20.7728C12.4346 20.9244 12.0592 21.0032 11.6771 20.9999Z" fill="#4361EE"/>
                    </svg>                
                    <p>Voltar</p>
                </a>
            </div>

            <div class="img">
                <img src="${pageContext.request.contextPath}/images/patrick-tomasso-GXXYkSwndP4-unsplash 1.png" alt="">
            </div>
            <div class="imgtext">
                <div class="ocupacao">
                    <p>
                        <svg width="18" height="15" viewBox="0 0 18 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.7331 2.93333C11.7331 3.7113 11.4241 4.45741 10.874 5.00751C10.3239 5.55762 9.57776 5.86667 8.79979 5.86667C8.02182 5.86667 7.27572 5.55762 6.72561 5.00751C6.1755 4.45741 5.86646 3.7113 5.86646 2.93333C5.86646 2.15537 6.1755 1.40926 6.72561 0.859154C7.27572 0.309047 8.02182 0 8.79979 0C9.57776 0 10.3239 0.309047 10.874 0.859154C11.4241 1.40926 11.7331 2.15537 11.7331 2.93333Z" fill="#4EBAB5"/>
                        <path d="M16.622 4.88866C16.622 5.40731 16.416 5.90471 16.0493 6.27145C15.6825 6.63819 15.1851 6.84422 14.6665 6.84422C14.1478 6.84422 13.6504 6.63819 13.2837 6.27145C12.917 5.90471 12.7109 5.40731 12.7109 4.88866C12.7109 4.37002 12.917 3.87261 13.2837 3.50587C13.6504 3.13914 14.1478 2.93311 14.6665 2.93311C15.1851 2.93311 15.6825 3.13914 16.0493 3.50587C16.416 3.87261 16.622 4.37002 16.622 4.88866Z" fill="#4EBAB5"/>
                        <path d="M12.7111 11.7334C12.7111 10.6961 12.2991 9.70128 11.5656 8.9678C10.8321 8.23433 9.83732 7.82227 8.80003 7.82227C7.76274 7.82227 6.76793 8.23433 6.03445 8.9678C5.30098 9.70128 4.88892 10.6961 4.88892 11.7334V14.6667H12.7111V11.7334Z" fill="#4EBAB5"/>
                        <path d="M4.88865 4.88866C4.88865 5.40731 4.68262 5.90471 4.31588 6.27145C3.94914 6.63819 3.45174 6.84422 2.93309 6.84422C2.41445 6.84422 1.91705 6.63819 1.55031 6.27145C1.18357 5.90471 0.977539 5.40731 0.977539 4.88866C0.977539 4.37002 1.18357 3.87261 1.55031 3.50587C1.91705 3.13914 2.41445 2.93311 2.93309 2.93311C3.45174 2.93311 3.94914 3.13914 4.31588 3.50587C4.68262 3.87261 4.88865 4.37002 4.88865 4.88866Z" fill="#4EBAB5"/>
                        <path d="M14.6666 14.6668V11.7334C14.668 10.7393 14.4156 9.7613 13.9332 8.89202C14.3667 8.78109 14.8198 8.77063 15.258 8.86144C15.6961 8.95225 16.1078 9.14194 16.4615 9.41603C16.8151 9.69011 17.1016 10.0414 17.2989 10.443C17.4962 10.8446 17.5991 11.286 17.5999 11.7334V14.6668H14.6666Z" fill="#4EBAB5"/>
                        <path d="M3.66667 8.89197C3.18438 9.76126 2.93196 10.7393 2.93333 11.7334V14.6667H2.59815e-07V11.7334C-0.000188191 11.2856 0.102142 10.8437 0.299148 10.4416C0.496155 10.0395 0.782607 9.68782 1.13655 9.41354C1.4905 9.13925 1.90254 8.94964 2.3411 8.85923C2.77966 8.76883 3.2331 8.78003 3.66667 8.89197Z" fill="#4EBAB5"/>
                        </svg>

                        <c:out value="${sessionScope.lotacao}"/> de <c:out value="${sessionScope.capac}"/></p>
                </div>
                <div class="nota">
                    <p>
                        <svg width="16" height="15" viewBox="0 0 16 15" fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path d="M7.81395 0L9.5683 5.52786H15.2455L10.6525 8.94427L12.4069 14.4721L7.81395 11.0557L3.22103 14.4721L4.97537 8.94427L0.382442 5.52786H6.05961L7.81395 0Z" fill="#FFD600"/>
                        </svg>            
                        4.5</p>
                </div>

                <h1><c:out value="${sessionScope.nomeEst}"/></h1>

                <p id="acom" style="width: 90px;">Acompanhantes</p>

                <p id="escol" style="margin-left: -20px;">Escolha uma data e horário</p>
                <form action="${pageContext.request.contextPath}/Reservando" method="get">
                    <div class="number-input" style="width: 45px; border: 2px solid;">
                        <!--Acompanhantes-->
                        <input class="quantity" min="0" name="acompanhantes" value="1" type="number" style="border:none;">
                    </div>
                    <!--DATA-->
                    <input class="data" style="width: 150px; margin-left: 20px;" type="date" name="dataReserva">
                    
                    <!--HORARIO-->
                    <input class="data" style="width: 100px; margin-left: 30px;" type="time" name="horaReserva">
                    <div class="btns" style="margin-left: -40px;">
                        <!--ID-->
                        <input type="hidden" name="idEstab" value="${sessionScope.idEst}">
                        <input type="hidden" name="nomeEstab" value="${sessionScope.nomeEst}">
                        <button type="submit" id="reserva" name="btn" value="reservarConfirmar" style="cursor: pointer">Reservar</button>
                    </div>
                </form>
            </div>

            <div class="defi">
                <c:if test="${sessionScope.defA == 'Sim'}">
                        <svg width="26" height="39" viewBox="0 0 26 39" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M22.3677 8.77522C24.2682 8.77522 25.8089 7.02462 25.8089 4.86515C25.8089 2.70568 24.2682 0.955078 22.3677 0.955078C20.4672 0.955078 18.9265 2.70568 18.9265 4.86515C18.9265 7.02462 20.4672 8.77522 22.3677 8.77522Z" fill="#EE7D14"/>
                            <path d="M17.2059 29.2252H13.7647C13.7647 32.451 11.4419 35.0903 8.60294 35.0903C5.76397 35.0903 3.44118 32.451 3.44118 29.2252C3.44118 25.9994 5.76397 23.3601 8.60294 23.3601V19.45C3.85412 19.45 0 23.8293 0 29.2252C0 34.6211 3.85412 39.0003 8.60294 39.0003C13.3518 39.0003 17.2059 34.6211 17.2059 29.2252ZM22.3676 22.3825H19.1674L22.0407 15.2076C23.0903 12.6074 21.4041 9.6748 18.8576 9.6748H9.91059C8.51691 9.6748 7.26088 10.5937 6.69309 12.0208L5.54029 15.5399L8.84382 16.5761L9.96221 13.5849H13.7647L10.616 21.6005C9.58368 24.2007 11.2871 27.2701 13.7991 27.2701H22.3676V37.0453H25.8088V26.2926C25.8088 24.1421 24.2603 22.3825 22.3676 22.3825Z" fill="#EE7D14"/>
                        </svg>  
                    </c:if>    
                    <div style="width: 5px; float: left;"></div>
                    <c:if test="${sessionScope.defC == 'Sim'}">
                        <svg width="32" height="40" viewBox="0 0 32 40" fill="none" xmlns="http://www.w3.org/2000/svg">
                            <path d="M16.3382 0C18.2308 0 19.7794 1.75953 19.7794 3.91007C19.7794 6.06061 18.2308 7.82014 16.3382 7.82014C14.4456 7.82014 12.897 6.06061 12.897 3.91007C12.897 1.75953 14.4456 0 16.3382 0ZM31.8235 13.6853H21.5V39.1007H18.0588V27.3705H14.6176V39.1007H11.1764V13.6853H0.852905V9.77518H31.8235V13.6853Z" fill="#0078FF"/>
                        </svg> 
                    </c:if>     
                <p>Este estabelecimento possui  recursos para deficientes auditivos e físicos.</p>
            </div>

            <div class="info">
                <h2>Informações</h2>
                <h4>Endereço</h4>
                <p><c:out value="${sessionScope.logad}"/>, nº <c:out value="${sessionScope.nume}"/></p>
                <p>CEP: <c:out value="${sessionScope.cep}"/></p>
                <p>Celular: <c:out value="${sessionScope.celu}"/></p>
                <p>Envio de currículo: <c:out value="${sessionScope.email}"/></p>

                <h4>Horário de Funcionamento</h4>
                <p>Segunda a Sábado: 08h as 18h</p>
                <p>Domingos e Feriados: 09h as 14h</p>

            </div>
            <div class="prev">
                <h2>Prevenções COVID-19</h2>
                <h4>Orientações</h4>
                <p>Ao chegar no local será ferido a sua temperatura, será validado sua reserva. Higienize as suas mãos.</p>
                <p>Ao escolher a sua mesa, o estabelecimento higienizará e então poderá fazer o seu pedido.</p>
                <p>Após o termino da refeição você terá 10 minutos para sair do estabelecimento.</p>

            </div>
            <div class="retangulo">
                <h1>Liberdade com segurança, siga as orientações</h1>
            </div>

        </div>

        <div class="rodape">
            <div class="rodapeprin">
                <div class="grupos">
                        <div class="top10">
                            <h3>A Rapina</h3>
                            <a href="${pageContext.request.contextPath}/Sobre" style="text-decoration: none;">Site Institucional</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/Contato" style="text-decoration: none;">Fale conosco</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/TelaTermos" style="text-decoration: none;">Termos de uso</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/Privacidade" style="text-decoration: none;">Política de Privacidade</a>
                        </div>
                        <div class="top10">
                            <h3>Voe com a Rapina</h3>
                            <a href="${pageContext.request.contextPath}/Pre_Cadastro" style="text-decoration: none;">Cadastre seu estabelecimento</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/TelaPlanos" style="text-decoration: none;">Rapina Planos</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/Campanha" style="text-decoration: none;">Campanha Rapinantes</a>
                            <br><br>
                            <a href="${pageContext.request.contextPath}/LogEmail" style="text-decoration: none;">Já sou uma loja parceira</a>
                        </div>
                        <div class="top10">
                            <div class="social">
                                <h3>Social</h3>
                                <a href="" title="Facebook"><svg class="icon" xmlns="http://www.w3.org/2000/svg" width="11" height="24" viewBox="0 0 11 24"><path d="M10.7 4L8.8 4C7.2 4 6.9 4.9 6.9 6L6.9 8.6 10.7 8.6 10.3 12.8 7.2 12.8 7.2 23.5 3.3 23.5 3.3 12.8 0 12.8 0 8.6 3.3 8.6 3.3 5.6C3.3 2.1 5.2 0 8.1 0 9.4 0 10.6 0.1 11 0.1L11 4 10.7 4Z"></path></svg></a>
                                <a href="" title="Instagram"><svg width="20" height="20" xmlns="http://www.w3.org/2000/svg"><path d="M17.510373 0H2.406639C1.078838 0 0 1.0788382 0 2.3236515v15.1867219c0 1.3278009 1.078838 2.406639 2.406639 2.406639h15.186722C18.921162 19.9170124 20 18.8381743 20 17.593361V2.3236515C19.917012 1.0788382 18.838174 0 17.510373 0zm-2.572614 2.4896266h1.659751c.497926 0 .829876.3319502.829876.8298755v1.659751c0 .4979253-.33195.8298755-.829876.8298755h-1.659751c-.497925 0-.829875-.3319502-.829875-.8298755v-1.659751c0-.4979253.33195-.8298755.829875-.8298755zM9.958506 6.1410788c2.074689 0 3.817428 1.7427386 3.817428 3.8174274s-1.742739 3.8174274-3.817428 3.8174274c-2.074689 0-3.817427-1.7427386-3.817427-3.8174274s1.742738-3.8174274 3.817427-3.8174274zm6.639004 11.2863071H3.319502c-.497925 0-.829875-.3319502-.829875-.8298755V8.2987552h1.659751c-.248963.9128631-.331951 1.9917012-.082988 2.9875519.497925 2.3236514 2.406639 4.1493775 4.73029 4.5643153 3.900415.746888 7.302905-2.1576763 7.302905-5.8921162 0-.5809128-.165975-1.1618257-.248963-1.659751h1.659751v8.2987552c-.082987.4979253-.414937.8298755-.912863.8298755z" fill-rule="evenodd"></path></svg></a>
                                <a href="" title="Twitter"><svg width="24" height="19" xmlns="http://www.w3.org/2000/svg"><path d="M20.957 4.543v.606c0 6.209-4.777 13.327-13.56 13.327-2.774 0-5.24-.758-7.397-2.12.462 0 .77.15 1.233.15 2.157 0 4.314-.756 6.01-1.968-2.004 0-3.853-1.363-4.47-3.332.309 0 .617.152.925.152.463 0 .463 0 1.079-.152C2.466 10.752.462 8.783.462 6.512c0 .454 1.695.454 2.466.606C1.695 6.209.925 4.846.925 3.18c0-.908.308-1.666.77-2.423 2.311 2.878 6.01 4.695 9.862 4.998-.154-.455-.154-.758-.154-1.06C11.403 2.12 13.56 0 16.18 0c1.387 0 2.62.454 3.544 1.514 1.079-.302 2.004-.605 2.928-1.211-.462 1.211-1.233 1.969-2.003 2.574a14.785 14.785 0 0 0 2.774-.757c-.77.909-1.541 1.817-2.466 2.423z" fill-rule="evenodd"></path></svg></a>
                                <a href="" title="Youtube"><svg width="24" height="17" xmlns="http://www.w3.org/2000/svg"><path d="M23.8 3.6s-.2-1.7-1-2.4c-.9-1-1.9-1-2.4-1C17 0 12 0 12 0S7 0 3.6.2c-.5.1-1.5.1-2.4 1-.7.7-1 2.4-1 2.4S0 5.5 0 7.5v1.8c0 1.9.2 3.9.2 3.9s.2 1.7 1 2.4c.9 1 2.1.9 2.6 1 1.9.2 8.2.2 8.2.2s5 0 8.4-.3c.5-.1 1.5-.1 2.4-1 .7-.7 1-2.4 1-2.4s.2-1.9.2-3.9V7.4c0-1.9-.2-3.8-.2-3.8zM9.5 11.5V4.8L16 8.2l-6.5 3.3z" fill-rule="evenodd"></path></svg></a>
                                <a href="" title="LinkedIn"><svg width="19" height="19" xmlns="http://www.w3.org/2000/svg"><path d="M3.859375 19h-3.5625V5.9375h3.5625V19zM2.078125 4.43175C.931 4.43175 0 3.493625 0 2.337S.931.24225 2.078125.24225 4.15625 1.180375 4.15625 2.337s-.929812 2.09475-2.078125 2.09475zM18.109375 19h-3.5625v-6.65475c0-3.9995-4.75-3.6966875-4.75 0V19h-3.5625V5.9375h3.5625v2.0959375c1.65775-3.070875 8.3125-3.2976875 8.3125 2.94025V19z" fill-rule="nonzero"></path></svg></a>
                            </div>
                        </div>
                        <div style="clear: both;">
                            <br>
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
        </div>
    </body>
</html>