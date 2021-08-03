/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;


import ClassesJavaBean.Login;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "TerminaSession", urlPatterns = {"/ExitSession"})
public class TerminaSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        int tipoUser = 0;
        //Verifica se na sessao possui dados do Tipo do Usuario
        if (sessao.getAttribute("logUser")!=null) {
            Login logUser = (Login) sessao.getAttribute("dadosAcesso");
            tipoUser = logUser.getTipo_usuario();//pega o Tipo do Usuario da Sessao
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/Home.jsp");
            dispatcher.forward(request, response);
            return;
        }       
        
        String botao = request.getParameter("btn");
        if (botao != null) {
            if (botao.equals("cancela")) {//Se o botao clicado for o Cancelado, pego o ID e verifica
                if (tipoUser == 1) { //Redireciona para o MenuADM caso o 1
                    response.sendRedirect(request.getContextPath() + "/segura/MenuADM");
                } else if (tipoUser == 2) {//Redireciona para o MenuCliente caso o 2
                    response.sendRedirect(request.getContextPath() + "/segura/MenuCliente");
                } else if (tipoUser == 3) {//Redireciona para o MenuEsta caso o 3
                    response.sendRedirect(request.getContextPath() + "/segura/MenuEsta");
                }

            } else if (botao.equals("sair")) {//Se o botao clicado for Sair, invalido a Sessão  e retorno a Home
                sessao.invalidate();
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/Home.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
