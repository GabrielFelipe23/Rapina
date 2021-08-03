/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.EstabelecimentoDAO;
import ClassesJavaBean.Estabelecimento;
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
@WebServlet(name = "ControlaEsta", urlPatterns = {"/ControlaEsta"})
public class ControlaEsta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Sessao
        HttpSession sessao = request.getSession();
        int tipoEsta = 0;

        //Verifico se a Sessao contem Estabelecimento e pego o tipo de usuario
        if (sessao.getAttribute("esta") != null) {
            Estabelecimento esta = (Estabelecimento) sessao.getAttribute("esta");
            sessao.setAttribute("esta", esta);
            tipoEsta = esta.getTipo_user();
            request.setAttribute("esta", esta);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCadastroEsta.jsp");
            dispatcher.forward(request, response);
        }
        //Pego os parametros do formulario
        String nomeEst = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj");
        String cep = request.getParameter("cep");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String senhaRe = request.getParameter("senhaRe");
        String endereco = request.getParameter("endereco");
        String numeroStr = request.getParameter("numero");
        String cel = request.getParameter("celular");
        String horario = request.getParameter("horario_de_fun");
        String capacidadeStr = request.getParameter("capacidade");
        String taxaStr = request.getParameter("valCancela");
        String concordar = request.getParameter("concordar");
        String concordarNews = request.getParameter("concordarNews");
        String defAud = request.getParameter("defAud");
        String defFis = request.getParameter("defFis");
        String disponibilidade = "Sim";
        int lotacao = 0;

        //VAR AUXS
        int tipoUsuario = tipoEsta;
        int capEst = 0;
        float taxaCancela = 0f;

        //Tratamento de Erros
        boolean temErro = false;

        if (nomeEst != null && nomeEst.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                nomeEst = null;
                request.setAttribute("ErroNome", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroNome", " ");
        }

        if (cnpj != null && cnpj.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                cnpj = null;
                //Declaração de Erro
                request.setAttribute("ErroCnpj", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroCnpj", " ");
        }

        if (cep != null && cep.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                cep = null;
                //Declaração de Erro
                request.setAttribute("ErroCep", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroCep", " ");
        }

        if (email != null && email.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                email = null;
                //Declaração de Erro
                request.setAttribute("ErroEmail", " ");
            }
        } else {
            temErro = true;
            email = null;
            request.setAttribute("ErroEmail", " ");
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

        if (endereco != null && endereco.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                endereco = null;
                //Declaração de Erro
                request.setAttribute("ErroEndereco", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroEndereco", " ");
        }

        if (numeroStr != null && numeroStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                numeroStr = null;
                //Declaração de Erro
                request.setAttribute("ErroNumero", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroNumero", " ");
        }

        if (cel != null && cel.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                cel = null;
                //Declaração de Erro
                request.setAttribute("ErroCelular", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroCelular", " ");
        }

        if (capacidadeStr != null && capacidadeStr.trim().length() > 0) {
            try {
                temErro = false;
                capEst = Integer.parseInt(capacidadeStr);
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                request.setAttribute("ErroCap", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroCap", " ");
        }

        if (taxaStr != null && taxaStr.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                taxaStr = null;
                request.setAttribute("ErroTaxa", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroTaxa", " ");
        }

        if (horario != null && horario.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                horario = null;
                //Declaração de Erro
                request.setAttribute("ErroHorario", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroHorario", " ");
        }

        if (concordar != null && concordar.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                concordar = null;
                //Declaração de Erro
                request.setAttribute("ErroConcorda", " ");
            }
        } else {
            temErro = true;
            request.setAttribute("ErroConcorda", " ");
        }

        //Condição caso não tenha Assistencia auditiva e fisica
        if (defAud == null && defFis == null) {
            defAud = "Não";
            defFis = "Não";
        } else if (defAud != null || defFis != null) {
            defAud = "Sim";
            defFis = "Sim";
        }

        //Condição da Taxa
        if (taxaCancela > 20.00) {//Erro
            temErro = true;
            request.setAttribute("ErroTaxa", " ");
        } else {
            temErro = false;
        }

        //Instancia as Classes
        Estabelecimento esta = new Estabelecimento(nomeEst, cnpj, cep, endereco,
                numeroStr, defAud, defFis, horario, capEst, taxaCancela, cel, email, senha,
                concordar, concordarNews, disponibilidade, tipoUsuario);
        esta.setLotacao(lotacao);
        
        //Objeto DAO estabelecimento
        EstabelecimentoDAO casEsta = new EstabelecimentoDAO();
        request.setAttribute("esta", esta);

        try {
            int verificaCadastro = casEsta.cadastraEst(esta);
            
            //retorna a variavel se foi cadastrado
            if (verificaCadastro == 1) {
                temErro = false;
            } else if (verificaCadastro == 0) {
                temErro = true;
            } else {
                temErro = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ControlaEsta.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Verifica se tem Erro
        if (temErro) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaCadastroEsta.jsp");
            dispatcher.forward(request, response);
        } else {
            sessao.setAttribute("esta", esta);
            response.sendRedirect(request.getContextPath() + "/TelaCartaoCli");
        }
    }

}
