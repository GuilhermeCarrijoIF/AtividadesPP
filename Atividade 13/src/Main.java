import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt", "BR"));

        Scanner scanner = new Scanner(System.in);
        Assinatura assinatura = new AssinaturaBase();
        Set<Integer> pacotesEscolhidos = new HashSet<>();

        int opcao;

        do {
            mostrarMenu();
            System.out.print("Escolha uma opcao: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Opcao invalida. Digite apenas numeros.");
                scanner.next();
                System.out.print("Escolha uma opcao: ");
            }

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    if (pacotesEscolhidos.contains(1)) {
                        System.out.println("Esse pacote ja foi adicionado.");
                    } else {
                        assinatura = new MultiplosDispositivos(assinatura);
                        pacotesEscolhidos.add(1);
                        System.out.println("Pacote adicionado com sucesso.");
                    }
                    break;

                case 2:
                    if (pacotesEscolhidos.contains(2)) {
                        System.out.println("Esse pacote ja foi adicionado.");
                    } else {
                        assinatura = new FreteGratis(assinatura);
                        pacotesEscolhidos.add(2);
                        System.out.println("Pacote adicionado com sucesso.");
                    }
                    break;

                case 3:
                    if (pacotesEscolhidos.contains(3)) {
                        System.out.println("Esse pacote ja foi adicionado.");
                    } else {
                        assinatura = new CaixaSurpresa(assinatura);
                        pacotesEscolhidos.add(3);
                        System.out.println("Pacote adicionado com sucesso.");
                    }
                    break;

                case 4:
                    if (pacotesEscolhidos.contains(4)) {
                        System.out.println("Esse pacote ja foi adicionado.");
                    } else {
                        assinatura = new CartaoPlatinum(assinatura);
                        pacotesEscolhidos.add(4);
                        System.out.println("Pacote adicionado com sucesso.");
                    }
                    break;

                case 5:
                    if (pacotesEscolhidos.contains(5)) {
                        System.out.println("Esse pacote ja foi adicionado.");
                    } else {
                        assinatura = new CashBack(assinatura);
                        pacotesEscolhidos.add(5);
                        System.out.println("Pacote adicionado com sucesso.");
                    }
                    break;

                case 6:
                    mostrarAssinatura(assinatura);
                    break;

                case 0:
                    System.out.println("\nFinalizando pedido...");
                    mostrarAssinatura(assinatura);
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n========== SERVICO DE STREAM ==========");
        System.out.println("Assinatura base ja inclusa: R$ 9,99");
        System.out.println("1 - Adicionar Pacote 1: varios dispositivos - R$ 19,99");
        System.out.println("2 - Adicionar Pacote 2: frete gratis - R$ 9,99");
        System.out.println("3 - Adicionar Pacote 3: caixa surpresa - R$ 29,99");
        System.out.println("4 - Adicionar Pacote 4: cartao Platinum - R$ 49,99");
        System.out.println("5 - Adicionar Pacote 5: Cash Back - R$ 19,99");
        System.out.println("6 - Ver assinatura atual");
        System.out.println("0 - Finalizar");
        System.out.println("=======================================");
    }

    private static void mostrarAssinatura(Assinatura assinatura) {
        System.out.println("\n----- ASSINATURA ATUAL -----");
        System.out.println(assinatura.obterDescricao());
        System.out.printf("Valor total: R$ %.2f%n", assinatura.custo());
        System.out.println("----------------------------");
    }
}
