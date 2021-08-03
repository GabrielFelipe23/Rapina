/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.NotificaDAO;
import ClassesJavaBean.Notification;
import ClassesJavaBean.Pagamento_taxa;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author Gabriel
 */
@WebServlet(name = "NotificaPagamento", urlPatterns = {"/NotificaPagamento"})
public class NotificaPagamento extends HttpServlet {

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        //parametro
        String msgText = request.getParameter("mensagem");
        
        //sessao
        HttpSession sessao = request.getSession();
        
        //objetos da session 
        Pagamento_taxa taxa = new Pagamento_taxa();
        
        //verifica se a sessao é nula
        if(sessao.getAttribute("dadosPag") != null){
            taxa = (Pagamento_taxa) sessao.getAttribute("dadosPag");
            request.setAttribute("dadosPag", taxa);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaRespostaPag.jsp");
            dispatcher.forward(request, response);
        }
        
        //var de data
        Date dataAtual = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        //set a msg
        taxa.setDescribe_taxa(msgText);
        
        //objeto DAO
        NotificaDAO cobranca= new NotificaDAO();
        Notification dadosNotifica = new Notification();
        
        //verifica qual é o tipo de usuário
        int tipoUser=0;
        tipoUser= taxa.getTipo_user();
       
        
        if(tipoUser == 2){
            String data = formatter.format(dataAtual);
            
            //passsa os dados que serão enviados
            dadosNotifica.setMensagem(taxa.getDescribe_taxa());
            dadosNotifica.setId_user(taxa.getId_usuario());
            dadosNotifica.setData(data);
            
            //criamos a notificação
            cobranca.criaResposta(dadosNotifica);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/ConfirmaMensagem.jsp");
            dispatcher.forward(request, response);
        }else{
            String data = formatter.format(dataAtual);
            
            //passsa os dados que serão enviados
            dadosNotifica.setMensagem(taxa.getDescribe_taxa());
            dadosNotifica.setId_estabelecimento(taxa.getId_estabelecimento());
            dadosNotifica.setData(data);
            
            //criamos a notificação para o estabelecimento
            cobranca.criaRespostaEsta(dadosNotifica);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/ConfirmaMensagem.jsp");
            dispatcher.forward(request, response);
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }



}
