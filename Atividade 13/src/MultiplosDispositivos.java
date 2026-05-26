public class MultiplosDispositivos extends AssinaturaDecorator {

    public MultiplosDispositivos(Assinatura assinatura) {
        super(assinatura);
    }

    @Override
    public String obterDescricao() {
        return super.obterDescricao() + "\n+ Pacote 1: assistir videos em varios dispositivos";
    }

    @Override
    public double custo() {
        return super.custo() + 19.99;
    }
}
