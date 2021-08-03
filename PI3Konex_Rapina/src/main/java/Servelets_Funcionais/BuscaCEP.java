/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.EstabelecimentoDAO;
import ClassesJavaBean.Estabelecimento;
import java.io.IOException;
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
@WebServlet(name = "BuscaCEP", urlPatterns = {"/BuscaCEP"})
public class BuscaCEP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //pega os parametros do jsp
        String cep = request.getParameter("cepDigitado");
        //var verificadora
        boolean temErro = false;

        //verififca se é null ou vazia
        if (cep != null && cep.trim().length() > 0) {
            temErro = false;

        } else {
            temErro = true;
            request.setAttribute("erro", temErro);
        }

        //verifica se tem erro
        if (temErro) {
            //não prossegue
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/BuscaCep.jsp");
            dispatcher.forward(request, response);
        } else {
            //constroe o objeto DAO
            EstabelecimentoDAO actionBusca = new EstabelecimentoDAO();

            List<Estabelecimento> listaRest;
            try {
                listaRest = actionBusca.retornaRestCep(cep);

                //cria uma sessao do cep
                HttpSession sessao = request.getSession();
                sessao.setAttribute("buscaEstabelecimento", listaRest);
                response.sendRedirect(request.getContextPath() + "/ResultadoBusca");
                
            } catch (SQLException ex) {
                Logger.getLogger(ListaRestaurantesBuscados.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
}