package br.edu.ifpb.main;

import br.edu.ifpb.domain.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 06/06/2019, 09:55:37
 */
public class Principal {

    public static void main(String[] args) {
        EntityManager em=Persistence
            .createEntityManagerFactory("ExemploPostgres")
            .createEntityManager();

//        Pessoa pessoa = new Pessoa(
//            "123","Chaves",8
//        );
//        EntityTransaction transaction = em.getTransaction();
//        
//        transaction.begin();
//        em.persist(pessoa);
//        transaction.commit();
        Pessoa pessoa = em.find(Pessoa.class,"123");
        System.out.println(pessoa.getNome());
    }
}
