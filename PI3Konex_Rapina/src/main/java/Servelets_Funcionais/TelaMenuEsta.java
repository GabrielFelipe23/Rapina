/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.EstabelecimentoDAO;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Reserva;
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
@WebServlet(name = "TelaMenuEsta", urlPatterns = {"/MenuEstabelecimento"})
public class TelaMenuEsta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //var que serão usadas para a sessao
        Estabelecimento esta =new Estabelecimento();
        int idEsta=0;

        HttpSession session = request.getSession();
        if(session.getAttribute("esta")!=null){
            esta = (Estabelecimento) session.getAttribute("esta");
            idEsta = esta.getId_estabelecimento();
        }
        //Pegar o parametro
        String idStr = request.getParameter("idRes");
        String botao = request.getParameter("btn");

        int codReserva = 0;
        boolean temErro = false;
        if (idStr != null && idStr.trim().length() > 0) {
            try {
                codReserva = Integer.parseInt(idStr);
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                idStr = null;
            }
        } else {
            temErro = true;
            idStr = null;
        }
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuEsta.jsp");
            dispatcher.forward(request, response);
        } else {

            //condição
            if (botao != null) {
                //condição
                if (botao.equals("consultaRes")) {

                    EstabelecimentoDAO estaDAO = new EstabelecimentoDAO();
                    List<Reserva> dadosRes;

                    try {
                        dadosRes = estaDAO.consultaRes(codReserva,idEsta);
                        request.setAttribute("consRes", dadosRes);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuEsta.jsp");
                        dispatcher.forward(request, response);
                        return;
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaMenuEsta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}