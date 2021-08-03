/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "PosClickReserva", urlPatterns = {"/PosClickReserva"})
public class PosClickReserva extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //pega os parametros
        String botao = request.getParameter("btn");

        String qtdA = request.getParameter("Acomp");
        String nome_estab = request.getParameter("nomeEstb");
        String data = request.getParameter("dataReserva");
        String horario = request.getParameter("horaReserva");
        String idEstb = request.getParameter("idEstab");

        //var a ser convertidas
        int Acom = 0;
        int idEs = 0;

        if (qtdA != null && qtdA.trim().length() > 0) {
            Acom = Integer.parseInt(qtdA);
        }
        if (idEstb != null && idEstb.trim().length() > 0) {
            idEs = Integer.parseInt(idEstb);
        }

        //Sessão
        HttpSession sessao = request.getSession();

        if (botao.equals("cadastrar")) {
            //SETO os dados da reserva que ele havia preenchido
            sessao.setAttribute("idEst", idEs);
            sessao.setAttribute("nomeEst", nome_estab);
            sessao.setAttribute("dataRes", data);
            sessao.setAttribute("horaRes", horario);
            sessao.setAttribute("qtdAcom", Acom);

            //Tela pre Cadastro 
            response.sendRedirect(request.getContextPath() + "/Pre_Cadastro");   
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
