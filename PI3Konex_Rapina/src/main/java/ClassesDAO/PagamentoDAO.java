
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Pagamento_taxa;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class PagamentoDAO {
     ArrayList<Pagamento_taxa> lista = new ArrayList<>();
     
     public List<Pagamento_taxa> listarDadosPagCli()throws SQLException {
         //Lista os Pagamentos Atrasados do Cliente
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select pt.id_pag_taxa, pt.data_cobranca, pt.valor_total, pt.id_usuario, l.nome, l.tipo_usuario from pagamento_taxa as pt join login as l on pt.id_usuario=l.id_usuario where pt.desc_taxa='Atraso na reserva'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pagamento_taxa pagTaxa = new Pagamento_taxa();

               
                //ID Pagamento Taxa
                pagTaxa.setId_pagamento_taxa(rs.getInt("id_pag_taxa"));
                
                //id do Usuario
                pagTaxa.setId_usuario(rs.getInt("id_usuario"));
                
                //Nome
                pagTaxa.setNomeUser(rs.getString("nome"));

                //tipo do Usuario
                pagTaxa.setTipo_user(rs.getInt("tipo_usuario"));
                
                //Data Cobrança
                pagTaxa.setData_cobranca(rs.getString("data_cobranca"));
                
                //cnpj
                pagTaxa.setValor_total(rs.getFloat("valor_total"));
                
                lista.add(pagTaxa);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
     }
     public List<Pagamento_taxa> listarDadosPagEsta() throws SQLException {
        //Lista os Pagamentos Atrasados do Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select pt.id_pag_taxa, pt.data_cobranca, pt.valor_total, pt.id_esta, l.nome, l.tipo_usuario from pagamento_taxa as pt join login as l on pt.id_esta=l.id_esta where pt.desc_taxa='Atraso na reserva'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pagamento_taxa pagTaxa = new Pagamento_taxa();

               
                //ID Pagamento Taxa
                pagTaxa.setId_pagamento_taxa(rs.getInt("id_pag_taxa"));
                
                //ID Estabelecimento
                pagTaxa.setId_estabelecimento(rs.getInt("id_esta"));
                
                //tipo do Usuario
                pagTaxa.setTipo_user(rs.getInt("tipo_usuario"));
                //Nome
                pagTaxa.setNomeUser(rs.getString("nome"));

                //Data Cobrança
                pagTaxa.setData_cobranca(rs.getString("data_cobranca"));
                
                //cnpj
                pagTaxa.setValor_total(rs.getFloat("valor_total"));
                

                lista.add(pagTaxa);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }
     
     public List<Pagamento_taxa> listarPagamentoCli(int id)throws SQLException {
         //Lista os Pagamentos Atrasados do Cliente
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select id_pag_taxa, desc_taxa, data_cobranca, valor_total from pagamento_taxa where id_usuario=?");
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Pagamento_taxa pagTaxa = new Pagamento_taxa();
               
                //ID Pagamento Taxa
                pagTaxa.setId_pagamento_taxa(rs.getInt("id_pag_taxa"));
                
                //Data Cobrança
                pagTaxa.setDescribe_taxa(rs.getString("desc_taxa"));
                
                //Data Cobrança
                pagTaxa.setData_cobranca(rs.getString("data_cobranca"));
                
                //valor total
                pagTaxa.setValor_total(rs.getFloat("valor_total"));
                
                lista.add(pagTaxa);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
     }
     public void removePagCli(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("delete from pagamento_taxa where id_pag_taxa=?");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }    
}
