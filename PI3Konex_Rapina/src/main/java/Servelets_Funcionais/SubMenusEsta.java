/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.PlanosDAO;
import ClassesJavaBean.Cartao;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Planos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
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
@WebServlet(name = "SubMenusEsta", urlPatterns = {"/SubMenusEsta"})
public class SubMenusEsta extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        
                Calendar c = Calendar.getInstance();
        int PegaMes = c.get(Calendar.MONTH);
        int aux = 0;
        int[] meses = {1,2,3,4,5,6,7,8,9,10,11,12};
        
        for(int i =0; i<meses.length; i++){
            if(meses[i] == PegaMes){
                aux=meses[i+1];
            } else {
            }
        }

        
        Estabelecimento esta = new Estabelecimento();
        Cartao cartao = new Cartao();
        int idEsta = 0;
        HttpSession session = request.getSession();
        
        if (session.getAttribute("esta") != null && session.getAttribute("cartao")!= null) {
              esta = (Estabelecimento) session.getAttribute("esta");
              cartao = (Cartao) session.getAttribute("cartao");
              idEsta = esta.getId_estabelecimento();
              
        }
        String botao = request.getParameter("btn");
        if (botao != null) {
            if(botao.equals("alteraCartao")){
                request.setAttribute("cartao", cartao);
                session.setAttribute("cartao", cartao);
                response.sendRedirect(request.getContextPath()+"/TelaAltCard");
                
            }else if(botao.equals("alteraDadosEsta")){
                request.setAttribute("esta", esta);
                session.setAttribute("esta", esta);
                response.sendRedirect(request.getContextPath()+"/AlteraDadosEsta");
                
            }else if(botao.equals("validaReserva")){
                response.sendRedirect(request.getContextPath()+"/CriaValidaReserva");
                
            }else if(botao.equals("telaDuvidas")){
                response.sendRedirect(request.getContextPath()+"/CriaTelaDuvidas");
                
            }else if(botao.equals("telaNotificacao")){
                response.sendRedirect(request.getContextPath()+"/CriaListaNotifica");
                
            }else if(botao.equals("alteraPlano")){
                        PlanosDAO dao = new PlanosDAO();

                try {
                    List<Planos> listaDados;
                    listaDados = dao.planosPorID(idEsta);
                    request.setAttribute("ListaPlano", listaDados);
                    request.setAttribute("mes_vencimento", aux);
                    session.setAttribute("ListaPlano", listaDados);
                    session.setAttribute("mes_vencimento", aux);

                } catch (SQLException ex) {
                    Logger.getLogger(SubMenusEsta.class.getName()).log(Level.SEVERE, null, ex);
                }
                response.sendRedirect(request.getContextPath() + "/CriaTelaAltPlano");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }



}
