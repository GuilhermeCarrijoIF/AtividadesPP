package br.edu.ifgoiano.padroes.strategy;

public class RecomendacaoPorGenero implements EstrategiaRecomendacao {
    private String genero;

    public RecomendacaoPorGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void recomendar() {
        System.out.println("Recomendando filmes e séries do gênero: " + genero);
    }
}
