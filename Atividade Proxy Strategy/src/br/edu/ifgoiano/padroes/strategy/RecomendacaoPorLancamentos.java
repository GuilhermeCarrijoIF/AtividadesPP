package br.edu.ifgoiano.padroes.strategy;

public class RecomendacaoPorLancamentos implements EstrategiaRecomendacao {
    @Override
    public void recomendar() {
        System.out.println("Recomendando os lançamentos mais recentes da plataforma.");
    }
}
