import java.util.List;

public class ReservaPassagem {
    private final ClasseVoo classeEscolhida;
    private final List<Passageiro> passageiros;
    private final double valorTotal;

    public ReservaPassagem(ClasseVoo classeEscolhida, List<Passageiro> passageiros, double valorTotal) {
        this.classeEscolhida = classeEscolhida;
        this.passageiros = passageiros;
        this.valorTotal = valorTotal;
    }

    public ClasseVoo getClasseEscolhida() {
        return classeEscolhida;
    }

    public List<Passageiro> getPassageiros() {
        return passageiros;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
