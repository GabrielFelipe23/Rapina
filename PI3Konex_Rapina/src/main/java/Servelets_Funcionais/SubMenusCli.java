/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ClienteDAO;
import ClassesDAO.FavoritoDAO;
import ClassesJavaBean.Cartao;
import ClassesJavaBean.Cliente;
import ClassesJavaBean.Favoritos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "SubMenusCli", urlPatterns = {"/SubMenusCli"})
public class SubMenusCli extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Cliente cli = new Cliente();
        int idCli = 0;
        Cartao cartao = new Cartao();
        HttpSession session = request.getSession();

        if (session.getAttribute("cli") != null && session.getAttribute("cartao") != null) {
            cli = (Cliente) session.getAttribute("cli");
            cartao = (Cartao) session.getAttribute("cartao");
            idCli = cli.getId_usuario();

        }
        String botao = request.getParameter("btn");
        if (botao != null) {
            if (botao.equals("alteraCartao")) {
                request.setAttribute("cartao", cartao);
                session.setAttribute("cartao", cartao);
                response.sendRedirect(request.getContextPath() + "/TelaAltCard");

            } else if (botao.equals("alteraDadosCli")) {
                request.setAttribute("cli", cli);
                session.setAttribute("cli", cli);
                response.sendRedirect(request.getContextPath() + "/TelaAlteraDados");

            } else if (botao.equals("telaDuvidas")) {
                response.sendRedirect(request.getContextPath() + "/CriaTelaDuvidas");
            } else if (botao.equals("telaDoacao")) {
                FavoritoDAO favDao = new FavoritoDAO();
                ClienteDAO cliDao = new ClienteDAO();
                Favoritos fav = new Favoritos();
                List<Favoritos> listaNomes;
                List<Cartao> listaCartao;
                try {
                    listaNomes = favDao.listarDadosFavoritos(idCli);
                    listaCartao = cliDao.listaIDCartao(idCli);
                    session.setAttribute("listaNomes", listaNomes);
                    session.setAttribute("listaCartao", listaCartao);
                    session.setAttribute("idP", idCli);
                    response.sendRedirect(request.getContextPath() + "/TelaDoacao");
                } catch (SQLException ex) {
                    Logger.getLogger(SubMenusCli.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (botao.equals("telaNotifica")) {
                response.sendRedirect(request.getContextPath() + "/CriaListaNotifica");
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  
}
