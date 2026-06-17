package br.edu.ifgoiano.padroes.proxy;

public class VideoProxy implements Video {
    private String titulo;
    private boolean premium;
    private VideoReal videoReal;

    public VideoProxy(String titulo, boolean premium) {
        this.titulo = titulo;
        this.premium = premium;
    }

    @Override
    public void assistir(Usuario usuario) {
        if (premium && !usuario.isPremium()) {
            System.out.println("Acesso negado.");
            System.out.println("O vídeo '" + titulo + "' é exclusivo para usuários premium.");
            return;
        }

        if (videoReal == null) {
            videoReal = new VideoReal(titulo, premium);
        } else {
            System.out.println("Vídeo já carregado anteriormente. Reutilizando o objeto real.");
        }

        videoReal.assistir(usuario);
    }
}
