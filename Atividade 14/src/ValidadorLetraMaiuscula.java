public class ValidadorLetraMaiuscula extends Validador {
    @Override
    protected void verificar(LoginRequest request) {
        if (!request.getSenha().matches(".*[A-Z].*")) {
            request.adicionarErro("A senha deve possuir pelo menos uma letra maiúscula.");
        }
    }
}
