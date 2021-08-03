<!--
    TELA REFERENTE AO MARCO II
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/menuADM.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <title>Menu Administrador</title>
    </head>
    <body> 
        <div id="container-landingadm">
            <section class="menu-baradm">
                <div class="menulogoadm">
                    <img src="${pageContext.request.contextPath}/images/icons/Logotipo-Branco 1.png" alt="logo-image" class="logo-icon" />
                </div>
                <div class="nomeMenuadm">
                    <h1>Olá </h1><p><c:out value="${sessionScope.nomeADM}"/></p><h1>, essa é a sua área :)</h1>
                </div>
                <div class="direitamenuadm">
                    <div width="32" height="34" viewBox="0 0 32 34" fill="none"><a style="cursor:pointer;" href="${pageContext.request.contextPath}/CriaTelaResposta"><img src="${pageContext.request.contextPath}/images/edit.svg" color:white></a></div>
                    <div width="32" height="34" viewBox="0 0 32 34" fill="none" style="margin-left: 100px;"><a style="cursor:pointer;" href="${pageContext.request.contextPath}/CriaListaNotifica"><img src="${pageContext.request.contextPath}/images/notificatio.svg" color:white></a></div>
                </div>
                <div id="sairlogout" width="37" height="30" viewBox="0 0 37 30" fill="none"><a style="cursor: pointer" href="${pageContext.request.contextPath}/CriaTelaMenuSaida"><img src="${pageContext.request.contextPath}/images/logout.png"></a></div>
            </section>
        </div>

        <div class="todo">
            <div class="pagamento invisible-scrollbar">

                <div class="pagtop">
                    <h2>Pagamentos em atraso</h2>
                    <form action="${pageContext.request.contextPath}/FazListagemPag" method="get">
                        <div class="select">
                            <select name="opcoes">
                                <option>Selecione o Usuario</option>
                                <option>Rapinista</option>
                                <option>Estabelecimento</option>
                            </select>
                            <div class="select__arrow"></div>
                        </div>
                        <div id="btn-confirma">
                            <input type="submit" value="Confirma">
                        </div>
                    </form>

                </div>
                <table class="tabela">
                    <thead>
                        <tr>
                            <th class="cod">Cód.</th>
                            <th class="user">Usuário</th>
                            <th class="atras">Atrasa desde</th>
                            <th class="val">Valor</th>
                            <th class="opcoes">Opções</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="lista" items="${listaPag}">
                            <tr>
                                <td class="cod"><c:out value="${lista.id_pagamento_taxa}"/></td>
                                <td class="user"><c:out value="${lista.nomeUser}"/></td>
                                <td class="atras"><c:out value="${lista.data_cobranca}"/></td>
                                <td class="val"><c:out value="${lista.valor_total}"/></td>
                                <td class="opcoes">
                                    <form action="${pageContext.request.contextPath}/BuscaPagamentos" method="get">
                                        <input type="hidden" name="lineTipo" value="${lista.tipo_user}">
                                            <input type="hidden" name="lineID" value="${lista.id_usuario}">
                                            <input type="hidden" name="lineIDEsta" value="${lista.id_estabelecimento}">       
                                            <input type="hidden" name="lineUser" value="${lista.nomeUser}">
                                            <input type="hidden" name="lineData" value="${lista.data_cobranca}">
                                            <input type="hidden" name="lineValor" value="${lista.valor_total}">
                                        <button name="btn" value="notifica">
                                            <svg width="19" height="19" viewBox="0 0 19 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                                            <path fill-rule="evenodd" clip-rule="evenodd" d="M16.414 0.585573C16.0389 0.210631 15.5303 0 15 0C14.4697 0 13.9611 0.210631 13.586 0.585573L5.586 8.58557C5.2109 8.96056 5.00011 9.46918 5 9.99957V11.5856C5 12.116 5.21071 12.6247 5.58579 12.9998C5.96086 13.3749 6.46957 13.5856 7 13.5856H8.586C9.11639 13.5855 9.62501 13.3747 10 12.9996L18 4.99957C18.3749 4.62452 18.5856 4.1159 18.5856 3.58557C18.5856 3.05524 18.3749 2.54663 18 2.17157L16.414 0.585573ZM3 1.58557C2.20435 1.58557 1.44129 1.90164 0.87868 2.46425C0.316071 3.02686 0 3.78992 0 4.58557V15.5856C0 16.3812 0.316071 17.1443 0.87868 17.7069C1.44129 18.2695 2.20435 18.5856 3 18.5856H14C14.7956 18.5856 15.5587 18.2695 16.1213 17.7069C16.6839 17.1443 17 16.3812 17 15.5856V12.5856C17 12.3204 16.8946 12.066 16.7071 11.8785C16.5196 11.6909 16.2652 11.5856 16 11.5856C15.7348 11.5856 15.4804 11.6909 15.2929 11.8785C15.1054 12.066 15 12.3204 15 12.5856V15.5856C15 15.8508 14.8946 16.1051 14.7071 16.2927C14.5196 16.4802 14.2652 16.5856 14 16.5856H3C2.73478 16.5856 2.48043 16.4802 2.29289 16.2927C2.10536 16.1051 2 15.8508 2 15.5856V4.58557C2 4.32036 2.10536 4.066 2.29289 3.87847C2.48043 3.69093 2.73478 3.58557 3 3.58557H6C6.26522 3.58557 6.51957 3.48022 6.70711 3.29268C6.89464 3.10514 7 2.85079 7 2.58557C7 2.32036 6.89464 2.066 6.70711 1.87847C6.51957 1.69093 6.26522 1.58557 6 1.58557H3Z" fill="#4EBAB5" fill-opacity="1"/>
                                            </svg>
                                        </button>

                                        <c:if test="${lista.tipo_user >=3 }">
                                            <button name="btn" value="bloquea">
                                                <svg width="17" height="21" viewBox="0 0 17 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                                                <path d="M16.8 10.5C16.8 9.34185 15.8581 8.4 14.7 8.4H13.65V5.25C13.65 2.35515 11.2948 0 8.4 0C5.50515 0 3.15 2.35515 3.15 5.25V8.4H2.1C0.94185 8.4 0 9.34185 0 10.5V18.9C0 20.0581 0.94185 21 2.1 21H14.7C15.8581 21 16.8 20.0581 16.8 18.9V10.5ZM5.25 5.25C5.25 3.5133 6.6633 2.1 8.4 2.1C10.1367 2.1 11.55 3.5133 11.55 5.25V8.4H5.25V5.25Z" fill="#4361ee" fill-opacity="1"/>
                                                </svg>
                                            </button>
                                        </c:if>    
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
            <div class="users">
                <h2 id="usersH2">Users Rapina planos</h2>
                <div class="planos">
                    <form action="${pageContext.request.contextPath}/TelaLogSenha" method="get">
                        <div class="serrana">
                            <img src="${pageContext.request.contextPath}/images/SERRANA 1.png" alt="">      
                            <p>Serrana</p>
                            <h3><c:out value="${sessionScope.dadosPlano}"/></h3>
                        </div>
                        <div class="rarpy">
                            <img src="${pageContext.request.contextPath}/images/RARPY 1.png" alt=""> 

                            <p>Rarpy</p>
                            <h3><c:out value="${sessionScope.dadosPlanoB}"/></h3>
                        </div>
                        <div class="acor">
                            <img src="${pageContext.request.contextPath}/images/AÇOR 1.png" alt=""> 

                            <p>Açor</p>
                            <h3><c:out value="${sessionScope.dadosPlanoC}"/></h3>
                        </div>
                    </form>    
                </div>
                <c:if test="${sessionScope.maior == 1}">
                    <p id="planP">Plano mais adquirido: Rarpy</p>
                </c:if> 
                <c:if test="${sessionScope.maior == 2}">
                    <p id="planP">Plano mais adquirido: Serrana</p>
                </c:if> 
                <c:if test="${sessionScope.maior == 3}">
                    <p id="planP">Plano mais adquirido: Açor</p>
                </c:if> 
            </div>

            <div class="jorCon">
                <div class="jornadas">
                    <h2 id="jornadasH2">Jornadas da Rapina</h2>
                    <div class="jornadasinfo">
                        <form action="${pageContext.request.contextPath}/TelaLogSenha" method="get">
                            <div class="reservas">
                                <svg width="32" height="25" viewBox="0 0 32 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path opacity="1" d="M28.125 12.5C28.125 13.3288 28.4542 14.1237 29.0403 14.7097C29.6263 15.2958 30.4212 15.625 31.25 15.625V21.875C31.25 22.7038 30.9208 23.4987 30.3347 24.0847C29.7487 24.6708 28.9538 25 28.125 25H3.125C2.2962 25 1.50134 24.6708 0.915291 24.0847C0.32924 23.4987 0 22.7038 0 21.875V15.625C0.828802 15.625 1.62366 15.2958 2.20971 14.7097C2.79576 14.1237 3.125 13.3288 3.125 12.5C3.125 11.6712 2.79576 10.8763 2.20971 10.2903C1.62366 9.70424 0.828802 9.375 0 9.375V3.125C0 2.2962 0.32924 1.50134 0.915291 0.915291C1.50134 0.32924 2.2962 0 3.125 0H28.125C28.9538 0 29.7487 0.32924 30.3347 0.915291C30.9208 1.50134 31.25 2.2962 31.25 3.125V9.375C30.4212 9.375 29.6263 9.70424 29.0403 10.2903C28.4542 10.8763 28.125 11.6712 28.125 12.5ZM22.6562 19.1406C22.6562 16.7969 17.9688 15.625 15.625 15.625C13.2812 15.625 8.59375 16.7969 8.59375 19.1406V20.3125H22.6562V19.1406ZM15.625 12.8906C16.5574 12.8906 17.4516 12.5202 18.1109 11.8609C18.7702 11.2016 19.1406 10.3074 19.1406 9.375C19.1406 8.4426 18.7702 7.54839 18.1109 6.88908C17.4516 6.22977 16.5574 5.85938 15.625 5.85938C14.6926 5.85938 13.7984 6.22977 13.1391 6.88908C12.4798 7.54839 12.1094 8.4426 12.1094 9.375C12.1094 10.3074 12.4798 11.2016 13.1391 11.8609C13.7984 12.5202 14.6926 12.8906 15.625 12.8906Z" fill="#4361ee"/>
                                </svg>
                                <p>Reservas confirmadas</p>
                                <h3><c:out value="${sessionScope.dadosReserva}"/></h3>
                            </div>
                            <div class="doacoes">
                                <svg width="25" height="25" viewBox="0 0 25 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path opacity="1" d="M12.5 0C5.6075 0 0 5.6075 0 12.5C0 19.3925 5.6075 25 12.5 25C19.3925 25 25 19.3925 25 12.5C25 5.6075 19.3925 0 12.5 0ZM16.8662 7.5C17.1155 7.49363 17.3635 7.53724 17.5956 7.62823C17.8277 7.71923 18.0392 7.85578 18.2177 8.02983C18.3962 8.20389 18.538 8.41192 18.6349 8.64166C18.7317 8.8714 18.7815 9.11821 18.7814 9.36752C18.7813 9.61683 18.7313 9.86359 18.6344 10.0933C18.5374 10.3229 18.3954 10.5309 18.2168 10.7048C18.0382 10.8788 17.8266 11.0152 17.5944 11.106C17.3622 11.1968 17.1142 11.2403 16.865 11.2338C16.3782 11.221 15.9157 11.0186 15.576 10.6698C15.2363 10.3209 15.0463 9.85319 15.0464 9.36627C15.0466 8.87934 15.2369 8.41173 15.5769 8.06311C15.9168 7.71449 16.3795 7.51243 16.8662 7.5ZM8.125 7.5C8.37131 7.50008 8.61519 7.54868 8.84272 7.64301C9.07025 7.73735 9.27697 7.87557 9.45108 8.0498C9.62519 8.22402 9.76328 8.43084 9.85747 8.65843C9.95165 8.88602 10.0001 9.12994 10 9.37625C9.99992 9.62256 9.95132 9.86644 9.85699 10.094C9.76265 10.3215 9.62443 10.5282 9.4502 10.7023C9.27598 10.8764 9.06916 11.0145 8.84157 11.1087C8.61398 11.2029 8.37006 11.2513 8.12375 11.2513C7.6263 11.2511 7.1493 11.0533 6.79767 10.7015C6.44604 10.3496 6.24858 9.87245 6.24875 9.375C6.24892 8.87755 6.44668 8.40055 6.79855 8.04892C7.15041 7.69729 7.62755 7.49983 8.125 7.5ZM12.5 20C6.25 20 5 13.75 5 13.75H20C20 13.75 18.75 20 12.5 20Z" fill="#4361ee"/>
                                </svg>
                                <p>Doações arrecadadas</p>
                                <h3><c:out value="${sessionScope.dadosDoacoes}"/></h3>
                            </div>
                            <div class="qtdreceb">
                                <svg width="36" height="25" viewBox="0 0 36 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path opacity="1" d="M3.57143 0H32.1429C33.0901 0 33.9985 0.376274 34.6682 1.04605C35.338 1.71582 35.7143 2.62423 35.7143 3.57143V21.4286C35.7143 22.3758 35.338 23.2842 34.6682 23.954C33.9985 24.6237 33.0901 25 32.1429 25H3.57143C2.62423 25 1.71582 24.6237 1.04605 23.954C0.376274 23.2842 0 22.3758 0 21.4286V3.57143C0 2.62423 0.376274 1.71582 1.04605 1.04605C1.71582 0.376274 2.62423 0 3.57143 0ZM28.5714 3.57143H7.14286C7.14286 4.51863 6.76658 5.42704 6.09681 6.09681C5.42704 6.76658 4.51863 7.14286 3.57143 7.14286V17.8571C4.51863 17.8571 5.42704 18.2334 6.09681 18.9032C6.76658 19.573 7.14286 20.4814 7.14286 21.4286H28.5714C28.5714 20.4814 28.9477 19.573 29.6175 18.9032C30.2873 18.2334 31.1957 17.8571 32.1429 17.8571V7.14286C31.1957 7.14286 30.2873 6.76658 29.6175 6.09681C28.9477 5.42704 28.5714 4.51863 28.5714 3.57143ZM10.7143 7.14286H14.2857V17.8571H10.7143V7.14286ZM21.4286 14.2857C21.9022 14.2857 22.3564 14.0976 22.6913 13.7627C23.0261 13.4278 23.2143 12.9736 23.2143 12.5C23.2143 12.0264 23.0261 11.5722 22.6913 11.2373C22.3564 10.9024 21.9022 10.7143 21.4286 10.7143C20.955 10.7143 20.5008 10.9024 20.1659 11.2373C19.831 11.5722 19.6429 12.0264 19.6429 12.5C19.6429 12.9736 19.831 13.4278 20.1659 13.7627C20.5008 14.0976 20.955 14.2857 21.4286 14.2857ZM21.4286 17.8571C20.0078 17.8571 18.6452 17.2927 17.6405 16.2881C16.6358 15.2834 16.0714 13.9208 16.0714 12.5C16.0714 11.0792 16.6358 9.71659 17.6405 8.71193C18.6452 7.70727 20.0078 7.14286 21.4286 7.14286C22.8494 7.14286 24.212 7.70727 25.2166 8.71193C26.2213 9.71659 26.7857 11.0792 26.7857 12.5C26.7857 13.9208 26.2213 15.2834 25.2166 16.2881C24.212 17.2927 22.8494 17.8571 21.4286 17.8571Z" fill="#4361ee"/>
                                </svg>
                                <p>Qtd. de recebidos</p>
                                <h3><c:out value="${sessionScope.dadosPagamentos}"/></h3>
                            </div>
                            <div class="qtduser">
                                <svg width="25" height="25" viewBox="0 0 25 25" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path opacity="1" d="M12.5 0C9.18479 0 6.00537 1.31696 3.66117 3.66117C1.31696 6.00537 0 9.18479 0 12.5C0 15.8152 1.31696 18.9946 3.66117 21.3388C6.00537 23.683 9.18479 25 12.5 25C15.8152 25 18.9946 23.683 21.3388 21.3388C23.683 18.9946 25 15.8152 25 12.5C25 9.18479 23.683 6.00537 21.3388 3.66117C18.9946 1.31696 15.8152 0 12.5 0V0ZM7.43125 7.13438C8.62344 4.90937 13.7125 6.94688 8.91875 12.5C1.89375 10.0063 5.24688 5.78437 7.43125 7.13438ZM17.6797 15.6469C17.828 15.612 17.9833 15.6212 18.1265 15.6734C18.2696 15.7256 18.3944 15.8185 18.4854 15.9408C18.5764 16.063 18.6296 16.2091 18.6386 16.3613C18.6476 16.5134 18.6119 16.6648 18.5359 16.7969C17.9189 17.8662 17.0312 18.7541 15.962 19.3713C14.8928 19.9884 13.6799 20.3131 12.4453 20.3125C11.2108 20.3131 9.99786 19.9884 8.92866 19.3713C7.85946 18.7541 6.97168 17.8662 6.35469 16.7969C6.27871 16.6648 6.24302 16.5134 6.252 16.3613C6.26099 16.2091 6.31426 16.063 6.40526 15.9408C6.49626 15.8185 6.62102 15.7256 6.76417 15.6734C6.90732 15.6212 7.06262 15.612 7.21094 15.6469H7.21875L7.24531 15.6547L7.35 15.6781L7.74375 15.7641C8.07969 15.8359 8.54844 15.9328 9.08281 16.0281C10.1656 16.2219 11.4609 16.4062 12.4453 16.4062C13.4297 16.4062 14.7266 16.2219 15.8078 16.0281C16.3878 15.9238 16.9656 15.8071 17.5406 15.6781L17.6453 15.6547L17.6719 15.6484L17.6797 15.6453V15.6469ZM17.5703 7.13438C19.7531 5.78437 23.1062 10.0063 16.0812 12.5C11.2891 6.94688 16.3781 4.90937 17.5688 7.13438H17.5703Z" fill="#4361ee"/>
                                </svg>                            
                                <p>Qtd. de usuários</p>
                                <h3><c:out value="${sessionScope.dadosUsers}"/></h3>
                            </div>
                        </form>
                    </div>
                    <hr>
                </div>
                <!--\\\\\\\\\\\\\\\\\\\RAPINANTE///////////////-->
                <div class="conInfo">
                    <div class="consulRap">
                        <h2 style="font-weight: 700;">Consultar Rapina</h2>

                        <!--\\\\\\\\\\\\\\\\\\\FORMULARIO///////////////-->
                        <form action="${pageContext.request.contextPath}/BuscaRapina" method="get">
                            <div class="codRap">
                                <input type="text" name="pegaIdRapinante" placeholder="Digite o cód. do Rapinista">
                                <button type="submit" name="btnR" value="confirmaBusca">ok</button>
                            </div>
                        </form>

                        <!--\\\\\\\\\\\\\\\\\\\INICIO LISTAGEM///////////////-->
                        <c:forEach var="b" items="${listaRapina}">
                            <h2 style="font-weight: 700; margin-top:30px ">Informações</h2>
                            <hr>
                            <div class="ifoCont">
                                <div class="resdoa">
                                    <h2 style="font-weight: 700;">Reservas</h2>
                                    <p>00211</p>
                                    <hr style="width: 290px;">
                                </div>
                                <div class="resdoa">
                                    <h2 style="font-weight: 700;">Doações</h2>
                                    <p>00095</p>
                                </div>
                            </div>
                        </c:forEach>    
                    </div>
                    <c:forEach var="b" items="${listaRapina}">    
                        <div id="hrvertical"></div>
                        <div class="infoRap">
                            <div class="infoRaptop">
                                <h2 style="font-weight: 700;">informações</h2>
                            </div>
                            <div class="infoRap1">
                                <p style="font-weight: bold;">Nome: <span style="font-weight: normal;"><c:out value="${b.nome}"/></span></p>
                                <p style="font-weight: bold;">Nascime.: <span style="font-weight: normal;"><c:out value="${b.data_nascimento}"/></span></p>
                            </div>
                            <div class="infoRap2">
                                <p style="font-weight: bold;">CPF: <span style="font-weight: normal;"><c:out value="${b.cpf}"/></span></p>
                                <p style="font-weight: bold;">Genêro: <span style="font-weight: normal;"><c:out value="${b.genero}"/></span></p>
                            </div>
                            <div class="infoRap3">
                                <p style="font-weight: bold;" style="margin-left:0px;">Ass. Newslatter: <span style="font-weight: normal;"><c:out value="${b.concorda_newstalleter}"/></span></p><br>
                                <p style="font-weight: bold;" id="infoRapemal" style="margin-left:0px;">Email: <span style="font-weight: normal;"><c:out value="${b.email}"/></span></p>
                                <hr>
                            </div>
                            <h2 style="margin-top: 180px;">Senha cadastrada: <span style="font-weight: normal;"><c:out value="${b.senha}"/></span></h2>
                            <hr>
                        </div>
                    </c:forEach> 
                </div>
            </div>

            <!--\\\\\\\\\\\\\\\\\\\LOJAS PARCEIRAS///////////////-->
            <div class="consulLojas">
                <div class="consulLojastop">
                    <h2 style="font-weight: bold;">Consultar Lojas parceiras</h2>
                    <form action="${pageContext.request.contextPath}/BuscaLojas" method="get">
                        <div class="codEsta">
                            <input type="text" name="pegaIdEsta" placeholder="Digite o cód. estabelecimento">
                            <button type="submit" name="btn" value="confirmaEsta">ok</button>
                        </div>
                    </form>
                </div>

                <!--\\\\\\\\\\\\\\\\\\\INICIO LISTAGEM///////////////-->
                <c:forEach var="a" items="${lista}">
                    <div class="linha">
                        <h3 style="font-weight: bold;">Status</h3>
                        <div class="sublinha1">
                            <p id="statustxt" style="font-weight: bold;"> Cliente está ativo? R: <span style="font-weight: normal; font-style: italic ; color: #4361EE;"><c:out value="${a.esta_status}"/></span></p>
                        </div>
                    </div>
                    <hr>
                    <div class="linha2">
                        <div class="sublinha21">
                            <h3 style="font-weight: bold;">Plano</h3><br>
                            <p style="margin-left: -41px;"><c:out value="${a.id_planos}"/></p>
                        </div>
                        <div class="sublinha22">
                            <h3 style="font-weight: bold;">Reservas Recebidas</h3>
                            <p>000013</p>
                        </div>
                    </div>
                    <hr>
                    <div class="linha3">
                        <h3 style="font-weight: bold;">Informações</h3>
                        <div class="sublinha31">
                            <p id="nomeesta" style="font-weight: bold;">Nome: <span style="font-weight: normal;"><c:out value="${a.nome_estabelecimento}"/></span></p>
                            <p style="font-weight: bold; margin-left: 80px; ">CNPJ: <span style="font-weight: normal;"><c:out value="${a.cnpj}"/></span></p>
                            <p style="font-weight: bold;">Endereço: <span style="font-weight: normal;"><c:out value="${a.logadouro_estabelecimento}"/></span></p>
                        </div>

                        <div class="sublinha32">
                            <p style="font-weight: bold;">CEP: <span style="font-weight: normal;"><c:out value="${a.cep_estabelecimento}"/></span></p>
                            <p id="numEd"style="font-weight: bold; margin-left: 50px;">Num: <span style="font-weight: normal;"><c:out value="${a.numero}"/></span></p>
                            <p style="font-weight: bold; margin-left: 12px;">Celular: <span style="font-weight: normal;"><c:out value="${a.celular}"/></span></p>
                        </div>
                    </div>
                    <hr>
                    <div class="linha4">
                        <div class="sublinha41">
                            <p id="acessAzul"style="font-weight: bold;">Acessi. Aud.: <span style="font-weight: normal;"><c:out value="${a.acessi_auditiva}"/></span>
                                <span style="font-weight: bold; margin-left: 30px; ">Acessi. Fis.:</span><span style="font-weight: normal;"><c:out value="${a.acessi_fisico}"/></span></p>

                            <p id="capLaranja" style="font-weight: bold;">Capacidade: <span style="font-weight: normal;"><c:out value="${a.capacidade}"/></span></p>
                            <p id="valRoxo" style="font-weight: bold; margin-left: -10px;">Valor taxa de Cancelamento: <span style="font-weight: normal;">R$ <c:out value="${a.taxa_cancelamento}"/></span></p>
                        </div>
                        <div class="sublinha42">
                            <p style="font-weight: bold; margin-left: 0px;">Newslatter: <span style="font-weight: normal;"><c:out value="${a.concorda_newstalleter}"/></span></p>
                            <p id="emailesta" style="font-weight: bold; margin-left: 38px;">Email: <span style="font-weight: normal;"><c:out value="${a.email}"/></span></p>
                        </div>
                    </div>
                    <hr>
                    <div class="linha5" style="margin-top:25px;">
                        <h3 style="font-weight: bold;">Senha cadastrada: <span style="font-weight: normal;"><c:out value="${a.senha}"/></span></h3>
                        <hr>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>