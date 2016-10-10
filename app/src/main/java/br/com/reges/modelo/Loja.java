package br.com.reges.modelo;

/**
 * Created by matheus on 03/10/2016.
 */
public class Loja {

    private String nome;
    private String end;
    private String site;
    private float nota;

    public Loja(String nome, String end, String site, float nota) {
        this.nome = nome;
        this.end = end;
        this.site = site;
        this.nota = nota;
    }

    public Loja(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}
