public class CaminhaoBuilder implements VeiculoBuilder {
    private Veiculo veiculo;

    public CaminhaoBuilder() {
        reset();
    }

    @Override
    public void reset() {
        veiculo = new Veiculo();
        veiculo.setTipo("Caminhao");
    }

    @Override
    public void construirMotor() {
        veiculo.setMotor("Motor Diesel V8");
    }

    @Override
    public void construirTransmissao() {
        veiculo.setTransmissao("Manual Pesada");
    }

    @Override
    public void pintar() {
        veiculo.setCor("Branco");
    }

    @Override
    public void adicionarRodas() {
        veiculo.setRodas(6);
    }

    @Override
    public Veiculo getResultado() {
        Veiculo resultado = veiculo;
        reset();
        return resultado;
    }
}
