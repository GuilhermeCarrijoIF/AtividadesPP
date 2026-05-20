public class SistemaPagamento {
    private static final double DESCONTO_PIX = 0.10;
    private static final double DESCONTO_BOLETO = 0.05;
    private static final double JUROS_CREDITO_POR_PARCELA = 0.0399;

    public ResultadoPagamento processarPagamento(double subtotal, FormaPagamento formaPagamento, int parcelas) {
        if (subtotal <= 0) {
            throw new IllegalArgumentException("O subtotal deve ser maior que zero.");
        }
        if (formaPagamento == null) {
            throw new IllegalArgumentException("Forma de pagamento inválida.");
        }

        double desconto = 0;
        double acrescimo = 0;
        int parcelasCalculadas = 1;

        switch (formaPagamento) {
            case PIX:
                desconto = subtotal * DESCONTO_PIX;
                break;
            case BOLETO:
                desconto = subtotal * DESCONTO_BOLETO;
                break;
            case DEBITO:
                break;
            case CREDITO:
                validarParcelasCredito(parcelas);
                parcelasCalculadas = parcelas;
                if (parcelas > 1) {
                    acrescimo = subtotal * JUROS_CREDITO_POR_PARCELA * (parcelas - 1);
                }
                break;
            default:
                throw new IllegalArgumentException("Forma de pagamento não suportada.");
        }

        double valorFinal = subtotal - desconto + acrescimo;
        return new ResultadoPagamento(formaPagamento, parcelasCalculadas, subtotal, desconto, acrescimo, valorFinal);
    }

    private void validarParcelasCredito(int parcelas) {
        if (parcelas < 1 || parcelas > 6) {
            throw new IllegalArgumentException("No crédito, o pagamento deve ser feito entre 1 e 6 parcelas.");
        }
    }
}
