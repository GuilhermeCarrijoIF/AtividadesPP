public class Passageiro {
    private final Pessoa pessoa;
    private final Assento assento;

    public Passageiro(Pessoa pessoa, Assento assento) {
        this.pessoa = pessoa;
        this.assento = assento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Assento getAssento() {
        return assento;
    }
}
