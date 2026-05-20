public class SistemaAluguelCarro {
    public ReservaCarro reservarCarro(TipoCarro tipoCarro, int quantidadeDiarias) {
        if (tipoCarro == null) {
            throw new IllegalArgumentException("Tipo de carro inválido.");
        }
        if (quantidadeDiarias <= 0) {
            throw new IllegalArgumentException("A quantidade de diárias do carro deve ser maior que zero.");
        }

        double total = tipoCarro.getDiaria() * quantidadeDiarias;
        return new ReservaCarro(tipoCarro, quantidadeDiarias, total);
    }
}
