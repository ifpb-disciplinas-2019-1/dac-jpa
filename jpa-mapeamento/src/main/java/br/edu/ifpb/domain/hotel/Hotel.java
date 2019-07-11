package br.edu.ifpb.domain.hotel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 11/07/2019, 09:50:42
 */
@Entity
public class Hotel implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String abreviacao;

//    @ManyToMany
//    private List<Hospede> hospedes;
    @OneToMany(mappedBy = "hotel")
    private List<Hospedagem> hospedagens;

    public Hotel() {
    }

    public Hotel(String abreviacao) {
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
