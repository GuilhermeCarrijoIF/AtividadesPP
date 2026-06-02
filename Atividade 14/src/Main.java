public class Main {
    public static void main(String[] args) {
        Validador cadeia = new ValidadorLoginCadastrado();

        cadeia
            .setProximo(new ValidadorLetraMaiuscula())
            .setProximo(new ValidadorLetraMinuscula())
            .setProximo(new ValidadorCaractereEspecial())
            .setProximo(new ValidadorNumero())
            .setProximo(new ValidadorNumerosConsecutivos())
            .setProximo(new ValidadorTamanhoMinimo())
            .setProximo(new ValidadorTamanhoMaximo());

        testarLogin(cadeia, "guilherme", "Abc12@de");
        testarLogin(cadeia, "joao", "Abc12@de");
        testarLogin(cadeia, "admin", "abc12@de");
        testarLogin(cadeia, "aluno", "ABC12@DE");
        testarLogin(cadeia, "admin", "Abcdefgh");
        testarLogin(cadeia, "guilherme", "Ab123&de");
        testarLogin(cadeia, "aluno", "A1@b");
        testarLogin(cadeia, "admin", "Abcdef123456789@");
    }

    private static void testarLogin(Validador cadeia, String login, String senha) {
        LoginRequest request = new LoginRequest(login, senha);

        cadeia.validar(request);

        System.out.println("-----------------------------------");
        System.out.println("Login: " + login);
        System.out.println("Senha: " + senha);

        if (request.estaValido()) {
            System.out.println("Resultado: Login e senha válidos!");
        } else {
            System.out.println("Resultado: Login ou senha inválidos.");
            System.out.println("Erros encontrados:");

            for (String erro : request.getErros()) {
                System.out.println("- " + erro);
            }
        }
    }
}
