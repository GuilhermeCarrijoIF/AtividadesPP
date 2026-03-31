/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifgoiano.dao;

/**
 *
 * @author Anna
 */
import br.edu.ifgoiano.model.Livro;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LivroMemoryDAO implements LivroDAO{
    
    private static List<Livro> dados = new ArrayList<>();
    private static int contadorId = 1;
    
    @Override
    public Livro salvar(Livro livro) {
        livro.setId(contadorId++);
        dados.add(livro);
        return livro;
    }
    
    @Override
    public void atualizar(Livro livro) {
        for (int i = 0; i < dados.size(); i++) {
            if (dados.get(i).getId() == livro.getId()) {
                dados.set(i, livro);
                break;
            }
        }
    }
    
    @Override
    public boolean excluir(int id) {
        return dados.removeIf(livro -> livro.getId() == id);
    }
    
    @Override
    public Livro buscarPorId(int id) {
        return dados.stream()
                .filter(livro -> livro.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    @Override
    public List<Livro> listarTodos() {
        return new ArrayList<>(dados);
    }
    
    @Override
    public List<Livro> listarDisponiveis() {
        return dados.stream()
                .filter(Livro::isDisponivel)
                .collect(Collectors.toList());
    }
}