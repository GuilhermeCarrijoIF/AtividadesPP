package br.edu.ifgoiano.padroes.strategy;

public class RecomendacaoPorPopularidade implements EstrategiaRecomendacao {
    @Override
    public void recomendar() {
        System.out.println("Recomendando os filmes e séries mais populares da plataforma.");
    }
}
