package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 10/07/2019, 10:32:54
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

    // UM Gerente gerencia UM Departamento
    // entidade inverso
    @OneToOne(mappedBy = "gerente")
    private Departamento departamento; // 1 -> 1 bidirecional

    // UM Gerente para MUITOS Projetos
    @OneToMany(mappedBy = "gerente") // inverso
//    @JoinColumn
    private List<Projeto> projetos = new ArrayList<>(); // 1 -> N bidirecional 

    public Gerente() {
    }

    public Gerente(String nome,String cpf,Date inicio,Date fim) {
        this.nome = nome;
        this.cpf = cpf;
        this.inicio = inicio;
        this.fim = fim;
    }

    public void novo(Projeto projeto) {
        this.projetos.add(projeto);
        projeto.setGerente(this);
    }

    public void excluir(Projeto projeto) {
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

}
