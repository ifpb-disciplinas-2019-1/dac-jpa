package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/06/2019, 11:19:26
 */
@Entity
public class Departamento implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String abreviacao;

    public Departamento() {
    }

    public Departamento(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

}
