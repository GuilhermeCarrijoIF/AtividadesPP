public enum TipoCarro {
    ECONOMICO("Econômico", 150.00),
    EXECUTIVO("Executivo", 150.00 * 2.00),
    LUXO("Luxo", 150.00 * 2.00 * 2.00);

    private final String descricao;
    private final double diaria;

    TipoCarro(String descricao, double diaria) {
        this.descricao = descricao;
        this.diaria = diaria;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getDiaria() {
        return diaria;
    }
}
