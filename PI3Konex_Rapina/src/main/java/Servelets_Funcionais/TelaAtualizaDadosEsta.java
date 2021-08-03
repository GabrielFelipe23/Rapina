/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.EstabelecimentoDAO;
import ClassesDAO.LoginDAO;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Login;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author gusta
 */
@WebServlet(name = "TelaAtualizaDadosEsta", urlPatterns = {"/AtualizaDadosEsta"})
public class TelaAtualizaDadosEsta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Buscar o id do cliente da Session anterior
        HttpSession session = request.getSession();

        int idUsuario = 0;
        String concorda = "";
        String senha = "";
        if (session.getAttribute("esta") != null) {
            Estabelecimento esta = (Estabelecimento) session.getAttribute("esta");

            idUsuario = esta.getId_estabelecimento();
            concorda = esta.getConcorda();
            senha = esta.getSenha();
            request.setAttribute("esta", esta);

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaAlteraDados.jsp");
            dispatcher.forward(request, response);
        }
        //pega os parametros
        String nomeEst = request.getParameter("nome");
        String cep = request.getParameter("cep");
        String email = request.getParameter("email");
        String senhaNova = request.getParameter("newsenha");
        String senhaAntiga = request.getParameter("senha");
        String endereco = request.getParameter("endereco");
        String numeroStr = request.getParameter("numero");
        String horario = request.getParameter("horariofun");
        String capacidadeStr = request.getParameter("capacidade");
        String taxaStr = request.getParameter("valCancela");
        String defAud = request.getParameter("defAud");
        String defFis = request.getParameter("defFis");

        //Tratamento de Erros
        boolean temErro = false;
        if (nomeEst != null && nomeEst.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroNomeEst", "Nome é Obrigatorio");
            }

        }
        if (cep != null && cep.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCep", "CEP é Obrigatorio");
            }

        }
        if (email != null && email.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroEmail", "Email é Obrigatorio");
            }

        }
        if (senhaNova != null && senhaNova.trim().length() > 0) {
            try {
                if (!senhaNova.equals(senhaAntiga)) {
                    temErro = false;
                } else {
                    temErro = true;
                    senhaNova = null;
                    request.setAttribute("ErroSenhaRe", "");
                }
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("ErroSenhaObg", "Senha é Obrigatoria");
            }

        }
        if (endereco != null && endereco.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroEndereco", "Endereço é Obrigatorio");
            }

        }
        if (numeroStr != null && numeroStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroNumero", "Numero é Obrigatorio");
            }

        }
        if (horario != null && horario.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroHorario", "Horario é Obrigatorio");
            }

        }
        if (capacidadeStr != null && capacidadeStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroCap", "Capacidade é Obrigatoria");
            }

        }
        if (taxaStr != null && taxaStr.trim().length() > 0) {
            try {
                if (taxaStr == "20.00") {
                    temErro = true;
                    request.setAttribute("ErroTaxaValor", "O valor maximo da taxa deve ser de até R$19.99");
                } else {
                    temErro = false;
                }
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("erroTaxaCancela", "Taxa de Cancelamento não informada");
            }

        }
        //Condição caso não tenha Assistencia auditiva e fisica
        if (defAud == null && defFis == null) {
            defAud = "Não";
            defFis = "Não";
        } else if (defAud != null || defFis != null) {
            defAud = "Sim";
            defFis = "Sim";
        }
        int capEst = Integer.parseInt(capacidadeStr);
        float taxaCancela = Float.parseFloat(taxaStr);

        //Constroe os objetos 
        Estabelecimento esta = new Estabelecimento();
        Login log = new Login();

        //Objeto aux para verificar a senha
        Estabelecimento estaAux = new Estabelecimento();
        estaAux.setSenha(senha);
        estaAux.setId_estabelecimento(idUsuario);

        //Objeto DAO
        EstabelecimentoDAO estaAtt = new EstabelecimentoDAO();

        //verifica se a senha é a que está cadastrada no bd
        int verificador = estaAtt.verificaSenha(estaAux);

        if (verificador == 1) {
            //Não há erro, ou seja a senha verificada está contida no BD
            temErro = false;
        } else if (verificador == -1) {
            temErro = true;
        }
        //Seta as informacoes para o objeto
        esta.setId_estabelecimento(idUsuario);
        esta.setNome_estabelecimento(nomeEst);
        esta.setCep_estabelecimento(cep);
        esta.setLogadouro_estabelecimento(endereco);
        esta.setNumero(numeroStr);
        esta.setHorario_funcionamento(horario);
        esta.setCapacidade(capEst);
        esta.setTaxa_cancelamento(taxaCancela);
        esta.setAcessi_fisico(defFis);
        esta.setAcessi_auditiva(defAud);
        esta.setEmail(email);
        esta.setSenha(senhaNova);
        esta.setConcorda(concorda);
        //Setar dados Login
        log.setId_esta(idUsuario);
        log.setNome(nomeEst);
        log.setEmail(email);
        log.setSenha(senhaNova);
        //request do Objeto
        request.setAttribute("estaAtt", esta);

        try {
            //Chama o metodo de atualizar
            int atualiza = estaAtt.atualiazaEst(esta);

            if (atualiza == 1) {
                temErro = false;
                
                LoginDAO logDAO =  new LoginDAO();
                logDAO.atualizaLoginEsta(log);
            } else {
                temErro = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaAtualizaDadosEsta.class.getName()).log(Level.SEVERE, null, ex);
        }

        //verifica se há erros
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaAlteraDadosEsta.jsp");
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
