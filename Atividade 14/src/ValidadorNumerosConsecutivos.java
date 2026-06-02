public class ValidadorNumerosConsecutivos extends Validador {
    @Override
    protected void verificar(LoginRequest request) {
        String senha = request.getSenha();

        for (int i = 0; i < senha.length() - 2; i++) {
            char c1 = senha.charAt(i);
            char c2 = senha.charAt(i + 1);
            char c3 = senha.charAt(i + 2);

            if (Character.isDigit(c1) &&
                Character.isDigit(c2) &&
                Character.isDigit(c3) &&
                c2 == c1 + 1 &&
                c3 == c2 + 1) {

                request.adicionarErro("A senha não pode possuir 3 números consecutivos em sequência.");
                return;
            }
        }
    }
}
