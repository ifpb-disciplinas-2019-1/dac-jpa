package br.edu.ifpb.domain.single;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 10:35:55
 */
@Entity
@DiscriminatorValue("Dog")
public class Cachorro extends Animal {

    private String pedigree;

    public Cachorro() {
    }

    public Cachorro(String pedigree,String nome,String raca) {
        super(nome,raca);
        this.pedigree = pedigree;
    }

    public String getPedigree() {
        return pedigree;
    }

    public void setPedigree(String pedigree) {
        this.pedigree = pedigree;
    }

}
