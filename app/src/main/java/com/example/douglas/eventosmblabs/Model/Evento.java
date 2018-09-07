package com.example.douglas.eventosmblabs.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Evento {

    @SerializedName("ID_Evento")
    @Expose
    private int id_evento;

    @SerializedName("Nome")
    @Expose
    private String nome;

    @SerializedName("Local")
    @Expose
    private String local;

    @SerializedName("Data")
    @Expose
    private String data;

    @SerializedName("Duracao")
    @Expose
    private String duracao;

    @SerializedName("Preco")
    @Expose
    private double preco;

    @SerializedName("Descricao")
    @Expose
    private String descricao;

    @SerializedName("Enderecoimagem")
    @Expose
    private String caminhofoto;

    public Evento(int id_evento, String nome, String local, String data, String duracao, double preco, String descricao, String caminhofoto) {
        this.id_evento = id_evento;
        this.nome = nome;
        this.local = local;
        this.data = data;
        this.duracao = duracao;
        this.preco = preco;
        this.descricao = descricao;
        this.caminhofoto = caminhofoto;
    }

    public String getCaminhofoto() {
        return caminhofoto;
    }

    public void setCaminhofoto(String caminhofoto) {
        this.caminhofoto = caminhofoto;
    }

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
