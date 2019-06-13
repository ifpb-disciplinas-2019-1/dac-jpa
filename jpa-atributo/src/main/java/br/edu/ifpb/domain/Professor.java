package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2019, 10:37:18
 */
@Entity
public class Professor implements Serializable {

    @Id
    private int id;
    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDeNascimento;
    @Basic(fetch = FetchType.LAZY)
    @ElementCollection // professor_emails <entidade_atributo>
    @CollectionTable(name = "Emails")
    private List<String> emails = new ArrayList<>();

    /**
     * @Entity class Email{
     * @Id private int id; private String valor;
     */
    public Professor(int id,String nome) {
        this(id,nome,new Date());
    }

    public Professor(int id,String nome,Date dataDeNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Professor() {
    }

    public void novoEmail(String email) {
        this.emails.add(email);
    }

    public List<String> getEmails() {
        return emails;
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

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

}
