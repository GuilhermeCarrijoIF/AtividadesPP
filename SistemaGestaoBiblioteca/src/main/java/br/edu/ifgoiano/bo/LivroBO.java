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
import java.util.List;

public class LivroBO {
    
    private LivroDAO livroDAO;
    private EmprestimoDAO emprestimoDAO;
    
    public LivroBO() {
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
    
    
    public Livro cadastrarLivro(String titulo, String autor) throws Exception {
        // Regra de negócio: título e autor não podem ser vazios
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new Exception("Título do livro não pode ser vazio!");
        }
        
        if (autor == null || autor.trim().isEmpty()) {
            throw new Exception("Autor do livro não pode ser vazio!");
        }
        
        Livro livro = new Livro(titulo, autor);
        return livroDAO.salvar(livro);
    }
    
    public void excluirLivro(int id) throws Exception {
        // Regra de negócio desafio: livro não pode ser excluído se estiver emprestado
        Livro livro = livroDAO.buscarPorId(id);
        
        if (livro == null) {
            throw new Exception("Livro não encontrado!");
        }
        
        if (!livro.isDisponivel()) {
            throw new Exception("Não é possível excluir um livro que está emprestado!");
        }
        
        boolean removido = livroDAO.excluir(id);
        if (!removido) {
            throw new Exception("Erro ao excluir o livro!");
        }
    }
    
    public List<Livro> listarTodos() {
        return livroDAO.listarTodos();
    }
    
    public List<Livro> listarDisponiveis() {
        return livroDAO.listarDisponiveis();
    }
    
    public Livro buscarPorId(int id) {
        return livroDAO.buscarPorId(id);
    }
}