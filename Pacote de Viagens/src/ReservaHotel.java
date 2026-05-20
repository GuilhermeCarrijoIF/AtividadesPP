public class ReservaHotel {
    private final TipoQuarto tipoQuarto;
    private final int quantidadePessoas;
    private final int quantidadeDiarias;
    private final double valorTotal;

    public ReservaHotel(TipoQuarto tipoQuarto, int quantidadePessoas, int quantidadeDiarias, double valorTotal) {
        this.tipoQuarto = tipoQuarto;
        this.quantidadePessoas = quantidadePessoas;
        this.quantidadeDiarias = quantidadeDiarias;
        this.valorTotal = valorTotal;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public int getQuantidadePessoas() {
        return quantidadePessoas;
    }

    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
