/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.NotificaDAO;
import ClassesJavaBean.Notification;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author gusta
 */
@WebServlet(name = "ControlaDuvidas", urlPatterns = {"/ControlaDuvidas2"})
public class ControlaDuvidas2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Boas Praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //Pega os Parametros
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String mensagem = request.getParameter("mensagem");
        //Var que verifica se tem erro algum campo
        boolean temErro = false;

        if (nome != null && nome.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroNome", " ");
            }

        } else {
            temErro = true;
            request.setAttribute("erroNome", " ");
        }
        if (email != null && email.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroEmail", " ");
            }

        } else {
            temErro = true;
            request.setAttribute("erroEmail", " ");
        }
        if (mensagem != null && mensagem.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroMensagem", " ");
            }

        } else {
            temErro = true;
            request.setAttribute("erroMensagem", " ");
        }

        //Instancio os Objetos
        Notification noti = new Notification(nome, email, mensagem);
        NotificaDAO notiDao = new NotificaDAO();
        
        try {
            //var que auxilia no retorno da resposta pelo metodo
            int verificaDuvida = notiDao.criaDuvida(noti);
            
            //condições
            if (verificaDuvida == 1) {
                temErro = false;
            } else if (verificaDuvida == 0) {
                temErro = true;
            } else {
                temErro = true;
            }
        } catch (SQLException ex) {

        }
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/Home.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/Contato.jsp");
            dispatcher.forward(request, response);
        }
    }

}
