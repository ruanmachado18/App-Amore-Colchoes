package com.example.appamorecolchoes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoricoPedidosActivity extends AppCompatActivity {

    RecyclerView recyclerPedidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_pedidos);

        recyclerPedidos = findViewById(R.id.recyclerPedidos);

        BancoControllerUsuarios bd =
                new BancoControllerUsuarios(this);

        ArrayList<Pedido> lista =
                bd.listarPedidos();

        recyclerPedidos.setLayoutManager(
                new LinearLayoutManager(this)
        );

        PedidoAdapter adapter =
                new PedidoAdapter(lista);

        recyclerPedidos.setAdapter(adapter);
    }
}