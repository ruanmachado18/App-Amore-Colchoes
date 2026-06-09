package com.example.appamorecolchoes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

import android.widget.ImageView;



import com.example.appamorecolchoes.CarrinhoActivity;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.ViewHolder> {

    private ArrayList<Carrinho> lista;
    private Context context;

    public CarrinhoAdapter(Context context, ArrayList<Carrinho> lista) {
        this.context = context;
        this.lista = lista;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgCarrinho;
        TextView txtNome;
        TextView txtPreco;
        Button btnRemover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCarrinho = itemView.findViewById(R.id.imgCarrinho);
            txtNome = itemView.findViewById(R.id.txtNomeCarrinho);
            txtPreco = itemView.findViewById(R.id.txtPrecoCarrinho);
            btnRemover = itemView.findViewById(R.id.btnRemover);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_carrinho, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Carrinho item = lista.get(position);

        holder.txtNome.setText(item.getNome());
        holder.txtPreco.setText(item.getPreco());
        holder.imgCarrinho.setImageResource(
                item.getImagem()
        );
        holder.btnRemover.setOnClickListener(v -> {


            BancoControllerUsuarios bd =
                    new BancoControllerUsuarios(context);

            boolean removido =
                    bd.removerCarrinho(item.getId());

            if(removido){

                lista.remove(position);

                notifyItemRemoved(position);
                notifyItemRangeChanged(position, lista.size());

                Toast.makeText(
                        context,
                        "Produto removido",
                        Toast.LENGTH_SHORT
                ).show();

                ((CarrinhoActivity) context).recreate();
            }

            else{

                Toast.makeText(
                        context,
                        "Erro ao remover",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}