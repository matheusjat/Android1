package br.com.reges.adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import br.com.reges.android1.R;
import br.com.reges.modelo.Loja;

/**
 * Created by matheus on 31/10/2016.
 */
public class LojaAdapter extends BaseAdapter{

    private List<Loja> lojas;
    private Activity activity;

    public LojaAdapter(Activity  activity, List<Loja> lojas) {
        this.lojas = lojas;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return lojas.size();
    }

    @Override
    public Object getItem(int position) {
        return lojas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lojas.get(position).getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Loja loja = lojas.get(position);

        LayoutInflater inflater = activity.getLayoutInflater();
        View linha = inflater.inflate(R.layout.listadelojas_list,null);

        TextView nome = (TextView) linha.findViewById(R.id.nome);
        ImageView logo = (ImageView) linha.findViewById(R.id.logo);

        nome.setText(loja.getNome());

        InputStream inputStream;
        Bitmap imageLogo = null;
        try {

            inputStream =
                    activity.getResources().getAssets().
                            open(loja.getNome().toLowerCase() + ".png");
            imageLogo = BitmapFactory.decodeStream(inputStream);

        } catch (IOException e) {
            Log.i("Erro", e.getMessage());
            e.printStackTrace();
        }

        if (imageLogo != null)
            logo.setImageBitmap(imageLogo);
        else
            logo.setImageResource(R.drawable.standard);

        return linha;
    }
}
