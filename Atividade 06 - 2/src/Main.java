import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RegistroFabricas.listarTemas();
        System.out.print("Digite o tema desejado: ");
        String temaSelecionado = scanner.nextLine().trim();

        try {
            FabricaTema fabrica = RegistroFabricas.obterFabrica(temaSelecionado);
            System.out.println("\n=== Tema: " + temaSelecionado.toUpperCase() + " ===");
            Cliente cliente = new Cliente(fabrica);
            cliente.executar();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
