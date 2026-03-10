package DIP;
class MySQLDatabase {

    public void conectar() {
        System.out.println("Conectando ao MySQL");
    }

}

class UsuarioService {

    MySQLDatabase banco = new MySQLDatabase();

    public void salvar() {
        banco.conectar();
    }

}