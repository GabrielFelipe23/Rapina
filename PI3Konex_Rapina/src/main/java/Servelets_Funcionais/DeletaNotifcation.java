/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.NotificaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "DeletaNotifcation", urlPatterns = {"/DeletaLineMsg"})
public class DeletaNotifcation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas    
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String idLinha = request.getParameter("lineId");
        String btn = request.getParameter("btn");
        
        //verifica se o idLinha é diferente de null
        if(idLinha != null && idLinha.trim().length() > 0){
            //verifica se o btn foi acionado
            if (btn.equals("btnDeleta")) {
                //converte o valor
                int idNoti = Integer.parseInt(idLinha);
                
                //constroe o objeto
                NotificaDAO notiDao = new NotificaDAO();
                
                //faz a ação de deletar
                try {
                    notiDao.removeNoti(idNoti);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaNotificacoes.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}