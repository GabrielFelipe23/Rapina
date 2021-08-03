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
public class Notification {
    
    public int tipo_user;
    public int id_notification;
    public String nome_noti;
    public String email_noti;
    public String mensagem;
    public int num_reserva;
    public String data;
    private int id_user;
    private int id_estabelecimento;

    public Notification() {

    }

    //Construtor para as Duvidas
    public Notification(String nome_noti, String email_noti, String mensagem) {
        this.nome_noti = nome_noti;
        this.email_noti = email_noti;
        this.mensagem = mensagem;

    }
    //Construtor para as Respostas
    public Notification(int id_user,String mensagem, String data){
        this.id_user = id_user;
        this.mensagem=mensagem;
        this.data= data;
    }
    //Construtor de Resposta para o Esta
    public Notification(int tipo_user,int id_estabelecimento,String mensagem, String data){
        this.tipo_user=tipo_user;
        this.id_estabelecimento = id_estabelecimento;
        this.mensagem=mensagem;
        this.data= data;
    }
    public Notification(String mensagem, String data,int id_estabelecimento){
        this.mensagem=mensagem;
        this.data= data;
         this.id_estabelecimento = id_estabelecimento;
    }

    //Getters e Setters
    public int getId_notification() {
        return id_notification;
    }

    public void setId_notification(int id_notification) {
        this.id_notification = id_notification;
    }

    public String getNome_noti() {
        return nome_noti;
    }

    public void setNome_noti(String nome_noti) {
        this.nome_noti = nome_noti;
    }

    public String getEmail_noti() {
        return email_noti;
    }

    public void setEmail_noti(String email_noti) {
        this.email_noti = email_noti;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getNum_reserva() {
        return num_reserva;
    }

    public void setNum_reserva(int num_reserva) {
        this.num_reserva = num_reserva;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_estabelecimento() {
        return id_estabelecimento;
    }

    public void setId_estabelecimento(int id_estabelecimento) {
        this.id_estabelecimento = id_estabelecimento;
    }

}
