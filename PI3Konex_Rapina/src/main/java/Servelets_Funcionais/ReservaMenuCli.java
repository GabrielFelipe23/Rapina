/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ReservaDAO;
import ClassesJavaBean.Login;
import ClassesJavaBean.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "ReservaMenuCli", urlPatterns = {"/ControleReservaCli"})
public class ReservaMenuCli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //recupera a sessao
        Login logUser = new Login();
        int id = 0;

        //Pegando a Sessao da tela anterior
        HttpSession sessaoUser = request.getSession();

        //verificamos se a session tem algum dado para ser obtido
        if (sessaoUser.getAttribute("dadosAcesso") != null) {
            //trasfiro os dados da session anterio pra o novo objeto
            logUser = (Login) sessaoUser.getAttribute("dadosAcesso");

            //setando os valaores para as variaveis que utilizaremos
            id = logUser.getId_usuario();

            //Setando o objeto para parametro
            request.setAttribute("logUser", logUser);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaLogSenha.jsp");
            dispatcher.forward(request, response);
        }

        //Parametros da JSP
        String idLine = request.getParameter("lineIdReserva");
        String taxa = request.getParameter("lineValorTaxa");
        String btn = request.getParameter("btn");
        //Parametros para Ver
        String nomeRes = request.getParameter("lineNomeRest");
        String enderecoRes = request.getParameter("lineEndereco");
        String numResStr = request.getParameter("lineNumero");
        String dataRes = request.getParameter("lineDataRes");
        String horaRes = request.getParameter("lineHoraRes");
        //verifica se o idLinha é diferente de null
        if (idLine != null && idLine.trim().length() > 0) {
            //prossegue com a jornada verificando qual botão foi acionado
            if (btn.equals("cancelaReserva")) {
                //converte var
                int idReserva= Integer.parseInt(idLine);
                float vTaxa= Float.parseFloat(taxa);
                
                //puxa os dados
                ReservaDAO actionRes = new ReservaDAO();
                List<Reserva> listaRes;
                
                try {
                    //Chama o metodo que retorna lista de Reservas e Dados do Estabelecimento
                    listaRes = actionRes.listarReservaCli(id);
                    
                    //despacha a sessaoUser 
                    sessaoUser.setAttribute("listaReservasCli", listaRes);
                    sessaoUser.setAttribute("numReserva", idReserva);
                    sessaoUser.setAttribute("valorTaxa", vTaxa);
                    
                    //chama a tela de confirmação
                    response.sendRedirect(request.getContextPath() + "/Cancelamento");
                } catch (SQLException ex) {
                    Logger.getLogger(ReservaMenuCli.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if (btn.equals("verTicket")) {
                //converte var
                int codReserva= Integer.parseInt(idLine);
                int numRes = Integer.parseInt(numResStr);
                
                //puxa os dados
                //seto os parametros
                sessaoUser.setAttribute("codRes", codReserva); 
                sessaoUser.setAttribute("horaRes", horaRes); 
                sessaoUser.setAttribute("dataRes", dataRes); 
                sessaoUser.setAttribute("estaRes", nomeRes); 
                sessaoUser.setAttribute("endRes", enderecoRes); 
                sessaoUser.setAttribute("numRes", numRes); 

                //chama a tela
                response.sendRedirect(request.getContextPath() + "/CriaTelaVerTicket");
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
