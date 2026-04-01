public class DatabaseConnectionManager {

    private static DatabaseConnectionManager instancia;
    private String conexao;

    private DatabaseConnectionManager() {
        this.conexao = "Conexão com o banco de dados estabelecida.";
        System.out.println("[DatabaseConnectionManager] Instância criada: " + this.hashCode());
    }

    public static synchronized DatabaseConnectionManager getInstancia() {
        if (instancia == null) {
            instancia = new DatabaseConnectionManager();
        }
        return instancia;
    }

    public String getConexao() {
        return conexao;
    }

    public synchronized void executarQuery(String query, String nomeThread) {
        System.out.println("[" + nomeThread + "] Executando query: " + query);
    }
}
