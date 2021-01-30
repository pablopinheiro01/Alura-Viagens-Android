package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.R;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.util.DataUtil;
import br.com.alura.aluraviagens.util.MoedaUtil;
import br.com.alura.aluraviagens.util.ResourcesUtil;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String RESUMO_DA_COMPRA = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(RESUMO_DA_COMPRA);

        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        if(getIntent().hasExtra(CHAVE_PACOTE)){
            Pacote pacote = (Pacote) getIntent().getSerializableExtra(CHAVE_PACOTE);

            inicializaCampos(pacote);

        }
    }

    private void inicializaCampos(Pacote pacote) {
        mostraImagem(pacote);

        mostraDestino(pacote);

        mostraDataViagem(pacote);

        mostraValorPago(pacote);
    }

    private void mostraValorPago(Pacote pacoteSaoPaulo) {
        TextView valorPago = findViewById(R.id.resumo_compra_valor_pago);
        valorPago.setText(MoedaUtil.formataMoedaParaBrasileiro(pacoteSaoPaulo.getPreco()));
    }

    private void mostraDataViagem(Pacote pacoteSaoPaulo) {
        TextView dataViagem = findViewById(R.id.resumo_compra_data_viagem);
        dataViagem.setText(DataUtil.periodoEmTexto(pacoteSaoPaulo.getDias()));
    }

    private void mostraDestino(Pacote pacoteSaoPaulo) {
        TextView destino = findViewById(R.id.resumo_compra_destino);
        destino.setText(pacoteSaoPaulo.getLocal());
    }

    private void mostraImagem(Pacote pacoteSaoPaulo) {
        ImageView imagemPacote = findViewById(R.id.resumo_compra_imagem_destino);
        Drawable drawable = ResourcesUtil.devolveDrawable(this,pacoteSaoPaulo.getImagem());
        imagemPacote.setImageDrawable(drawable);
    }
}