/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.FavoritoDAO;
import ClassesJavaBean.Cliente;
import ClassesJavaBean.Favoritos;
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
@WebServlet(name = "TelaMenuCliente", urlPatterns = {"/segura/Menu"})
public class TelaMenuCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        HttpSession session = request.getSession();
        Cliente cliente = new Cliente();
        int id = 0;
        //VERIFICA QUAL USER ESTÁ NA SESSAO
        if (session.getAttribute("cli") != null) {
            cliente = (Cliente) session.getAttribute("cli");

            //pega o id do Cliente
            id = cliente.getId_usuario();

        }
        //Pegar o parametro
        String botao = request.getParameter("btn");
        //condição
        if (botao != null) {
            //condição
            if (botao.equals("att card")) {
                response.sendRedirect(request.getContextPath() + "/TelaAltCard");//Redireciona para o Atualiza Cartao
            } else if (botao.equals("att dados")) {
                response.sendRedirect(request.getContextPath() + "/TelaAlteraDados");//Redireciona para o Atualiza Dados do Cliente
            } else if (botao.equals("sub exclusao")) {
                response.sendRedirect(request.getContextPath() + "/TelaSolicitaExclusao");//Redireciona para a Solicita Exclusão
            } else if (botao.equals("envia doacao")) {
                FavoritoDAO favDao = new FavoritoDAO();
                Favoritos fav = new Favoritos();
                fav.setId_cliente(id);
                
                List<Favoritos> listaNomes;

                try {
                    listaNomes = favDao.listarDadosFavoritos(id);//lista os Favoritos do Cliente
                    session.setAttribute("listaNomes", listaNomes);
                    session.setAttribute("idP", fav.getId_cliente());
                    response.sendRedirect(request.getContextPath() + "/TelaDoacao");//Redireciona para a Tela de Doação
                } catch (SQLException ex) {
                    Logger.getLogger(TelaMenuCliente.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
