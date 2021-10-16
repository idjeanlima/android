package com.example.liam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantidade = 1;
    int nomeComprimento = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void somar(View view){
        quantidade = quantidade + 1;
        displayQtd(quantidade);
    }

    public void diminuir(View view){
        if (quantidade > 1){
            quantidade = quantidade - 1;
            displayQtd(quantidade);
        }
    }

    public String displayQtd(int quant){
        TextView exibir = (TextView) findViewById(R.id.qtd);
        exibir.setText("" + quant);
        return exibir.getText().toString();
    }

    public void finalizar(View view) {
        TextView c_nomeComprimento = (TextView) findViewById(R.id.nome);
        nomeComprimento = c_nomeComprimento.length();

        TextView c_nome = (TextView) findViewById(R.id.nome);
        String nome = c_nome.getText().toString();

        TextView c_resumo = (TextView) findViewById(R.id.resumo);
        c_resumo.setText(displayResumo(nome, quantidade));
    }

    public String displayResumo(String quem, int quanto){
        String mensagem = "Resumo: ";
        if (nomeComprimento < 3){
            mensagem = mensagem + "\nPor favor, preencha seu nome corretamente.";
        } else {
            mensagem = mensagem + "\nNome: " + quem;
            mensagem = mensagem + "\nQuantidade: " + quanto;
        }
        return mensagem;
    }
}
