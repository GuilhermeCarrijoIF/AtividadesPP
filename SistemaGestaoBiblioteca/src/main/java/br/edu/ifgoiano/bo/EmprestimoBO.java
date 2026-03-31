/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifgoiano.bo;

/**
 *
 * @author Anna
 */
import br.edu.ifgoiano.dao.LivroDAO;
import br.edu.ifgoiano.dao.LivroMemoryDAO;
import br.edu.ifgoiano.dao.EmprestimoDAO;
import br.edu.ifgoiano.dao.EmprestimoMemoryDAO;
import br.edu.ifgoiano.model.Livro;
import br.edu.ifgoiano.model.Emprestimo;
import java.util.List;

public class EmprestimoBO {
    
    private LivroDAO livroDAO;
    private EmprestimoDAO emprestimoDAO;
    
    public EmprestimoBO() {
        this.livroDAO = new LivroMemoryDAO();
        this.emprestimoDAO = new EmprestimoMemoryDAO();
    }

    public LivroDAO getLivroDAO() {
        return livroDAO;
    }

    public void setLivroDAO(LivroDAO livroDAO) {
        this.livroDAO = livroDAO;
    }

    public EmprestimoDAO getEmprestimoDAO() {
        return emprestimoDAO;
    }

    public void setEmprestimoDAO(EmprestimoDAO emprestimoDAO) {
        this.emprestimoDAO = emprestimoDAO;
    }
    
    
    public void realizarEmprestimo(int idLivro, String nomeLeitor) throws Exception {
        // REGRA 1: Nome do leitor não pode ser vazio
        if (nomeLeitor == null || nomeLeitor.trim().isEmpty()) {
            throw new Exception("Nome do leitor não pode ser vazio!");
        }
        
        // REGRA 2: Livro existe?
        Livro livro = livroDAO.buscarPorId(idLivro);
        if (livro == null) {
            throw new Exception("Livro não encontrado!");
        }
        
        // REGRA 3: Livro está disponível?
        if (!livro.isDisponivel()) {
            throw new Exception("Este livro já está emprestado!");
        }
        
        // REGRA 4: Verificar se o livro não está em outro empréstimo ativo
        Emprestimo emprestimoExistente = emprestimoDAO.buscarPorIdLivro(idLivro);
        if (emprestimoExistente != null) {
            throw new Exception("Este livro já possui um empréstimo registrado!");
        }
        
        // Altera o estado do livro
        livro.setDisponivel(false);
        livroDAO.atualizar(livro);
        
        // Cria e salva o empréstimo
        Emprestimo emprestimo = new Emprestimo(idLivro, nomeLeitor);
        emprestimoDAO.salvar(emprestimo);
    }
    
    public void devolverLivro(int idLivro) throws Exception {
        // REGRA 1: Livro existe?
        Livro livro = livroDAO.buscarPorId(idLivro);
        if (livro == null) {
            throw new Exception("Livro não encontrado!");
        }
        
        // REGRA 2: Livro está emprestado?
        if (livro.isDisponivel()) {
            throw new Exception("Este livro não está emprestado!");
        }
        
        // REGRA 3: Encontrar o empréstimo ativo
        Emprestimo emprestimo = emprestimoDAO.buscarPorIdLivro(idLivro);
        if (emprestimo == null) {
            throw new Exception("Não foi encontrado um empréstimo ativo para este livro!");
        }
        
        // Remove o empréstimo e libera o livro
        emprestimoDAO.excluir(emprestimo.getId());
        livro.setDisponivel(true);
        livroDAO.atualizar(livro);
    }
    
    public List<Emprestimo> listarEmprestimos() {
        return emprestimoDAO.listarTodos();
    }
}