import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SistemaLogin login = SistemaLogin.getInstancia();

        System.out.println("=== Sistema de Login ===\n");

        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        String captcha = login.gerarCaptcha();
        System.out.println("\nDigite o código: [ " + captcha + " ]");
        System.out.print("Código: ");
        String captchaDigitado = scanner.nextLine();

        System.out.println();
        login.autenticar(usuario, senha, captcha, captchaDigitado);

        scanner.close();
    }
}
