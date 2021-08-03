/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.NotificaDAO;
import ClassesJavaBean.Cliente;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Notification;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "TelaDeletaConta", urlPatterns = {"/DeletaConta"})
public class TelaDeletaConta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //para deletar a conta será necessário ter o ID do User da Sessão
        HttpSession sessao = request.getSession();

        Cliente cliente = new Cliente();
        Estabelecimento esta = new Estabelecimento();

        int idEsta = 0;
        int idCliente = 0;
        int tipoUsuario = 0;

        //VERIFICA QUAL USER ESTÁ NA SESSAO
        if (sessao.getAttribute("cli") != null && sessao.getAttribute("esta") == null) {
            cliente = (Cliente) sessao.getAttribute("cli");

            //pega o id do Cliente
            idCliente = cliente.getId_usuario();
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
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaInicial.jsp");
            dispatcher.forward(request, response);
        }

        //Pega os paramentros das JSP
        String btn = request.getParameter("btn");

        //verifica qual botão foi acionado
        if (btn != null) {
            if (btn.equals("Sim")) {
                //Faz a confirmação da solicitação e despacha para tela PosAtualiza
                //1º Crio um objeto 
                Notification solicitaCli = new Notification();
                Notification solicitaEst = new Notification();

                //Crio a Mensagem da solicitação
                String msg = "Olá Rapina Masters, quero que vocês façam a exclusão da minha conta.";

                //declaro a data e horario da solicitação
                Date dataAtual = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String data = formatter.format(dataAtual);

                //6ºCriar o objeto DAO 
                NotificaDAO notification = new NotificaDAO();

                //ºSetar o id do usuário
                if (tipoUsuario == 2) {
                    solicitaCli.setId_user(idCliente);
                    solicitaCli.setMensagem(msg);
                    solicitaCli.setData(data);

                    try {
                        //7º Executa o metodo
                        int x = notification.solicitaExclusao(solicitaCli);

                        if (x == 1) {
                            //prossegue com a tela pos atualiza
                            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaPosAtualiza.jsp");
                            dispatcher.forward(request, response);

                        } else {
                            //Não prossegue e emite msg
                            request.setAttribute("erroSolicita", "No momento você não pode solicitar a exclusão");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaSolicitaExclusao.jsp");
                            dispatcher.forward(request, response);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaDeletaConta.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else if (tipoUsuario == 3) {
                    solicitaEst.setId_estabelecimento(idEsta);
                    solicitaEst.setMensagem(msg);
                    solicitaEst.setData(data);

                    try {
                        //7º Executa o metodo
                        int x = notification.solicitaExclusaoEsta(solicitaEst);

                        if (x == 1) {
                            //prossegue com a tela pos atualiza
                            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaPosAtualiza.jsp");
                            dispatcher.forward(request, response);

                        } else {
                            //Não prossegue e emite msg
                            request.setAttribute("erroSolicita", "No momento você não pode solicitar a exclusão");
                            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaSolicitaExclusao.jsp");
                            dispatcher.forward(request, response);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(TelaDeletaConta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else if (btn.equals("Não")) {
                //despacha a tela de MENU
                if (tipoUsuario == 2) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
                    dispatcher.forward(request, response);
                } else if (tipoUsuario == 3) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuEsta.jsp");
                    dispatcher.forward(request, response);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
