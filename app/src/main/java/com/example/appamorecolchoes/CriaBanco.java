package com.example.appamorecolchoes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco_exemplo.db";
    private static final int VERSAO = 10;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(
                "CREATE TABLE contatos (" +
                        "codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT," +
                        "email TEXT)"
        );

        db.execSQL(
                "CREATE TABLE usuarios (" +
                        "codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT," +
                        "email TEXT," +
                        "senha TEXT," +
                        "cpf TEXT," +
                        "telefone TEXT)"
        );

        db.execSQL(
                "CREATE TABLE pedidos (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT," +
                        "preco TEXT," +
                        "imagem INTEGER)"
        );
        db.execSQL(
                "CREATE TABLE carrinho (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "nome TEXT," +
                        "preco TEXT," +
                        "imagem INTEGER)"
        );


        db.execSQL(
                "INSERT INTO usuarios(nome,email,senha) " +
                        "VALUES('Admin','admin@teste.com','adm123')"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS contatos");
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS carrinho");
        db.execSQL("DROP TABLE IF EXISTS pedidos");

        onCreate(db);
    }
}