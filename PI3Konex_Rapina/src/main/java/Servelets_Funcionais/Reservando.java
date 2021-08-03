/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Login;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Reservando", urlPatterns = {"/Reservando"})
public class Reservando extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //pegos os inputs do tipo hidden
        String botao = request.getParameter("btn");
        String nome_estab = request.getParameter("nomeEstb");
        String qtdA = request.getParameter("acompanhantes");
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

        //verifico se a sessao log é nulla, se for, despacha a tela Inicial
        HttpSession sessao = request.getSession();
        Login logUser = new Login();
        int idUser = 0;

        if (botao.equals("reservarConfirmar")) {
            //verificamos se a session tem algum dado para ser obtido
            if (sessao.getAttribute("dadosAcesso") != null) {
                //trasfiro os dados da session anterio pra o novo objeto
                logUser = (Login) sessao.getAttribute("dadosAcesso");

                //setando os valaores para as variaveis que utilizaremos
                idUser = logUser.getId_usuario();

                //Setando o objeto para parametro
                request.setAttribute("logUser", logUser);

                //seto os valores dos inputs
                sessao.setAttribute("nomeEst", nome_estab);
                sessao.setAttribute("idUser", idUser);
                sessao.setAttribute("idEst", idEs);
                sessao.setAttribute("dataRes", data);
                sessao.setAttribute("horaRes", horario);
                sessao.setAttribute("qtdAcom", Acom);

                //despacha a tela para o pre ticket
                response.sendRedirect(request.getContextPath() + "/PreTicket");
            } else {
                //seto os valores
                sessao.setAttribute("nomeEst", nome_estab);
                sessao.setAttribute("idUser", idUser);
                sessao.setAttribute("idEst", idEs);
                sessao.setAttribute("dataRes", data);
                sessao.setAttribute("horaRes", horario);
                sessao.setAttribute("qtdAcom", Acom);

                //despacha a tela de seleção 
                response.sendRedirect(request.getContextPath() + "/TelaInicial");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
