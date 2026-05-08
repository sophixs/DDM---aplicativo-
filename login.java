package com.sophiacostameuapptesteunip;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
immport android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail, editSenha;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_login.xml);

        // Ligando os elementos do XML com o Java
        editEmail = findViewById(R.id.editEmail);
        editSenha = findViewById(R.id.editSenha);
        btnLogin = findViewById(R.id.btnLogin);

        // Evento de clique do botão
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editEmail.getText().toString().trim();
                String senha = editSenha.getText().toString().trim();

                // Validações básicas
                if (TextUtils.isEmpty(email)) {
                    editEmail.setError("Digite o email");
                    return;
                }

                if (TextUtils.isEmpty(senha)) {
                    editSenha.setError("Digite a senha");
                    return;
                }

                // Exemplo de login fixo (simples)
                if (email.equals("admin@email.com") && senha.equals("123456")) {
                    Toast.makeText(LoginActivity.this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();

                    // Aqui você pode abrir outra tela
                    // Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    // startActivity(intent);
                    // finish();

                } else {
                    Toast.makeText(LoginActivity.this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
