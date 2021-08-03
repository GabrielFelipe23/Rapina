/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.DoacaoDAO;
import ClassesDAO.FavoritoDAO;
import ClassesDAO.PagamentoDAO;
import ClassesJavaBean.Doacao;
import ClassesJavaBean.Favoritos;
import ClassesJavaBean.Login;
import ClassesJavaBean.Pagamento_taxa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "RefazDoacoes", urlPatterns = {"/RefazDoacao"})
public class RefazDoacoes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas    
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        Login logUser = new Login();
        int id = 0;

        //Pegando a Sessao da tela anterior
        HttpSession sessaoUser = request.getSession();

        //verificamos se a session tem algum dado para ser obtido
        if (sessaoUser.getAttribute("dadosAcesso") != null) {
            //trasfiro os dados da session anterio pra o novo objeto
            logUser = (Login) sessaoUser.getAttribute("dadosAcesso");
            //setando os valaores para as variaveis que utilizaremos
            id = logUser.getId_usuario();

            //Setando o objeto para parametro
            request.setAttribute("logUser", logUser);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaLogSenha.jsp");
            dispatcher.forward(request, response);
        }

        String idLine = request.getParameter("lineIdDoa");
        String nome = request.getParameter("lineIdNome");
        String valor = request.getParameter("lineValor");
        String id_esta = request.getParameter("lineIdEstab");

        String btn = request.getParameter("btn");
        float valorDoado = 0f;
        boolean temErro = false;

        //verifica se o idLinha é diferente de null
        if (idLine != null && idLine.trim().length() > 0) {
            //verifica o valorDoado
            if (valor != null && valor.trim().length() > 0) {
                valorDoado = Float.parseFloat(valor);
                temErro = false;
            }

            if (temErro) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
                dispatcher.forward(request, response);
            } else {
                //verifica se o btn foi acionado
                if (btn.equals("refazDoacao")) {
                    //1ª conversão
                    int idEstabel = Integer.parseInt(id_esta);

                    //var 
                    Date dataAtual = new Date();
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

                    //constroe o objeto
                    DoacaoDAO doe = new DoacaoDAO();

                    //faz a ação de deletar
                    try {
                        String data = formatter.format(dataAtual);

                        doe.refazDoacoes(id, idEstabel, nome, data, valorDoado);

                        //chama o metodo que retorna uma lista de usuarios 
                        List<Doacao> listaA;
                        listaA = doe.listaDoacoesClie(id);
                        sessaoUser.setAttribute("listaDoacoesCli", listaA);

                        RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
                        dispatcher.forward(request, response);

                    } catch (SQLException ex) {
                        Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
