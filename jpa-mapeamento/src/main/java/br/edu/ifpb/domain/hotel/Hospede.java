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
public class Hospede implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;

//    @ManyToMany(mappedBy = "hospedes")
//    private List<Hotel> hoteis;
    @OneToMany(mappedBy = "hospede")
    private List<Hospedagem> hospedagens;

    public Hospede() {
    }

    public Hospede(String nome) {
        this.nome = nome;
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

}
