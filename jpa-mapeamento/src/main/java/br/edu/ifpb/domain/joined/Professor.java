package br.edu.ifpb.domain.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 11:16:47
 */
@Entity
@DiscriminatorValue("T")
public class Professor extends Pessoa {

    private String siape;

    public Professor() {
    }

    public Professor(String siape,String nome,String cpf) {
        super(nome,cpf);
        this.siape = siape;
    }

    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

}
