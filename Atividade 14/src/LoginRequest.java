import java.util.ArrayList;
import java.util.List;

public class LoginRequest {
    private String login;
    private String senha;
    private List<String> erros = new ArrayList<>();

    public LoginRequest(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public List<String> getErros() {
        return erros;
    }

    public void adicionarErro(String erro) {
        erros.add(erro);
    }

    public boolean estaValido() {
        return erros.isEmpty();
    }
}
