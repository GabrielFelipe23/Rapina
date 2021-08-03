/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.NotificaDAO;
import ClassesJavaBean.Notification;
import ClassesJavaBean.Pagamento_mensalidade;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
 * @author gusta
 */
@WebServlet(name = "RespondePagEsta", urlPatterns = {"/RespondePagEsta"})
public class RespondePagEsta extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //parametros
        String botao = request.getParameter("btn");
        String idEstaStr = request.getParameter("lineIDEsta");
        String data = request.getParameter("lineData");
        String valorStr = request.getParameter("lineValor");
        String mensagem = request.getParameter("mensagem");
        //Sessao
        HttpSession sessao = request.getSession();
        boolean temErro = false;
        int id = 0;
        float valor = 0f;

        if (valorStr != null && valorStr.trim().length() > 0) {
            valor = Float.parseFloat(valorStr);
            if (idEstaStr != null && idEstaStr.trim().length() > 0) {
                 id = Integer.parseInt(idEstaStr);
                 if (botao.equals("notificaEsta")) {  
                            NotificaDAO notiDAO = new NotificaDAO();
                            String nome = null;
                     try {
                         nome = notiDAO.retornaNome(id);
                     } catch (SQLException ex) {
                         Logger.getLogger(RespondePagEsta.class.getName()).log(Level.SEVERE, null, ex);
                     }
                            //constroe o objeto
                            Pagamento_mensalidade pagMes = new Pagamento_mensalidade(id,data,valor);
                            pagMes.setNome(nome);
                            request.setAttribute("pagMes", pagMes);
                            
                            //constroe a sessao
                            sessao.setAttribute("dadosPagMes", pagMes);
                            response.sendRedirect(request.getContextPath() + "/CriaTelaPagEsta");
                        }

        }
            
        }     
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
