import java.util.Arrays;
import java.util.List;

public class ValidadorLoginCadastrado extends Validador {
    private final List<String> loginsCadastrados = Arrays.asList(
            "admin",
            "guilherme",
            "aluno"
    );

    @Override
    protected void verificar(LoginRequest request) {
        if (!loginsCadastrados.contains(request.getLogin())) {
            request.adicionarErro("Login não cadastrado no sistema.");
        }
    }
}
