package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 09:17:46
 */
@Entity
public class Projeto implements Serializable{

    @Id
    @GeneratedValue
    private int id;
    private String descricao;
    
    // MUITOS Projetos estão vinculado a UM Gerente
    @ManyToOne // POSSUIDOR
    private Gerente gerente; // 1 -> N bidirecional
    
    // MUITOS Projetos podem estar vinculados a MUITOS Funcionarios
    @ManyToMany
    @JoinTable(name = "Alocacao")
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Projeto() {
    }

    public Projeto(String descricao) {
        this.descricao = descricao;
    }
    
    public void adicinar(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }
    public void remover(Funcionario funcionario){
        this.funcionarios.remove(funcionario);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
 
    
}
