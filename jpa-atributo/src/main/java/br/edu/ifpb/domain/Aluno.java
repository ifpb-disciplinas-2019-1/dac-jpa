package br.edu.ifpb.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 07/06/2019, 07:29:49
 */
@Entity
public class Aluno implements Serializable {

    @Id
    private int codigo;
    @Column(length = 15,unique = true)
    private String matricula;
    @Column(name = "nomeDoAluno",nullable = false,updatable = false)
    private String nome;
    @Transient
    private String cpf;
//    private transient String cpf; 
    
    
    private double cre;

    public Aluno() {
    }

    public Aluno(int codigo,String matricula,String nome,double cre) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = "1212121212";
        this.cre = cre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCre() {
        return cre;
    }

    public void setCre(double cre) {
        this.cre = cre;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
