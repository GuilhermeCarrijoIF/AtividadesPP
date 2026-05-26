public class CartaoPlatinum extends AssinaturaDecorator {

    public CartaoPlatinum(Assinatura assinatura) {
        super(assinatura);
    }

    @Override
    public String obterDescricao() {
        return super.obterDescricao() + "\n+ Pacote 4: cartao de credito Platinum";
    }

    @Override
    public double custo() {
        return super.custo() + 49.99;
    }
}
