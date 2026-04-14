public class Main {
    public static void main(String[] args) {
        System.out.println("=== Tema Medieval ===");
        Cliente clienteMedieval = new Cliente(new FabricaMedieval());
        clienteMedieval.executar();

        System.out.println();

        System.out.println("=== Tema Futurista ===");
        Cliente clienteFuturista = new Cliente(new FabricaFuturista());
        clienteFuturista.executar();
    }
}
