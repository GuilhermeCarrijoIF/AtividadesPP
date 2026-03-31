import java.util.Random;

public class SistemaLogin {

    private static SistemaLogin instancia;

    private final String usuarioCadastrado = "Guilherme";
    private final String senhaCadastrada = "123456789";

    private SistemaLogin() {}

    public static SistemaLogin getInstancia() {
        if (instancia == null) {
            instancia = new SistemaLogin();
        }
        return instancia;
    }

    public String gerarCaptcha() {
        String caracteres = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789@#$&";
        Random rand = new Random();
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            captcha.append(caracteres.charAt(rand.nextInt(caracteres.length())));
        }
        return captcha.toString();
    }

    public boolean autenticar(String usuario, String senha, String captchaGerado, String captchaDigitado) {
        if (!captchaGerado.equals(captchaDigitado)) {
            System.out.println("CAPTCHA incorreto. Acesso negado.");
            return false;
        }
        if (usuarioCadastrado.equals(usuario) && senhaCadastrada.equals(senha)) {
            System.out.println("Login realizado com sucesso! Bem-vindo, " + usuario + "!");
            return true;
        }
        System.out.println("Usuário ou senha incorretos.");
        return false;
    }
}
