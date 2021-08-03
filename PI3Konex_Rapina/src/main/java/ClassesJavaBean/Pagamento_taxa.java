
package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Pagamento_taxa {
    
    //atributos pagamento taxa
    private int id_pagamento_taxa;
    public String describe_taxa;
    public String data_cobranca;
    public String nomeUser;
    private float valor_rapina_adm;
    private float valor_estabelecimento;
    private float valor_total;
    public int id_usuario;
    private int id_adm;
    public int id_estabelecimento;
    public int tipo_user;
    
    //metodo construtor

    public Pagamento_taxa() {
    }
    
    //Metodos especiais
    public void consultarTaxa() {
    }

    public void pagarTaxa() {
    }
    
    public Pagamento_taxa(int id_usuario,String nomeUser, String data_cobranca, float valor_total, int tipo_user){
        this.id_usuario=id_usuario;
        this.nomeUser=nomeUser;
        this.data_cobranca=data_cobranca;
        this.valor_total=valor_total;
        this.tipo_user=tipo_user;
    }
    
    public Pagamento_taxa(String nomeUser, String data_cobranca, float valor_total, int tipo_user, int id_estabelecimento){
        this.nomeUser=nomeUser;
        this.data_cobranca=data_cobranca;
        this.valor_total=valor_total;
        this.tipo_user=tipo_user;
        this.id_estabelecimento=id_estabelecimento;
    }
    
    
    //metodos especiais

    public int getId_pagamento_taxa() {
        return id_pagamento_taxa;
    }

    public void setId_pagamento_taxa(int id_pagamento_taxa) {
        this.id_pagamento_taxa = id_pagamento_taxa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getDescribe_taxa() {
        return describe_taxa;
    }

    public void setDescribe_taxa(String describe_taxa) {
        this.describe_taxa = describe_taxa;
    }

    public String getData_cobranca() {
        return data_cobranca;
    }

    public void setData_cobranca(String data_cobranca) {
        this.data_cobranca = data_cobranca;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }
    

    public float getValor_rapina_adm() {
        return valor_rapina_adm;
    }

    public void setValor_rapina_adm(float valor_rapina_adm) {
        this.valor_rapina_adm = valor_rapina_adm;
    }

    public float getValor_estabelecimento() {
        return valor_estabelecimento;
    }

    public void setValor_estabelecimento(float valor_estabelecimento) {
        this.valor_estabelecimento = valor_estabelecimento;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public int getId_adm() {
        return id_adm;
    }

    public void setId_adm(int id_adm) {
        this.id_adm = id_adm;
    }

    public int getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(int id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

    public int getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(int tipo_user) {
        this.tipo_user = tipo_user;
    }
    
    
}
