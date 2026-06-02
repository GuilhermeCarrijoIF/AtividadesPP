public class ValidadorNumero extends Validador {
    @Override
    protected void verificar(LoginRequest request) {
        if (!request.getSenha().matches(".*[0-9].*")) {
            request.adicionarErro("A senha deve possuir pelo menos um número.");
        }
    }
}
