package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Estabelecimento {

    //Atributos do Estabelecimento
    public int id_estabelecimento;
    public String nome_estabelecimento;
    private String cnpj;
    private String email;
    private String senha;
    public int capacidade;
    private int lotacao;
    public String cep_estabelecimento;
    public String logadouro_estabelecimento;
    public String numero;
    public String horario_funcionamento;
    public String disponibilidade;
    public String acessi_auditiva;
    public String acessi_fisico;
    public String acessi_nenhuma;
    public float taxa_cancelamento;
    private String celular;
    private String concorda;
    public String concorda_newstalleter;
    public int tipo_user;
    private int id_planos;
    private int id_pagamento_taxa;
    public int id_cartao;
    public String esta_status;
    public String auxPlano;
    
    public Estabelecimento() {

    }

    public Estabelecimento(String nome_estabelecimento, String cnpj,
            String cep_estabelecimento, String logadouro_estabelecimento,
            String numero, String acessi_auditiva, String acessi_fisico,
            String horario_funcionamento, int capacidade,
            float taxa_cancelamento, String celular, String email, String senha,
            String concorda, String concorda_newstalleter,
            String disponibilidade,int tipo_user) {
        this.nome_estabelecimento = nome_estabelecimento;
        this.cnpj = cnpj;
        this.cep_estabelecimento = cep_estabelecimento;
        this.logadouro_estabelecimento = logadouro_estabelecimento;
        this.numero = numero;
        this.acessi_auditiva = acessi_auditiva;
        this.acessi_fisico = acessi_fisico;
        this.horario_funcionamento = horario_funcionamento;
        this.capacidade = capacidade;
        this.taxa_cancelamento = taxa_cancelamento;
        this.email = email;
        this.senha = senha;
        this.concorda = concorda;
        this.celular = celular;
        this.concorda_newstalleter = concorda_newstalleter;
        this.disponibilidade = disponibilidade;
        this.tipo_user = tipo_user;
        if (concorda_newstalleter == null) {
            this.concorda_newstalleter = "Não";
        }

    }

    public int getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(int id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

    public String getNome_estabelecimento() {
        return nome_estabelecimento;
    }

    public void setNome_estabelecimento(String nome_estabelecimento) {
        this.nome_estabelecimento = nome_estabelecimento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCep_estabelecimento() {
        return cep_estabelecimento;
    }

    public void setCep_estabelecimento(String cep_estabelecimento) {
        this.cep_estabelecimento = cep_estabelecimento;
    }

    public String getLogadouro_estabelecimento() {
        return logadouro_estabelecimento;
    }

    public void setLogadouro_estabelecimento(String logadouro_estabelecimento) {
        this.logadouro_estabelecimento = logadouro_estabelecimento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAcessi_auditiva() {
        return acessi_auditiva;
    }

    public void setAcessi_auditiva(String acessi_auditiva) {
        this.acessi_auditiva = acessi_auditiva;
    }

    public String getAcessi_fisico() {
        return acessi_fisico;
    }

    public void setAcessi_fisico(String acessi_fisico) {
        this.acessi_fisico = acessi_fisico;
    }

    public String getAcessi_nenhuma() {
        return acessi_nenhuma;
    }

    public void setAcessi_nenhuma(String acessi_nenhuma) {
        this.acessi_nenhuma = acessi_nenhuma;
    }

    public String getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }
    
    

    public float getTaxa_cancelamento() {
        return taxa_cancelamento;
    }

    public void setTaxa_cancelamento(float taxa_cancelamento) {
        this.taxa_cancelamento = taxa_cancelamento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getId_planos() {
        return id_planos;
    }

    public void setId_planos(int id_planos) {
        this.id_planos = id_planos;
    }

    public int getId_pagamento_taxa() {
        return id_pagamento_taxa;
    }

    public void setId_pagamento_taxa(int id_pagamento_taxa) {
        this.id_pagamento_taxa = id_pagamento_taxa;
    }

    public int getTipo_user() {
        return tipo_user;
    }

    public void setTipo_user(int tipo_user) {
        this.tipo_user = tipo_user;
    }

    public int getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(int id_cartao) {
        this.id_cartao = id_cartao;
    }
    public String getEsta_status() {
        return esta_status;
    }

    public void setEsta_status(String esta_status) {
        this.esta_status = esta_status;
    }

    public String getAuxPlano() {
        return auxPlano;
    }

    public void setAuxPlano(String auxPlano) {
        this.auxPlano = auxPlano;
    }

}
