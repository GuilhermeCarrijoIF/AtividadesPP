public enum LadoAeronave {
    ESQUERDO("Esquerdo"),
    DIREITO("Direito");

    private final String descricao;

    LadoAeronave(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
