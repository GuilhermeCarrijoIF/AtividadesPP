public class Filme {
    private final String titulo;
    private final Genero genero;
    private final String tipo;

    public Filme(String titulo, Genero genero, String tipo) {
        this.titulo = titulo;
        this.genero = genero;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo + " \"" + titulo + "\" - Gênero: " + genero.getDescricao();
    }
}
