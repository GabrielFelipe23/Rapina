/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.LoginDAO;
import ClassesJavaBean.Login;
import java.io.IOException;
import java.sql.SQLException;
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
@WebServlet(name = "TelaLoginEmail", urlPatterns = {"/LoginEmail"})
public class TelaLoginEmail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //boas praticas de uso
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Pega o atributo declarado no input do JSP
        String email = request.getParameter("email");

        //Variavel verificadora de erros
        boolean temErro = false;

        if (email != null && email.trim().length() > 0) {
            if (email.trim().length() <= 30) {
                temErro = false;
            }
        } else {
            temErro = true;
            //seta o erro
            request.setAttribute("erroEmail", " ");
        }

        //construimos o objeto 
        Login acesso = new Login(email);
        LoginDAO buscaBd = new LoginDAO();

        //setando o objeto
        request.setAttribute("acessoAtt", acesso);
        try {
            //verifica email
            int x = buscaBd.validaEmail(acesso);

            if (x != 0) {
                temErro = false;
                //passo o valor identificado para o 
                acesso.setTipo_usuario(x);
            } else {
                temErro = true;
                //seta o erro
                request.setAttribute("erroEmail", " ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaLoginEmail.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verificamos se há erro nos processos anteriores
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/LogEmail.jsp");
            dispatcher.forward(request, response);
        } else {
            //Inicia a sessao
            HttpSession sessao = request.getSession();

            //seta objeto que utilizaremos na proxima sessao
            sessao.setAttribute("dadosAcesso", acesso);

            //Redireciono para a proxima tela
            response.sendRedirect(request.getContextPath() + "/LogSenha");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
