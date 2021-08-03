
package ClassesJavaBean;

import java.util.Date;

/**
 *
 * @author Gabriel Felipe
 */
public class Planos {
    //Atributos plano rapina
    public int id_planos;
    public String nome_plano;
    private float valor_plano;
    public String benefícios;
    private int id_esta;
    private String status_plano;
    private int dia_vencimento;
    private int mes_vencimento;

    //metodo construtor
    public Planos(){
        
    }
    
    public Planos(String nome_plano) {   
        //condição dos planos 
        if(null != this.nome_plano)switch (this.nome_plano) {
            case "Serrana":
                this.valor_plano=(float) 19.9;
                break;
            case "Rarpy":
                this.valor_plano=(float) 49.9;
                break;
            case "Açor":
                this.valor_plano=(float) 29.9;
                break;
            default:
                break;
        }
        
    }

    //metodo getters e setters

    public int getId_planos() {
        return id_planos;
    }

    public void setId_planos(int id_planos) {
        this.id_planos = id_planos;
    }

    public String getNome_plano() {
        return nome_plano;
    }

    public void setNome_plano(String nome_plano) {
        this.nome_plano = nome_plano;
    }

    public float getValor_plano() {
        return valor_plano;
    }

    public void setValor_plano(float valor_plano) {
        this.valor_plano = valor_plano;
    }

    public String getBenefícios() {
        return benefícios;
    }

    public void setBenefícios(String benefícios) {
        this.benefícios = benefícios;
    }

    /**
     * @return the id_esta
     */
    public int getId_esta() {
        return id_esta;
    }

    /**
     * @param id_esta the id_esta to set
     */
    public void setId_esta(int id_esta) {
        this.id_esta = id_esta;
    }

    /**
     * @return the status_plano
     */
    public String getStatus_plano() {
        return status_plano;
    }

    /**
     * @param status_plano the status_plano to set
     */
    public void setStatus_plano(String status_plano) {
        this.status_plano = status_plano;
    }    

    /**
     * @return the dia_vencimento
     */
    public int getDia_vencimento() {
        return dia_vencimento;
    }

    /**
     * @param dia_vencimento the dia_vencimento to set
     */
    public void setDia_vencimento(int dia_vencimento) {
        this.dia_vencimento = dia_vencimento;
    }

    /**
     * @return the mes_vencimento
     */
    public int getMes_vencimento() {
        return mes_vencimento;
    }

    /**
     * @param mes_vencimento the mes_vencimento to set
     */
    public void setMes_vencimento(int mes_vencimento) {
        this.mes_vencimento = mes_vencimento;
    }
}
