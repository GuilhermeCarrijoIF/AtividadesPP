public class FreteGratis extends AssinaturaDecorator {

    public FreteGratis(Assinatura assinatura) {
        super(assinatura);
    }

    @Override
    public String obterDescricao() {
        return super.obterDescricao() + "\n+ Pacote 2: frete gratis em produtos";
    }

    @Override
    public double custo() {
        return super.custo() + 9.99;
    }
}
