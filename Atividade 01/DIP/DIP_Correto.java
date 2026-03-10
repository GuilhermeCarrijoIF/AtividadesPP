package DIP;
interface Database {
    void conectar();
}

class MySQLDatabase implements Database {

    public void conectar() {
        System.out.println("Conectando ao MySQL");
    }

}

class UsuarioService {

    Database banco;

    public UsuarioService(Database banco) {
        this.banco = banco;
    }

    public void salvar() {
        banco.conectar();
    }

}