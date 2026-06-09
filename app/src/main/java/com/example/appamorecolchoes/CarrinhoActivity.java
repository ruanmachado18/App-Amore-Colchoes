package com.example.appamorecolchoes;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import android.widget.Button;
import android.widget.Toast;

public class CarrinhoActivity extends AppCompatActivity {

    Button btnFinalizarPedido;

    RecyclerView recyclerCarrinho;
    TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        recyclerCarrinho =
                findViewById(R.id.recyclerCarrinho);

        txtTotal =
                findViewById(R.id.txtTotal);

        btnFinalizarPedido =
                findViewById(R.id.btnFinalizarPedido);

        BancoControllerUsuarios bd =
                new BancoControllerUsuarios(this);

        ArrayList<Carrinho> lista =
                bd.listarCarrinho();

        recyclerCarrinho.setLayoutManager(
                new LinearLayoutManager(this)
        );

        CarrinhoAdapter adapter =
                new CarrinhoAdapter(this, lista);

        recyclerCarrinho.setAdapter(adapter);
        double total = 0;

        btnFinalizarPedido.setOnClickListener(v -> {

            BancoControllerUsuarios bdFinalizar =
                    new BancoControllerUsuarios(this);

            ArrayList<Carrinho> listaPedidos =
                    bdFinalizar.listarCarrinho();

            for (Carrinho item : listaPedidos) {

                bdFinalizar.salvarPedido(
                        item.getNome(),
                        item.getPreco(),
                        item.getImagem()
                );
            }

            bdFinalizar.limparCarrinho();

            Toast.makeText(
                    this,
                    "Pedido realizado com sucesso!",
                    Toast.LENGTH_LONG
            ).show();

            recreate();
        });

        for (Carrinho item : lista) {

            String precoTexto = item.getPreco()
                    .replace("R$", "")
                    .replace(".", "")
                    .replace(",", ".")
                    .trim();

            try {
                total += Double.parseDouble(precoTexto);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        txtTotal.setText(
                String.format("Total: R$ %.2f", total)
        );
    }

}