public enum TipoQuarto {
    SIMPLES("Simples", 200.00),
    EXECUTIVO("Executivo", 200.00 * 1.50),
    SUITE_PRESIDENCIAL("Suíte Presidencial", 200.00 * 1.50 * 3.00);

    private final String descricao;
    private final double diariaPorPessoa;

    TipoQuarto(String descricao, double diariaPorPessoa) {
        this.descricao = descricao;
        this.diariaPorPessoa = diariaPorPessoa;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getDiariaPorPessoa() {
        return diariaPorPessoa;
    }
}
