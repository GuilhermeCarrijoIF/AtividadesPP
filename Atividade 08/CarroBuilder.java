public class CarroBuilder implements VeiculoBuilder {
    private Veiculo veiculo;

    public CarroBuilder() {
        reset();
    }

    @Override
    public void reset() {
        veiculo = new Veiculo();
        veiculo.setTipo("Carro");
    }

    @Override
    public void construirMotor() {
        veiculo.setMotor("Motor 1.6");
    }

    @Override
    public void construirTransmissao() {
        veiculo.setTransmissao("Automatica");
    }

    @Override
    public void pintar() {
        veiculo.setCor("Prata");
    }

    @Override
    public void adicionarRodas() {
        veiculo.setRodas(4);
    }

    @Override
    public Veiculo getResultado() {
        Veiculo resultado = veiculo;
        reset();
        return resultado;
    }
}
