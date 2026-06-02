public class ValidadorTamanhoMaximo extends Validador {
    @Override
    protected void verificar(LoginRequest request) {
        if (request.getSenha().length() > 16) {
            request.adicionarErro("A senha não pode ter mais de 16 caracteres.");
        }
    }
}
