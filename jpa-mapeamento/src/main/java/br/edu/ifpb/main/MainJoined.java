package br.edu.ifpb.main;

import br.edu.ifpb.domain.single.Animal;
import br.edu.ifpb.domain.table.Carro;
import br.edu.ifpb.domain.table.Celta;
import br.edu.ifpb.domain.table.Fusca;
import br.edu.ifpb.domain.joined.Aluno;
import br.edu.ifpb.domain.joined.Pessoa;
import br.edu.ifpb.domain.joined.Professor;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 16/07/2019, 10:39:29
 */
public class MainJoined {

    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("ExemploPostgres")
            .createEntityManager();
        Pessoa pessoa = new Pessoa(
            "João","123"
        );

        Aluno aluno = new Aluno(
            "123","Chaves","124"
        );

        Professor professor = new Professor(
            "125","Girafales","126"
        );

        em.getTransaction().begin();
        em.persist(pessoa);
        em.persist(aluno);
        em.persist(professor);
        em.getTransaction().commit();

        em.createQuery("FROM Aluno g",Aluno.class)
            .getResultList()
            .forEach(
                g -> System.out.println(g.getNome())
            );
    }

}
