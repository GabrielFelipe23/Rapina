/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesDAO.PlanosDAO;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Planos;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
 * @author Alex Yudy Kitahara
 */
@WebServlet(name = "PlanosRapina", urlPatterns = {"/PlanosRapina"})
public class PlanosRapina extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //boas praticas
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");  
        
        Estabelecimento esta = new Estabelecimento();
        int idesta=0;
        int idplanos =0;
        
        //Buscar o id do estabelecimento da Session anterior
        HttpSession session = request.getSession();
        
        if(session.getAttribute("esta")!=null){
            esta = (Estabelecimento) session.getAttribute("esta");
            idesta = esta.getId_estabelecimento();
        }


        //Pegar o parametro
        String botao = request.getParameter("button");
        
        // constroe os objetos 
        Planos plano = new Planos();
        PlanosDAO dao = new PlanosDAO();
        
        
        if (botao != null) {
            if(botao.equals("Serrana")){
                idplanos = 1;
                plano.setId_esta(idesta);
                plano.setId_planos(idplanos);
            }
            if(botao.equals("Acor")){
                idplanos = 2;
                plano.setId_esta(idesta);
                plano.setId_planos(idplanos);
            }
            if(botao.equals("Rarpy")){
                idplanos = 3;
                plano.setId_esta(idesta);
                plano.setId_planos(idplanos);
            }
        }
        
        try {
            dao.atualizaPlano(plano,idesta);
        } catch (SQLException ex) {
            Logger.getLogger(PlanosRapina.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/A_TELAS_JSP/MenuEsta.jsp");
        dispatcher.forward(request, response);
        return;

    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
