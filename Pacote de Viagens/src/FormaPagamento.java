public enum FormaPagamento {
    PIX("Pix"),
    BOLETO("Boleto"),
    DEBITO("Débito"),
    CREDITO("Crédito");

    private final String descricao;

    FormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
