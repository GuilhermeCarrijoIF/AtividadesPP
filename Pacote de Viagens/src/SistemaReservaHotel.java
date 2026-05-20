public class SistemaReservaHotel {
    public ReservaHotel reservarHotel(TipoQuarto tipoQuarto, int quantidadePessoas, int quantidadeDiarias) {
        if (tipoQuarto == null) {
            throw new IllegalArgumentException("Tipo de quarto inválido.");
        }
        if (quantidadePessoas <= 0) {
            throw new IllegalArgumentException("A quantidade de pessoas deve ser maior que zero.");
        }
        if (quantidadeDiarias <= 0) {
            throw new IllegalArgumentException("A quantidade de diárias do hotel deve ser maior que zero.");
        }

        double total = tipoQuarto.getDiariaPorPessoa() * quantidadePessoas * quantidadeDiarias;
        return new ReservaHotel(tipoQuarto, quantidadePessoas, quantidadeDiarias, total);
    }
}
