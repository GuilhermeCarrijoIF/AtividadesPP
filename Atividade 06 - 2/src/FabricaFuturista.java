public class FabricaFuturista implements FabricaTema {
    @Override public Personagem criarPersonagem() { return new Androide(); }
    @Override public Arma criarArma() { return new Laser(); }
    @Override public Transporte criarTransporte() { return new NaveEspacial(); }
}
