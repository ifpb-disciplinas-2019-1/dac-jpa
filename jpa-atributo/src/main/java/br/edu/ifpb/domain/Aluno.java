package br.edu.ifpb.domain;

import br.edu.ifpb.infra.jpa.convert.ConvertLocalDate;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Embedded
    @AttributeOverride(name = "valor",column = @Column(name = "cpfpessoa"))
    private CPF cpf;
//    private transient String cpf; 

//    @Temporal(TemporalType.DATE)
    @Convert(converter = ConvertLocalDate.class)
    private LocalDate dataDaMatricula;
    private double cre;

    public Aluno() {
    }

    public Aluno(int codigo,String matricula,String nome,double cre) {
        this.codigo = codigo;
        this.matricula = matricula;
        this.nome = nome;
        this.cre = cre;
        this.cpf = new CPF(
            "1212121212"
        );
        this.dataDaMatricula = LocalDate.now();
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

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

}
