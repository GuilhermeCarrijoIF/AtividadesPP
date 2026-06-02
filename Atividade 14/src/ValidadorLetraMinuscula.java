public class ValidadorLetraMinuscula extends Validador {
    @Override
    protected void verificar(LoginRequest request) {
        if (!request.getSenha().matches(".*[a-z].*")) {
            request.adicionarErro("A senha deve possuir pelo menos uma letra minúscula.");
        }
    }
}
