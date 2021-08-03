/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelets_Funcionais;

import ClassesJavaBean.Login;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gusta
 */
@WebFilter(filterName = "FiltroLogin", urlPatterns = "/segura/*", servletNames = "LoginEmail")
public class FiltroLogin implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Faz Nada
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //Dou Cast nos objetos do tipo HttpRequest e HttpResponse
        HttpServletRequest serveletRequest = (HttpServletRequest) request;
        HttpServletResponse serveletResponse = (HttpServletResponse) response;

        //Declaro o Httpsession para pegar o dado da sessão 
        HttpSession session = serveletRequest.getSession();
        //Verifico se o usuario ja foi verificado
        if (session.getAttribute("dadosAcesso") == null) {
            //Se não estiver logado redireciona para a tela de Email
            serveletResponse.sendRedirect(serveletRequest.getContextPath() + "/LogEmail");
            return;
        } else {
            //Se ele tiver logado redireciona para a respectiva tela de cada um
            Login login = (Login) session.getAttribute("dadosAcesso");
            if (verificaLogin(login, serveletRequest, serveletResponse)) {
                //Segue o fluxo
                chain.doFilter(request, response);
            } else {
                //Logica de Erro = Tela de Erro
                serveletResponse.sendRedirect(serveletRequest.getContextPath() + "/CriaTelaErro404");
            }

        }

    }

    private boolean verificaLogin(Login login, HttpServletRequest serveletRequest, HttpServletResponse serveletResponse) {
        String urlAcesso = serveletRequest.getRequestURI();
        if (urlAcesso.endsWith("/Home")) {
            return true;
        } else if (urlAcesso.endsWith("/MenuADM") && login.getTipo_usuario() == 1) {
            return true;
        } else if (urlAcesso.endsWith("/MenuCliente") && login.getTipo_usuario() == 2) {
            return true;
        } else if (urlAcesso.endsWith("/MenuEsta") && login.getTipo_usuario() == 3) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {
        //Faz nada
    }

}
