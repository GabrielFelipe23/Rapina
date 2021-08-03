/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesDAO;

import ClassesJavaBean.Cartao;
import ClassesJavaBean.Doacao;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Pagamento_mensalidade;
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
public class EstabelecimentoDAO {

    ArrayList<Estabelecimento> lista = new ArrayList<>();
    ArrayList<Reserva> listaRes = new ArrayList<>();
    ArrayList<Reserva> consRes = new ArrayList<>();
    ArrayList<Pagamento_mensalidade> listaMensal = new ArrayList<>();
    ArrayList<Doacao> listaDoa = new ArrayList<>();

    public EstabelecimentoDAO() {

    }

    public int consultaCNPJ(Estabelecimento dado) {
        //Consulta se o CNPJ informado já existe no bd
        ConexaoJDBC conexao = new ConexaoJDBC();
        int verifica = 0;
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("Select*from estabelecimento where cnpj = ?");
            stmt.setString(1, dado.getCnpj());
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

    public int cadastraEst(Estabelecimento dado) throws SQLException {
        //Cadastra o Estabelecimento
        int cadastrado = 0;
        int verifica = consultaCNPJ(dado);
        if (verifica == 1) {
            cadastrado = -1;
            return cadastrado;
        } else if (verifica == 0) {
            //Elementos para a conexão e verificação
            ConexaoJDBC conexao = new ConexaoJDBC();

            //declarações do prepareStatement
            try (
                     Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("insert into estabelecimento(nome_esta,cnpj,email,senha,capacidade,lotacao,endereco,cep,numero,celular,horario_de_fun,disponibilidade,taxa_cancelamento,concordar,newslatter,def_aud,def_fis,tipo_usuario) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);) {
                //passa os parametros
                stmt.setString(1, dado.getNome_estabelecimento());
                stmt.setString(2, dado.getCnpj());
                stmt.setString(3, dado.getEmail());
                stmt.setString(4, dado.getSenha());
                stmt.setInt(5, dado.getCapacidade());
                stmt.setInt(6, dado.getLotacao());
                stmt.setString(7, dado.getLogadouro_estabelecimento());
                stmt.setString(8, dado.getCep_estabelecimento());
                stmt.setString(9, dado.getNumero());
                stmt.setString(10, dado.getCelular());
                stmt.setString(11, dado.getHorario_funcionamento());
                stmt.setString(12, dado.getDisponibilidade());
                stmt.setFloat(13, dado.getTaxa_cancelamento());
                stmt.setString(14, dado.getConcorda());
                stmt.setString(15, dado.getConcorda_newstalleter());
                stmt.setString(16, dado.getAcessi_auditiva());
                stmt.setString(17, dado.getAcessi_fisico());
                stmt.setInt(18, dado.getTipo_user());
                
                //Executa a Query
                cadastrado = stmt.executeUpdate();
                //Pega o id inserido no bd da tabela estabelecimento
                ResultSet rs = stmt.getGeneratedKeys();
                int id = 0;
                if (rs.next()) {
                    id = rs.getInt(1);
                }
                dado.setId_estabelecimento(id);
                cadastrado = 1;
                return cadastrado;
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        return cadastrado;
    }

    public void atualiazaStatus(String st, int id) throws SQLException {

        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("update estabelecimento set esta_status=? where id_esta=?");) {
            //passa os parametros
            stmt.setString(1, st);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int atualiazaEst(Estabelecimento dado) throws SQLException {
        //Atualiza o Estabelecimento 
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        //var verificadora
        int atualiza = 0;
        //declarações do prepareStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("update estabelecimento set nome_esta=?,email=?, senha=?, capacidade=?, endereco=?, cep=?, numero=?, celular=?, horario_de_fun=?,taxa_cancelamento=?,concordar=?,def_aud=?, def_fis=? where id_esta=?");) {
            //passa os parametros
            stmt.setString(1, dado.getNome_estabelecimento());
            stmt.setString(2, dado.getEmail());
            stmt.setString(3, dado.getSenha());
            stmt.setInt(4, dado.getCapacidade());
            stmt.setString(5, dado.getLogadouro_estabelecimento());
            stmt.setString(6, dado.getCep_estabelecimento());
            stmt.setString(7, dado.getNumero());
            stmt.setString(8, dado.getCelular());
            stmt.setString(9, dado.getHorario_funcionamento());
            stmt.setFloat(10, dado.getTaxa_cancelamento());
            stmt.setString(11, dado.getConcorda());
            stmt.setString(12, dado.getAcessi_auditiva());
            stmt.setString(13, dado.getAcessi_fisico());
            stmt.setInt(14, dado.getId_estabelecimento());
            stmt.executeUpdate();

            atualiza = 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return atualiza;

    }

    public void remove(int valor) throws SQLException {
        //Remover o Estabelecimento por ID
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //declarações do preparedStatement
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt = conn.prepareStatement("delete from "
                + "estabelecimento where id_esta= ?");) {
            //Executa a Query
            stmt.setInt(1, valor);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public List<Estabelecimento> listarTodos() throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select*from estabelecimento;");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estabelecimento esta = new Estabelecimento();
                esta.setId_estabelecimento(rs.getInt("id_esta"));
                esta.setNome_estabelecimento(rs.getString("nome_esta"));
                esta.setCnpj(rs.getString("cnpj"));
                esta.setCep_estabelecimento(rs.getString("cep"));
                esta.setLogadouro_estabelecimento(rs.getString("endereco"));
                esta.setNumero(rs.getString("numero"));
                esta.setAcessi_auditiva(rs.getString("def_aud"));
                esta.setAcessi_fisico(rs.getString("def_fis"));
                esta.setHorario_funcionamento(rs.getString("horario_de_fun"));
                esta.setCapacidade(rs.getInt("capacidade"));
                esta.setTaxa_cancelamento(rs.getFloat("taxa_cancelamento"));
                esta.setEmail(rs.getString("email"));
                esta.setSenha(rs.getString("senha"));
                esta.setConcorda(rs.getString("concordar"));
                esta.setConcorda_newstalleter(rs.getString("newslatter"));
                esta.setDisponibilidade(rs.getString("disponibilidade"));
                esta.setId_planos(rs.getInt("id_planos"));
                esta.setTipo_user(rs.getInt("tipo_usuario"));
                lista.add(esta);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    public Estabelecimento estaPorID(int estaID) throws SQLException {
        //Pega um Estabelecimento pelo ID
        Estabelecimento esta = new Estabelecimento();
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select * from estabelecimento where id_esta=?;");
            stmt.setInt(1, estaID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                esta.setId_estabelecimento(rs.getInt("id_esta"));
                esta.setNome_estabelecimento(rs.getString("nome_esta"));
                esta.setCnpj(rs.getString("cnpj"));
                esta.setCep_estabelecimento(rs.getString("cep"));
                esta.setLogadouro_estabelecimento(rs.getString("endereco"));
                esta.setNumero(rs.getString("numero"));
                esta.setAcessi_auditiva(rs.getString("def_aud"));
                esta.setAcessi_fisico(rs.getString("def_fis"));
                esta.setHorario_funcionamento(rs.getString("horario_de_fun"));
                esta.setCapacidade(rs.getInt("capacidade"));
                esta.setTaxa_cancelamento(rs.getFloat("taxa_cancelamento"));
                esta.setEmail(rs.getString("email"));
                esta.setSenha(rs.getString("senha"));
                esta.setConcorda(rs.getString("concordar"));
                esta.setConcorda_newstalleter(rs.getString("newslatter"));
                esta.setDisponibilidade(rs.getString("disponibilidade"));
                esta.setId_planos(rs.getInt("id_planos"));
                esta.setTipo_user(rs.getInt("tipo_usuario"));

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return esta;
    }

    public int cadastraCartaoEsta(Cartao dadoCartao) throws SQLException {
        //Cadastra o Cartao do Estabelecimento
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        Estabelecimento esta = new Estabelecimento();
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
            int idCartaoEsta = 0;
            if (rs.next()) {
                idCartaoEsta = rs.getInt(1);

            }
            dadoCartao.setId_card(idCartaoEsta);
            esta.setId_cartao(idCartaoEsta);
            a = 1;
            return a;
        } catch (SQLException e) {
            System.out.println(e);

        }
        return a;
    }

    public void vinculaCartaoEsta(Cartao dado, int esta) throws SQLException {
        //Vincula cartão com o ultimo estabelecimento
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        String sql = "update estabelecimento set id_cartao= (?) where id_esta= (?)";
        try (
                 Connection conn = conexao.obterConexaoBD();  PreparedStatement stmt2 = conn.prepareStatement(sql)) {

            //Setando Parametros
            stmt2.setInt(1, dado.getId_card());
            stmt2.setInt(2, esta);
            stmt2.executeUpdate();
        }
    }

    public void atualizaCartaoEsta(Cartao dado) throws SQLException {
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //var verificador
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
        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public int verificaSenha(Estabelecimento dado) {
        int verifica = 0;

        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();

        //verifica a senha
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select * from estabelecimento where id_esta = ?");

            stmt.setInt(1, dado.getId_estabelecimento());
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

    public List<Estabelecimento> listarDadosADM(int id) throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select esta_status, id_planos, nome_esta, cnpj, endereco, cep, numero, celular, def_aud, def_fis, taxa_cancelamento, capacidade, email, newslatter, senha from estabelecimento where id_esta=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estabelecimento esta = new Estabelecimento();

                /////*PRIMEIRA LINHA*////
                //Status
                esta.setEsta_status(rs.getString("esta_status"));

                /////*SEGUNDA LINHA*////
                esta.setId_planos(rs.getInt("id_planos"));

                //quantidade de reservas
                /////*TERCEIRA LINHA*////
                //nome
                esta.setNome_estabelecimento(rs.getString("nome_esta"));
                //cnpj
                esta.setCnpj(rs.getString("cnpj"));
                //endereco
                esta.setLogadouro_estabelecimento(rs.getString("endereco"));
                //cep
                esta.setCep_estabelecimento(rs.getString("cep"));
                //num
                esta.setNumero(rs.getString("numero"));
                //celular
                esta.setCelular(rs.getString("celular"));

                /////*TERCEIRA LINHA*////
                //deficiencias
                esta.setAcessi_auditiva(rs.getString("def_aud"));
                esta.setAcessi_fisico(rs.getString("def_fis"));

                //valor taxa
                esta.setTaxa_cancelamento(rs.getFloat("taxa_cancelamento"));
                //capacidades
                esta.setCapacidade(rs.getInt("capacidade"));

                //email
                esta.setEmail(rs.getString("email"));

                //News
                esta.setConcorda_newstalleter(rs.getString("newslatter"));

                /////*QUINTA LINHA*////
                esta.setSenha(rs.getString("senha"));

                lista.add(esta);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }

    /*Menu Esta*/
    public List<Reserva> listarDadosRes(int id) throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select r.num_reserva, r.data_reserva,r.hora_reserva,r.reserva_status,l.nome from reserva as r join login as l on r.id_usuario=l.id_usuario  where r.id_esta=? order by r.reserva_status = 'Ativa' desc");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reserva res = new Reserva();

                /////*PRIMEIRA LINHA*////
                //Status
                res.setNum_reserva(rs.getInt("num_reserva"));

                /////*SEGUNDA LINHA*////
                res.setData_reservada(rs.getString("data_reserva"));

                //quantidade de reservas
                /////*TERCEIRA LINHA*////
                //nome
                res.setHorario_reservado(rs.getString("hora_reserva"));
                //cnpj
                res.setReserva_status(rs.getString("reserva_status"));
                //endereco
                res.setNome_reservado(rs.getString("nome"));

                listaRes.add(res);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return listaRes;
    }

    public List<Reserva> consultaRes(int num, int idEsta) throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select data_reserva,hora_reserva,reserva_status from reserva where num_reserva=? and id_esta=?");
            stmt.setInt(1, num);
            stmt.setInt(2, idEsta);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reserva conRes = new Reserva();

                conRes.setData_reservada(rs.getString("data_reserva"));
                conRes.setHorario_reservado(rs.getString("hora_reserva"));
                conRes.setReserva_status(rs.getString("reserva_status"));

                consRes.add(conRes);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return consRes;
    }

    public List<Doacao> listaDadosDoa(int id) throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select d.valor, l.nome from doacao as d join login as l on d.id_usuario = l.id_usuario where d.id_esta=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Doacao doa = new Doacao();

                //Valor
                doa.setValor(rs.getFloat("valor"));
                //Nome
                doa.setNome(rs.getString("nome"));

                listaDoa.add(doa);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return listaDoa;
    }

    public List<Pagamento_mensalidade> listaPagMensal(int id) throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select pm.data_cobranca,p.valor from pagamento_mensalidade as pm join planos as p on pm.id_planos=p.id_planos where pm.id_esta = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pagamento_mensalidade pm = new Pagamento_mensalidade();

                //Data de Reserva
                pm.setData_cobranca(rs.getString("data_cobranca"));
                //Horario de Reserva
                pm.setValor(rs.getFloat("valor"));

                listaMensal.add(pm);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return listaMensal;
    }

    public List<Estabelecimento> retornaRestCep(String cep) throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select*from estabelecimento where cep= ? order by id_planos");
            stmt.setString(1, cep);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estabelecimento esta = new Estabelecimento();

                esta.setCep_estabelecimento(rs.getString("cep"));
                esta.setId_estabelecimento(rs.getInt("id_esta"));
                esta.setNome_estabelecimento(rs.getString("nome_esta"));
                esta.setLogadouro_estabelecimento(rs.getString("endereco"));
                esta.setNumero(rs.getString("numero"));
                esta.setAcessi_auditiva(rs.getString("def_aud"));
                esta.setAcessi_fisico(rs.getString("def_fis"));
                esta.setEmail(rs.getString("email"));
                esta.setCelular(rs.getString("celular"));
                esta.setCapacidade(rs.getInt("capacidade"));
                esta.setLotacao(rs.getInt("lotacao"));
                esta.setCnpj(rs.getString("cnpj"));
                esta.setHorario_funcionamento(rs.getString("horario_de_fun"));
                esta.setTaxa_cancelamento(rs.getFloat("taxa_cancelamento"));
                esta.setId_planos(rs.getInt("id_planos"));

                lista.add(esta);
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return lista;
    }
}
