package br.edu.ifgoiano.model;

public class Livro {
    
    private int id;
    private String titulo;
    private String autor;
    private boolean disponivel;

    public Livro() {
        this.disponivel = true;
    }

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro\n" +
               "ID: " + id + "\n" +
               "Título: " + titulo + "\n" +
               "Autor: " + autor + "\n" +
               "Status: " + (disponivel ? "Disponível" : "Indisponível") + "\n" +
               "---------------------------";
    }
}