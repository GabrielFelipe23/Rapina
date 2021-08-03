/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ClienteDAO;
import ClassesJavaBean.Cartao;
import java.io.IOException;
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
 * @author Gabriel
 */
@WebServlet(name = "TelaAlteraCartao", urlPatterns = {"/AlteraCartao"})
public class TelaAlteraCartao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Buscar o id do cliente da Session anterior
        HttpSession session = request.getSession();

        int idCartao = 0;
        if (session.getAttribute("cartao") != null) {
            Cartao cartao = (Cartao) session.getAttribute("cartao");

            idCartao = cartao.getId_card();
            request.setAttribute("cartao", cartao);

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaAlteraCard.jsp");
            dispatcher.forward(request, response);
        }

        //pega os parametros
        String num = request.getParameter("numCartao");
        String validade = request.getParameter("val");
        String cvv = request.getParameter("cvv");
        String titu = request.getParameter("titular");

        //converte os parametros
        int codV = 0;

        //Variavel verificadora de erros
        boolean temErro = false;

        //verifica os campos
        if (num != null && num.trim().length() > 0) {
            temErro = false;
        } else {
            temErro = true;
        }

        if (validade != null && validade.trim().length() > 0) {
            temErro = false;
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        if (cvv != null && cvv.trim().length() > 0) {
            temErro = false;
            codV = Integer.parseInt(cvv);
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        if (titu != null && titu.trim().length() > 0) {
            temErro = false;
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        //Constroe os objetos 
        Cartao cartaoAtt = new Cartao();

        //Seta as informacoes para o objeto
        cartaoAtt.setId_card(idCartao);
        cartaoAtt.setNum_cartao(num);
        cartaoAtt.setCvv(codV);
        cartaoAtt.setValidade(validade);
        cartaoAtt.setTitular(titu);

        //request do Objeto
        request.setAttribute("cartaoAt", cartaoAtt);

        //Objeto para atualização
        ClienteDAO clienteAtt = new ClienteDAO();

        try {
            //Chama o metodo de atualizar
            int atualiza = clienteAtt.atualizaCartao(cartaoAtt);

            if (atualiza == 1) {
                temErro = false;
            } else {
                temErro = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaAlteraCartao.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verifica se há erros
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaAlteraCard.jsp");
            dispatcher.forward(request, response);
        } else {
            //Não há erros- despacha dados alterado.
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaPosAtualiza.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
