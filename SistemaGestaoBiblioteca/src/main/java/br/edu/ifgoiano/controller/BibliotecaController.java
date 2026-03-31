/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifgoiano.controller;

/**
 *
 * @author Anna
 */
import br.edu.ifgoiano.bo.LivroBO;
import br.edu.ifgoiano.bo.EmprestimoBO;
import br.edu.ifgoiano.model.Livro;
import br.edu.ifgoiano.model.Emprestimo;
import java.util.List;

public class BibliotecaController {
    
    private LivroBO livroBO;
    private EmprestimoBO emprestimoBO;
    
    public BibliotecaController() {
        this.livroBO = new LivroBO();
        this.emprestimoBO = new EmprestimoBO();
    }

    public LivroBO getLivroBO() {
        return livroBO;
    }

    public void setLivroBO(LivroBO livroBO) {
        this.livroBO = livroBO;
    }

    public EmprestimoBO getEmprestimoBO() {
        return emprestimoBO;
    }

    public void setEmprestimoBO(EmprestimoBO emprestimoBO) {
        this.emprestimoBO = emprestimoBO;
    }
    
    
    public String cadastrarLivro(String titulo, String autor) {
        try {
            Livro livro = livroBO.cadastrarLivro(titulo, autor);
            return "Livro cadastrado com sucesso! ID: " + livro.getId();
        } catch (Exception e) {
            return "Erro ao cadastrar livro: " + e.getMessage();
        }
    }
    
    public String listarLivrosDisponiveis() {
        List<Livro> livros = livroBO.listarDisponiveis();
        if (livros.isEmpty()) {
            return "Nenhum livro disponível no momento.";
        }
        
        StringBuilder sb = new StringBuilder("\n--- LIVROS DISPONÍVEIS ---\n");
        for (Livro livro : livros) {
            sb.append(livro.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public String listarTodosLivros() {
        List<Livro> livros = livroBO.listarTodos();
        if (livros.isEmpty()) {
            return "Nenhum livro cadastrado.";
        }
        
        StringBuilder sb = new StringBuilder("\n--- TODOS OS LIVROS ---\n");
        for (Livro livro : livros) {
            sb.append(livro.toString()).append("\n");
        }
        return sb.toString();
    }
    
    public String realizarEmprestimo(int idLivro, String nomeLeitor) {
        try {
            emprestimoBO.realizarEmprestimo(idLivro, nomeLeitor);
            return "Empréstimo realizado com sucesso!";
        } catch (Exception e) {
            return "Erro ao realizar empréstimo: " + e.getMessage();
        }
    }
    
    public String devolverLivro(int idLivro) {
        try {
            emprestimoBO.devolverLivro(idLivro);
            return "Livro devolvido com sucesso!";
        } catch (Exception e) {
            return "Erro ao devolver livro: " + e.getMessage();
        }
    }
    
    public String excluirLivro(int idLivro) {
        try {
            livroBO.excluirLivro(idLivro);
            return "Livro excluído com sucesso!";
        } catch (Exception e) {
            return "Erro ao excluir livro: " + e.getMessage();
        }
    }
    
    public String listarEmprestimos() {
        List<Emprestimo> emprestimos = emprestimoBO.listarEmprestimos();
        if (emprestimos.isEmpty()) {
            return "Nenhum empréstimo ativo.";
        }
        
        StringBuilder sb = new StringBuilder("\n--- EMPRÉSTIMOS ATIVOS ---\n");
        for (Emprestimo emp : emprestimos) {
            sb.append(emp.toString()).append("\n");
        }
        return sb.toString();
    }
}