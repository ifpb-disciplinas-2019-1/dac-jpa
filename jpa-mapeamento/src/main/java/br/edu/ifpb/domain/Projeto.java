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
 * @since 19/06/2019, 11:32:30
 */
@Entity
public class Projeto implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String descricao;

    // MUITOS Projetos são financiados por MUITOS Fornecedores
    @ManyToMany
//    @JoinTable(name = "Financiadores") // tabela associativa (tabela de junção)
    private List<Fornecedor> fornecedores = new ArrayList<>(); // N -> N unidirecional

    // MUITOS Projejtos são gerenciados por UM Gerente
    @ManyToOne // possuídor
    private Gerente gerente; // N -> 1 bidirecional

    // MUITOS Projetos trabalham MUITOS Funcionarios
    @ManyToMany // possuídor
    @JoinTable(name = "Trabalho") // tabela associativa (tabela de junção)
    private List<Funcionario> funcionarios = new ArrayList<>(); // N -> N bidirecional
   
    public Projeto() {
    }

    public Projeto(String descricao) {
        this.descricao = descricao;
    }

    public void novo(Fornecedor fornecedor) {
        this.fornecedores.add(fornecedor);
    }

    public void novo(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
        funcionario.novo(this);
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
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
