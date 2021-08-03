/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import java.io.IOException;
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
@WebServlet(name = "ListaRestaurantesBuscados", urlPatterns = {"/ListaRestaurantesBuscados"})
public class ListaRestaurantesBuscados extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas de uso
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //Pegando a Sessao da tela anterior
        HttpSession sessao = request.getSession();

        //pega o parametro do botao
        String botao = request.getParameter("btn");
        String cep = request.getParameter("lineCEP");
        String id_estab = request.getParameter("lineIdEstb");
        String nome_estab = request.getParameter("lineNome");
        String endereco = request.getParameter("lineEndereco");
        String numero = request.getParameter("lineNumero");
        String defAud = request.getParameter("lineDefAud");
        String defCad = request.getParameter("lineDefCad");
        String email = request.getParameter("lineEmail"); 
        String cel = request.getParameter("lineCel");
        String cap = request.getParameter("lineCap");
        String lot = request.getParameter("lineLota");
        //parametros a serem convertidos
        int capa=0;
        int num=0;
        int idEstab=0;
        int lota=0;
        
        //verifica os parametros
        if(id_estab != null && id_estab.trim().length() > 0){
            idEstab= Integer.parseInt(id_estab);
           
            //proxima verificação
            if(numero != null && numero.trim().length() > 0){
               num= Integer.parseInt(numero);
            }
            //proxima verificação
            if(cap != null && cap.trim().length() > 0){
               capa=Integer.parseInt(cap);
            }
            //proxima verificação
            if(lot != null && lot.trim().length() > 0){
               lota=Integer.parseInt(lot);
            }
            
            if (botao.equals("selectRest")) {
                //setar os dados da sessao
                sessao.setAttribute("nomeEst", nome_estab);
                sessao.setAttribute("idEst", idEstab);
                sessao.setAttribute("logad", endereco);
                sessao.setAttribute("cep", cep);
                sessao.setAttribute("capac", capa);
                sessao.setAttribute("nume", num);
                sessao.setAttribute("defA", defAud);
                sessao.setAttribute("defC", defCad);
                sessao.setAttribute("celu", cel);
                sessao.setAttribute("email", email);
                sessao.setAttribute("lotacao", lota);
                
                //despacha a tela de seleção 
                response.sendRedirect(request.getContextPath() + "/SelectionBusca");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}