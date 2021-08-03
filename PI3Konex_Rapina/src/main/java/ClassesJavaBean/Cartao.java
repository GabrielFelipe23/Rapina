
package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Cartao {
    //atributos do cartão
    public int id_card;
    public String num_cartao;
    private String validade;
    private int cvv;
    private String titular;
    
    //metodo construtor
    public Cartao() {
    }
    public Cartao(String num_cartao, String validade, int cvv, String titular) {
        this.num_cartao = num_cartao;
        this.validade = validade;
        this.cvv = cvv;
        this.titular = titular;
    }
    //metodos getters e setters

    public String getNum_cartao() {
        return num_cartao;
    }

    public void setNum_cartao(String num_cartao) {
        this.num_cartao = num_cartao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

}
