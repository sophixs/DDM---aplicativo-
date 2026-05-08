package com.sophiacostameuapptesteunip;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculoTMB extends AppCompatActivity {

    private Object AppCompatActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_tmb);
        // Importações necessárias para funcionamento da Activity e componentes da interface
import Bundle;
import View;
import Object ViewGroup;
        ViewGroup;
import android.widget.*;

import AppCompatActivity;

// Classe principal que herda de AppCompatActivity (uma tela do app)
        class MainActivity extends AppCompatActivity {

            // Declaração dos componentes da interface (inputs e botões)
            EditText peso, altura, idade; // Campos de entrada de texto
            Spinner sexo;                 // Lista suspensa (Masculino/Feminino)
            Button calcular;              // Botão para realizar o cálculo
            TextView resultado;           // Texto onde será exibido o resultado

            // Método chamado quando a Activity é criada
            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                // Define qual layout XML será usado nessa tela
                setContentView(R.layout.activity_main);

                // Liga os componentes Java com os elementos do XML usando seus IDs
                peso = findViewById(R.id.Peso);
                altura = findViewById(R.id.Altura);
                idade = findViewById(R.id.Idade);
                sexo = findViewById(R.id.Sexo);
                calcular = findViewById(R.id.Calcular);
                resultado = findViewById(R.id.Resultado);

                // ==========================
                // CONFIGURAÇÃO DO SPINNER
                // ==========================

                // Array com as opções que aparecerão no Spinner
                String[] opcoes = {"Masculino", "Feminino"};

                // Criação do Adapter (responsável por "ligar" os dados ao Spinner)
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        this, // Contexto da aplicação
                        android.R.layout.simple_spinner_item, // Layout padrão do item
                        opcoes // Lista de opções
                ) {
                    // Método que define como o item selecionado aparece
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);

                        // Pega o TextView do layout padrão
                        TextView text = view.findViewById(android.R.id.text1);

                        // Define a cor do texto como branco
                        text.setTextColor(getResources().getColor(android.R.color.white));

                        return view;
                    }

                    // Método que define como os itens do dropdown aparecem
                    @Override
                    public View getDropDownView(int position, View convertView, ViewGroup parent) {
                        View view = super.getDropDownView(position, convertView, parent);

                        // Pega o TextView do item
                        TextView text = view.findViewById(android.R.id.text1);

                        // Define a cor do texto como branco
                        text.setTextColor(getResources().getColor(android.R.color.white));

                        return view;
                    }
                };

                // Define o layout do dropdown (quando abre a lista)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // Aplica o adapter ao Spinner
                sexo.setAdapter(adapter);

                // ==========================
                // AÇÃO DO BOTÃO
                // ==========================

                // Define o que acontece quando o botão é clicado
                calcular.setOnClickListener(v -> {

                    // Verifica se algum campo está vazio
                    if (peso.getText().toString().isEmpty() ||
                            altura.getText().toString().isEmpty() ||
                            idade.getText().toString().isEmpty()) {

                        // Mostra mensagem de erro
                        resultado.setText("Preencha todos os campos!");
                        return; // Para a execução
                    }

                    // Converte os valores digitados para números
                    double p = Double.parseDouble(peso.getText().toString()); // peso
                    double a = Double.parseDouble(altura.getText().toString()); // altura
                    int i = Integer.parseInt(idade.getText().toString()); // idade

                    double tmb; // variável para armazenar o resultado

                    // Verifica o sexo selecionado no Spinner
                    if (sexo.getSelectedItem().toString().equals("Masculino")) {

                        // Fórmula da TMB para homens
                        tmb = 66 + (13.7 * p) + (5 * a) - (6.8 * i);

                    } else {

                        // Fórmula da TMB para mulheres
                        tmb = 655 + (9.6 * p) + (1.8 * a) - (4.7 * i);
                    }

                    // Exibe o resultado formatado com 2 casas decimais
                    resultado.setText("TMB: " + String.format("%.2f", tmb) + " kcal/dia");
                });
            }
        }
        });
    }
}
