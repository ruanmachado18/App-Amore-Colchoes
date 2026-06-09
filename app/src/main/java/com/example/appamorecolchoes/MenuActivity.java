package com.example.appamorecolchoes;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MenuActivity extends AppCompatActivity {

    CardView cardProdutos;
    CardView cardCarrinho;
    CardView cardPedidos;
    CardView cardCadastro;
    CardView cardSobre;
    CardView cardSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cardProdutos = findViewById(R.id.cardProdutos);
        cardCarrinho = findViewById(R.id.cardCarrinho);
        cardPedidos = findViewById(R.id.cardPedidos);
        cardCadastro = findViewById(R.id.cardCadastro);
        cardSobre = findViewById(R.id.cardSobre);
        cardSair = findViewById(R.id.cardSair);

        // PRODUTOS
        cardProdutos.setOnClickListener(v ->
                startActivity(new Intent(this, ProdutosActivity.class)));

        // CARRINHO
        cardCarrinho.setOnClickListener(v ->
                startActivity(new Intent(this, CarrinhoActivity.class)));

        // PEDIDOS
        cardPedidos.setOnClickListener(v ->
                startActivity(new Intent(this, HistoricoPedidosActivity.class)));

        // CADASTRO
        cardCadastro.setOnClickListener(v ->
                startActivity(new Intent(this, CadastroActivity.class)));

        // SOBRE
        cardSobre.setOnClickListener(v ->
                startActivity(new Intent(this, SobreActivity.class)));


        // SAIR
        cardSair.setOnClickListener(v -> {
            startActivity(new Intent(this, Login.class));
            finish();
        });
    }
}