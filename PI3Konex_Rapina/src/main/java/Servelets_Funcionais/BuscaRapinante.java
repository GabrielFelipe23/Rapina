/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ClienteDAO;
import ClassesJavaBean.Cliente;
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
@WebServlet(name = "BuscaRapinante", urlPatterns = {"/BuscaRapina"})
public class BuscaRapinante extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //pegar o parametro id do estabelecimento
        String idR = request.getParameter("pegaIdRapinante");
        String botaoR = request.getParameter("btnR");

        //VAR
        int idRap = 0;

        //validar o parametro id
        if (idR != null && idR.trim().length() > 0) {
            idRap = Integer.parseInt(idR);
        }
        if (botaoR.equals("confirmaBusca")) {
            //constroe o objeto DAO
            ClienteDAO actionDAO = new ClienteDAO();

            //chama o metodo que retorna uma lista de usuarios 
            List<Cliente> listaD;
            try {
                listaD = actionDAO.listarDadosRapina(idRap);

                //despacha a tela do menu ADM
                request.setAttribute("listaRapina", listaD);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuADM.jsp");
                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(BuscaLojas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuADM.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
