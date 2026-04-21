public class Montadora {

    public void montarVeiculo(VeiculoBuilder builder) {
        builder.reset();
        builder.construirMotor();
        builder.construirTransmissao();
        builder.pintar();
        builder.adicionarRodas();
    }
}
