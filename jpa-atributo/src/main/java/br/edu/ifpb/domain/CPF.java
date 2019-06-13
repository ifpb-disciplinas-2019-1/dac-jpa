package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 12/06/2019, 11:05:41
 */
@Embeddable
public class CPF implements Serializable {

//    @Column(name = "cpf")
    private String valor;

    public CPF() {
    }

    public CPF(String valor) {
        this.valor = valor;
    }

    public String simples() {
        return valor; //12345678910
    }

    public String formatado() {
        return valor; //123.456.789-10
    }

    public boolean valido() {
        return true; //false
    }
}
