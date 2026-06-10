public class Main {
    public static void main(String[] args) {
        PlataformaStreaming plataforma = new PlataformaStreaming();

        Cliente ana = new Cliente("Ana");
        Cliente bruno = new Cliente("Bruno");
        Cliente carla = new Cliente("Carla");
        Cliente diego = new Cliente("Diego");
        Cliente elisa = new Cliente("Elisa");

        ana.inscrever(plataforma, Genero.ACAO);
        ana.inscrever(plataforma, Genero.ANIME);

        bruno.inscrever(plataforma, Genero.COMEDIA);
        bruno.inscrever(plataforma, Genero.FICCAO_CIENTIFICA);

        carla.inscrever(plataforma, Genero.TERROR);
        carla.inscrever(plataforma, Genero.ACAO);

        diego.inscrever(plataforma, Genero.ANIME);

        elisa.inscrever(plataforma, Genero.FICCAO_CIENTIFICA);
        elisa.inscrever(plataforma, Genero.COMEDIA);

        plataforma.adicionarConteudo(new Filme("Missão Final", Genero.ACAO, "Filme"));
        plataforma.adicionarConteudo(new Filme("Risadas em Família", Genero.COMEDIA, "Série"));
        plataforma.adicionarConteudo(new Filme("Casa Sombria", Genero.TERROR, "Filme"));
        plataforma.adicionarConteudo(new Filme("Robôs do Amanhã", Genero.FICCAO_CIENTIFICA, "Série"));
        plataforma.adicionarConteudo(new Filme("Academia dos Heróis", Genero.ANIME, "Anime"));

        System.out.println("\nExemplo de cancelamento de notificação:");
        ana.cancelarInscricao(plataforma, Genero.ACAO);
        plataforma.adicionarConteudo(new Filme("Corrida Explosiva", Genero.ACAO, "Filme"));
    }
}
