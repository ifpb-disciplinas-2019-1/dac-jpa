package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/06/2019, 10:25:45
 */
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "nomeDoFuncionario")
    private String nome;
    private String cpf;

    // UM Funcionario possui UM Endereco
    @OneToOne
    @JoinColumn(name = "endereco")
    private Endereco endereco; // 1 -> 1 unidirecional     // <nomedaentidade_atributo>

    // UM Funcionario possui MUITOS Dependentes
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "funcionario_id")
    private List<Dependente> dependentes = new ArrayList<>(); // 1 -> N unidirecional

    // MUITOS Funcionarios trabalham em UM Departamento
    @ManyToOne
    private Departamento departamento; // N -> 1 unidirecional
    
    // MUITOS Funcionarios participam de MUITOS Projetos
    @ManyToMany(mappedBy = "funcionarios") //inverso
    private List<Projeto> projetos = new ArrayList<>(); // N -> N bidirecional

    public Funcionario() {
    }

    public Funcionario(String nome,String cpf,Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void novo(Dependente dependente) {
        this.dependentes.add(dependente);
    }
    public void novo(Projeto projeto) {
        this.projetos.add(projeto);
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
