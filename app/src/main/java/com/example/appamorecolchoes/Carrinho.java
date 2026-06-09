package com.example.appamorecolchoes;

public class Carrinho {

    private int id;
    private String nome;
    private String preco;
    private int imagem;

    public Carrinho(int id, String nome, String preco, int imagem) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.imagem = imagem;
    }

    public int getImagem() {
        return imagem;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPreco() {
        return preco;
    }
}