package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 19/06/2019, 11:33:19
 */
@Entity
public class Fornecedor implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;
    private String nome;
    private String area;

    public Fornecedor() {
    }

    public Fornecedor(String nome,String area) {
        this.nome = nome;
        this.area = area;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

}
