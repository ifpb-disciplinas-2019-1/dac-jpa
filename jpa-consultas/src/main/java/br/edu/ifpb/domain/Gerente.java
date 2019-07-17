package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 09:40:28
 */
@Entity
public class Gerente implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cpf;
    @Temporal(TemporalType.DATE)
    private Date inicio;
    @Temporal(TemporalType.DATE)
    private Date fim;

    // UM Gerente possui UM Departamento
    @OneToOne(mappedBy = "gerente")// INVERSO
    private Departamento dep; // 1 -> 1 bidirecional

    // UM Gerente possui MUITOS Projetos
    @OneToMany(mappedBy = "gerente") // INVERSO
    private List<Projeto> projetos; // N -> 1 bidirecional

    public Gerente() {
        this.projetos = new ArrayList<>();
    }

    public Gerente(String nome, String cpf) {
        this(nome, cpf, new Date(), new Date());
    }

    public Gerente(String nome, String cpf, Date inicio, Date fim) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.inicio = inicio;
        this.fim = fim;
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Departamento getDep() {
        return dep;
    }

    public void setDep(Departamento dep) {
        this.dep = dep;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

}
