package br.edu.ifgoiano.padroes.strategy;

public class ServicoRecomendacao {
    private EstrategiaRecomendacao estrategia;

    public void setEstrategia(EstrategiaRecomendacao estrategia) {
        this.estrategia = estrategia;
    }

    public void recomendarVideo() {
        if (estrategia == null) {
            System.out.println("Nenhuma estratégia de recomendação foi definida.");
            return;
        }

        estrategia.recomendar();
    }
}
