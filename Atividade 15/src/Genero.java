public enum Genero {
    ACAO("Ação"),
    COMEDIA("Comédia"),
    TERROR("Terror"),
    ANIME("Anime"),
    FICCAO_CIENTIFICA("Ficção Científica");

    private final String descricao;

    Genero(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
