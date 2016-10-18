package br.com.reges.modelo;

/**
 * Created by matheus on 03/10/2016.
 */
public class Loja {

    private String nome;
    private String email;
    private String site;
    private float nota;

    public Loja(String nome, String email, String site, float nota) {
        this.nome = nome;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
