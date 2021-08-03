/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.PlanosDAO;
import ClassesJavaBean.Planos;
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

/**
 *
 * @author Alex Yudy Kitahara
 */
@WebServlet(name = "TelaAltPlano", urlPatterns = {"/TelaAltPlano"})
public class TelaAltPlano extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id_esta = 3;
        PlanosDAO dao = new PlanosDAO();

        try {
            List<Planos> listaDados;
            listaDados = dao.planosPorID(id_esta);
            request.setAttribute("ListaPlano", listaDados);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(TelaAltPlano.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
