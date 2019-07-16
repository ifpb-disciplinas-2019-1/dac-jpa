package br.edu.ifpb.domain.joined;

import java.io.Serializable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 11:15:56
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", length = 5)
@DiscriminatorValue("P")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(String nome,String cpf) {
        this.nome = nome;
        this.cpf = cpf;
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

}
