package com.example.appamorecolchoes;

public class Produto {
    private String nome;
    private String preco;
    private int imagem;

    public Produto(String nome, String preco, int imagem) {
        this.nome = nome;
        this.preco = preco;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getPreco() {
        return preco;
    }

    public int getImagem() {
        return imagem;
    }
}
