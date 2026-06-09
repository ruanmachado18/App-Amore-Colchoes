package com.example.appamorecolchoes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import android.widget.ImageView;

public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.ViewHolder> {

    private ArrayList<Pedido> lista;

    public PedidoAdapter(ArrayList<Pedido> lista) {
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPedido;
        TextView txtNome;
        TextView txtPreco;

        public ViewHolder(View itemView) {
            super(itemView);

            imgPedido = itemView.findViewById(R.id.imgPedido);
            txtNome = itemView.findViewById(R.id.txtNomePedido);
            txtPreco = itemView.findViewById(R.id.txtPrecoPedido);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pedido, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position) {

        Pedido pedido = lista.get(position);

        holder.txtNome.setText(
                pedido.getNome()
        );

        holder.txtPreco.setText(
                pedido.getPreco()
        );

        holder.imgPedido.setImageResource(
                pedido.getImagem()
        );
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}