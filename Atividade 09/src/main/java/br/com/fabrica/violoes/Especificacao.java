package br.com.fabrica.violoes;

import java.util.ArrayList;
import java.util.List;

public class Especificacao implements Cloneable {
    private String corpo;
    private String tipoCordas;
    private String indicacao;
    private List<String> caracteristicas;

    public Especificacao(String corpo, String tipoCordas, String indicacao, List<String> caracteristicas) {
        this.corpo = corpo;
        this.tipoCordas = tipoCordas;
        this.indicacao = indicacao;
        this.caracteristicas = new ArrayList<>(caracteristicas);
    }

    public String getCorpo() {
        return corpo;
    }

    public String getTipoCordas() {
        return tipoCordas;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public List<String> getCaracteristicas() {
        return caracteristicas;
    }

    public void adicionarCaracteristica(String caracteristica) {
        this.caracteristicas.add(caracteristica);
    }

    public Especificacao cloneSuperficial() {
        try {
            return (Especificacao) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Erro ao clonar especificação.", e);
        }
    }

    public Especificacao cloneProfundo() {
        return new Especificacao(corpo, tipoCordas, indicacao, new ArrayList<>(caracteristicas));
    }

    @Override
    public String toString() {
        return "Especificacao{" +
                "corpo='" + corpo + '\'' +
                ", tipoCordas='" + tipoCordas + '\'' +
                ", indicacao='" + indicacao + '\'' +
                ", caracteristicas=" + caracteristicas +
                '}';
    }
}
