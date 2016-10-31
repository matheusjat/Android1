package br.com.reges.android1;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.reges.Database.LojaDAO;
import br.com.reges.modelo.Loja;

/**
 * Created by matheus on 08/08/2016.
 */
public class PrimeiraTelaActivity extends AppCompatActivity {

    private List<Loja> lojas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primeiratela_activity);
        Log.i("Log", "onCreate()");
    }



    @Override
    protected void onStart() {
        super.onStart();

        ListView listaDeNomes = (ListView) findViewById(R.id.listaDeNomes);
        Log.i("Activit1", "Instânciando a lista de nomes");
        registerForContextMenu(listaDeNomes);

//        String[] alunos = {"Fast Shop", "Ricardo Eletro", "Casas Bahia", "Ponto Frio"};

        lojas = new ArrayList<Loja>(); //pegar lista do banco!!
        LojaDAO lojaDAO = new LojaDAO(this);

        Loja loja = new Loja();

        lojas = lojaDAO.list();

        ArrayAdapter<Loja> adapter = new ArrayAdapter<Loja>(this,
                android.R.layout.simple_list_item_1, lojas);

        listaDeNomes.setAdapter(adapter);

        listaDeNomes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(PrimeiraTelaActivity.this, "Posição = " + position, Toast.LENGTH_LONG).show();

            }
        });

        listaDeNomes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(PrimeiraTelaActivity.this, "Clique Longo!", Toast.LENGTH_LONG).show();
                return false;
            }
        });

    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        ((Activity) this).openOptionsMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = this.getMenuInflater();
        inflater.inflate(R.menu.primeiratela_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuItem ligar = menu.add("Ligar");
        ligar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent irParaDiscagem = new Intent(Intent.ACTION_CALL);

                Loja loja = new Loja();

                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

                loja = lojas.get(info.position);

                String fone = loja.getTel();
                Uri numeroParaDiscagem = Uri.parse("tel: " + fone);
                irParaDiscagem.setData(numeroParaDiscagem);

                if (PackageManager.PERMISSION_GRANTED ==
                        ContextCompat.checkSelfPermission(PrimeiraTelaActivity.this,
                                Manifest.permission.CALL_PHONE)) {
                    startActivity(irParaDiscagem);
                }

                return false;
            }
        });

        menu.add("Ir para o site");
        MenuItem apagar = menu.add("Apagar");
        apagar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                LojaDAO lojaDAO = new LojaDAO(PrimeiraTelaActivity.this);
                Loja loja = new Loja();

                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

                loja = lojas.get(info.position);
                lojaDAO.delete(loja);

                onStart();

                return false;
            }
        });

        super.onCreateContextMenu(menu, v, menuInfo);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.novaemp_menu:
                Intent intent = new Intent(this, SegundaTelaActivity.class);
                startActivity(intent);
                break;
            case R.id.locloja_menu:
                break;
            case R.id.pref_menu:
                break;
            case R.id.sair_menu:
                AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
                dlgAlert.setTitle("Cadastro de Lojas");
                dlgAlert.setMessage("Gostaria de sair da apliação?");
                dlgAlert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PrimeiraTelaActivity.this.finish();
                    }
                });
                dlgAlert.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dlgAlert.create().show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
