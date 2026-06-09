package com.example.appamorecolchoes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button btEntrar;
    EditText txtLogEmail, txtLogSenha;
    TextView txtCadastroLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btEntrar = findViewById(R.id.btEntrar);
        txtLogEmail = findViewById(R.id.txtLogEmail);
        txtLogSenha = findViewById(R.id.txtLogSenha);
        txtCadastroLink = findViewById(R.id.txtCadastroLink);


        btEntrar.setOnClickListener(this);
        txtCadastroLink.setOnClickListener(this);



    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btEntrar) {
            String email = txtLogEmail.getText().toString().trim();
            String senha = txtLogSenha.getText().toString().trim();

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
            } else {
                BancoControllerUsuarios bd = new BancoControllerUsuarios(getBaseContext());
                // Usando o novo método de autenticação que criamos
                if (bd.autenticar(email, senha)) {
                    Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();
                    Intent tela = new Intent(this, MenuActivity.class);
                    startActivity(tela);
                    finish();
                } else {
                    Toast.makeText(this, "E-mail ou Senha incorretos!", Toast.LENGTH_LONG).show();
                }
            }
        } else if (v.getId() == R.id.txtCadastroLink) {
            Intent telaCadastro = new Intent(this, CadastroActivity.class);
            startActivity(telaCadastro);
        }
    }
}