package br.edu.ifpb.domain.table;

import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 11:01:34
 */
@Entity
public class Celta extends Carro {

    private String ano;

    public Celta(String ano,String nome,String modelo) {
        super(nome,modelo);
        this.ano = ano;
    }

    public Celta() {
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

}
