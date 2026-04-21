public interface VeiculoBuilder {
    void reset();
    void construirMotor();
    void construirTransmissao();
    void pintar();
    void adicionarRodas();
    Veiculo getResultado();
}
