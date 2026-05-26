public class CashBack extends AssinaturaDecorator {

    public CashBack(Assinatura assinatura) {
        super(assinatura);
    }

    @Override
    public String obterDescricao() {
        return super.obterDescricao() + "\n+ Pacote 5: compra com Cash Back";
    }

    @Override
    public double custo() {
        return super.custo() + 19.99;
    }
}
