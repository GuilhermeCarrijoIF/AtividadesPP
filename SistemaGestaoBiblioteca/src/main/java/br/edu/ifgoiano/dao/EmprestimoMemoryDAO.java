/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifgoiano.dao;

/**
 *
 * @author Anna
 */
import br.edu.ifgoiano.model.Emprestimo;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoMemoryDAO implements EmprestimoDAO{
    
    private static List<Emprestimo> dados = new ArrayList<>();
    private static int contadorId = 1;
    
    @Override
    public Emprestimo salvar(Emprestimo emprestimo) {
        emprestimo.setId(contadorId++);
        dados.add(emprestimo);
        return emprestimo;
    }
    
    @Override
    public Emprestimo buscarPorId(int id) {
        return dados.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public Emprestimo buscarPorIdLivro(int idLivro) {
        return dados.stream()
                .filter(emp -> emp.getIdLivro() == idLivro)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Emprestimo> listarTodos() {
        return new ArrayList<>(dados);
    }
    
    @Override
    public boolean excluir(int id) {
        return dados.removeIf(emp -> emp.getId() == id);
    }
}