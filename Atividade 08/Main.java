public class Main {
    public static void main(String[] args) {
        Montadora montadora = new Montadora();

        VeiculoBuilder carroBuilder = new CarroBuilder();
        VeiculoBuilder caminhaoBuilder = new CaminhaoBuilder();
        VeiculoBuilder motoBuilder = new MotoBuilder();

        montadora.montarVeiculo(carroBuilder);
        Veiculo carro = carroBuilder.getResultado();

        montadora.montarVeiculo(caminhaoBuilder);
        Veiculo caminhao = caminhaoBuilder.getResultado();

        montadora.montarVeiculo(motoBuilder);
        Veiculo moto = motoBuilder.getResultado();

        System.out.println(carro);
        System.out.println(caminhao);
        System.out.println(moto);
    }
}
