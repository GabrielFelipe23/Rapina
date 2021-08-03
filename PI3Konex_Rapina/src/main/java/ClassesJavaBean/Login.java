/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesJavaBean;

/**
 *
 * @author Gabriel
 */
public class Login {
    private int id_login;
    private String email;
    private String senha;
    public String nome;
    private int id_esta;
    private int id_adm;
    private int id_usuario;
    private int tipo_usuario;

    public Login() {
    }

    public Login(String email) {
        if(email!=null){
            this.email = email;
        }
    }

    
    
    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
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
        public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_esta() {
        return id_esta;
    }

    public void setId_esta(int id_esta) {
        this.id_esta = id_esta;
    }

    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(int tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    
    
    
}