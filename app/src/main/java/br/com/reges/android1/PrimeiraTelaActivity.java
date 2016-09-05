package br.com.reges.android1;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by matheus on 08/08/2016.
 */
public class PrimeiraTelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeiratela_activity);

        ListView listaDeNomes = (ListView)findViewById(R.id.listaDeNomes);

        String[] alunos = {"João Paulo", "Carlos", "Pedro", "José"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alunos);

        listaDeNomes.setAdapter(adapter);

        final Intent intent = new Intent(this, SegundaTelaActivity.class);

        listaDeNomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long l) {
                Toast.makeText(PrimeiraTelaActivity.this, "Posição = " +
                        position, Toast.LENGTH_LONG).show();

                if(position == 0){
                    startActivity(intent);
                }
            }
        });

        Log.i("Log", "onCreate()");
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        ((Activity) this).openOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Nova Loja");
        menu.add("Localizar Loja");
        menu.add("Preferencias");
        menu.add("Sair");

        return super.onCreateOptionsMenu(menu);
    }

}
