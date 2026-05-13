public class FirebirdAdapter implements BancoDados {

    private Firebird firebird;

    public FirebirdAdapter() {
        this.firebird = new Firebird();
    }

    @Override
    public void conectar() {
        firebird.iniciarFirebird();
    }

    @Override
    public void salvar(String dado) {
        firebird.gravarFirebird(dado);
    }
}