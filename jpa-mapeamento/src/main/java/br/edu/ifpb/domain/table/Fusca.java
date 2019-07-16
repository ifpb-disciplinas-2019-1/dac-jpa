package br.edu.ifpb.domain.table;

import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 11:01:34
 */
@Entity
public class Fusca extends Carro {

    private String numetoDoChassi;

    public Fusca(String numetoDoChassi,String nome,String modelo) {
        super(nome,modelo);
        this.numetoDoChassi = numetoDoChassi;
    }

    public Fusca() {
    }

    public String getNumetoDoChassi() {
        return numetoDoChassi;
    }

    public void setNumetoDoChassi(String numetoDoChassi) {
        this.numetoDoChassi = numetoDoChassi;
    }

}
