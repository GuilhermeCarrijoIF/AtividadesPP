package br.com.fabrica.violoes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CadastroPrototiposVioloes fabrica = new CadastroPrototiposVioloes();

        TipoViolao tipoEscolhido = escolherTipoViolao();

        Violao violaoCloneSuperficial = fabrica.criarViolaoComCloneSuperficial(tipoEscolhido);
        Violao outroCloneSuperficial = fabrica.criarViolaoComCloneSuperficial(tipoEscolhido);

        Violao violaoCloneProfundo = fabrica.criarViolaoComCloneProfundo(tipoEscolhido);
        Violao outroCloneProfundo = fabrica.criarViolaoComCloneProfundo(tipoEscolhido);

        System.out.println("\n=== CLONAGEM SUPERFICIAL ===");
        System.out.println("Antes da alteração:");
        System.out.println("Clone 1: " + violaoCloneSuperficial);
        System.out.println("Clone 2: " + outroCloneSuperficial);

        violaoCloneSuperficial
                .getEspecificacao()
                .adicionarCaracteristica("ALTERAÇÃO FEITA NO CLONE SUPERFICIAL");

        System.out.println("\nDepois de alterar a lista de características do Clone 1:");
        System.out.println("Clone 1: " + violaoCloneSuperficial);
        System.out.println("Clone 2: " + outroCloneSuperficial);
        System.out.println("Resultado: como a clonagem é superficial, os clones compartilham o mesmo objeto Especificacao.");

        System.out.println("\n=== CLONAGEM PROFUNDA ===");
        System.out.println("Antes da alteração:");
        System.out.println("Clone 1: " + violaoCloneProfundo);
        System.out.println("Clone 2: " + outroCloneProfundo);

        violaoCloneProfundo
                .getEspecificacao()
                .adicionarCaracteristica("ALTERAÇÃO FEITA NO CLONE PROFUNDO");

        System.out.println("\nDepois de alterar a lista de características do Clone 1:");
        System.out.println("Clone 1: " + violaoCloneProfundo);
        System.out.println("Clone 2: " + outroCloneProfundo);
        System.out.println("Resultado: como a clonagem é profunda, cada clone possui sua própria Especificacao.");
    }

    private static TipoViolao escolherTipoViolao() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Fábrica de Violões - Padrão Prototype ===");
        System.out.println("Escolha o tipo de violão:");

        TipoViolao[] tipos = TipoViolao.values();

        for (int i = 0; i < tipos.length; i++) {
            System.out.printf("%d - %s%n", i + 1, tipos[i]);
        }

        System.out.print("Opção: ");
        int opcao = scanner.nextInt();

        if (opcao < 1 || opcao > tipos.length) {
            throw new IllegalArgumentException("Opção inválida.");
        }

        return tipos[opcao - 1];
    }
}
