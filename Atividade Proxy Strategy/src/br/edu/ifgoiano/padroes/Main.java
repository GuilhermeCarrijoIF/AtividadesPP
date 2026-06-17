package br.edu.ifgoiano.padroes;

import br.edu.ifgoiano.padroes.proxy.Usuario;
import br.edu.ifgoiano.padroes.proxy.Video;
import br.edu.ifgoiano.padroes.proxy.VideoProxy;
import br.edu.ifgoiano.padroes.strategy.RecomendacaoPorGenero;
import br.edu.ifgoiano.padroes.strategy.RecomendacaoPorLancamentos;
import br.edu.ifgoiano.padroes.strategy.RecomendacaoPorPopularidade;
import br.edu.ifgoiano.padroes.strategy.ServicoRecomendacao;


public class Main {
    public static void main(String[] args) {
        System.out.println("=======================================");
        System.out.println(" SISTEMA DE STREAMING - PROXY/STRATEGY ");
        System.out.println("=======================================");

        Usuario usuarioComum = new Usuario("João", false);
        Usuario usuarioPremium = new Usuario("Maria", true);

        executarExemploProxy(usuarioComum, usuarioPremium);
        executarExemploStrategy();
    }

    private static void executarExemploProxy(Usuario usuarioComum, Usuario usuarioPremium) {
        System.out.println();
        System.out.println("=== EXEMPLO DO PADRÃO PROXY ===");

        Video videoGratis = new VideoProxy("Aventuras no Espaço", false);
        Video videoPremium = new VideoProxy("Documentário Exclusivo", true);

        System.out.println();
        System.out.println("Tentativa 1: usuário comum assistindo vídeo gratuito");
        videoGratis.assistir(usuarioComum);

        System.out.println();
        System.out.println("Tentativa 2: usuário comum tentando assistir vídeo premium");
        videoPremium.assistir(usuarioComum);

        System.out.println();
        System.out.println("Tentativa 3: usuário premium assistindo vídeo premium");
        videoPremium.assistir(usuarioPremium);

        System.out.println();
        System.out.println("Tentativa 4: usuário premium assistindo o mesmo vídeo novamente");
        videoPremium.assistir(usuarioPremium);
    }

    private static void executarExemploStrategy() {
        System.out.println();
        System.out.println("=== EXEMPLO DO PADRÃO STRATEGY ===");

        ServicoRecomendacao servico = new ServicoRecomendacao();

        System.out.println();
        System.out.println("Estratégia 1:");
        servico.setEstrategia(new RecomendacaoPorGenero("Ficção Científica"));
        servico.recomendarVideo();

        System.out.println();
        System.out.println("Estratégia 2:");
        servico.setEstrategia(new RecomendacaoPorPopularidade());
        servico.recomendarVideo();

        System.out.println();
        System.out.println("Estratégia 3:");
        servico.setEstrategia(new RecomendacaoPorLancamentos());
        servico.recomendarVideo();
    }
}
