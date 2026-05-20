public enum TipoPoltrona {
    JANELA("Janela"),
    MEIO("Meio"),
    CORREDOR("Corredor");

    private final String descricao;

    TipoPoltrona(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
