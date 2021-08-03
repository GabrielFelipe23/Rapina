/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CriadoresServelets;

import ClassesDAO.ClienteDAO;
import ClassesJavaBean.Cliente;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author gusta
 */
@WebServlet(name = "CriaTelaListaCli", urlPatterns = {"/ListaCliente"})
public class CriaTelaListaCli extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("clientes") != null) {
            Cliente cli = (Cliente) sessao.getAttribute("clientes");
            ClienteDAO cliDao = new ClienteDAO();//Adicionei
            try {
                request.setAttribute("clientes", cliDao.listarTodos());
            } catch (SQLException ex) {
                Logger.getLogger(CriaTelaListaCli.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("cli", cli);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/ListaCliente.jsp");
            dispatcher.forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
