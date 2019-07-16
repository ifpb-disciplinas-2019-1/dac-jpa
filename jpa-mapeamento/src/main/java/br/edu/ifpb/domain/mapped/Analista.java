package br.edu.ifpb.domain.mapped;

import javax.persistence.Entity;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 11:16:47
 */
@Entity
public class Analista extends FuncionarioExecutivo{

    private String matricula;

    public Analista() {
    }

    public Analista(String matricula,String nome,String cpf) {
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
