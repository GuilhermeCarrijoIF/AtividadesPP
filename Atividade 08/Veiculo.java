public class Veiculo {
    private String tipo;
    private String motor;
    private String transmissao;
    private String cor;
    private int rodas;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setTransmissao(String transmissao) {
        this.transmissao = transmissao;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setRodas(int rodas) {
        this.rodas = rodas;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "tipo='" + tipo + '\'' +
                ", motor='" + motor + '\'' +
                ", transmissao='" + transmissao + '\'' +
                ", cor='" + cor + '\'' +
                ", rodas=" + rodas +
                '}';
    }
}
