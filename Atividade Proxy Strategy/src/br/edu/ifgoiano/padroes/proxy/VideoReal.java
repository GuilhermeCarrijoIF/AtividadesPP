package br.edu.ifgoiano.padroes.proxy;

public class VideoReal implements Video {
    private String titulo;
    private boolean premium;

    public VideoReal(String titulo, boolean premium) {
        this.titulo = titulo;
        this.premium = premium;
        carregarVideo();
    }

    private void carregarVideo() {
        System.out.println("Carregando arquivo pesado do vídeo: " + titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPremium() {
        return premium;
    }

    @Override
    public void assistir(Usuario usuario) {
        System.out.println(usuario.getNome() + " está assistindo ao vídeo: " + titulo);
    }
}
