package br.com.reges.android1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by matheus on 08/08/2016.
 */
public class PrimeiraTela extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeiratela_activity);
        Log.i("Log", getString(R.string.log_text));
    }
}
