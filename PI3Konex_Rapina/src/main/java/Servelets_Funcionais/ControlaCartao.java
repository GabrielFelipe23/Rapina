/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Cartao;
import ClassesJavaBean.Cliente;
import ClassesDAO.ClienteDAO;
import ClassesDAO.EstabelecimentoDAO;
import ClassesJavaBean.Estabelecimento;
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
 * @author gusta
 */
@WebServlet(name = "ControlaCartao", urlPatterns = {"/ControlaCartao"})
public class ControlaCartao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //pega os dados do Cadastro do Cliente
        HttpSession sessao = request.getSession();

        //OBJETOS DA SESSOES
        Cliente cliente = new Cliente();
        Estabelecimento esta = new Estabelecimento();

        //VAR DAS SESSOES
        int idCli = 0;
        int tipoUsuario = 0;
        int idEsta = 0;

        
        //inputs da sessao hidden
        String qtdA = request.getParameter("Acomp");
        String data = request.getParameter("dataReserva");
        String horario = request.getParameter("horaReserva");
        String idEstb = request.getParameter("idEstab");
        String nome_estab = request.getParameter("nomeEstb");
        
        //var a ser convertidas
        int Acom = 0;
        int idEs = 0;

        if (qtdA != null && qtdA.trim().length() > 0) {
            Acom = Integer.parseInt(qtdA);
        }
        if (idEstb != null && idEstb.trim().length() > 0) {
            idEs = Integer.parseInt(idEstb);
        }
        
        //VERIFICA QUAL USER ESTÁ NA SESSAO
        if (sessao.getAttribute("cli") != null && sessao.getAttribute("esta") == null) {
            cliente = (Cliente) sessao.getAttribute("cli");

            //pega o id do Cliente
            idCli = cliente.getId_usuario();
            tipoUsuario = cliente.getTipo_user();

            //Request
            request.setAttribute("cli", cliente);

        } else if (sessao.getAttribute("cli") == null && sessao.getAttribute("esta") != null) {
            esta = (Estabelecimento) sessao.getAttribute("esta");

            //pega o Id do Estabelecimento e o tipo do usuário
            idEsta = esta.getId_estabelecimento();
            tipoUsuario = esta.getTipo_user();

            //Request do objeto
            request.setAttribute("esta", esta);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCartaoCli.jsp");
            dispatcher.forward(request, response);
        }

        //PEGANDO  OS ARIBUTOS DA JSP
        String numCard = request.getParameter("numCartao");
        String validade = request.getParameter("val");
        String cvvStr = request.getParameter("cvv");
        String titular = request.getParameter("titular");

        //Declarções de Erro
        boolean temErro = false;

        //VAR DE CONVERSAO
        int cvv = 0;

        //VERIFICA TITULAR
        if (numCard != null && numCard.trim().length() > 0) {
            temErro = false;
        } else {
            temErro = true;
            numCard = null;
            request.setAttribute("erro", " ");
        }

        //VERIFICA VALIDADE
        if (validade != null && validade.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erro", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        //VERIFICA CVV
        if (cvvStr != null && cvvStr.trim().length() > 0) {
            try {
                cvv = Integer.parseInt(cvvStr);
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                cvvStr = null;
                request.setAttribute("erro", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("erro", " ");
        }

        //VERIFICA TITULAR
        if (titular != null && titular.trim().length() > 0) {
            temErro = false;
        } else {
            temErro = true;
            titular = null;
            request.setAttribute("erro", " ");
        }

        Cartao cartao = new Cartao(numCard, validade, cvv, titular);
        ClienteDAO cliCartao = new ClienteDAO();
        EstabelecimentoDAO estaCartao = new EstabelecimentoDAO();

        //Request do bjeto cartao
        request.setAttribute("cartao", cartao);

        //verificações
        try {
            if (tipoUsuario == 2) {//Se o tipo de Usuario for 2 é Cadastro do cartao do Cliente
                int verificaCadastroCli = cliCartao.cadastraCartao(cartao);
                switch (verificaCadastroCli) {
                    case 1:
                        temErro = false;
                        cliCartao.vinculaCartao(cartao, idCli);//vincula o Cartao
                        idCli = -1;//id ser -1 para nao dar erro
                        break;
                    case 0:
                        temErro = true;
                        break;
                    default:
                        temErro = true;
                        break;
                }
            } else if (tipoUsuario == 3) {//Se o tipo de Usuario for 3 é Cadastro do cartao do Esta
                int verificaCadastroEsta = estaCartao.cadastraCartaoEsta(cartao);
                switch (verificaCadastroEsta) {
                    case 1:
                        temErro = false;
                        estaCartao.vinculaCartaoEsta(cartao, idEsta);//vincula o Cartao
                        idEsta = -1;//id ser -1 para nao dar erro
                        break;
                    case 0:
                        temErro = true;
                        break;
                    default:
                        temErro = true;
                        break;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlaCartao.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Verifica se tem Erro
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCartaoCli.jsp");
            dispatcher.forward(request, response);
        } else {
            sessao.setAttribute("cartao", cartao);
            if (tipoUsuario == 2) {//Redireciona para o MenuCliente
                
                //SETO os dados da reserva que ele havia preenchido
                sessao.setAttribute("idEst", idEs);
                sessao.setAttribute("dataRes", data);
                sessao.setAttribute("horaRes", horario);
                sessao.setAttribute("qtdAcom", Acom);
                sessao.setAttribute("cli", cliente);
                
                response.sendRedirect(request.getContextPath() + "/LogEmail");
            } else if (tipoUsuario == 3) {//Redireciona para o MenuEsta
                response.sendRedirect(request.getContextPath() + "/LogEmail");
            }
        }
    }
}
