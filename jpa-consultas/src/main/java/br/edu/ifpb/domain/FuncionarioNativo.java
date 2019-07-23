package br.edu.ifpb.domain;

import java.io.Serializable;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 23/07/2019, 11:14:04
 */
public class FuncionarioNativo {

    private int id;
    private String nome;

//    public FuncionarioNativo() {
//    }

    public FuncionarioNativo(int id,String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "FuncionarioNativo{" + "id=" + id + ", nome=" + nome + '}';
    }
    

}
