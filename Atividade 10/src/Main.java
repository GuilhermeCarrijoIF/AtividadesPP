public class Main {

    public static void main(String[] args) {

        PerfilCliente perfil = PerfilCliente.ULTIMATE;

        BancoDados banco = BancoFactory.criarBanco(perfil);

        banco.conectar();
        banco.salvar("Transação realizada pelo usuário");
    }
}