
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Busque estabelecimento</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="keywords" content="HTML, CSS, JAVASCRIPT">
        <meta name="description" content="Crowd Control">
        <meta name="author" content="konex-group">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/estList.css">
        <script src="https://kit.fontawesome.com/194a95388c.js" crossorigin="anonymous"></script>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <link href="https://fonts.googleapis.com/css2?family=Ubuntu:wght@300;400;500;700&display=swap" rel="stylesheet">
        
       
    </head>
    
    <body>
        <div id="container-landing">
            <div class="background-color">
                <div class="margin">
                    <section class="menu-bar">
                        <div>
                            <a href="${pageContext.request.contextPath}/Home"><img src="${pageContext.request.contextPath}/images/icons/Logotipo-Branco 1.png" alt="logo-image" class="logo-icon" /></a>
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
                    <div class="establishments">
                        <div class="introducing-context">
                            <div class="security-search">
                                <p>Liberdade com segurança</p>
                                <h1>Busca segura é Rapina</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="list-est">
                
                <c:forEach var="busca" items="${sessionScope.buscaEstabelecimento}">   
                    <form action="${pageContext.request.contextPath}/ListaRestaurantesBuscados" method="get">
                        <input type="hidden" name="lineCEP" value="${busca.cep_estabelecimento}">
                        <input type="hidden" name="lineIdEstb" value="${busca.id_estabelecimento}">
                        <input type="hidden" name="lineNome" value="${busca.nome_estabelecimento}">
                        <input type="hidden" name="lineEndereco" value="${busca.logadouro_estabelecimento}">
                        <input type="hidden" name="lineNumero" value="${busca.numero}">
                        <input type="hidden" name="lineDefAud" value="${busca.acessi_auditiva}">
                        <input type="hidden" name="lineDefCad" value="${busca.acessi_fisico}">
                        <input type="hidden" name="lineEmail" value="${busca.email}">
                        <input type="hidden" name="lineCel" value="${busca.celular}">
                        <input type="hidden" name="lineCap" value="${busca.capacidade}">
                        <input type="hidden" name="lineLota" value="${busca.lotacao}">
                        <button type="submit" style="background: transparent;float: left;" name="btn" value="selectRest">
                            <div class="cartao">
                                <!--FAZER IF TESTE PARA SABER O NIVEL DA AGLOMERAÇÃO-->
                                <div style="float: left;">
                                    <c:if test="${busca.lotacao <=  (busca.capacidade * 4)/10}">
                                        <img src="${pageContext.request.contextPath}/images/Ellipse 10.png" alt="">
                                    </c:if>
                                        
                                    <c:if test="${busca.lotacao >=  (busca.capacidade * 4)/10}">
                                        <img src="${pageContext.request.contextPath}/images/Ellipse 10 (2).png" alt="">
                                    </c:if>
                                </div>
                                
                                <div style="float: left;margin-right: 79px;margin-left: 74px;">
                                    <c:if test="${busca.id_estabelecimento == 1}">
                                       <img src="${pageContext.request.contextPath}/images/Ellipse 59.png" alt=""> 
                                    </c:if>
                                    <c:if test="${busca.id_estabelecimento == 2}">
                                       <img src="${pageContext.request.contextPath}/images/Ellipse 60.png" alt=""> 
                                    </c:if>
                                    <c:if test="${busca.id_estabelecimento == 3}">
                                       <img src="${pageContext.request.contextPath}/images/Ellipse 61.png" alt=""> 
                                    </c:if>
                                    <c:if test="${busca.id_estabelecimento == 4}">
                                       <img src="${pageContext.request.contextPath}/images/Ellipse 62.png" alt=""> 
                                    </c:if>
                                    <c:if test="${busca.id_estabelecimento == 5}">
                                       <img src="${pageContext.request.contextPath}/images/Ellipse 63.png" alt=""> 
                                    </c:if>   
                                    <c:if test="${busca.id_estabelecimento == 6}">
                                       <img src="${pageContext.request.contextPath}/images/Ellipse 64.png" alt=""> 
                                    </c:if> 
                                    <c:if test="${busca.id_estabelecimento == 7}">
                                       <img src="${pageContext.request.contextPath}/images/Ellipse 65.png" alt=""> 
                                    </c:if>
                                    <c:if test="${busca.id_estabelecimento == 8}">
                                       <img src="${pageContext.request.contextPath}/images/Ellipse 66.png" alt=""> 
                                    </c:if>   
                                    <c:if test="${busca.id_estabelecimento == 9}">
                                       <img src="${pageContext.request.contextPath}/images/Ellipse 67.png" alt=""> 
                                    </c:if>    
                                </div>

                                <div id="passar_mouse"> 
                                    <img src="${pageContext.request.contextPath}/images/Group 45.png" alt="">   
                                    <div id="mostrar">
                                        Este estabelecimento está localizado na Rua:<c:out value="${busca.logadouro_estabelecimento}"/>-Nº <c:out value="${busca.numero}"/>
                                    </div>
                                </div>
                                   
                                <h1><c:out value="${busca.nome_estabelecimento}"/></h1>
                                <div id="estrela">
                                    <svg width="16" height="15" viewBox="0 0 16 15" fill="#FFD600" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M8 0L9.79611 5.52786H15.6085L10.9062 8.94427L12.7023 14.4721L8 11.0557L3.29772 14.4721L5.09383 8.94427L0.391548 5.52786H6.20389L8 0Z" fill="#FFD600"/>
                                    </svg>
                                </div>
                                
                                <p>4.5</p>

                                <div id="cap">
                                    <svg width="15" height="12" viewBox="0 0 15 12" fill="#000" xmlns="http://www.w3.org/2000/svg">
                                    <path d="M9.60005 2.4C9.60005 3.03652 9.34719 3.64697 8.89711 4.09706C8.44702 4.54714 7.83657 4.8 7.20005 4.8C6.56353 4.8 5.95308 4.54714 5.50299 4.09706C5.05291 3.64697 4.80005 3.03652 4.80005 2.4C4.80005 1.76348 5.05291 1.15303 5.50299 0.702944C5.95308 0.252856 6.56353 0 7.20005 0C7.83657 0 8.44702 0.252856 8.89711 0.702944C9.34719 1.15303 9.60005 1.76348 9.60005 2.4Z" fill="black" fill-opacity="0.8"/>
                                    <path d="M13.6 3.9999C13.6 4.42425 13.4315 4.83121 13.1314 5.13127C12.8313 5.43133 12.4244 5.5999 12 5.5999C11.5757 5.5999 11.1687 5.43133 10.8687 5.13127C10.5686 4.83121 10.4 4.42425 10.4 3.9999C10.4 3.57556 10.5686 3.16859 10.8687 2.86853C11.1687 2.56847 11.5757 2.3999 12 2.3999C12.4244 2.3999 12.8313 2.56847 13.1314 2.86853C13.4315 3.16859 13.6 3.57556 13.6 3.9999Z" fill="black" fill-opacity="0.8"/>
                                    <path d="M10.4 9.5999C10.4 8.75121 10.0629 7.93728 9.46274 7.33716C8.86263 6.73704 8.04869 6.3999 7.2 6.3999C6.35131 6.3999 5.53737 6.73704 4.93726 7.33716C4.33714 7.93728 4 8.75121 4 9.5999V11.9999H10.4V9.5999Z" fill="black" fill-opacity="0.8"/>
                                    <path d="M4.00005 3.9999C4.00005 4.42425 3.83148 4.83121 3.53142 5.13127C3.23136 5.43133 2.8244 5.5999 2.40005 5.5999C1.9757 5.5999 1.56874 5.43133 1.26868 5.13127C0.96862 4.83121 0.800049 4.42425 0.800049 3.9999C0.800049 3.57556 0.96862 3.16859 1.26868 2.86853C1.56874 2.56847 1.9757 2.3999 2.40005 2.3999C2.8244 2.3999 3.23136 2.56847 3.53142 2.86853C3.83148 3.16859 4.00005 3.57556 4.00005 3.9999Z" fill="black" fill-opacity="0.8"/>
                                    <path d="M12 12V9.60005C12.0012 8.78667 11.7947 7.98647 11.4 7.27525C11.7547 7.18448 12.1254 7.17592 12.4839 7.25022C12.8424 7.32452 13.1792 7.47972 13.4686 7.70398C13.758 7.92823 13.9923 8.21562 14.1537 8.54422C14.3152 8.87281 14.3994 9.23394 14.4 9.60005V12H12Z" fill="black" fill-opacity="0.8"/>
                                    <path d="M3 7.27518C2.6054 7.98642 2.39888 8.78662 2.4 9.59998V12H2.12576e-07V9.59998C-0.000153974 9.23362 0.0835707 8.87208 0.244758 8.54307C0.405945 8.21407 0.640315 7.92633 0.929907 7.70192C1.2195 7.4775 1.55662 7.32237 1.91545 7.2484C2.27427 7.17443 2.64527 7.18359 3 7.27518Z" fill="black" fill-opacity="0.8"/>
                                    </svg>
                                </div>
                                <p><c:out value="${busca.lotacao}"/> de <c:out value="${busca.capacidade}"/></p>

                                <div class="acessi">
                                    <c:if test="${busca.acessi_auditiva == 'Sim'}">
                                        <img src="${pageContext.request.contextPath}/images/cadeiraOn.png" alt="">
                                    </c:if>
                                    <c:if test="${busca.acessi_auditiva == 'Não'}">
                                        <img src="${pageContext.request.contextPath}/images/cadeiraOff.png" alt="">
                                    </c:if>     
                                    <div style="width: 5px; float: left;"></div>
                                    <c:if test="${busca.acessi_fisico == 'Sim'}">
                                        <img src="${pageContext.request.contextPath}/images/audOn.png" alt="">
                                    </c:if>
                                    <c:if test="${busca.acessi_fisico == 'Não'}">
                                        <img src="${pageContext.request.contextPath}/images/audOff.png" alt="">
                                    </c:if>
                                </div>
                                
                                <div style="width: 300px; height: 300px; background: none; margin-top: -200px; margin-left: -40px;" id="passar_mouse2">
                                    <div class="Reservar" id="mostrar2">
                                        <p>Reservar</p>
                                    </div>   
                                </div>
                                
                               
                                
                            </div>
                        </button>
                    </form>
                </c:forEach> 

                <!-- Substitui botao -->
                <div style="clear: both;"></div>
            </div>

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
