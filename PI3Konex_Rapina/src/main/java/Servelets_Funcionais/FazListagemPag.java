/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.PagamentoDAO;
import ClassesJavaBean.Pagamento_taxa;
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
 * @author gusta
 */
@WebServlet(name = "FazListagemPag", urlPatterns = {"/FazListagemPag"})
public class FazListagemPag extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String opcao = request.getParameter("opcoes");
        List<Pagamento_taxa> listaDados;

        PagamentoDAO pagDAO = new PagamentoDAO();

        if (opcao.equalsIgnoreCase("Rapinista")) {

            try {
                listaDados = pagDAO.listarDadosPagCli();

                request.setAttribute("listaPag", listaDados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuADM.jsp");
                dispatcher.forward(request, response);
                return;
            } catch (SQLException ex) {
                Logger.getLogger(BuscaPagamentos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (opcao.equalsIgnoreCase("Estabelecimento")) {

            try {
                listaDados = pagDAO.listarDadosPagEsta();
                request.setAttribute("listaPag", listaDados);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuADM.jsp");
                dispatcher.forward(request, response);
                return;
            } catch (SQLException ex) {
                Logger.getLogger(BuscaPagamentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
