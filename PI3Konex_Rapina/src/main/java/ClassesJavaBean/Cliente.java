
package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Cliente {

    //Atributos do usuário 
    public int id_usuario;
    public String nome;
    private String cpf;
    private String email;
    private String genero;
    private String data_nascimento;
    private String senha;
    private String concorda;
    public String concorda_newstalleter;
    public int num_cartao;
    public int id_favoritado;
    public int tipo_user;
    public String data_cadastros;
    public int acesso;
            
            
    //metodo construtor
    public Cliente() {
    }
    
    public Cliente(String nome,String cpf, String email, String genero, 
            String data_nascimento, String senha,String concorda, 
            String concorda_newstalleter, int tipo_user) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.genero = genero;
        this.data_nascimento = data_nascimento;
        this.senha = senha;
        this.concorda = concorda;
        this.concorda_newstalleter = concorda_newstalleter;
        this.tipo_user = tipo_user;
    }


    //metodos getters e setters
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConcorda() {
        return concorda;
    }

    public void setConcorda(String concorda) {
        this.concorda = concorda;
    }

    public String getConcorda_newstalleter() {
        return concorda_newstalleter;
    }

    public void setConcorda_newstalleter(String concorda_newstalleter) {
        this.concorda_newstalleter = concorda_newstalleter;
    }

    public int getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(int num_cartao) {
        this.num_cartao = num_cartao;
    }

    public int getId_favoritado() {
        return id_favoritado;
    }

    public void setId_favoritado(int id_favoritado) {
        this.id_favoritado = id_favoritado;
    }

    public int getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(int tipo_user) {
        this.tipo_user = tipo_user;
    }

    public String getData_cadastros() {
        return data_cadastros;
    }

    public void setData_cadastros(String data_cadastros) {
        this.data_cadastros = data_cadastros;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
    
    
}
