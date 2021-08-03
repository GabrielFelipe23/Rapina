/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ReservaDAO;
import ClassesJavaBean.Reserva;
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

/**
 *
 * @author gusta
 */
@WebServlet(name = "AlteraReserva", urlPatterns = {"/AlteraReserva"})
public class AlteraReserva extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Pega os parametros
        String codStr = request.getParameter("codReserva");
        String data = request.getParameter("dataRes");
        String horario = request.getParameter("horaRes");
        String acompanhaStr = request.getParameter("acomRes");
        int cod = 0;
        int acompanhates = 0;

        //Variavel verificadora de erros
        boolean temErro = false;

        //verifica os campos
        if (codStr != null && codStr.trim().length() > 0) {
            temErro = false;
            cod = Integer.parseInt(codStr);
        } else {
            temErro = true;
        }

        if (data != null && data.trim().length() > 0) {
            temErro = false;
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        if (horario != null && horario.trim().length() > 0) {
            temErro = false;
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        if (acompanhaStr != null && acompanhaStr.trim().length() > 0) {
            temErro = false;
            acompanhates = Integer.parseInt(acompanhaStr);
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        //Constroe objeto e a DAO da Reserva
        Reserva res = new Reserva();
        ReservaDAO resDao = new ReservaDAO();
        //Seto os valores da reserva
        res.setNum_reserva(cod);
        res.setQtd_acompanhantes(acompanhates);
        res.setData_reservada(data);
        res.setHorario_reservado(horario);

        try {
            int altera = resDao.alteraReserva(res);
            if (altera == 1) {
                temErro = false;

            } else if (altera == 0) {
                temErro = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlteraReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
            dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
