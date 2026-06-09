package com.example.appamorecolchoes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {

    private List<Produto> listaProdutos;

    private Context context;

    public ProdutoAdapter(Context context, List<Produto> listaProdutos) {
        this.context = context;
        this.listaProdutos = listaProdutos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduto;
        TextView txtNome, txtPreco;
        Button btnComprar;

        public ViewHolder(View itemView) {
            super(itemView);
            imgProduto = itemView.findViewById(R.id.imgProduto);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtPreco = itemView.findViewById(R.id.txtPreco);
            btnComprar = itemView.findViewById(R.id.btnComprar);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Ajustado para o nome correto do seu arquivo XML: activity_item_produto
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item_produto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Produto produto = listaProdutos.get(position);
        holder.txtNome.setText(produto.getNome());
        holder.txtPreco.setText(produto.getPreco());
        holder.imgProduto.setImageResource(produto.getImagem());

        holder.btnComprar.setOnClickListener(v -> {

            BancoControllerUsuarios bd =
                    new BancoControllerUsuarios(context);

            boolean sucesso =
                    bd.adicionarCarrinho(
                            produto.getNome(),
                            produto.getPreco(),
                            produto.getImagem()
                    );

            if (sucesso) {
                Toast.makeText(
                        context,
                        "Produto adicionado ao carrinho",
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                Toast.makeText(
                        context,
                        "Erro ao adicionar produto",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }
}