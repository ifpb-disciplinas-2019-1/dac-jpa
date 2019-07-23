package br.edu.ifpb.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 17/07/2019, 07:59:48
 */
@NamedQueries(
    {
     @NamedQuery(name = "Dependente.todos",query = "SELECT d FROM Dependente d"), 
     @NamedQuery(name = "Dependente.idSuperior",query = "SELECT d FROM Dependente d WHERE d.codigo > :id")
    }
)
@Entity
public class Dependente implements Serializable {

    @Id
    @GeneratedValue
    private int codigo;
    private String nome;

    public Dependente() {
    }

    public Dependente(String nome) {
        this.nome = nome;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dependente other = (Dependente) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome,other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dependente{" + "codigo=" + codigo + ", nome=" + nome + '}';
    }

}
