public class Cliente {
    private Personagem personagem;
    private Arma arma;
    private Transporte transporte;

    public Cliente(FabricaTema fabrica) {
        this.personagem = fabrica.criarPersonagem();
        this.arma = fabrica.criarArma();
        this.transporte = fabrica.criarTransporte();
    }

    public void executar() {
        personagem.exibirInfo();
        arma.exibirInfo();
        transporte.exibirInfo();
        personagem.atacar();
        arma.usar();
        transporte.mover();
        arma.guardar();
        transporte.parar();
    }
}
