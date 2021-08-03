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
public class Doacao {
    public int id_doacao;
    public String nome;
    public float valor;
    private String data_doa;
    private int id_user;
    private int id_cartao;
    private int id_esta;
    
    //metodo construtor
    public Doacao(String nome, float valor, int id_user,String data_doa, int id_esta, int id_cartao) {
        this.nome = nome;
        this.valor = valor;
        this.id_user = id_user;
        this.data_doa = data_doa;
        this.id_esta = id_esta;
        this.id_cartao = id_cartao;
    }
    public Doacao(){
        
    }

    public int getId_doacao() {
        return id_doacao;
    }

    public void setId_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getId_user() {
        return id_user;
    }

    public String getData_doa() {
        return data_doa;
    }

    public void setData_doa(String data_doa) {
        this.data_doa = data_doa;
    }

    public int getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(int id_cartao) {
        this.id_cartao = id_cartao;
    }
    

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getID_cartao() {
        return id_cartao;
    }
    

    public int getId_esta() {
        return id_esta;
    }

    public void setId_esta(int id_esta) {
        this.id_esta = id_esta;
    }
    
}
