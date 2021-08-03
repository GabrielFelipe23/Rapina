/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Reserva;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gusta
 */
public class ReservaDAO {

    ArrayList<Reserva> lista = new ArrayList<>();

    public int ConsultaReserva(int dado, int idEsta) {
        //Consulta se o CPF é igual
        ConexaoJDBC conexao = new ConexaoJDBC();
        int verifica = 0;
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("Select*from reserva where num_reserva = ? and id_esta=?");
            stmt.setInt(1, dado);
            stmt.setInt(2, idEsta);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                verifica = 1;
                return verifica;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return verifica;
    }

    public void atualizaValida(int valor, int idEsta) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("update reserva set reserva_status='Validada' where num_reserva=? and id_esta=? and reserva_status='Ativa'");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.setInt(2, idEsta);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void atualizaSaida(int valor, int idEsta) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("update reserva set reserva_status='Aplicada' where num_reserva=? and id_esta=? and reserva_status='Validada'");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.setInt(2, idEsta);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void entraEsta(int idEsta) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("update estabelecimento set lotacao=lotacao+1 where id_esta=?");) {
            //Executa a Query
            stmt.setInt(1, idEsta);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void saiEsta(int idEsta) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("update estabelecimento set lotacao=lotacao-1 where id_esta=?");) {
            //Executa a Query
            stmt.setInt(1, idEsta);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<Reserva> listarDadosReserva(int id) throws SQLException {
        //Lista as Reservas
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select r.reserva_status, r.quant_pessoas, r.data_reserva, r.hora_reserva, l.nome from reserva as r join login as l on r.id_usuario=l.id_usuario where num_reserva=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reserva res = new Reserva();

                //Status
                res.setReserva_status(rs.getString("reserva_status"));
                //Nome
                res.setNome_reservado(rs.getString("nome"));
                //Pessoas
                res.setQtd_acompanhantes(rs.getInt("quant_pessoas"));
                //Data reservada
                res.setData_reservada(rs.getString("data_reserva"));
                //Horario reservado
                res.setHorario_reservado(rs.getString("hora_reserva"));

                lista.add(res);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    public List<Reserva> listarReservaCli(int id) throws SQLException {
        //Lista as Reservas
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select r.num_reserva, r.quant_pessoas, r.id_esta, r.data_reserva, r.hora_reserva, l.nome_esta, l.endereco, l.cep, l.numero, l.celular, l.taxa_cancelamento from reserva as r join estabelecimento as l on r.id_esta=l.id_esta where r.id_usuario=? && r.reserva_status='ativa' order by r.data_reserva desc;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reserva res = new Reserva();

                //num reserva
                res.setNum_reserva(rs.getInt("num_reserva"));

                //qtd de acompanhates
                res.setQtd_acompanhantes(rs.getInt("quant_pessoas"));

                //id do estabelecimento
                res.setId_estabelecimento(rs.getInt("id_esta"));

                //data reservada
                res.setData_reservada(rs.getString("data_reserva"));

                //horario reservado
                res.setHorario_reservado(rs.getString("hora_reserva"));

                //nome do estabelecimento
                res.setNome_Restaurante(rs.getString("nome_esta"));

                //endereço
                res.setEndereco(rs.getString("endereco"));

                //cep
                res.setCep(rs.getString("cep"));

                //numero
                res.setNumero(rs.getInt("numero"));

                //celular estabelecimento
                res.setContato_Rest(rs.getString("celular"));

                //valor da taxa
                res.setValor_taxa(rs.getFloat("taxa_cancelamento"));

                lista.add(res);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    public void cancelaReserva(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("UPDATE reserva SET reserva_status = 'Cancelada' WHERE num_reserva =?");) {

            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public int alteraReserva(Reserva dado) throws SQLException {
        //Altera a Reserva 
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        //var verificadora
        int altera = 0;
        //declarações do prepareStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("update reserva "
                + "set data_reserva=? ,hora_reserva=?, quant_pessoas=? where num_reserva=?");) {
            //passa os parametros
            stmt.setString(1, dado.getData_reservada());
            stmt.setString(2, dado.getHorario_reservado());
            stmt.setInt(3, dado.getQtd_acompanhantes());
            stmt.setInt(4, dado.getNum_reserva());
            stmt.executeUpdate();
            altera = 1;

        } catch (SQLException e) {
            System.out.println(e);
        }
        return altera;
    }

    public int criaReserva(Reserva dados) {
        int cria = 0;
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("insert into reserva (quant_pessoas, data_criacao, reserva_status, data_reserva, hora_reserva, id_usuario, id_esta) value (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {

            //Executa a Query
            stmt.setInt(1, dados.getQtd_acompanhantes());
            stmt.setString(2, dados.getData_criada());
            stmt.setString(3, dados.getReserva_status());
            stmt.setString(4, dados.getData_reservada());
            stmt.setString(5, dados.getHorario_reservado());
            stmt.setInt(6, dados.getId_cliente());
            stmt.setInt(7, dados.getId_estabelecimento());

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            int numReserva = 0;
            if (rs.next()) {
                numReserva = rs.getInt(1);

            }
            dados.setNum_reserva(numReserva);
            cria = 1;
            return cria;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return cria;
    }

}
