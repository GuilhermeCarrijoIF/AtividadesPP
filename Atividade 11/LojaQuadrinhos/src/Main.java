import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Loja de Quadrinhos ===");
        System.out.println("1 - Bronze");
        System.out.println("2 - Prata");
        System.out.println("3 - Ouro");
        System.out.println("4 - Platina");
        System.out.print("Escolha o nível do cliente: ");

        int opcao = scanner.nextInt();
        NivelCliente nivel = NivelCliente.fromOpcao(opcao);

        if (nivel == null) {
            System.out.println("Opção inválida.");
            scanner.close();
            return;
        }

        CaixaAssinatura caixa = GeradorCaixa.gerar(nivel);
        caixa.exibir();

        scanner.close();
    }
}
