package br.com.reges.android1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import br.com.reges.modelo.Loja;

/**
 * Created by matheus on 22/08/2016.
 */
public class SegundaTelaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundatela_activity);
        Log.i("Log", "SegundaTelaActivity onCreate()");

        Button salvar = (Button) findViewById(R.id.form_botaoSalvar);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loja loja = RetornaLoja.exec(SegundaTelaActivity.this);

//                Salvar No Banco!!!

                finish();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Log", "SegundaTelaActivity onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Log", "SegundaTelaActivity onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Log", "SegundaTelaActivity onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Log", "SegundaTelaActivity onStop()");
    }

    @Override
    protected void onDestroy() {
        Log.i("Log", "SegundaTelaActivity onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("Log", "SegundaTelaActivity onRestart()");
    }
}
