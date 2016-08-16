package br.com.reges.android1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by matheus on 08/08/2016.
 */
public class PrimeiraTela extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeiratela_activity);

        ListView listaDeNomes = (ListView)findViewById(R.id.listaDeNomes);

        String[] alunos = {"João", "Carlos", "Pedro", "José"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, alunos);

        listaDeNomes.setAdapter(adapter);

        listaDeNomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long l) {
                Toast.makeText(PrimeiraTela.this, "Posição = " +
                        position, Toast.LENGTH_LONG).show();
            }
        });

        Log.i("Teste", "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Teste", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Log", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Teste", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Teste", "onStop()");
    }

    @Override
    protected void onDestroy() {
        Log.i("Teste", "onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Teste", "onRestart()");
    }
}
