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

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "BuscaLojas", urlPatterns = {"/BuscaLojas"})
public class BuscaLojas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //pegar o parametro id do estabelecimento e Rapinante
        String id = request.getParameter("pegaIdEsta");
        String botao = request.getParameter("btn");

        //VAR
        boolean temErro = false;
        int idEs = 0;

        //validar o parametro id
        if (id != null && id.trim().length() > 0) {
            idEs = Integer.parseInt(id);
            temErro = false;
        } else {
            temErro = false;
        }

        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuADM.jsp");
            dispatcher.forward(request, response);
        } else {
            //verificar se o botao foi pressionado
            if (botao.equals("confirmaEsta")) {
                //constroe o objeto DAO
                EstabelecimentoDAO actionDAO = new EstabelecimentoDAO();

                //chama o metodo que retorna uma lista de usuarios 
                List<Estabelecimento> listaDados;
                try {
                    listaDados = actionDAO.listarDadosADM(idEs);

                    //despacha a tela do menu ADM
                    request.setAttribute("lista", listaDados);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuADM.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(BuscaLojas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
