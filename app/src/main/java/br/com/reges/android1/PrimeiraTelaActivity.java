package br.com.reges.android1;

import android.app.Activity;

import android.content.Intent;
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
public class PrimeiraTelaActivity extends Activity{

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

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Log", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Log", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Log", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Log", "onStop()");
    }

    @Override
    protected void onDestroy() {
        Log.i("Log", "onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Log", "onRestart()");
    }
}
