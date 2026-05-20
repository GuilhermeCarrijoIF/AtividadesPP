public enum ClasseVoo {
    PRIMEIRA_CLASSE("1ª Classe", 1, 3),
    EXECUTIVA("Classe Executiva", 4, 8),
    ECONOMICA("Classe Econômica", 9, 32);

    private final String descricao;
    private final int fileiraInicial;
    private final int fileiraFinal;

    ClasseVoo(String descricao, int fileiraInicial, int fileiraFinal) {
        this.descricao = descricao;
        this.fileiraInicial = fileiraInicial;
        this.fileiraFinal = fileiraFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getFileiraInicial() {
        return fileiraInicial;
    }

    public int getFileiraFinal() {
        return fileiraFinal;
    }
}
