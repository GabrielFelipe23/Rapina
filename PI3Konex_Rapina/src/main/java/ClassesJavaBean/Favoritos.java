package ClassesJavaBean;

/**
 *
 * @author Gabriel Felipe
 */
public class Favoritos {
    //atributos da classe favoritos
    public int id_favorito;
    public int id_cliente;
    public String nome_estabelecimento;
    public String endereço;
    public int num_estabelecimento;
    public String horario_funcionamento;
    
    //metodo construtor
    
    public Favoritos() {
    }

    //metodos especiais
    public void deletarFavorito() {
    }

    public void consultarFavorito() {
    }

    public void cadastrarFavorito() {
    }
    
    
    
    //metodos getters e setters
    public int getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(int id_favorito) {
        this.id_favorito = id_favorito;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNome_estabelecimento() {
        return nome_estabelecimento;
    }

    public void setNome_estabelecimento(String nome_estabelecimento) {
        this.nome_estabelecimento = nome_estabelecimento;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public int getNum_estabelecimento() {
        return num_estabelecimento;
    }

    public void setNum_estabelecimento(int num_estabelecimento) {
        this.num_estabelecimento = num_estabelecimento;
    }

    public String getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }
    
}
