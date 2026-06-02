public abstract class Validador {
    protected Validador proximo;

    public Validador setProximo(Validador proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public void validar(LoginRequest request) {
        verificar(request);

        if (proximo != null) {
            proximo.validar(request);
        }
    }

    protected abstract void verificar(LoginRequest request);
}
