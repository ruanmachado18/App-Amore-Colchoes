package com.example.appamorecolchoes;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Referenciando os componentes do XML com os IDs corretos
        final EditText etNome = findViewById(R.id.etNome);
        final EditText etEmail = findViewById(R.id.etEmail);
        final EditText etSenha = findViewById(R.id.etSenha);
        final EditText etConfirmarSenha = findViewById(R.id.etConfirmarSenha);
        Button btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString().trim();
                String email = etEmail.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();
                String confirmarSenha = etConfirmarSenha.getText().toString().trim();

                if (nome.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {
                    Toast.makeText(CadastroActivity.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                } else if (!senha.equals(confirmarSenha)) {
                    Toast.makeText(CadastroActivity.this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
                } else {
                    // Salvando no banco de dados
                    BancoControllerUsuarios bd = new BancoControllerUsuarios(getBaseContext());
                    String resultado = bd.insereDado(nome, email, senha);

                    Toast.makeText(CadastroActivity.this, resultado, Toast.LENGTH_LONG).show();

                    if (!resultado.contains("Erro")) {
                        finish(); // Só fecha se salvou com sucesso
                    }
                }
            }
        });
    }
}
