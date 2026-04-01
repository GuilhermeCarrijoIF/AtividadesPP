public class DatabaseAccessThread extends Thread {

    private String query;

    public DatabaseAccessThread(String nome, String query) {
        super(nome);
        this.query = query;
    }

    @Override
    public void run() {
        DatabaseConnectionManager manager = DatabaseConnectionManager.getInstancia();

        System.out.println("[" + getName() + "] Obteve instância: " + manager.hashCode());

        manager.executarQuery(query, getName());
    }
}
