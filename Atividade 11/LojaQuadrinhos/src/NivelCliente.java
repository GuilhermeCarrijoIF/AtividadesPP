public enum NivelCliente {
    BRONZE("Bronze", 3),
    PRATA("Prata", 5),
    OURO("Ouro", 7),
    PLATINA("Platina", 10);

    private final String nome;
    private final int quantidadeItens;

    NivelCliente(String nome, int quantidadeItens) {
        this.nome = nome;
        this.quantidadeItens = quantidadeItens;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public static NivelCliente fromOpcao(int opcao) {
        switch (opcao) {
            case 1:
                return BRONZE;
            case 2:
                return PRATA;
            case 3:
                return OURO;
            case 4:
                return PLATINA;
            default:
                return null;
        }
    }
}
