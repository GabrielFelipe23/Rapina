/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.EstabelecimentoDAO;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Pagamento_mensalidade;
import ClassesJavaBean.Pagamento_taxa;
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
@WebServlet(name = "BuscaPagamentos", urlPatterns = {"/BuscaPagamentos"})
public class BuscaPagamentos extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //parametros
        String botao = request.getParameter("btn");
        String tipoUser=request.getParameter("lineTipo");
        String idStr = request.getParameter("lineID");
        String idEstaStr = request.getParameter("lineIDEsta");
        String nome = request.getParameter("lineUser");
        String data = request.getParameter("lineData");
        String valorStr = request.getParameter("lineValor");
        
        //Sessao
        HttpSession sessao = request.getSession();
        
        int id = 0;
        int typeUser=0;
        float valor = 0f;

        if (valorStr != null && valorStr.trim().length() > 0) {
            valor = Float.parseFloat(valorStr);
            
            if (idStr != null && idStr.trim().length() > 0) {
                id = Integer.parseInt(idStr);
                
                if (tipoUser != null && tipoUser.trim().length() > 0) {

                    if (botao.equals("notifica")) {
                        //converte o tipo de usuario    
                        typeUser = Integer.parseInt(tipoUser);

                        if(typeUser == 2){
                            //constroe o objeto
                            Pagamento_taxa pagTaxa = new Pagamento_taxa(id, nome, data, valor, typeUser);
                            request.setAttribute("pag", pagTaxa);
                            
                            //constroe a sessao
                            sessao.setAttribute("dadosPag", pagTaxa);
                            response.sendRedirect(request.getContextPath() + "/RespondePagamento");
                        }else{
                            //converte o id
                            int id_estabelecimento=0;
                            id_estabelecimento= Integer.parseInt(idEstaStr);
                            
                            //constroe o objeto
                            Pagamento_taxa pagTaxa = new Pagamento_taxa(nome, data, valor, typeUser, id_estabelecimento);
                            request.setAttribute("pag", pagTaxa);
                            
                            //constroe a sessao
                            sessao.setAttribute("dadosPag", pagTaxa);
                            response.sendRedirect(request.getContextPath() + "/RespondePagamento");
                        }

                    } else if (botao.equals("bloquea")) {
                        //Alterar Status do Estabelecimento para 'Inativo'
                        String sts= "Inativo";
                        EstabelecimentoDAO estab= new EstabelecimentoDAO();
                        
                        //converte o id
                        int id_estabelecimento=0;
                        id_estabelecimento= Integer.parseInt(idEstaStr);
                        
                        try {
                            //chama a dao
                            estab.atualiazaStatus(sts, id_estabelecimento);
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(BuscaPagamentos.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        //constroe a sessao
                        response.sendRedirect(request.getContextPath() + "/segura/MenuADM");
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
