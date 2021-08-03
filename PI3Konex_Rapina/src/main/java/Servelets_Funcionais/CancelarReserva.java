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
@WebServlet(name = "CancelarReserva", urlPatterns = {"/CancelarReserva"})
public class CancelarReserva extends HttpServlet {

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
        String Numreserva = request.getParameter("lineIdReserva");
        String btn = request.getParameter("btn");

        //VAR PARA CONVERTE
        int idReserva = 0;

        //verifica se o idLinha é diferente de null
        if (Numreserva != null && Numreserva.trim().length() > 0) {
            //prossegue com a jornada verificando qual botão foi acionado
            if (btn.equals("Confirmar")) {
                //converte
                idReserva = Integer.parseInt(Numreserva);
                
                //pega o id da reserva e objeto que remove Reserva
                ReservaDAO actionReserva = new ReservaDAO();

                try {
                    //metodo que remove
                    actionReserva.cancelaReserva(idReserva);
                    
                    //lista as reservas novamente
                    List<Reserva> listaRes;
                    listaRes = actionReserva.listarReservaCli(id);
                    sessaoUser.setAttribute("listaReservasCli", listaRes);

                    //volta para o menu
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(CancelarReserva.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (btn.equals("voltar")) {
               
                //volta para o menu
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
                dispatcher.forward(request, response);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
