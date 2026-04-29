package br.com.fabrica.violoes;

public class Violao implements ViolaoPrototype, Cloneable {
    private TipoViolao tipo;
    private String nome;
    private double precoBase;
    private Especificacao especificacao;

    public Violao(TipoViolao tipo, String nome, double precoBase, Especificacao especificacao) {
        this.tipo = tipo;
        this.nome = nome;
        this.precoBase = precoBase;
        this.especificacao = especificacao;
    }

    public TipoViolao getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public Especificacao getEspecificacao() {
        return especificacao;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    @Override
    public Violao cloneSuperficial() {
        try {
            return (Violao) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Erro ao clonar violão.", e);
        }
    }

    @Override
    public Violao cloneProfundo() {
        return new Violao(
                tipo,
                nome,
                precoBase,
                especificacao.cloneProfundo()
        );
    }

    @Override
    public String toString() {
        return "Violao{" +
                "tipo=" + tipo +
                ", nome='" + nome + '\'' +
                ", precoBase=" + precoBase +
                ", especificacao=" + especificacao +
                '}';
    }
}
