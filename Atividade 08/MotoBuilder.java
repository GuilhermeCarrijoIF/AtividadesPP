public class MotoBuilder implements VeiculoBuilder {
    private Veiculo veiculo;

    public MotoBuilder() {
        reset();
    }

    @Override
    public void reset() {
        veiculo = new Veiculo();
        veiculo.setTipo("Moto");
    }

    @Override
    public void construirMotor() {
        veiculo.setMotor("Motor 250cc");
    }

    @Override
    public void construirTransmissao() {
        veiculo.setTransmissao("Manual");
    }

    @Override
    public void pintar() {
        veiculo.setCor("Vermelha");
    }

    @Override
    public void adicionarRodas() {
        veiculo.setRodas(2);
    }

    @Override
    public Veiculo getResultado() {
        Veiculo resultado = veiculo;
        reset();
        return resultado;
    }
}
