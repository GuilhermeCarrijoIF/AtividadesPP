public class CaixaSurpresa extends AssinaturaDecorator {

    public CaixaSurpresa(Assinatura assinatura) {
        super(assinatura);
    }

    @Override
    public String obterDescricao() {
        return super.obterDescricao() + "\n+ Pacote 3: caixa surpresa com produtos de filmes e series";
    }

    @Override
    public double custo() {
        return super.custo() + 29.99;
    }
}
