/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifgoiano.dao;

/**
 *
 * @author Anna
 */
import br.edu.ifgoiano.model.Emprestimo;
import java.util.List;

public interface EmprestimoDAO {
    
    Emprestimo salvar(Emprestimo emprestimo);
    Emprestimo buscarPorId(int id);
    Emprestimo buscarPorIdLivro(int idLivro);
    List<Emprestimo> listarTodos();
    boolean excluir(int id);
}