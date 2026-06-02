public class ValidadorTamanhoMinimo extends Validador {
    @Override
    protected void verificar(LoginRequest request) {
        if (request.getSenha().length() < 8) {
            request.adicionarErro("A senha deve ter pelo menos 8 caracteres.");
        }
    }
}
