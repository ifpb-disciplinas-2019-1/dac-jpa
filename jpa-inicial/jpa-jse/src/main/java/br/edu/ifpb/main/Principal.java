package br.edu.ifpb.main;

import br.edu.ifpb.domain.Pessoa;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 06/06/2019, 09:55:37
 */
public class Principal {

    public static void main(String[] args) {
        EntityManager em = Persistence
            .createEntityManagerFactory("ExemploDerby")
            .createEntityManager();

        Pessoa pessoa = new Pessoa(
            "123","Maria",8
        );
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(pessoa);
            transaction.commit();
        } catch (EntityExistsException e) {
            System.out.println("sou um EntityExistsException");
        } catch (RollbackException e) {
            System.out.println("sou um RollbackException");
        }
//        Pessoa pessoa = em.find(Pessoa.class,"123");
//        System.out.println(pessoa.getNome());
    }
}
