/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.EstabelecimentoDAO;
import ClassesDAO.LoginDAO;
import ClassesDAO.ReservaDAO;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Login;
import ClassesJavaBean.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ValidandoReserva", urlPatterns = {"/ConfirmaReserva"})
public class ValidandoReserva extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //pega os parametros
        String botao = request.getParameter("btn");
        //Sessão
        HttpSession sessao = request.getSession();
        Login logUser = new Login();
        
        int idUser =0;
        String email = "";
        
        //verificamos se a session tem algum dado para ser obtido
        if (sessao.getAttribute("dadosAcesso") != null) {
            //trasfiro os dados da session anterio pra o novo objeto
            logUser = (Login) sessao.getAttribute("dadosAcesso");
            //setando os valores para as variaveis que utilizaremos
            email = logUser.getEmail();
            System.out.println(logUser.getId_usuario());
            idUser = logUser.getId_usuario();

              
            //Setando o objeto para parametro
            request.setAttribute("logUser", logUser);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaLogEmail.jsp");
            dispatcher.forward(request, response);
        }
        
        String qtdA = request.getParameter("Acomp");
        String data = request.getParameter("dataReserva");
        String horario = request.getParameter("horaReserva");
        String idEstb = request.getParameter("idEstab");
        
        //var a ser convertidas
        int Acom = 0;
        int idEs = 0;
        
        if (qtdA != null && qtdA.trim().length() > 0) {
            Acom = Integer.parseInt(qtdA);
        }
        if (idEstb != null && idEstb.trim().length() > 0) {
            idEs = Integer.parseInt(idEstb);
        }
        
        //
        if(botao.equals("reservar")){
            //cosntroe a dao
            ReservaDAO actionRes = new ReservaDAO();
            EstabelecimentoDAO actionEst = new EstabelecimentoDAO();
            
            //var 
            int varRes =0;
            
            
            Date dataAtual = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dataAt = formatter.format(dataAtual);
            
            //objeto reserva
            Reserva reservar = new Reserva(idUser, idEs, Acom, dataAt, data,horario);
            
            //aciona o metodo
            varRes = actionRes.criaReserva(reservar);
            int codReserva= reservar.getNum_reserva();
            
           
            
            //puxa o endereço 
            List<Estabelecimento> dados;
            try {
                dados = actionEst.listarDadosADM(idEs);
                
                //seto os parametros 
                sessao.setAttribute("codRes", codReserva);
                sessao.setAttribute("qtdAcom", Acom);
                sessao.setAttribute("dataRes", data);
                sessao.setAttribute("horaRes", horario);
                sessao.setAttribute("dados", dados);
                sessao.setAttribute("user", idUser);
                
                //despacha a tela para o ticket.
                response.sendRedirect(request.getContextPath() + "/Ticket");
            } catch (SQLException ex) {
                Logger.getLogger(ValidandoReserva.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }else if(botao.equals("cancela")){
            //volta para o menu Cliente
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/BuscaCep.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
