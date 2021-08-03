/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.DoacaoDAO;
import ClassesDAO.FavoritoDAO;
import ClassesJavaBean.Cartao;
import ClassesJavaBean.Cliente;
import ClassesJavaBean.Doacao;
import ClassesJavaBean.Favoritos;
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
 * @author gusta
 */
@WebServlet(name = "ControlaDoacao", urlPatterns = {"/ControlaDoacao"})
public class ControlaDoacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
       
        Cliente cliente = new Cliente();
        List<Favoritos> listaDados;
        List<Cartao> listaCartao;
        int idCli=0;

        
        //VERIFICA QUAL USER ESTÁ NA SESSAO
        if (session.getAttribute("cli") != null || session.getAttribute("listaNomes")!=null) {
            cliente = (Cliente) session.getAttribute("cli");
            listaDados = (List<Favoritos>) session.getAttribute("listaNomes");
            listaCartao = (List<Cartao>) session.getAttribute("listaCartao");

            //pega o id do Cliente
            idCli = cliente.getId_usuario();
            //Request
            session.setAttribute("listaNomes", listaDados);
            session.setAttribute("listaCartao", listaCartao);
        }
            
        
        //Pegando os Parametros
        String nomeDoacao = request.getParameter("nomeDoacao");
        String valorStr = request.getParameter("valDoa");
        String idEstaStr = request.getParameter("nomeEsta");
        String idCartaoStr = request.getParameter("idCartao");

        float valor = 0f;
        int idEsta = 0;
        int idCartao= 0;
        boolean temErro = false;
        if (nomeDoacao != null && nomeDoacao.trim().length() > 0) {
            try {
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
            }
        } else {
            temErro = true;
        }
        if (valorStr != null && valorStr.trim().length() > 0) {
            try {
                valor = Float.parseFloat(valorStr);
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                valorStr = null;
            }
        } else {
            temErro = true;
            valorStr = null;
        }
        
        if (idCartaoStr != null && idCartaoStr.trim().length() > 0) {
            try {
                idCartao = Integer.parseInt(idCartaoStr);
                temErro = false;
            } catch (StringIndexOutOfBoundsException ex) {
                temErro = true;
                //Declaração de Erro
                idCartaoStr = null;
            }
        } else {
            temErro = true;
            idCartaoStr = null;
        }
        if(valor<1.50){
            nomeDoacao="Doacão Ocasional";
        }else if(valor<3.50){
            nomeDoacao="Doacao Indicativa";
        }else{
            nomeDoacao="Doacao Melhor";
        }
        Date dataAtual = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String data = formatter.format(dataAtual);
        
        DoacaoDAO doaDao = new DoacaoDAO();
        try {
            idEsta = doaDao.consultaNome(idEstaStr);
        } catch (SQLException ex) {
            Logger.getLogger(ControlaDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        Doacao doa = new Doacao(nomeDoacao,valor,idCli,data,idEsta,idCartao);
        
        try {
            int verifica = doaDao.cadastra(doa);
            switch (verifica) {
                case 1:
                    temErro= false;
                    break;
                case 0:
                    temErro = true;
                    break;
                default:
                    temErro=true;
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControlaDoacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(temErro){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/TelaDoacao.jsp");
            dispatcher.forward(request, response);
        }else{
            RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuCliente.jsp");
            dispatcher.forward(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
