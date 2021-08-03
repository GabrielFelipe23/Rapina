<%-- 
    TELA REFERENTE AO MARCO II

    Document   : TelaCadastroEsta
    Created on : 28 de abr de 2021, 18:24:32
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/CSS/cadastroEsta.css"/>
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/icons/logotipo.png">
        <title>Loja Parceira- Cadastro</title>

        <style>
            .erroInput{
                border: 1px solid red;
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
        <div class="boy">
            <div class="linha">
                <div class="cubo">

                    <div class="bloco">
                        <!--FORMULARIO-->
                        <form action="${pageContext.request.contextPath}/ControlaEsta" method="post">

                            <div class="svg">
                                <svg width="18" height="19" viewBox="0 0 18 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path opacity="0.4" d="M9 0C6.243 0 4 2.243 4 5C4 7.757 6.243 10 9 10C11.757 10 14 7.757 14 5C14 2.243 11.757 0 9 0ZM9 8C7.346 8 6 6.654 6 5C6 3.346 7.346 2 9 2C10.654 2 12 3.346 12 5C12 6.654 10.654 8 9 8ZM18 19V18C18 14.141 14.859 11 11 11H7C3.14 11 0 14.141 0 18V19H2V18C2 15.243 4.243 13 7 13H11C13.757 13 16 15.243 16 18V19H18Z" fill="black"/>
                                </svg>
                            </div>  


                            <!--INPUT NOME-->
                            <input type="text" id="nome" name="nome" placeholder="Digite seu nome" value="${esta.nome_estabelecimento}" class="text373 ${not empty ErroNome ? 'erroInput' : '' }">

                            <div class="margin"></div>

                            <div class="svg">
                                <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <g opacity="0.4">
                                <path d="M1 5V3C1 2.46957 1.21071 1.96086 1.58579 1.58579C1.96086 1.21071 2.46957 1 3 1H5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M1 13V15C1 15.5304 1.21071 16.0391 1.58579 16.4142C1.96086 16.7893 2.46957 17 3 17H5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M13 1H15C15.5304 1 16.0391 1.21071 16.4142 1.58579C16.7893 1.96086 17 2.46957 17 3V5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M13 17H15C15.5304 17 16.0391 16.7893 16.4142 16.4142C16.7893 16.0391 17 15.5304 17 15V13" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M6 7H6.01" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M12 7H12.01" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M6.5 12C6.82588 12.3326 7.21485 12.5968 7.64413 12.7772C8.07341 12.9576 8.53436 13.0505 9 13.0505C9.46564 13.0505 9.92659 12.9576 10.3559 12.7772C10.7852 12.5968 11.1741 12.3326 11.5 12" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                </g>
                                </svg>                
                            </div> 

                            <!--INPUT CNPJ-->
                            <input type="text" id="cnpj" name="cnpj" placeholder="Informe o CNPJ" value="${esta.cnpj}" class="text270 ${not empty ErroCnpj ? 'erroInput' : '' }">

                            <div class="margin"></div>

                            <div class="svg">
                                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M12 21C16.9706 21 21 16.9706 21 12C21 7.02944 16.9706 3 12 3C7.02944 3 3 7.02944 3 12C3 16.9706 7.02944 21 12 21Z" stroke="black" stroke-opacity="0.2" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M3.6001 9H20.4001" stroke="black" stroke-opacity="0.2" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M3.6001 15H20.4001" stroke="black" stroke-opacity="0.2" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M11.5002 3C9.8155 5.69961 8.92236 8.81787 8.92236 12C8.92236 15.1821 9.8155 18.3004 11.5002 21" stroke="black" stroke-opacity="0.2" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M12.5 3C14.1847 5.69961 15.0778 8.81787 15.0778 12C15.0778 15.1821 14.1847 18.3004 12.5 21" stroke="black" stroke-opacity="0.2" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                </svg>                
                            </div>    
                            <!--INPUT CEP-->
                            <input type="text" id="cep" name="cep" placeholder="Digite o CEP" value="${esta.cep_estabelecimento}" class="text270 ${not empty ErroCep ? 'erroInput' : '' }">

                            <div class="svg">
                                <svg width="20" height="19" viewBox="0 0 20 19" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M12.5608 7.48957L11.9269 7.1954L11.4327 7.68955L9.96273 9.15955L9.25562 9.86666L9.25665 9.86768L8.55376 10.5685L4.56665 14.5441L11.4269 7.68376L11.9211 7.18962L11.6269 6.55572C11.1409 5.50827 11.4257 3.79566 12.806 2.41473C13.6241 1.60124 14.5916 1.1444 15.4633 1.0293C16.3345 0.914252 17.0494 1.14045 17.5127 1.60376C17.9815 2.07251 18.2069 2.78998 18.0911 3.65964C17.9751 4.53085 17.5162 5.49604 16.7027 6.30955C15.3216 7.69064 13.6085 7.97575 12.5608 7.48957ZM1.29264 1.90249L6.77512 7.37716L5.35899 8.79329L1.87796 5.32057C1.87767 5.32027 1.87737 5.31998 1.87708 5.31968C1.31539 4.75591 1 3.99251 1 3.19666C1 2.74458 1.10177 2.30298 1.29264 1.90249Z" stroke="black" stroke-opacity="0.25" stroke-width="2"/>
                                </svg>                                                             
                            </div>    

                            <!--INPUT ENDEREÇO-->
                            <input type="text" id="endereco" name="endereco" placeholder="Qual é o endereço do estabelecimento?" value="${esta.logadouro_estabelecimento}" class="text697 ${not empty ErroEndereco ? 'erroInput' : '' }">

                            <div class="margin"></div>

                            <div class="svg">
                                <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M17.8043 6.11413C17.912 6.11413 18 6.02609 18 5.91848V4.45109C18 4.34348 17.912 4.25543 17.8043 4.25543H13.7935V0.195652C13.7935 0.0880435 13.7054 0 13.5978 0H12.0326C11.925 0 11.837 0.0880435 11.837 0.195652V4.25543H6.26087V0.195652C6.26087 0.0880435 6.17283 0 6.06522 0H4.5C4.39239 0 4.30435 0.0880435 4.30435 0.195652V4.25543H0.195652C0.0880435 4.25543 0 4.34348 0 4.45109V5.91848C0 6.02609 0.0880435 6.11413 0.195652 6.11413H4.30435V11.8859H0.195652C0.0880435 11.8859 0 11.9739 0 12.0815V13.5489C0 13.6565 0.0880435 13.7446 0.195652 13.7446H4.30435V17.8043C4.30435 17.912 4.39239 18 4.5 18H6.06522C6.17283 18 6.26087 17.912 6.26087 17.8043V13.7446H11.837V17.8043C11.837 17.912 11.925 18 12.0326 18H13.5978C13.7054 18 13.7935 17.912 13.7935 17.8043V13.7446H17.8043C17.912 13.7446 18 13.6565 18 13.5489V12.0815C18 11.9739 17.912 11.8859 17.8043 11.8859H13.7935V6.11413H17.8043ZM11.837 11.8859H6.26087V6.11413H11.837V11.8859Z" fill="black" fill-opacity="0.3"/>
                                </svg>                
                            </div>     
                            <!--INPUT NUMERO-->                    
                            <input type="text" id="num" name="numero" placeholder="Número" value="${esta.numero}" class="text270 ${not empty ErroNumero ? 'erroInput' : '' }">


                            <div class="acessi">
                                <h1>Seu estabelecimento tem normas de acessibilidade para esses públicos?</h1>
                                <div class="radio">
                                    <label for="Cadeirantes">
                                        <!--INPUT CADEIRANTES-->
                                        <input type="radio" id="Cadeirantes" name="defFis" value="Sim" value="${esta.acessi_fisico}">
                                        <p>Cadeirantes</p>
                                    </label>
                                    <div class="marginRadio"></div>
                                    <label for="audi">
                                        <!--INPUT AUDITIVO-->
                                        <input type="radio" id="audi" name="defAud" value="Sim" value="${esta.acessi_auditiva}">
                                        <p>Deficientes auditivos</p>
                                    </label>
                                    <div class="marginRadio"></div>
                                    <label for="Nãotenho">
                                        <!--INPUT NENHUM-->
                                        <input type="radio" id="Nãotenho" name="Não" value="Nãotenho" value="${esta.acessi_nenhuma}">
                                        <p>Não tenho</p>
                                    </label>
                                </div>
                            </div>

                            <!--INPUT HORARIO-->
                            <input type="text" id="horario" name="horario_de_fun" placeholder="Horário de funcionamento" value="${esta.horario_funcionamento}" class="horario ${not empty ErroHorario ? 'erroInput' : '' }">
                            <div class="svghora">
                                <svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <g opacity="0.4">
                                <path d="M17 3H5C2.79086 3 1 4.79086 1 7V17C1 19.2091 2.79086 21 5 21H17C19.2091 21 21 19.2091 21 17V7C21 4.79086 19.2091 3 17 3Z" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M7 1V5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M15 1V5" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                <path d="M1 9H21" stroke="black" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                </g>
                                </svg>            
                            </div>

                            <div class="svg">
                                <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M18 1.125C18 0.826631 17.8815 0.540484 17.6705 0.329505C17.4595 0.118527 17.1734 0 16.875 0H11.25C10.9516 0 10.6655 0.118527 10.4545 0.329505C10.2435 0.540484 10.125 0.826631 10.125 1.125C10.125 1.42337 10.2435 1.70952 10.4545 1.92049C10.6655 2.13147 10.9516 2.25 11.25 2.25H14.1412L10.4513 5.95125C10.3458 6.05583 10.2621 6.18026 10.205 6.31735C10.1479 6.45444 10.1185 6.60149 10.1185 6.75C10.1185 6.89851 10.1479 7.04556 10.205 7.18265C10.2621 7.31974 10.3458 7.44417 10.4513 7.54875C10.5558 7.65419 10.6803 7.73789 10.8174 7.795C10.9544 7.85212 11.1015 7.88152 11.25 7.88152C11.3985 7.88152 11.5456 7.85212 11.6826 7.795C11.8197 7.73789 11.9442 7.65419 12.0487 7.54875L15.75 3.8475V6.75C15.75 7.04837 15.8685 7.33452 16.0795 7.5455C16.2905 7.75647 16.5766 7.875 16.875 7.875C17.1734 7.875 17.4595 7.75647 17.6705 7.5455C17.8815 7.33452 18 7.04837 18 6.75V1.125ZM7.54875 10.4513C7.44417 10.3458 7.31974 10.2621 7.18265 10.205C7.04556 10.1479 6.89851 10.1185 6.75 10.1185C6.60149 10.1185 6.45444 10.1479 6.31735 10.205C6.18026 10.2621 6.05583 10.3458 5.95125 10.4513L2.25 14.1412V11.25C2.25 10.9516 2.13147 10.6655 1.92049 10.4545C1.70952 10.2435 1.42337 10.125 1.125 10.125C0.826631 10.125 0.540484 10.2435 0.329505 10.4545C0.118527 10.6655 0 10.9516 0 11.25V16.875C0 17.1734 0.118527 17.4595 0.329505 17.6705C0.540484 17.8815 0.826631 18 1.125 18H6.75C7.04837 18 7.33452 17.8815 7.5455 17.6705C7.75647 17.4595 7.875 17.1734 7.875 16.875C7.875 16.5766 7.75647 16.2905 7.5455 16.0795C7.33452 15.8685 7.04837 15.75 6.75 15.75H3.8475L7.54875 12.0487C7.65419 11.9442 7.73789 11.8197 7.795 11.6826C7.85212 11.5456 7.88152 11.3985 7.88152 11.25C7.88152 11.1015 7.85212 10.9544 7.795 10.8174C7.73789 10.6803 7.65419 10.5558 7.54875 10.4513Z" fill="black" fill-opacity="0.3"/>
                                </svg>                
                            </div>   

                            <!--INPUT CAPACIDADE-->
                            <input type="text" id="capmes" name="capacidade" placeholder="Qual é a capacidade de mesas?" maxlength="2" class="text373 ${not empty ErroCap ? 'erroInput' : '' }">

                            <div class="margin"></div>

                            <div class="svg">
                                <svg width="11" height="18" viewBox="0 0 11 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path d="M5.48 7.9C3.21 7.31 2.48 6.7 2.48 5.75C2.48 4.66 3.49 3.9 5.18 3.9C6.96 3.9 7.62 4.75 7.68 6H9.89C9.82 4.28 8.77 2.7 6.68 2.19V0H3.68V2.16C1.74 2.58 0.18 3.84 0.18 5.77C0.18 8.08 2.09 9.23 4.88 9.9C7.38 10.5 7.88 11.38 7.88 12.31C7.88 13 7.39 14.1 5.18 14.1C3.12 14.1 2.31 13.18 2.2 12H0C0.12 14.19 1.76 15.42 3.68 15.83V18H6.68V15.85C8.63 15.48 10.18 14.35 10.18 12.3C10.18 9.46 7.75 8.49 5.48 7.9Z" fill="black" fill-opacity="0.3"/>
                                </svg>                
                            </div>  

                            <!--INPUT VALOR TAXA-->
                            <input type="text" id="valcan" name="valCancela" placeholder="Valor do Cancelamento" class="text270 ${not empty ErroTaxa ? 'erroInput' : '' }">

                            <div class="margin"></div>

                            <div class="svg">
                                <svg width="18" height="18" viewBox="0 0 18 18" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path opacity="0.3" d="M11.9389 13.2886L12.1815 13.3189L12.3544 13.146L13.9022 11.5976C13.9025 11.5972 13.9028 11.5969 13.9031 11.5966C14.0429 11.4589 14.2195 11.3647 14.4116 11.3252C14.6037 11.2858 14.8032 11.3029 14.9858 11.3745C14.9862 11.3746 14.9866 11.3748 14.9869 11.3749L16.8708 12.1274C16.8712 12.1276 16.8716 12.1277 16.872 12.1279C17.056 12.2029 17.2137 12.3305 17.3255 12.4949C17.4371 12.6591 17.4978 12.8526 17.5 13.0511V16.5075C17.4987 16.6422 17.4703 16.7752 17.4165 16.8986C17.3624 17.0226 17.2839 17.1343 17.1856 17.227C17.0872 17.3198 16.9712 17.3917 16.8444 17.4383C16.7184 17.4847 16.5844 17.5053 16.4503 17.4988C9.99645 17.0964 6.15615 14.1741 3.85229 10.849C1.53311 7.5017 0.754087 3.71801 0.505991 1.61159C0.4906 1.47142 0.504946 1.32957 0.548095 1.19533C0.59139 1.06062 0.6627 0.936629 0.757322 0.8315C0.851942 0.726372 0.967729 0.64249 1.09706 0.585362C1.22638 0.528234 1.36633 0.499151 1.50768 0.500019V0.500028H1.51075H4.85208C5.05026 0.500749 5.24374 0.560698 5.40767 0.672215L5.6889 0.258805L5.40767 0.672216C5.57179 0.78386 5.6988 0.942092 5.77233 1.12658L5.77241 1.1268L6.52664 3.0166L6.52663 3.0166L6.528 3.01996C6.60182 3.20109 6.62065 3.39998 6.58214 3.59176C6.54367 3.78337 6.44968 3.95938 6.31192 4.09786C6.31179 4.09799 6.31166 4.09812 6.31153 4.09825L4.76221 5.6482L4.58446 5.82602L4.6212 6.07474L5.11583 6.00168C4.6212 6.07474 4.62123 6.075 4.62128 6.07527L4.62138 6.07594L4.62164 6.0777L4.62243 6.08286L4.62512 6.09966C4.62741 6.1137 4.63074 6.13337 4.63523 6.15832C4.64421 6.2082 4.65785 6.27925 4.67722 6.36867C4.71594 6.54739 4.77765 6.80009 4.8709 7.1042C5.05702 7.71115 5.37096 8.52999 5.88357 9.37586C6.91385 11.076 8.75462 12.8914 11.9389 13.2886Z" stroke="black"/>
                                </svg>                
                            </div>               
                            <!--INPUT CELULAR-->
                            <input type="text" id="cel" name="celular" placeholder="Informe o celular" value="${esta.celular}"  class="text270 ${not empty ErroCelular ? 'erroInput' : '' }">

                            <div class="svg">
                                <svg width="21" height="16" viewBox="0 0 21 16" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path opacity="0.3" d="M20.0744 2C20.0744 0.9 19.1726 0 18.0705 0H2.03908C0.936923 0 0.0351562 0.9 0.0351562 2V14C0.0351562 15.1 0.936923 16 2.03908 16H18.0705C19.1726 16 20.0744 15.1 20.0744 14V2ZM18.0705 2L10.0548 7L2.03908 2H18.0705ZM18.0705 14H2.03908V4L10.0548 9L18.0705 4V14Z" fill="black"/>
                                </svg>                
                            </div>      
                            <!--INPUT EMAIL-->
                            <input type="text" id="email" name="email" placeholder="Email para login" value="${esta.email}" class="text373 ${not empty ErroEmail ? 'erroInput' : '' }">

                            <div class="margin"></div>

                            <div class="svg">
                                <svg width="20" height="20" viewBox="0 0 20 20" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path opacity="0.4" d="M15 5H20V15H15V17C15 17.2652 15.1054 17.5196 15.2929 17.7071C15.4804 17.8946 15.7348 18 16 18H18V20H15.5C14.95 20 14 19.55 14 19C14 19.55 13.05 20 12.5 20H10V18H12C12.2652 18 12.5196 17.8946 12.7071 17.7071C12.8946 17.5196 13 17.2652 13 17V3C13 2.73478 12.8946 2.48043 12.7071 2.29289C12.5196 2.10536 12.2652 2 12 2H10V0H12.5C13.05 0 14 0.45 14 1C14 0.45 14.95 0 15.5 0H18V2H16C15.7348 2 15.4804 2.10536 15.2929 2.29289C15.1054 2.48043 15 2.73478 15 3V5ZM0 5H11V7H2V13H11V15H0V5ZM18 13V7H15V13H18ZM6.5 10C6.5 9.60218 6.34196 9.22064 6.06066 8.93934C5.77936 8.65804 5.39782 8.5 5 8.5C4.60218 8.5 4.22064 8.65804 3.93934 8.93934C3.65804 9.22064 3.5 9.60218 3.5 10C3.5 10.3978 3.65804 10.7794 3.93934 11.0607C4.22064 11.342 4.60218 11.5 5 11.5C5.39782 11.5 5.77936 11.342 6.06066 11.0607C6.34196 10.7794 6.5 10.3978 6.5 10ZM11 8.89C10.39 8.33 9.44 8.38 8.88 9C8.32 9.6 8.37 10.55 9 11.11C9.55 11.63 10.43 11.63 11 11.11V8.89Z" fill="black"/>
                                </svg>                
                            </div>      
                            <!--INPUT SENHA-->
                            <input type="password" id="senha" name="senha" placeholder="Digite uma senha" class="text270 ${not empty ErroSenhaRe ? 'erroInput' : '' }">

                            <div class="margin"></div>

                            <div class="svg">
                                <svg width="18" height="21" viewBox="0 0 18 21" fill="none" xmlns="http://www.w3.org/2000/svg">
                                <path opacity="0.4" d="M15 7H17C17.2652 7 17.5196 7.10536 17.7071 7.29289C17.8946 7.48043 18 7.73478 18 8V20C18 20.2652 17.8946 20.5196 17.7071 20.7071C17.5196 20.8946 17.2652 21 17 21H1C0.734784 21 0.48043 20.8946 0.292893 20.7071C0.105357 20.5196 0 20.2652 0 20V8C0 7.73478 0.105357 7.48043 0.292893 7.29289C0.48043 7.10536 0.734784 7 1 7H3V6C3 4.4087 3.63214 2.88258 4.75736 1.75736C5.88258 0.632141 7.4087 0 9 0C10.5913 0 12.1174 0.632141 13.2426 1.75736C14.3679 2.88258 15 4.4087 15 6V7ZM2 9V19H16V9H2ZM8 13H10V15H8V13ZM4 13H6V15H4V13ZM12 13H14V15H12V13ZM13 7V6C13 4.93913 12.5786 3.92172 11.8284 3.17157C11.0783 2.42143 10.0609 2 9 2C7.93913 2 6.92172 2.42143 6.17157 3.17157C5.42143 3.92172 5 4.93913 5 6V7H13Z" fill="black"/>
                                </svg>                   
                            </div>       
                            <!--INPUT CONFIRMA SENHA-->
                            <input type="password" id="senhacon" name="senhaRe" placeholder="Confirme a sua senha" class="text270 ${not empty ErroSenhaRe ? 'erroInput' : '' }">

                            <div class="terms">
                                <!--INPUT CONDIÇÃO TERMOS-->
                                <input type="checkbox" id="condicoes" name="concordar" value="Sim" value="${esta.concorda}">
                                <label for="condicoes"><p id="Pcond">Concordo com os termos e condições de uso</p></label>

                                <!--INPUT NEWS-->
                                <input type="checkbox" id="novidades" name="concordarNews" value="Sim" value="${esta.concorda_newstalleter}">
                                <label for="novidades"><p>Eu aceito receber novidades e ofertas Rapina</p></label>

                            </div>

                            <div class="cadastrar">
                                <button type="Submit">Cadastrar</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>