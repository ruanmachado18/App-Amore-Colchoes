package com.example.appamorecolchoes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BancoControllerUsuarios {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoControllerUsuarios(Context context) {
        banco = new CriaBanco(context);
    }

    // CADASTRAR USUÁRIO
    public String insereDado(String nome, String email, String senha) {

        db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", nome);
        valores.put("email", email);
        valores.put("senha", senha);

        long resultado = db.insert("usuarios", null, valores);

        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    // LOGIN
    public boolean autenticar(String email, String senha) {

        db = banco.getReadableDatabase();

        String selection = "email = ? AND senha = ?";
        String[] selectionArgs = {email, senha};

        Cursor cursor = db.query(
                "usuarios",
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean logado = cursor.moveToFirst();

        cursor.close();
        db.close();

        return logado;
    }

    // ADICIONAR PRODUTO AO CARRINHO
    public boolean adicionarCarrinho(
            String nome,
            String preco,
            int imagem) {

        db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("nome", nome);
        valores.put("preco", preco);
        valores.put("imagem", imagem);

        long resultado = db.insert(
                "carrinho",
                null,
                valores
        );

        db.close();

        return resultado != -1;
    }

    // LISTAR PRODUTOS DO CARRINHO
    public ArrayList<Carrinho> listarCarrinho() {

        ArrayList<Carrinho> lista = new ArrayList<>();

        db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM carrinho",
                null
        );

        while (cursor.moveToNext()) {

            lista.add(
                    new Carrinho(
                            cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getInt(3)
                    )
            );
        }

        cursor.close();
        db.close();

        return lista;
    }

    public void limparCarrinho() {

        db = banco.getWritableDatabase();

        db.delete(
                "carrinho",
                null,
                null
        );

        db.close();
    }

    public boolean removerCarrinho(int id) {

        db = banco.getWritableDatabase();

        int resultado = db.delete(
                "carrinho",
                "id = ?",
                new String[]{
                        String.valueOf(id)
                }
        );

        db.close();



        return resultado > 0;
    }

    public void salvarPedido(String nome,
                             String preco,
                             int imagem){

        db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("nome", nome);
        valores.put("preco", preco);
        valores.put("imagem", imagem);

        db.insert(
                "pedidos",
                null,
                valores
        );

        db.close();
    }

    public ArrayList<Pedido> listarPedidos() {

        ArrayList<Pedido> lista = new ArrayList<>();

        db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM pedidos",
                null
        );

        while (cursor.moveToNext()) {

            lista.add(
                    new Pedido(
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getInt(3)
                    )
            );
        }

        cursor.close();
        db.close();

        return lista;
    }



}

