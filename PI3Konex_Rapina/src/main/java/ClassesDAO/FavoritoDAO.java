/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Favoritos;
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
public class FavoritoDAO {
    ArrayList<Favoritos> lista = new ArrayList<>();
    public List<Favoritos> listarDadosFavoritos(int id) throws SQLException {
        //Lista os Favoritos
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select nome_esta,id_favorito from favorito where id_usuario=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Favoritos fav = new Favoritos();

                //Nome Estabelecimento
                fav.setNome_estabelecimento(rs.getString("nome_esta"));
                //id Restaurante
                fav.setId_favorito(rs.getInt("id_favorito"));
                
                lista.add(fav);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }
    public void removeFav(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("delete from favorito where id_favorito=?");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }        
}
