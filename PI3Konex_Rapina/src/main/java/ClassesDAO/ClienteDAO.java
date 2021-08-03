/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Cartao;
import ClassesJavaBean.Cliente;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
*
* @author gusta
 */
public class ClienteDAO {

    ArrayList<Cliente> lista = new ArrayList<>();
    ArrayList<Cartao> listaCartao = new ArrayList<>();
    ArrayList<Cartao> listaDoaCartao = new ArrayList<>();

    public ClienteDAO() {

    }

    public int ConsultaCPF(Cliente dado) {
        //Consulta se o CPF é igual
        ConexaoJDBC conexao = new ConexaoJDBC();
        int verifica = 0;
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("Select*from usuario where cpf = ?");
            stmt.setString(1, dado.getCpf());
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

    public int cadastra(Cliente dado) throws SQLException {
        //Elementos para a conexão e verificação
        int a = 0;
        int x = ConsultaCPF(dado);
        if (x == 1) {
            a = -1;
            return a;
        } else if (x == 0) {
            ConexaoJDBC conexao = new ConexaoJDBC();

            //Declarações do preparedStatement
            try (
                    Connection conn = conexao.obterConexaoBD();
                    PreparedStatement stmt = conn.prepareStatement("insert into usuario(nome,genero,cpf,"
                            + "email,senha,nascimento,concordar,newslatter"
                            + ",tipo_usuario,data_cadastro,acesso)"
                            + " values(?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {
                //passa os parametros
                stmt.setString(1, dado.getNome());
                stmt.setString(2, dado.getGenero());
                stmt.setString(3, dado.getCpf());
                stmt.setString(4, dado.getEmail());
                stmt.setString(5, dado.getSenha());
                stmt.setString(6, dado.getData_nascimento());
                stmt.setString(7, dado.getConcorda());
                stmt.setString(8, dado.getConcorda_newstalleter());
                stmt.setInt(9, dado.getTipo_user());
                stmt.setString(10, dado.getData_cadastros());
                stmt.setInt(11, dado.getAcesso());
                
                //Executa a Query
                stmt.executeUpdate();
                //Pega o ultimo id inserido no bd
                ResultSet rs = stmt.getGeneratedKeys();
                int id = 0;
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                dado.setId_usuario(id);
                a = 1;
                return a;
            } catch (SQLException e) {

                System.out.println(e);
            }
        }
        return a;

    }

    public int atualiza(Cliente dado) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        //Var verificador
        int atualiza = 0;
        String sql = "update usuario set nome=?, genero=?, cpf=?, email=?, senha=?,nascimento=?, concordar=? where id_usuario= ?";
        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement(sql);) {
            //Executa a Query
            stmt.setString(1, dado.getNome());
            stmt.setString(2, dado.getGenero());
            stmt.setString(3, dado.getCpf());
            stmt.setString(4, dado.getEmail());
            stmt.setString(5, dado.getSenha());
            stmt.setString(6, dado.getData_nascimento());
            stmt.setString(7, dado.getConcorda());
            stmt.setInt(8, dado.getId_usuario());
            stmt.executeUpdate();

            atualiza = 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return atualiza;
    }

    public void remove(int valor) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("delete from "
                + "usuario where id_usuario= ?");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<Cliente> listarTodos() throws SQLException {
        //Listagem de todos os Clientes
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select*from usuario");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                //id,nome,
                Cliente cliente = new Cliente();
                cliente.setId_usuario(rs.getInt("id_usuario"));
                cliente.setNome(rs.getString("nome"));
                cliente.setGenero(rs.getString("genero"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setData_nascimento(rs.getString("nascimento"));
                cliente.setConcorda(rs.getString("concordar"));
                cliente.setConcorda_newstalleter(rs.getString("newslatter"));
                cliente.setNum_cartao(rs.getInt("id_cartao"));
                cliente.setTipo_user(rs.getInt("tipo_usuario"));
                lista.add(cliente);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    public Cliente cliPorID(int cliID) throws SQLException {
        //Pega Cliente por ID
        Cliente cli = new Cliente();
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select * from usuario where id_usuario=?");
            stmt.setInt(1, cliID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cli.setId_usuario(rs.getInt("id_usuario"));
                cli.setNome(rs.getString("nome"));
                cli.setGenero(rs.getString("genero"));
                cli.setCpf(rs.getString("cpf"));
                cli.setEmail(rs.getString("email"));
                cli.setSenha(rs.getString("senha"));
                cli.setData_nascimento(rs.getString("nascimento"));
                cli.setConcorda(rs.getString("concordar"));
                cli.setConcorda_newstalleter(rs.getString("newslatter"));
                cli.setNum_cartao(rs.getInt("id_cartao"));
                cli.setTipo_user(rs.getInt("tipo_usuario"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cli;
    }

    public int cadastraCartao(Cartao dadoCartao) throws SQLException {
        //Cadastra o Cartao do Cliente
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        Cliente cli = new Cliente();
        int a = 0;
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("insert into cartao(num_cartao,validade"
                + ",cvv,titular) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {

            //passa os parametros do cartao
            stmt.setString(1, dadoCartao.getNum_cartao());
            stmt.setString(2, dadoCartao.getValidade());
            stmt.setInt(3, dadoCartao.getCvv());
            stmt.setString(4, dadoCartao.getTitular());

            //Executa a Query
            stmt.executeUpdate();
            //Pega o ultimo id do cartao
            ResultSet rs = stmt.getGeneratedKeys();
            int idCartaoCli = 0;
            if (rs.next()) {
                idCartaoCli = rs.getInt(1);

            }
            dadoCartao.setId_card(idCartaoCli);
            cli.setNum_cartao(idCartaoCli);
            a = 1;
            return a;
        } catch (SQLException e) {
            System.out.println(e);

        }
        return a;
    }

    public void vinculaCartao(Cartao dado, int cli) throws SQLException {
        //Vincula cartão com o ultimo cliente
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        String sql = "update usuario set id_cartao= (?) where id_usuario= (?)";
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt2 = conn.prepareStatement(sql)) {

            //Setando Parametros
            stmt2.setInt(1, dado.getId_card());
            stmt2.setInt(2, cli);
            stmt2.executeUpdate();
        }
    }

    public int atualizaCartao(Cartao dado) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //var verificador
        int a = 0;

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("update cartao "
                + "set num_cartao= ?, validade= ?, cvv= ?, titular= ? where id_cartao= ?");) {

            //Executa a Query
            stmt.setString(1, dado.getNum_cartao());
            stmt.setString(2, dado.getValidade());
            stmt.setInt(3, dado.getCvv());
            stmt.setString(4, dado.getTitular());
            stmt.setInt(5, dado.getId_card());

            //executa
            stmt.executeUpdate();

            //novo valor de A
            a = 1;
        } catch (SQLException e) {
            System.out.println(e);

        }
        return a;
    }

    public int verificaSenha(Cliente dado) {
        int verifica = 0;

        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //verifica a senha
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select * from usuario where id_usuario = ?");

            stmt.setInt(1, dado.getId_usuario());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senha = rs.getString("senha");

                if (senha.equals(dado.getSenha())) {
                    verifica = 1;

                } else {
                    verifica = -1;
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return verifica;
    }

    public List<Cliente> listarDadosRapina(int id) throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select nome,cpf, nascimento, genero, newslatter, email, senha from usuario where id_usuario=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();

                /////*PRIMEIRA LINHA*////
                cli.setNome(rs.getString("nome"));
                cli.setCpf(rs.getString("cpf"));
                cli.setData_nascimento(rs.getString("nascimento"));
                cli.setGenero(rs.getString("genero"));

                /////*SEGUNDA LINHA*////
                cli.setConcorda_newstalleter(rs.getString("newslatter"));
                cli.setEmail(rs.getString("email"));
                cli.setSenha(rs.getString("senha"));

                lista.add(cli);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    public List<Cartao> listaIDCartao(int id) throws SQLException {
        //Lista os Cartaos do usuario
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select id_cartao from usuario where id_usuario=?;");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cartao cartao = new Cartao();

                //id Cartao
                cartao.setId_card(rs.getInt("id_cartao"));

                listaDoaCartao.add(cartao);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return listaDoaCartao;
    }

    public String verificaUser(int id) {
        //Consulta se é o primeiro cadastro dele
        ConexaoJDBC conexao = new ConexaoJDBC();
        String verifica = null;
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("Select data_cadastro from usuario where id_usuario = ?");
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String dataCad = rs.getString("data_cadastro");
                verifica = dataCad;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return verifica;
    }
}
