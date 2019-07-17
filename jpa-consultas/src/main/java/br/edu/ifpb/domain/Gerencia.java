package br.edu.ifpb.domain;

import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 17/07/2019, 10:48:19
 */
public class Gerencia implements Serializable{

    private String abreviacao;
    private Gerente gerente;

    public Gerencia(String abreviacao,Gerente gerente) {
        this.abreviacao = abreviacao;
        this.gerente = gerente;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public Gerente getGerente() {
        return gerente;
    }
    
}
