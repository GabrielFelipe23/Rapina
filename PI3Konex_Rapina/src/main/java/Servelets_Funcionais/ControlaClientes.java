 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Cliente;
import ClassesDAO.ClienteDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ControlaClientes", urlPatterns = {"/ControlaClientes"})
public class ControlaClientes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //session
        HttpSession sessao = request.getSession();
        int tipoCli = 0;
        //Se na Sessão o cliente tiver algum dado pego o tipo de usuario
        if (sessao.getAttribute("cli") != null) {
            Cliente cliente = (Cliente) sessao.getAttribute("cli");
            sessao.setAttribute("cli", cliente);

            tipoCli = cliente.getTipo_user();
            request.setAttribute("cli", cliente);

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCadastroCli.jsp");
            dispatcher.forward(request, response);
        }
        //Pega os parametros do formulario
        String idStr = request.getParameter("idCliente");
        String nome = request.getParameter("nome");
        String genero = request.getParameter("genero");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String telefone = request.getParameter("celular");
        String senhaRe = request.getParameter("senhaRepete");
        String dataNascStr = request.getParameter("dataNasc");
        String concordar = request.getParameter("concordar");
        String concordarNews = "Não";
        int acesso = 0;

        //inputs da sessao hidden
        String qtdA = request.getParameter("Acomp");
        String data = request.getParameter("dataReserva");
        String horario = request.getParameter("horaReserva");
        String idEstb = request.getParameter("idEstab");
        
        //Tratamento de Exceções
        boolean temErro = false;

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

        if (senha != null && senha.trim().length() > 0) {
            try {
                if (!senha.equals(senhaRe)) {
                    temErro = true;
                    senha = null;
                    request.setAttribute("ErroSenhaRe", " ");
                } else {
                    temErro = false;
                }
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("ErroSenhaRe", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroSenhaRe", " ");
        }

        if (dataNascStr != null && dataNascStr.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroDataNasc", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("erroDataNasc", " ");
        }

        if (concordar != null && concordar.trim().length() > 0) {
            try {
                temErro = true;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = false;
                //Declaração de Erro
                request.setAttribute("erroConcorda", " ");
            }

        }
        
        //var a ser convertidas
        int Acom = 0;
        int idEs = 0;

        if (qtdA != null && qtdA.trim().length() > 0) {
            Acom = Integer.parseInt(qtdA);
        }
        if (idEstb != null && idEstb.trim().length() > 0) {
            idEs = Integer.parseInt(idEstb);
        }
        
        
        //Instancia as Classes
        Cliente cliente = new Cliente(nome, cpf, email, genero,
                dataNascStr, senha, concordar, concordarNews, tipoCli);
        cliente.setAcesso(acesso);
        
        Date dataAtual = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dataAt = formatter.format(dataAtual);
        
        cliente.setData_cadastros(dataAt);
        
        //Metodo DAO que realiza o cadastro
        ClienteDAO casCli = new ClienteDAO();
        request.setAttribute("cliente", cliente);

        try {
            //int verificadora para o Cadastro
            int verificaCadastro = casCli.cadastra(cliente);

            if (verificaCadastro == 1) {//Se for igual a 1 cria o Cadastro

                temErro = false;
            } else if (verificaCadastro == 0) {//Se for igual a 0 , possui um erro
                temErro = true;
            } else {
                temErro = true;
                request.setAttribute("erroCpf", temErro);
                request.setAttribute("ErroSenhaRe", temErro);
            }
        } catch (SQLException ex) {
            System.out.println("Erro:" + ex);
        }

        //Verifica se tem Erro
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCadastroCli.jsp");
            dispatcher.forward(request, response);
        } else {
            //SETO os dados da reserva que ele havia preenchido
            sessao.setAttribute("idEst", idEs);
            sessao.setAttribute("dataRes", data);
            sessao.setAttribute("horaRes", horario);
            sessao.setAttribute("qtdAcom", Acom);
            sessao.setAttribute("cli", cliente);
            response.sendRedirect(request.getContextPath() + "/TelaCartaoCli");
        }
    }
}
