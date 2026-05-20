public class ResultadoPagamento {
    private final FormaPagamento formaPagamento;
    private final int parcelas;
    private final double subtotal;
    private final double desconto;
    private final double acrescimo;
    private final double valorFinal;

    public ResultadoPagamento(FormaPagamento formaPagamento, int parcelas, double subtotal,
                              double desconto, double acrescimo, double valorFinal) {
        this.formaPagamento = formaPagamento;
        this.parcelas = parcelas;
        this.subtotal = subtotal;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
        this.valorFinal = valorFinal;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public double getAcrescimo() {
        return acrescimo;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public double getValorParcela() {
        return valorFinal / parcelas;
    }
}
