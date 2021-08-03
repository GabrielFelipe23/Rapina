/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class ContagemDAO {
    public int contaPlanoA() throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(id_planos) as plano from estabelecimento where id_planos='1'");) {

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("plano");
                }
            }
        }
        return a;
    }
    public int contaPlanoB() throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(id_planos) as plano from estabelecimento where id_planos='2'");) {

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("plano");
                }
            }
        }
        return a;
    }
    public int contaPlanoC() throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(id_planos) as plano from estabelecimento where id_planos='3'");) {

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("plano");
                }
            }
        }
        return a;
    }
   
    public int contaReservas() throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(num_reserva) as qtd from reserva where reserva_status='ativa'");) {

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    
    public int contaDoacoes() throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(id_doacao) as qtd from doacao;");) {

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    public int contaPagamentos() throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select sum(qtd) as qtdPagamentos from (select count(id_pag) as qtd from pagamento_mensalidade union all select count(id_pag_taxa) as qtd from pagamento_taxa) as a");) {

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtdPagamentos");
                }
            }
        }
        return a;
    }
    public int contaUsers() throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(id_login) as qtd from login");) {

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    
    public int contaFavoritos(int id) throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(id_favorito) as qtd from favorito where id_esta=?");) {
            stmt.setInt(1,id);
            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    public int contaDoaRecebidas(int id) throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(id_doacao) as qtd from doacao where id_esta=?");) {
            stmt.setInt(1, id);
            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    public int contaResValidada(int id) throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(num_reserva) as qtd from reserva where reserva_status='validada' and id_esta=?");) {
            stmt.setInt(1, id);
            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    
    public int contaRecebidos(int id) throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select sum(qtd) as qtdPagamentos from ( select count(id_pag) as qtd from pagamento_mensalidade where id_esta= ? union all select count(id_pag_taxa) as qtd from pagamento_taxa) as a");) {
            stmt.setInt(1, id);
            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtdPagamentos");
                }
            }
        }
        return a;
    }
    
    public int contaReservas(int x) throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(num_reserva) as qtd from reserva where id_usuario=? && reserva_status='ativa'");) {

            stmt.setInt(1, x);
            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    
    
    public int contaReservaCli(int x) throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(num_reserva) as qtd from reserva where id_usuario=? && reserva_status='ativa'");) {

            stmt.setInt(1, x);
            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    
    public int contaDoeCli(int x) throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(nome) as qtd from doacao where id_usuario=?");) {

            stmt.setInt(1, x);
            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    
    public int contaPagCli(int x) throws SQLException{
        int a=0;
        
        //conexao jdbc
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select count(id_pag_taxa) as qtd from pagamento_taxa where id_usuario=?");) {

            stmt.setInt(1, x);
            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    a=rs.getInt("qtd");
                }
            }
        }
        return a;
    }
    
}
