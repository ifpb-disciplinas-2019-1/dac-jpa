package br.edu.ifpb.domain;

import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 17/07/2019, 11:17:22
 */
public class Dependentes implements Serializable{

    private String funcionario;
    private String dependente;

    public Dependentes(String funcionario,String dependente) {
        this.funcionario = funcionario;
        this.dependente = dependente;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public String getDependente() {
        return dependente;
    }
    
}
