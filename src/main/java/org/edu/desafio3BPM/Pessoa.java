package org.edu.desafio3BPM;

public class Pessoa {
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa() {

    }

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public boolean valido() {
        return this.id > 0 && !this.nome.isEmpty();
    }
}
