/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.ClienteDAO;
import ClassesDAO.LoginDAO;
import ClassesJavaBean.Cliente;
import ClassesJavaBean.Login;
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
@WebServlet(name = "TelaAtualizaDados", urlPatterns = {"/AtualizaDados"})
public class TelaAtualizaDados extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Buscar o id do cliente da Session anterior
        HttpSession session = request.getSession();

        int idUsuario = 0;
        String senha = "";
        String concordar = "Sim";

        if (session.getAttribute("cli") != null) {
            Cliente cliente = (Cliente) session.getAttribute("cli");

            idUsuario = cliente.getId_usuario();
            concordar = cliente.getConcorda();
            senha = cliente.getSenha();
            request.setAttribute("cli", cliente);

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaAlteraDados.jsp");
            dispatcher.forward(request, response);
        }

        //pega os parametros
        String nome = request.getParameter("nome");
        String genero = request.getParameter("genero");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senhaNova = request.getParameter("newsenha");
        String senhaAntiga = request.getParameter("senha");
        String dataNascStr = request.getParameter("dataNasc");

        //Variavel verificadora de erros
        boolean temErro = false;

        //Tratamento de Exceções
        if (nome != null && nome.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroNome", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("erroNome", " ");
        }

        if (genero != null && genero.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroGenero", " ");
            }
        }

        if (cpf != null && cpf.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCpf", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("erroCpf", " ");
        }

        if (email != null && email.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroEmail", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("erroEmail", " ");
        }

        if (senhaNova != null && senhaNova.trim().length() > 0) {
            try {
                if (!senhaNova.equals(senhaAntiga)) {
                    temErro = false;
                } else {
                    temErro = true;

                    //força ao erro
                    senhaNova = null;
                    request.setAttribute("erroSenha", " ");
                }
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroSenha", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("erroSenha", " ");
        }

        //data
        if (dataNascStr != null && dataNascStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroDataNasc", " ");
            }
        } else {
            temErro = true;
            //Declaração de Erro
            request.setAttribute("erroDataNasc", " ");
        }

        //Constroe os objetos 
        Cliente cliente = new Cliente();
        Login log = new Login();

        //objeto teste onde verifica se a senha antiga é igual a do BD
        Cliente clienteAux = new Cliente();
        clienteAux.setSenha(senhaAntiga);
        clienteAux.setId_usuario(idUsuario);

        //metodo DAO
        ClienteDAO clienteAtt = new ClienteDAO();

        //verifica se a senha é a que está cadastrada no bd
        int verificador = clienteAtt.verificaSenha(clienteAux);

        if (verificador == 1) {
            //Não há erro, ou seja a senha verificada está contida no BD
            temErro = false;
        } else if (verificador == -1) {
            temErro = true;
        }

        //setamos as informações
        //Seta as informacoes para o objeto
        cliente.setId_usuario(idUsuario);
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setData_nascimento(dataNascStr);
        cliente.setGenero(genero);
        cliente.setEmail(email);
        cliente.setSenha(senhaNova);
        cliente.setConcorda(concordar);
        
        log.setId_usuario(idUsuario);
        log.setNome(nome);
        log.setEmail(email);
        log.setSenha(senhaNova);

        //request do Objeto
        request.setAttribute("clienteAt", cliente);

        try {
            //Chama o metodo de atualizar
            int atualiza = clienteAtt.atualiza(cliente);

            if (atualiza == 1) {
                temErro = false;
                LoginDAO logDAO =  new LoginDAO();
                logDAO.atualizaLoginCli(log);
            } else {
                temErro = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaAtualizaDados.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verifica se há erros
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaAlteraDados.jsp");
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
