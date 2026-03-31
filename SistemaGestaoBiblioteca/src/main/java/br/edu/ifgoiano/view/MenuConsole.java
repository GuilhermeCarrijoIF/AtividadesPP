/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifgoiano.view;

/**
 *
 * @author Anna
 */
import java.util.Scanner;

import br.edu.ifgoiano.controller.BibliotecaController;

public class MenuConsole {
    
    private BibliotecaController controller;
    private Scanner scanner;
    
    public MenuConsole() {
        this.controller = new BibliotecaController();
        this.scanner = new Scanner(System.in);
    }
    
    public void exibirMenu() {
        int opcao = 0;
        
        do {
            System.out.println("\n===== SISTEMA DE GESTÃO DE BIBLIOTECA =====");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros Disponíveis");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Excluir Livro");
            System.out.println("6. Listar Todos os Livros");
            System.out.println("7. Listar Empréstimos Ativos");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                
                switch (opcao) {
                    case 1:
                        cadastrarLivro();
                        break;
                    case 2:
                        System.out.println(controller.listarLivrosDisponiveis());
                        break;
                    case 3:
                        realizarEmprestimo();
                        break;
                    case 4:
                        devolverLivro();
                        break;
                    case 5:
                        excluirLivro();
                        break;
                    case 6:
                        System.out.println(controller.listarTodosLivros());
                        break;
                    case 7:
                        System.out.println(controller.listarEmprestimos());
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Digite um número válido!");
                opcao = -1;
            }
        } while (opcao != 0);
        
        scanner.close();
    }
    
    private void cadastrarLivro() {
        System.out.println("\n--- CADASTRAR LIVRO ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        
        String resultado = controller.cadastrarLivro(titulo, autor);
        System.out.println(resultado);
    }
    
   private void realizarEmprestimo() {
    System.out.println("\n--- REALIZAR EMPRÉSTIMO ---");

    String livrosDisponiveis = controller.listarLivrosDisponiveis();
    System.out.println(livrosDisponiveis);

    // Para aqui se não houver livros disponíveis
    if (livrosDisponiveis.contains("Nenhum livro disponível")) {
        return;
    }

    System.out.print("ID do Livro: ");
    try {
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nome do Leitor: ");
        String leitor = scanner.nextLine();

        String resultado = controller.realizarEmprestimo(id, leitor);
        System.out.println(resultado);
    } catch (NumberFormatException e) {
        System.out.println("Erro: ID inválido!");
    }
}
    
    private void devolverLivro() {
        System.out.println("\n--- DEVOLVER LIVRO ---");
        
        // Mostra empréstimos ativos
        System.out.println(controller.listarEmprestimos());
        
        System.out.print("ID do Livro a devolver: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            
            String resultado = controller.devolverLivro(id);
            System.out.println(resultado);
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido!");
        }
    }
    
    private void excluirLivro() {
        System.out.println("\n--- EXCLUIR LIVRO ---");
        
        // Mostra todos os livros
        System.out.println(controller.listarTodosLivros());
        
        System.out.print("ID do Livro a excluir: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Confirma exclusão? (S/N): ");
            String confirmacao = scanner.nextLine();
            
            if (confirmacao.equalsIgnoreCase("S")) {
                String resultado = controller.excluirLivro(id);
                
                System.out.println(resultado);
            } else {
                System.out.println("Operação cancelada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: ID inválido!");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE GESTÃO DE BIBLIOTECA ===");
        System.out.println("Iniciando aplicação...\n");
        
        MenuConsole menu = new MenuConsole();
        menu.exibirMenu();
        
        System.out.println("\n=== SISTEMA ENCERRADO ===");
    }
}



