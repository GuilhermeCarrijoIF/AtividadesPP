public class ParadoxAdapter implements BancoDados {

    private Paradox paradox;

    public ParadoxAdapter() {
        this.paradox = new Paradox();
    }

    @Override
    public void conectar() {
        paradox.abrirConexaoParadox();
    }

    @Override
    public void salvar(String dado) {
        paradox.salvarNoParadox(dado);
    }
}