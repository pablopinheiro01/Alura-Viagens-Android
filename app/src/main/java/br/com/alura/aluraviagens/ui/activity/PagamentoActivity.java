package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.MoedaUtil;

import android.os.Bundle;
import android.widget.TextView;

import java.math.BigDecimal;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);
        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("Sao Paulo", "sao_paulo_sp", 2, new BigDecimal(245.5));

        mostraPreco(pacoteSaoPaulo);

    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco_pacote);
        preco.setText(MoedaUtil.formataMoedaParaBrasileiro(pacote.getPreco()));
    }
}