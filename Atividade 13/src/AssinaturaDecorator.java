public abstract class AssinaturaDecorator implements Assinatura {

    protected Assinatura assinatura;

    public AssinaturaDecorator(Assinatura assinatura) {
        this.assinatura = assinatura;
    }

    @Override
    public String obterDescricao() {
        return assinatura.obterDescricao();
    }

    @Override
    public double custo() {
        return assinatura.custo();
    }
}
