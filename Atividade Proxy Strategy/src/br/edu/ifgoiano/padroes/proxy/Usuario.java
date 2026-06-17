package br.edu.ifgoiano.padroes.proxy;

public class Usuario {
    private String nome;
    private boolean premium;

    public Usuario(String nome, boolean premium) {
        this.nome = nome;
        this.premium = premium;
    }

    public String getNome() {
        return nome;
    }

    public boolean isPremium() {
        return premium;
    }
}
