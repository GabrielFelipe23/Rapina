/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Doacao;
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
public class DoacaoDAO {
    ArrayList<Doacao> lista = new ArrayList<>();
    
    //Consulta o Nome para Converter 
    public int consultaNome(String nome) throws SQLException {
        //Elementos para a conexão e verificação
        int a = 0;
        ConexaoJDBC conexao = new ConexaoJDBC();

        //Declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("select id_esta from estabelecimento where nome_esta =?")) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int resultado = rs.getInt("id_esta");
                a = resultado;
            }
        }
        return a;
    }

    //Cadastra a Doação
    public int cadastra(Doacao dado) throws SQLException {
        //Elementos para a conexão e verificação
        int a = 0;
        ConexaoJDBC conexao = new ConexaoJDBC();

        //Declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  
                 PreparedStatement stmt = conn.prepareStatement("insert into doacao(nome, valor, id_usuario,data_doacao, id_esta, id_cartao)"
                + " values(?,?,?,?,?,?)");) {
            //passa os parametros
            stmt.setString(1, dado.getNome());
            stmt.setFloat(2, dado.getValor());
            stmt.setInt(3, dado.getId_user());
            stmt.setString(4, dado.getData_doa());
            stmt.setInt(5, dado.getId_esta());
            stmt.setInt(6, dado.getID_cartao());

            //Executa a Query
            stmt.executeUpdate();
            //Pega o ultimo id inserido no bd
            a = 1;
            return a;

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return a;
    }

    public void remove(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("delete from "
                + "doacao where id_doacao= ?");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    //Mais Funções serao adicionadas
    public List<Doacao> listaDoacoesClie(int id) throws SQLException {
        //Lista os Favoritos
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select*from doacao where id_usuario=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Doacao doa = new Doacao();

                //id doações
                doa.setId_doacao(rs.getInt("id_doacao"));
                
                //nome da doação
                doa.setNome(rs.getString("nome"));
                
                //Data da doação
                doa.setData_doa(rs.getString("data_doacao"));
                
                //valor da doacao
                doa.setValor(rs.getFloat("valor"));
                
                //estabelecimento
                doa.setId_esta(rs.getInt("id_esta"));
                lista.add(doa);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }
    public void refazDoacoes(int idUser, int idEsta, String name, String data, float value) throws SQLException {
        //Elementos para a conexão e verificação
        int a = 0;
        ConexaoJDBC conexao = new ConexaoJDBC();

        //Declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  
                 PreparedStatement stmt = conn.prepareStatement("insert into doacao(nome, valor, id_usuario,data_doacao, id_esta)"
                                                                + " values(?,?,?,?,?)");) {
            //passa os parametros
            stmt.setString(1, name);
            stmt.setFloat(2, value);
            stmt.setInt(3, idUser);
            stmt.setString(4, data);
            stmt.setInt(5, idEsta);

            //Executa a Query
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
}
