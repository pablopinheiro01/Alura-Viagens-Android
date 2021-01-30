package br.com.alura.aluraviagens.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import br.com.alura.R;
import br.com.alura.aluraviagens.dao.PacoteDAO;
import br.com.alura.aluraviagens.model.Pacote;
import br.com.alura.aluraviagens.ui.adapter.ListaPacotesAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import static br.com.alura.aluraviagens.ui.activity.PacoteActivityConstantes.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);

        configuraLista();

    }

    private void configuraLista() {
        List<Pacote> pacotes = new PacoteDAO().lista();
        //dentro da classe anonima eu so posso acessar objetos fixos por isso defini o final
        final ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes,this ));
        listaDePacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                vaiParaResumoPacote(position, pacotes);
            }
        });
    }

    private void vaiParaResumoPacote(int position, List<Pacote> pacotes) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        Pacote pacote = pacotes.get(position);
        //o pacote tem que ser Serializible e nao devemos esquecer essa implementacao
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }


}