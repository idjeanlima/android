package com.example.hamburgueriax;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantidade = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fun_som(View view){
        quantidade = quantidade + 1;
        TextView exibir = (TextView) findViewById(R.id.qtd);
        exibir.setText("" + quantidade);
    }

    public void fun_dim(View view){
        if (quantidade > 0) {
            quantidade = quantidade - 1;
            TextView exibir = (TextView) findViewById(R.id.qtd);
            exibir.setText("" + quantidade);
        }
    }

    public void criarMensagemPedido(String nome, int valorT, boolean check1, boolean check2, boolean check3) {
        if (quantidade > 0) {
            String mensagem = "Resumo do pedido:\nNome: " + nome;
            if (check1) mensagem += "\nCheck 1 ok";
            if (check2) mensagem += "\nCheck 2 ok";
            if (check3) mensagem += "\nCheck 3 ok";
            mensagem += "\nQuantidade: " + quantidade;
            mensagem += "\n\nValor total: R$ " + valorT + ",00";

            TextView displayResumo = (TextView) findViewById(R.id.resumo);
            displayResumo.setText(mensagem);
        } else {
            TextView displayResumo = (TextView) findViewById(R.id.resumo);
            displayResumo.setText("Resumo do pedido:");
        }
        return;
    }

    public void enviarPedido (View view) {
        EditText c_nome = (EditText) findViewById(R.id.nome);
        String nome = c_nome.getText().toString();

        CheckBox c_check1 = (CheckBox) findViewById(R.id.checkBox);
        boolean check1 = c_check1.isChecked();

        CheckBox c_check2 = (CheckBox) findViewById(R.id.checkBox2);
        boolean check2 = c_check2.isChecked();

        CheckBox c_check3 = (CheckBox) findViewById(R.id.checkBox3);
        boolean check3 = c_check3.isChecked();

        int valorT = calculaPreco(check1, check2, check3);

        criarMensagemPedido(nome, valorT, check1, check2, check3);
        return;
    }

    public int calculaPreco(boolean check1, boolean check2, boolean check3){
        int valor = 20;
        if (check1) valor = valor + 2;
        if (check2) valor = valor + 1;
        if (check3) valor = valor + 3;
        return valor * quantidade;
    }

}
