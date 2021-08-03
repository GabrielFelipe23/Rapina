package ConexaoBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gusta
 */
public class ConexaoJDBC {
    public Connection obterConexaoBD() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("Driver do MySQL não encontrado", ex);
        }
        /*Alteração 1: o "bd_test_rapina" será usado para testes, mudar para o
        nome definitivo após todos os testes serem feitos.
        Alteração 2: nome do user trocado para tads, referente a uma questão do Apache*/
        Connection conexao = DriverManager.getConnection("jdbc:mysql://local"
                + "host:3306/rapina?useUnicode=yes&"
                + "characterEncoding=UTF-8&useTimezone=America/Sao_Paulo", "tads", "senac");
        return conexao;

    }
}
