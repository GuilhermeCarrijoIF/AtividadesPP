public class ValidadorCaractereEspecial extends Validador {
    @Override
    protected void verificar(LoginRequest request) {
        if (!request.getSenha().matches(".*[@#$%&*].*")) {
            request.adicionarErro("A senha deve possuir pelo menos um caractere especial: @, #, $, %, & ou *.");
        }
    }
}
