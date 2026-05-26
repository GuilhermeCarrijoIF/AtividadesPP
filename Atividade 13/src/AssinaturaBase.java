public class AssinaturaBase implements Assinatura {

    @Override
    public String obterDescricao() {
        return "Assinatura Base: assistir videos em um unico dispositivo";
    }

    @Override
    public double custo() {
        return 9.99;
    }
}
