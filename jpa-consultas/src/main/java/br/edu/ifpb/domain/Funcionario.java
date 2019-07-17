package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 07:51:52
 */

@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cpf;

    // UM Funcionario possui UM Endereco
    @OneToOne//(cascade = CascadeType.PERSIST)
//    @JoinColumn(name = "end_cod",unique = true) // 
    @JoinColumn(name = "end_cod") // 
    private Endereco endereco; // 1 -> 1 unidirecional

    // UM Funcionario possui MUITOS Dependentes
    @OneToMany()
    @JoinColumn(name = "funcionario_id") /// Caso não utilize o JoinColumn, será criada a tabela associativa
    private List<Dependente> dependentes; // 1 -> N unidirecional

    // MUITOS Funcionarios trabalham em MUITOS Projetos
    @ManyToMany(mappedBy = "funcionarios")
//    @JoinTable(name = "Alocacao")
    private List<Projeto> projetos; // N -> N unidirecional

    // MUITOS Funcionarios estão alocados em UM Departamento
    @ManyToOne
    private Departamento departamento; // N -> 1 unidirecional

    public Funcionario(String nome, String cpf, Endereco endereco) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public Funcionario() {
        this.dependentes = new ArrayList<>();
        this.projetos = new ArrayList<>();
    }

    public void adicionar(Dependente dependente) {
        this.dependentes.add(dependente);
    }

    public void remover(Dependente dependente) {
        this.dependentes.remove(dependente);
    }

    public void adicionar(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public void remover(Projeto projeto) {
        this.projetos.remove(projeto);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco + ", dependentes=" + dependentes + ", projetos=" + projetos + ", departamento=" + departamento + '}';
    }

}
