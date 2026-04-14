public class Cliente {
    private Personagem personagem;
    private Arma arma;

    public Cliente(FabricaTema fabrica) {
        this.personagem = fabrica.criarPersonagem();
        this.arma = fabrica.criarArma();
    }

    public void executar() {
        personagem.exibirInfo();
        arma.exibirInfo();
        personagem.atacar();
        arma.usar();
        arma.guardar();
    }
}
