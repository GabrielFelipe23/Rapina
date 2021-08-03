package ClassesDAO;

import ClassesJavaBean.Cartao;
import ClassesJavaBean.Cliente;
import ClassesJavaBean.Estabelecimento;
import ClassesJavaBean.Login;
import ConexaoBD.ConexaoJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    private String email;
    private String senha;

    public LoginDAO() {
    }

    public LoginDAO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public int validaEmail(Login dadoRecebido) throws SQLException {
        //Var auxliadora
        int tipoUser = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email = ?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, dadoRecebido.getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tipoUser = rs.getInt("tipo_usuario");
                    dadoRecebido.setTipo_usuario(tipoUser);
                    return tipoUser;
                }
            }
        }
        return tipoUser;
    }

    public int validaSenha() throws SQLException {
        //Var auxliadora
        int liberaAcesso = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    String senhaBd = rs.getString("senha");

                    //condição
                    if (senhaBd.equals(getSenha())) {
                        liberaAcesso = 1;
                    } else {
                        liberaAcesso = 0;
                    }
                }
            }
        }
        return liberaAcesso;
    }
         public void atualizaLoginCli(Login dado) throws SQLException {
        //Atualiza o Login do Cliente 
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        //declarações do prepareStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("update login set nome=?,email=?, senha=? where id_usuario=?");) {
            //passa os parametros
            stmt.setString(1, dado.getNome());
            stmt.setString(2, dado.getEmail());
            stmt.setString(3, dado.getSenha());
            stmt.setInt(4, dado.getId_usuario());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
      public void atualizaLoginEsta(Login dado) throws SQLException {
        //Atualiza o Login do Estabelecimento 
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        //declarações do prepareStatement
        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("update login "
                        + "set nome=? ,email=?, senha=? where id_esta=?");) {
            //passa os parametros
            stmt.setString(1, dado.getNome());
            stmt.setString(2, dado.getEmail());
            stmt.setString(3, dado.getSenha());
            stmt.setInt(4, dado.getId_esta());
            stmt.executeUpdate();
  
        } catch (SQLException e) {
            System.out.println(e);
        }        
        

    }
    
    public int retornaIDEsta(String email) throws SQLException{
        //Var auxliadora
        int retorna = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    int idEsta = rs.getInt("id_esta");
                    
                    retorna = idEsta; 
                }
            }
        }
        return retorna;
    }
    public String retornaNome(String id) throws SQLException{
        //Var auxliadora
        String retorna = null;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    String nome = rs.getString("nome");
                    
                    retorna = nome; 
                }
            }
        }
        return retorna;
    }
    
    public int retornaIDCli(String email) throws SQLException{
        //Var auxliadora
        int retorna = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    int idEsta = rs.getInt("id_usuario");
                    
                    retorna = idEsta; 
                }
            }
        }
        return retorna;
    }
    public String retornaNomeCli(String id) throws SQLException{
        //Var auxliadora
        String retorna = null;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from login where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    String nome = rs.getString("nome");
                    
                    retorna = nome; 
                }
            }
        }
        return retorna;
    }
        public int retornaIDCartaoEsta(String email) throws SQLException{
        //Var auxliadora
        int retorna = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from estabelecimento where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    int idCartao = rs.getInt("id_cartao");
                    
                    retorna = idCartao; 
                }
            }
        }
        return retorna;
    }
        public int retornaIDCartaoCli(String email) throws SQLException{
        //Var auxliadora
        int retorna = 0;

        //Crio a conexao com o bd
        ConexaoJDBC conexao = new ConexaoJDBC();

        try (
                Connection conn = conexao.obterConexaoBD();
                PreparedStatement stmt = conn.prepareStatement("Select * from usuario where email =?");) {

            //passa o parametro recebido para o STMT usando o dado.get(atributo)
            stmt.setString(1, getEmail());

            //Executa a Query
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    //verifico se a senha digitada é igual da coluna do BD
                    int idCartao = rs.getInt("id_cartao");
                    
                    retorna = idCartao; 
                }
            }
        }
        return retorna;
    }
        public Estabelecimento pegaDadosEsta(int id) throws SQLException {
        //Lista os Estabelecimento
        Estabelecimento esta = new Estabelecimento();
        ConexaoJDBC conexao = new ConexaoJDBC();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select esta_status, id_planos, nome_esta, cnpj, endereco, cep, numero, celular, def_aud, def_fis, horario_de_fun, disponibilidade, taxa_cancelamento, capacidade, email, newslatter, concordar, senha, tipo_usuario from estabelecimento where id_esta=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Estabelecimento aux = new Estabelecimento();

                //Status
                String status=rs.getString("esta_status");

                //ID Planos
                int idPlano=rs.getInt("id_planos");

                //nome
                String nome = rs.getString("nome_esta");
                //cnpj
                String cnpj = rs.getString("cnpj");
                //endereco
                String endereco = rs.getString("endereco");
                //cep
                String cep = rs.getString("cep");
                //num
                String num = rs.getString("numero");
                //celular
                String cel = rs.getString("celular");
                
                //Horario Fun
                String horaFun = rs.getString("horario_de_fun");
                
                //Disponiblidade
                String dispo = rs.getString("disponibilidade");
                
                //deficiencias
                String defAud = rs.getString("def_aud");
                String defFis = rs.getString("def_fis");

                //valor taxa
                float taxaCancela =rs.getFloat("taxa_cancelamento");
                
                //capacidades
                int cap =rs.getInt("capacidade");
                
                //email
               String email =rs.getString("email");
               
               //Concorda
               String concorda = rs.getString("concordar");

                //News
                String conNews =rs.getString("newslatter");

                //Senha
                String senha =rs.getString("senha");
                
                //Tipo Usuario
                int tipo = rs.getInt("tipo_usuario");
                
                aux = new Estabelecimento(nome,cnpj,cep,endereco,num,defAud,defFis,horaFun,cap,taxaCancela,cel,email,senha,concorda,conNews,dispo,tipo);
                esta=aux;

                
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return esta;
    }
    
         public Cliente pegaDadosRapina(int id) throws SQLException {
        //Lista os Estabelecimento
        ConexaoJDBC conexao = new ConexaoJDBC();
        Cliente cli = new Cliente();
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select nome,cpf, nascimento, genero, newslatter, email, concordar, tipo_usuario, senha from usuario where id_usuario=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente aux = new Cliente();

                /////*PRIMEIRA LINHA*////
                String nome =rs.getString("nome");
                String cpf =rs.getString("cpf");
                String dataNasc = rs.getString("nascimento");
                String genero =rs.getString("genero");

                /////*SEGUNDA LINHA*////
                String concordar = rs.getString("concordar");
                String conNews = rs.getString("newslatter");
                String email = rs.getString("email");
                String senha =rs.getString("senha");
                int tipo = rs.getInt("tipo_usuario");
                
                aux = new Cliente(nome, cpf, email, genero, dataNasc, senha, concordar, concordar, tipo);

                cli = aux;
            }

        } catch (SQLException erro) {
            System.out.println(erro);
        }
        return cli;
    }
         
        public Cartao pegaDadosCartao(int id) {

        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        Cartao cartao = new Cartao();
        //verifica a senha
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select num_cartao, validade,cvv,titular from cartao where id_cartao = ?");
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cartao aux = new Cartao();
                String numCartao = rs.getString("num_cartao");
                String validade = rs.getString("validade");
                int cvv = rs.getInt("cvv");
                String titular = rs.getString("titular");
                
                aux = new Cartao(numCartao, validade, cvv, titular);
                cartao = aux;

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return cartao;
    }
    public void acessoCliente(String email) {

        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        //verifica a senha
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("update usuario set acesso = acesso + 1 where email=?");

            stmt.setString(1, email);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public int  retornaAcesso(String email) {
        int acess =0;
        
        //Elementos para a conexão e verificação
        ConexaoJDBC conexao = new ConexaoJDBC();
        //verifica a senha
        try {
            Connection conn = conexao.obterConexaoBD();
            PreparedStatement stmt = conn.prepareStatement("select acesso from usuario where email =?" );

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                acess = rs.getInt("acesso");
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return acess;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
