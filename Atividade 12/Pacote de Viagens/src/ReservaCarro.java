public class ReservaCarro {
    private final TipoCarro tipoCarro;
    private final int quantidadeDiarias;
    private final double valorTotal;

    public ReservaCarro(TipoCarro tipoCarro, int quantidadeDiarias, double valorTotal) {
        this.tipoCarro = tipoCarro;
        this.quantidadeDiarias = quantidadeDiarias;
        this.valorTotal = valorTotal;
    }

    public TipoCarro getTipoCarro() {
        return tipoCarro;
    }

    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
