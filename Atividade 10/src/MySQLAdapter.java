public class MySQLAdapter implements BancoDados {

    private MySQL mysql;

    public MySQLAdapter() {
        this.mysql = new MySQL();
    }

    @Override
    public void conectar() {
        mysql.conectarMySQL();
    }

    @Override
    public void salvar(String dado) {
        mysql.inserirMySQL(dado);
    }
}