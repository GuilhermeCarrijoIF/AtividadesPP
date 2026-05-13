public class BancoFactory {

    public static BancoDados criarBanco(PerfilCliente perfil) {

        switch (perfil) {

            case GRATUITO:
                return new ParadoxAdapter();

            case BASICO:
                return new FirebirdAdapter();

            case ULTIMATE:
                return new MySQLAdapter();

            default:
                throw new IllegalArgumentException("Perfil inválido");
        }
    }
}