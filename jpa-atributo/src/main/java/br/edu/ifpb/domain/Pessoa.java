package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/06/2019, 08:09:41
 */
@Entity
public class Pessoa implements Serializable {

    @Id
    private int codigo;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    public Pessoa() {
    }

    public Pessoa(int codigo, String nome, Sexo sexo) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }


}
