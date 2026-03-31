/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifgoiano.dao;

/**
 *
 * @author Anna
 */
import br.edu.ifgoiano.model.Livro;
import java.util.List;

public interface LivroDAO {
    
    Livro salvar(Livro livro);
    void atualizar(Livro livro);
    boolean excluir(int id);
    Livro buscarPorId(int id);
    List<Livro> listarTodos();
    List<Livro> listarDisponiveis();
}