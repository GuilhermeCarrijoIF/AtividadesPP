public class Main {

    public static void main(String[] args) throws InterruptedException {

        DatabaseAccessThread[] threads = {
            new DatabaseAccessThread("Thread-1", "SELECT * FROM usuarios"),
            new DatabaseAccessThread("Thread-2", "SELECT * FROM produtos"),
            new DatabaseAccessThread("Thread-3", "INSERT INTO logs VALUES ('acesso')"),
            new DatabaseAccessThread("Thread-4", "UPDATE clientes SET ativo = true"),
            new DatabaseAccessThread("Thread-5", "DELETE FROM sessoes WHERE expirado = true")
        };

        for (DatabaseAccessThread t : threads) {
            t.start();
        }

        for (DatabaseAccessThread t : threads) {
            t.join();
        }

        System.out.println("\nTodas as threads finalizaram.");
        System.out.println("Instância compartilhada: " + DatabaseConnectionManager.getInstancia().hashCode());
    }
}
