package br.com.reges.android1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by matheus on 22/08/2016.
 */
public class SegundaTelaActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segundatela_activity);
        Log.i("Log", "SegundaTelaActivity onCreate()");
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
