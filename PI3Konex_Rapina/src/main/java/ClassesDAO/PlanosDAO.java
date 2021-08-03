/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Planos;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex Yudy Kitahara
 */
public class PlanosDAO {
    ArrayList<Planos> lista = new ArrayList<>();
    
    public int atualizaPlano(Planos dado, int idesta) throws SQLException {
        //Elementos para a conexão e verificação
        
        ConexaoJDBC conexao = new ConexaoJDBC();
        //Var verificador
        int atualiza = 0;
        String sql = "update estabelecimento set id_planos=? where id_esta = ?";
        //declarações do preparedStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement(sql);) {
            //Executa a Query
            stmt.setInt(1, dado.getId_planos());
            stmt.setInt(2, idesta);
            stmt.executeUpdate();

            atualiza = 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return atualiza;
    }
    
    
    public List<Planos>planosPorID(int id_esta) throws SQLException {
        //Pega planosente por ID
        
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select a.nome,a.valor,b.status_plano,b.dia_vencimento from planos as a inner join estabelecimento as b on a.id_planos = b.id_planos where id_esta =?");
            stmt.setInt(1, id_esta);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Planos planos = new Planos();
                planos.setNome_plano(rs.getString("nome"));
                planos.setValor_plano(rs.getFloat("valor"));
                planos.setStatus_plano(rs.getString("status_plano"));
                planos.setDia_vencimento(rs.getInt("dia_vencimento"));
                lista.add(planos);
                
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return lista;
    }
}
