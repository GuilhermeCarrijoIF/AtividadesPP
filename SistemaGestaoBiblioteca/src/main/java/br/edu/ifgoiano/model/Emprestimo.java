/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifgoiano.model;

/**
 *
 * @author Anna
 */
import java.util.Date;

public class Emprestimo {
    
     private int id;
    private int idLivro;
    private String nomeLeitor;
    private Date dataEmprestimo;
    
    public Emprestimo() {
    
    }
    
    public Emprestimo(int idLivro, String nomeLeitor) {
        this.idLivro = idLivro;
        this.nomeLeitor = nomeLeitor;
        this.dataEmprestimo = new Date();
    }
    
    public Emprestimo(int id, int idLivro, String nomeLeitor, Date dataEmprestimo) {
        this.id = id;
        this.idLivro = idLivro;
        this.nomeLeitor = nomeLeitor;
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getNomeLeitor() {
        return nomeLeitor;
    }

    public void setNomeLeitor(String nomeLeitor) {
        this.nomeLeitor = nomeLeitor;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    @Override
public String toString() {
    return "Livro ID: " + idLivro + " | Leitor: " + nomeLeitor + " | Data: " + dataEmprestimo;
}
}