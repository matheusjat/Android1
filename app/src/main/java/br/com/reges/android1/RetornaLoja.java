package br.com.reges.android1;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.reges.modelo.Loja;

/**
 * Created by matheus on 03/10/2016.
 */
public class RetornaLoja {

    public static Loja exec(SegundaTelaActivity form) {
        EditText nome_ET;
        EditText end_ET;
        EditText site_ET;
        RatingBar nota_ET;
        Loja loja;

        nome_ET = (EditText) form.findViewById(R.id.form_nome);
        end_ET = (EditText) form.findViewById(R.id.form_end);
        site_ET = (EditText) form.findViewById(R.id.form_site);
        nota_ET = (RatingBar) form.findViewById(R.id.form_avaliacao);

        String nome = nome_ET.getText().toString();
        String end = end_ET.getText().toString();
        String site = site_ET.getText().toString();
        float nota = nota_ET.getRating();

        loja = new Loja(nome, end, site, nota);
        return loja;
    }
}
