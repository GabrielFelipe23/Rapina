/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.FavoritoDAO;
import ClassesDAO.PagamentoDAO;
import ClassesJavaBean.Favoritos;
import ClassesJavaBean.Login;
import ClassesJavaBean.Pagamento_taxa;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "DeletaPagamento", urlPatterns = {"/DeletaPagamento"})
public class DeletaPagamento extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas    
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        Login logUser = new Login();
        int id=0;
        
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
        
        String idLine = request.getParameter("lineIdPag");
        String dataPag = request.getParameter("lineDataPag");
        String valor = request.getParameter("lineValorPag");
        String desc = request.getParameter("lineDescPag");
        String btn = request.getParameter("btn");
        
        //verifica se o idLinha é diferente de null
        if(idLine != null && idLine.trim().length() > 0){
            //verifica se o btn foi acionado
            if (btn.equals("deletar")) {
                //converte o valor
                int idFav = Integer.parseInt(idLine);
                
                //constroe o objeto
                PagamentoDAO pagDAO = new PagamentoDAO();
                
                //faz a ação de deletar
                try {
                    pagDAO.removePagCli(idFav);
                   
                    //chama o metodo que retorna uma lista de usuarios 
                    List<Pagamento_taxa> listaO;
                    listaO = pagDAO.listarPagamentoCli(id);
                    sessaoUser.setAttribute("listaPagamCli", listaO);
                    
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
                    dispatcher.forward(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(ListaNotifica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (btn.equals("notificar")){
                //requests att da sessao
                sessaoUser.setAttribute("dataCobrancaPag", dataPag);
                
                float value= Float.parseFloat(valor);
                sessaoUser.setAttribute("valorCobrancaPag", value);
                
                int idPag = Integer.parseInt(idLine);
                sessaoUser.setAttribute("idCobranca", idPag);
                
                sessaoUser.setAttribute("descTaxaPag", desc);
                
                sessaoUser.setAttribute("idUser", id);
                //chama a tela de mensagem
                RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/HelpMasterCli.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

}
