package com.example.appamorecolchoes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class ProdutosActivity extends AppCompatActivity {

    RecyclerView recyclerProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        recyclerProdutos = findViewById(R.id.recyclerProdutos);

        recyclerProdutos.setLayoutManager(
                new LinearLayoutManager(this)
        );

        List<Produto> listaProdutos = new ArrayList<>();

        listaProdutos.add(
                new Produto(
                        "Colchão Premium",
                        "R$ 1.299",
                        R.drawable.premiun
                )
        );

        listaProdutos.add(
                new Produto(
                        "Colchão Queen",
                        "R$ 1.899",
                        R.drawable.colchaoqueen
                )
        );

        listaProdutos.add(
                new Produto(
                        "Colchão Ortopédico",
                        "R$ 2.299",
                        R.drawable.colchaopremiun
                )
        );

        ProdutoAdapter adapter =
                new ProdutoAdapter(
                        this,
                        listaProdutos
                );

        recyclerProdutos.setAdapter(adapter);
    }
}