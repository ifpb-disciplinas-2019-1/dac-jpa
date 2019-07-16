package br.edu.ifpb.domain.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 10:35:55
 */
@Entity
@DiscriminatorValue("cat")
public class Gato extends Animal {

    private String manha;

    public Gato() {
    }

    public Gato(String manha,String nome,String raca) {
        super(nome,raca);
        this.manha = manha;
    }

    public String getManha() {
        return manha;
    }

    public void setManha(String manha) {
        this.manha = manha;
    }

}

