package br.edu.ifpb.domain.joined;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 11:16:47
 */
@Entity
@DiscriminatorValue("A")
public class Aluno extends Pessoa{

    private String matricula;

    public Aluno() {
    }

    public Aluno(String matricula,String nome,String cpf) {
        super(nome,cpf);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
}
